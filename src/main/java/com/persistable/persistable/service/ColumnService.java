package com.persistable.persistable.service;


import com.persistable.persistable.domain.Mesh;
import com.persistable.persistable.repository.ColumnRepository;
import com.persistable.persistable.service.dto.MeshDto;
import com.persistable.persistable.service.mapper.CycleAvoidingMappingContext;
import com.persistable.persistable.service.mapper.FixedCycleAvoidingMappingContext;
import com.persistable.persistable.service.mapper.MeshMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ColumnService {

    private final ColumnRepository columnRepository;

    private final MeshMapper meshMapper;

    private final FixedCycleAvoidingMappingContext cycleAvoidingMappingContext;

    public ColumnService(ColumnRepository columnRepository, MeshMapper meshMapper, FixedCycleAvoidingMappingContext cycleAvoidingMappingContext) {
        this.columnRepository = columnRepository;
        this.meshMapper = meshMapper;
        this.cycleAvoidingMappingContext = cycleAvoidingMappingContext;
    }

    @Transactional
    public List<MeshDto> getMeshAll(){

        List<Mesh> meshList = columnRepository.findAll();

        List<MeshDto> meshDtos = toListDto(meshList);

        return meshDtos;
    }

    private List<MeshDto> toListDto(List<Mesh> list) {
        return meshMapper.toListDto(list, this.cycleAvoidingMappingContext);
    }


}