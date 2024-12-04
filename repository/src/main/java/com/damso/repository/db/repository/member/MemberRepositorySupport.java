//package com.damso.repository.db.repository.member;
//
//import com.damso.admin.service.member.command.MemberSearchCommand;
//import com.damso.repository.db.entity.member.Member;
//import com.querydsl.jpa.impl.JPAQuery;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.support.PageableExecutionUtils;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//import static com.damso.admin.storage.entity.member.QMember.member;
//
//@Repository
//@RequiredArgsConstructor
//public class MemberRepositorySupport {
//    private final JPAQueryFactory queryFactory;
//
//    public Page<Member> findAllMembers(MemberSearchCommand command, Pageable pageable) {
//        List<Member> members = queryFactory.select(QMember.member)
//                .from(QMember.member)
//                .where(
//                        MemberExpression.memberIdEq(command.memberId()),
//                        MemberExpression.emailLike(command.email()),
//                        MemberExpression.nameLike(command.name()),
//                        MemberExpression.roleEq(command.role()),
//                        MemberExpression.statusEq(command.status()),
//                        MemberExpression.joinedAtGoe(command.startDate()),
//                        MemberExpression.joinedAtLoe(command.endDate())
//                )
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .orderBy(QMember.member.id.desc())
//                .fetch();
//
//        JPAQuery<Long> total = queryFactory.select(QMember.member.count())
//                .from(QMember.member)
//                .where(
//                        MemberExpression.memberIdEq(command.memberId()),
//                        MemberExpression.emailLike(command.email()),
//                        MemberExpression.nameLike(command.name()),
//                        MemberExpression.roleEq(command.role()),
//                        MemberExpression.statusEq(command.status()),
//                        MemberExpression.joinedAtGoe(command.startDate()),
//                        MemberExpression.joinedAtLoe(command.endDate())
//                );
//
//        return PageableExecutionUtils.getPage(members, pageable, total::fetchOne);
//    }
//}