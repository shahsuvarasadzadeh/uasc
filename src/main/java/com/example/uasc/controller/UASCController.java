package com.example.uasc.controller;
import com.example.uasc.dto.U_create;
import com.example.uasc.dto.U_update;
import com.example.uasc.entity.U_entity;
import com.example.uasc.service.U_inter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        result(model);
        return "hello";
    }
    @GetMapping(path = "/welcome")
    public String welcome(Model model) {
        result(model);
        return "hello";
    }
    @PostMapping(path = "/delete")
    public String delete(@RequestParam Long id, Model model) {
        uInter.getDelete(id);
        result(model);
        return "hello";
    }

    @PostMapping(path = "/update")
    public String updateMark(Model model, @RequestParam Long id,
                             @RequestParam Long score, @RequestParam Long credit) {
        U_update uDto = new U_update(id, score, credit);
        uInter.updateMark(uDto);
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