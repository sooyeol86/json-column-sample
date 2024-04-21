package com.example.testproduct.entity;

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
@DiscriminatorValue("1")
@Table(name = "product_normal_price")
public class ProductNormalPrice extends Product {

	@Column(name = "price")
	private Integer price;

	@Column(name = "display_price")
	private Integer displayPrice;
}
