//package com.damso.admin.service.member;
//
//import com.damso.admin.core.response.error.ErrorCode;
//import com.damso.admin.core.response.exception.BusinessException;
//import com.damso.admin.service.member.command.MemberModifyCommand;
//import com.damso.admin.service.member.command.MemberRegisterCommand;
//import com.damso.admin.storage.entity.member.Member;
//import com.damso.admin.storage.repository.member.MemberRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//public class MemberEditorImpl implements MemberEditor {
//    private final MemberRepository memberRepository;
//
//    @Override
//    public void register(MemberRegisterCommand command) {
//        if (memberRepository.existsByEmail(command.email())) {
//            throw new BusinessException(ErrorCode.MEMBER_EMAIL_DUPLICATED);
//        }
//
//        memberRepository.save(new Member(
//                command.email(),
//                command.name(),
//                command.role())
//        );
//    }
//
//    @Override
//    public void modify(Long memberId, MemberModifyCommand command) {
//        Member member = memberRepository.findById(memberId)
//                .orElseThrow(() -> new BusinessException(ErrorCode.MEMBER_NOT_FOUND));
//
//        if (!member.getEmail().equals(command.email()) && memberRepository.existsByEmail(command.email())) {
//            throw new BusinessException(ErrorCode.MEMBER_EMAIL_DUPLICATED);
//        }
//
//        member.update(command.email(),
//                command.name(),
//                command.role(),
//                command.status());
//    }
//}
