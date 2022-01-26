package com.persistable.persistable.service.mapper;

import org.mapstruct.Context;

import java.util.List;

public interface CommonMapperForCycleAvoiding<D, E>  {


    D toDto(E e, @Context FixedCycleAvoidingMappingContext context);


    E toEntity(D d, @Context FixedCycleAvoidingMappingContext context);


    List<D> toListDto(List<E> entityList, @Context FixedCycleAvoidingMappingContext context);


    List<E> toListEntity(List<D> dtoList, @Context FixedCycleAvoidingMappingContext context);

}
