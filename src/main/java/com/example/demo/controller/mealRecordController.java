package com.example.demo.controller;

import com.example.demo.dto.FoodCaloriesDTO;
import com.example.demo.dto.MemCalListDTO;
import com.example.demo.dto.MemberInfoDTO;
import com.example.demo.entity.MemberCalList;
import com.example.demo.service.FoodCaloriesService;
import com.example.demo.service.MemberCalListService;
import com.example.demo.service.MemberInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mealRecord")
@Log4j2
@RequiredArgsConstructor
public class mealRecordController {

    private final MemberInfoService memberInfoService;
    private final FoodCaloriesService foodCaloriesService;
    private final MemberCalListService memberCalListService;

    @GetMapping("/mealRecordPage")
    public String mealRecordPage() {
        log.info("mealRecordPage...........");
        return "/mealRecord/mealRecordPage";
    }

    @GetMapping("/mealRecord")
    public String mealRecord(HttpServletRequest req, Model model) {
        Object mid = req.getSession().getAttribute("mid");

        if (mid != null) {
            log.info("not null");
            // todo : 페이지별 mealType을 파라미터로 받아와야한다. (하드 코딩x)
            List<MemCalListDTO> memberCalList = memberCalListService.getMemberCalList(mid.toString(), "M");
            log.info(memberCalList);

            float cnt = 0;
            for (int i = 0; i <memberCalList.size(); i++) {
                cnt += Float.parseFloat(memberCalList.get(i).getCalories());
            }

            model.addAttribute("memberCalList" ,memberCalList);
            model.addAttribute("totalCal" , cnt);
        } else {
            model.addAttribute("loginCHK", "null");
        }
        log.info("mealRecord...........");
        return "/mealRecord/mealRecord";
    }

    @GetMapping("/caloriesDiagosis")
    public String caloriesDiagosis() {
        log.info("caloriesDiagosis...........");

        return "/mealRecord/caloriesDiagosis";
    }

    @ResponseBody
    @GetMapping("/memberInfoCheck")
    public MemberInfoDTO memberInfoCheck(HttpServletRequest req) {
        Object mid = req.getSession().getAttribute("mid");

        if (mid != null) {
            log.info("not null");
            MemberInfoDTO memberInfoDTO = memberInfoService.getMemberInfo(mid.toString());
            log.info(memberInfoDTO);
            return memberInfoDTO;
        } else {
            log.info("null");
            return null;
        }
    }

    @ResponseBody
    @PostMapping("/memberInfoSave")
    public String memberInfoSave(MemberInfoDTO memberInfoDTO) {
        log.info("memberInfoSave...........");
        log.info(memberInfoDTO.getBmi());

        String bmi = memberInfoService.setMemberInfo(memberInfoDTO);
        return bmi;
    }

    @ResponseBody
    @GetMapping("/getFoodCalorieInfo")
    public List<FoodCaloriesDTO> getFoodCalorieInfo(@RequestParam("foodName") String foodName) {
        log.info(foodName);
        List<FoodCaloriesDTO> foodCaloriesDTO = foodCaloriesService.getListOfCalories(foodName);
        log.info(foodCaloriesDTO);
        return foodCaloriesDTO;
    }

    @ResponseBody
    @PostMapping("/addCalories")
    public String addCalories(@RequestParam(value = "checkBox") String checkBox, HttpServletRequest req) {
        // 오브젝트 배열을 받을때는 이렇게 그냥 스트링으로 받아준다.
        // 그리고 js 에서 보내줄때는 JSON.stringify() 로 스트링으로 만들어서 보내준다.
        log.info("/addCalories.............");
        log.info(checkBox);
        Object _mid = req.getSession().getAttribute("mid");
        String mid = _mid.toString();

        // 직렬화 시켜 가져온 오브젝트 배열을 JSONArray 형색으로 바꿔준다.
        JSONArray array = JSONArray.fromObject(checkBox);

        List<Map<String,Object>> memberCalList = new ArrayList<Map<String,Object>>();

        for (int i = 0; i < array.size(); i++) {
            //JSONArray 형태의 값을 가져와 JSONObject 로 풀어준다.
            JSONObject obj = (JSONObject) array.get(0);

            Map<String,Object> memCalMap = new HashMap<String,Object>();

            MemCalListDTO memCalListDTO = new MemCalListDTO();
            memCalListDTO.setMid(mid);
            memCalListDTO.setFoodNm((String) obj.get("name"));
            memCalListDTO.setCalories((String) obj.get("cal"));
            memCalListDTO.setFoodCd((String) obj.get("cd"));
            memCalListDTO.setMealType((String) obj.get("mealType"));
            memCalMap.put("memCalListDTO",memCalListDTO);

            memberCalList.add(memCalMap);
        }

        memberCalListService.setMemCalList(memberCalList);

        return "";
    }

    @ResponseBody
    @GetMapping("/delCalories")
    public void delCalories(@RequestParam(value = "idx[]") List<Long> idx) {
        log.info(idx);
        memberCalListService.delMemCalories(idx);
    }

}
