package com.example.demo.repository;

import com.example.demo.entity.MemberCalList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberCalListRepository extends JpaRepository<MemberCalList,Long> {
    List<MemberCalList> findByMidAndMealType(String mid,String mealType);
}
