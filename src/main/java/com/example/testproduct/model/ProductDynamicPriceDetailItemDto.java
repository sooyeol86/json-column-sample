package com.example.testproduct.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDynamicPriceDetailItemDto {
	@JsonProperty("start_range")
	private Integer startRange;
	@JsonProperty("finish_range")
	private Integer isPreApplyAble;
	@JsonProperty("price")
	private Integer price;
}
