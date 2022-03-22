package com.example.demo.repository;

import com.example.demo.entity.MemberCalList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberCalListRepository extends JpaRepository<MemberCalList,Long> {
    List<MemberCalList> findByMidAndMealType(String mid,String mealType);

    @Query(value = "SELECT a.*, b.cal_num FROM (SELECT * FROM MEM_CAL_LIST WHERE MID = ?1 AND MEAL_TYPE = ?2)a," +
            "(SELECT SUM(CALORIE) AS cal_num FROM MEM_CAL_LIST WHERE MID = ?1 AND MEAL_TYPE = ?2)b" , nativeQuery = true)
    List<MemberCalList> getMemCalList(String mid,String mealType);

    void deleteByIdx(Long idx);
}
