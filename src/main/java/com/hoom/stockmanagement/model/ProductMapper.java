package com.hoom.stockmanagement.model;

import com.hoom.stockmanagement.controller.CreateProductRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );

    Product toProduct(CreateProductRequestModel createProductRequestModel);

}
