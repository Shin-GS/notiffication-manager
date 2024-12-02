package com.damso.admin.service.member;

import com.damso.admin.core.response.error.ErrorCode;
import com.damso.admin.core.response.exception.BusinessException;
import com.damso.admin.service.member.command.MemberRegisterCommand;
import com.damso.admin.service.member.command.MemberSearchCommand;
import com.damso.admin.service.member.model.MemberSearchModel;
import com.damso.admin.storage.entity.member.Member;
import com.damso.admin.storage.repository.member.MemberRepository;
import com.damso.admin.storage.repository.member.MemberRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberFinderImpl implements MemberFinder {
    private final MemberRepositorySupport memberRepositorySupport;
    private final MemberRepository memberRepository;

    @Override
    public Page<MemberSearchModel> findMembers(MemberSearchCommand command,
                                               Pageable pageable) {
        return memberRepositorySupport.findAllMembers(command, pageable)
                .map(MemberSearchModel::of);
    }

    @Override
    public void register(MemberRegisterCommand command) {
        if (memberRepository.existsByEmail(command.email())) {
            throw new BusinessException(ErrorCode.MEMBER_EMAIL_DUPLICATED);
        }

        memberRepository.save(new Member(
                command.email(),
                command.name(),
                command.role())
        );
    }
}