package com.example.uasc.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@Table(name = "post")
@Data
@AllArgsConstructor
public class U_entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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