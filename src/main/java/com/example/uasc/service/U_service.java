package com.example.uasc.service;
import com.example.uasc.dto.U_create;
import com.example.uasc.dto.U_dto;
import com.example.uasc.dto.U_update;
import com.example.uasc.entity.U_entity;
import com.example.uasc.exceptions.NotFoundException;
import com.example.uasc.repository.U_repository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class U_service implements U_inter {
    private final U_repository uRepository;
    public U_service(U_repository uRepository) {
        this.uRepository = uRepository;
    }

    @Override
    public void addmark(U_create uCreate) {
        final U_entity uEntity;
        U_entity uEntity1 = new U_entity(uCreate.getScore(), uCreate.getCredit());
        uEntity = uRepository.save(uEntity1);
        System.out.println(uEntity.getCredit());
        U_dto.of(uEntity);
    }
    @Override
    public List<U_entity> getmark() {
        System.out.println(uRepository.findAll());
        return uRepository.findAll();
    }
    @Override
    public void getDelete(Long id) {
        final U_entity uEntity = uRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Pls include correct value"));
        uRepository.deleteById(uEntity.getId());
    }
    @Override
    public void updateMark(U_update uDto) {
        final U_entity uEntity = uRepository.findById(uDto.getId()).orElseThrow(()
                -> new NotFoundException("pls include correct value"));
        uEntity.setScore(uDto.getScore());
        uEntity.setCredit(uDto.getCredit());
    }
    @Override
    public U_entity getMarkById(Long id) {
        return uRepository.findById(id).get();
    }

    @Override
    public void deleteAll() {
        uRepository.deleteAll();
    }
}
