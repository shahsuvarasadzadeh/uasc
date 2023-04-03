package com.example.uasc.dto;
import lombok.Data;
@Data
public class U_update {
    private Long id;
    private Long score;
    private Long credit;
    public U_update(Long id, Long score, Long credit) {
        this.id = id;
        this.score = score;
        this.credit = credit;
    }
}