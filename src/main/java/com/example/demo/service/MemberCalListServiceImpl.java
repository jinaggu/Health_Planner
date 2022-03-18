package com.example.demo.service;

import com.example.demo.dto.MemCalListDTO;
import com.example.demo.entity.MemberCalList;
import com.example.demo.repository.MemberCalListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class MemberCalListServiceImpl implements MemberCalListService {

    private final MemberCalListRepository memberCalListRepository;

    @Override
    public void setMemCalList(List<Map<String, Object>> memCalList) {
        List<MemberCalList> memberCalLists = new ArrayList<>();

        for (int i = 0; i < memCalList.size(); i++) {
            Map<String, Object> entityMap = dtoToEntity((MemCalListDTO) memCalList.get(i).get("memCalListDTO"));
            MemberCalList memberCalList = (MemberCalList) entityMap.get("memCalList");
            memberCalLists.add(memberCalList);
        }
        memberCalListRepository.saveAll(memberCalLists);
    }

    @Override
    public List<MemCalListDTO> getMemberCalList(String mid, String mealType) {
        List<MemberCalList> result = memberCalListRepository.findByMidAndMealType(mid, mealType);
        log.info("entity : " + result);
        return result.stream().map(MemberCalList -> entitiesToDTO(MemberCalList)).collect(Collectors.toList());
    }

}
