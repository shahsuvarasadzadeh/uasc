package com.example.uasc.controller;

import com.example.uasc.dto.U_create;
import com.example.uasc.entity.U_entity;
import com.example.uasc.service.U_inter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class UASCController {
    private final U_inter uInter;

    @GetMapping(path = "/addMark")
    public String addNew(Model model, @RequestParam Long score, @RequestParam Long credit) {
        System.out.println(score + credit);
        U_create uCreate = new U_create(score, credit);
        uInter.addmark(uCreate);
        double sumC = 0;
        double sumCS = 0;
        double sum = 0;
        List<U_entity> uEntit = uInter.getmark();
        for (int i = 0; i < uEntit.size(); i++) {
            sumC = sumC + uEntit.get(i).getCredit();
            sumCS = sumCS + uEntit.get(i).getCredit() * uEntit.get(i).getScore();
        }
        sum = sumCS / sumC;
        System.out.println(sum);
        model.addAttribute("result", sum);
        final List<U_entity> uEntities = uInter.getmark();
        model.addAttribute("all", uEntities);
        return "hello";
    }
}
