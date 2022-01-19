package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, String> {

    @Query(value = "SELECT * FROM MEMBER m WHERE m.mid = ?1 and m.pw = ?2", nativeQuery = true)
    Member findMember(String id, String pw);
}
