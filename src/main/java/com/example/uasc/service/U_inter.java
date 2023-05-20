package com.example.uasc.service;
import com.example.uasc.dto.U_create;
import com.example.uasc.dto.U_update;
import com.example.uasc.entity.U_entity;
import java.util.List;
public interface U_inter {
    void addmark(U_create uCreate);
    List<U_entity> getmark();
    void getDelete(Long id);
    void updateMark(U_update uUpdate);
    U_entity getMarkById(Long id);

    void deleteAll();
}