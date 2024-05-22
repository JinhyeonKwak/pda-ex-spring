package com.example.shoppingmall.member;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {

    MemberRepository memberRepository;

    @Transactional
    public String join(Member member) {
        memberRepository.save(member);

        String userId = memberRepository
                .findByUserId(member.getUserId())
                .getUserId();

        System.out.println("예외처리를 해도 트랜잭션은 마무리 될까요?");

        return userId;
    }

    public boolean checkDuplicateId(String userId) {
        Member existMember
            = memberRepository.findByUserId(userId);

        if (existMember == null)
            return false;
        else
            return true;
    }
}
