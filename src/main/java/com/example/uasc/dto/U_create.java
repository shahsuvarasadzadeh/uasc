package com.example.uasc.dto;

import lombok.Data;

@Data
public class U_create {
    private Long score;
    private Long credit;

    public U_create(Long score, Long credit) {
        this.score=score;
        this.credit=credit;
    }
}
