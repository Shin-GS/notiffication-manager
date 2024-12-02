package com.damso.admin.api.member;

import com.damso.admin.core.response.success.SuccessCode;
import com.damso.admin.core.response.success.SuccessResponse;
import com.damso.admin.service.member.MemberFinder;
import com.damso.admin.service.member.command.MemberRegisterCommand;
import com.damso.admin.service.member.command.MemberSearchCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberApi {
    private final MemberFinder memberFinder;

    @GetMapping
    public SuccessResponse search(MemberSearchCommand command,
                                  @PageableDefault(size = 1) Pageable pageable) {
        return SuccessResponse.of(SuccessCode.SUCCESS,
                memberFinder.findMembers(command, pageable));
    }

    @PostMapping
    public SuccessResponse register(@RequestBody MemberRegisterCommand command) {
        memberFinder.register(command);
        return SuccessResponse.of(SuccessCode.SUCCESS);
    }
}