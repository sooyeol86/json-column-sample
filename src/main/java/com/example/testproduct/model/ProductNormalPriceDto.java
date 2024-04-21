package com.example.testproduct.model;

import com.example.testproduct.model.ProductDto;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ProductNormalPriceDto extends ProductDto {

	private Integer price;
	private Integer displayPrice;
}
