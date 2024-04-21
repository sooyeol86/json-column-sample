package com.example.testproduct.model;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ProductDto {

	private Long id;
	private String name;
	private Integer priceType;
	private ProductOptionDto option;
	private List<String> paidType;
}
