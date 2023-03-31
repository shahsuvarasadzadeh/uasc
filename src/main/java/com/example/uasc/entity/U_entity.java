package com.example.uasc.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Table(name = "Post")
@Data
@AllArgsConstructor
public class U_entity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Id")
    private Long id;
    @Column(name = "score")
    private Long score;
    @Column(name = "credit")
    private Long credit;

    public U_entity(Long score, Long credit) {
        this.score = score;
        this.credit = credit;
    }
}