package com.example.uasc.dto;
import com.example.uasc.entity.U_entity;
import lombok.Data;
@Data
public class U_dto {
    private final Long id;
    private final Long score;
    private final Long credit;
    public U_dto(Long id, Long score, Long credit) {
        this.score = score;
        this.credit = credit;
        this.id = id;
    }
    public static U_dto of(U_entity uEntity) {
        return new U_dto(uEntity.getId(), uEntity.getScore(), uEntity.getCredit());
    }
}