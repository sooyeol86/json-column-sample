package com.example.testproduct.model;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ProductDynamicPriceDto extends ProductDto {

	private String rangeName;
	private List<Map<String, Object>> detail;
}
