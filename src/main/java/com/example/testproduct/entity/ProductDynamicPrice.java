package com.example.testproduct.entity;

import java.util.List;
import java.util.Map;

import org.hibernate.annotations.Type;

import com.example.testproduct.model.ProductDynamicPriceDetailItemDto;

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DiscriminatorValue("2")
@Table(name = "product_dynamic_price")
public class ProductDynamicPrice extends Product {

	@Column(name = "range_name")
	private String rangeName;

	@Column(name = "detail")
	@Type(JsonBinaryType.class)
	private List<ProductDynamicPriceDetailItemDto> detail;
}
