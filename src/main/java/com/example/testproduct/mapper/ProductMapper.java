package com.example.testproduct.mapper;

import org.springframework.stereotype.Component;

import com.example.testproduct.entity.Product;
import com.example.testproduct.entity.ProductDynamicPrice;
import com.example.testproduct.entity.ProductNormalPrice;
import com.example.testproduct.model.ProductDto;
import com.example.testproduct.model.ProductDynamicPriceDto;
import com.example.testproduct.model.ProductNormalPriceDto;

@Component
public class ProductMapper {

	public ProductDto toModel(Product entity) {
		if (entity.getClass() == ProductNormalPrice.class) {

			return ProductNormalPriceDto
				.builder()
				.id(entity.getId())
				.name(entity.getName())
				.option(entity.getOption())
				.paidType(entity.getPaidType())
				.priceType(entity.getPriceType())
				.price(((ProductNormalPrice)entity).getPrice())
				.displayPrice(((ProductNormalPrice)entity).getDisplayPrice())
				.build();
		} else if (entity.getClass() == ProductDynamicPrice.class) {

			return ProductDynamicPriceDto
				.builder()
				.id(entity.getId())
				.name(entity.getName())
				.option(entity.getOption())
				.paidType(entity.getPaidType())
				.priceType(entity.getPriceType())
				.rangeName(((ProductDynamicPrice)entity).getRangeName())
				.detail(((ProductDynamicPrice)entity).getDetail())
				.build();
		}

		return ProductDto
			.builder()
			.id(entity.getId())
			.name(entity.getName())
			.option(entity.getOption())
			.paidType(entity.getPaidType())
			.priceType(entity.getPriceType())
			.build();
	}
}
