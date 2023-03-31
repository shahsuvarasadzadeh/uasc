package com.example.uasc.service;

import com.example.uasc.dto.U_create;
import com.example.uasc.dto.U_dto;
import com.example.uasc.entity.U_entity;
import com.example.uasc.repository.U_repository;

import java.util.List;

public interface U_inter {
    U_dto addmark(U_create uCreate);

    List<U_entity> getmark();
}
