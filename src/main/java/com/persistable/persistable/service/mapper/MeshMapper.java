package com.persistable.persistable.service.mapper;


import com.persistable.persistable.domain.Mesh;
import com.persistable.persistable.service.dto.MeshDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MeshMapper extends CommonMapperForCycleAvoiding <MeshDto, Mesh> {
}