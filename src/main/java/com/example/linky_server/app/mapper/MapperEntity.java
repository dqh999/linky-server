package com.example.staynex_server.common.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

public interface MapperEntity<E,D> {
    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    E toEntity(D dto);

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    D toDTO(E entity);

    List<D> toDTOs(List<E> entities);

    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    List<E> toEntities(List<D> dtos);

}