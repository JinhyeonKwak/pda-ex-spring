package com.example.shoppingmall.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Optional;

public interface MemberJPARepository
        extends JpaRepository<Member, Integer> {
    // extends 인터페이스의 기본 메소드는 그대로 사용하면 됨.
    //         -> 하이버네이트
    // 커스텀 메소드 (QueryByExampleExecutor)
    Optional<Member> findByUserId(String userId);
}
