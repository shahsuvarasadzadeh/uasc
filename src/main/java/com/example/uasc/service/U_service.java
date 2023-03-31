package com.example.uasc.service;

import com.example.uasc.dto.U_create;
import com.example.uasc.dto.U_dto;
import com.example.uasc.entity.U_entity;
import com.example.uasc.repository.U_repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class U_service implements U_inter {
    private final U_repository uRepository;
    @Override
    public U_dto addmark(U_create uCreate) {
        final U_entity uEntity;
        U_entity uEntity1=new U_entity(uCreate.getScore(),uCreate.getCredit());
        uEntity=uRepository.save(uEntity1);
        System.out.println(uEntity.getCredit());
        return U_dto.of(uEntity);
    }
    @Override
    public List<U_entity> getmark() {
        System.out.println(uRepository.findAll());
        return uRepository.findAll();
    }
}