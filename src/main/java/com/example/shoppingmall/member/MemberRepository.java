package com.example.shoppingmall.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository {

    @Autowired
    EntityManager entityManager;

    private Map<String, Member> memberTable = new HashMap<>();

//    @Autowired
//    DataSource dataSource;

//    public void makeConnection() {
//        DataSourceUtils.getConnection(dataSource);
//    }

//    @Transactional
    public void save(Member member) {
//        memberTable.put(member.getUserId(), member);
        entityManager.persist(member);
//        entityManager.flush();

//        Member savedMember = entityManager.find(Member.class, member.getId());
//                                    //    getBean(Member.class, "member");
//                            // memberTable.get(member.getUserId());
//        return savedMember.getUserId();
    }


    public Member findByUserId(String userId) {
        String jpql = "SELECT m FROM Member m WHERE m.userId = :userId";

//        try {
            Member foundMember =
                    entityManager.createQuery(jpql, Member.class)
                            .setParameter("userId", userId)
                            .getSingleResult();
            if (foundMember == null) {
                return null;
            } else {
                return foundMember;
            }
//            return foundMember;
//        } catch (NoResultException e) {
//            System.out.println("NoResultException 예외 발생!");
//            return null;
//        }
//        return memberTable.get(userId);
    }

    public Member findById(int id) {
        return entityManager.find(Member.class, id);
//        return memberTable.get(id);
    }
}
