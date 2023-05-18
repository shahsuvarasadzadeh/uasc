package com.example.uasc.controller;
import com.example.uasc.dto.U_create;
import com.example.uasc.dto.U_update;
import com.example.uasc.entity.U_entity;
import com.example.uasc.service.U_inter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        result(model);
        return "hello";
    }
    @GetMapping(path = "/welcome")
    public String welcome(Model model) {
        result(model);
        return "hello";
    }
    @GetMapping(path = "/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        uInter.getDelete(id);
        result(model);
        return "hello";
    }

    @GetMapping(path = "/update/{id}")
    public String toUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("mark", uInter.getMarkById(id));
        return "update";
    }

    @PostMapping(path = "/update/{id}")
    public String updateMark(Model model, @PathVariable Long id,
                             @ModelAttribute("mark") U_update entity) {
        uInter.updateMark(entity);
        result(model);
        return "hello";
    }
    public void result(Model model) {
        double sumC = 0;
        double sumCS = 0;
        double sum = 0;
        List<U_entity> uEntit = uInter.getmark();
        for (U_entity uEntity : uEntit) {
            sumC = sumC + uEntity.getCredit();
            sumCS = sumCS + uEntity.getCredit() * uEntity.getScore();
        }
        sum = sumCS / sumC;
        System.out.println(sum);
        model.addAttribute("result", sum);
        final List<U_entity> uEntities = uInter.getmark();
        model.addAttribute("all", uEntities);
    }
}