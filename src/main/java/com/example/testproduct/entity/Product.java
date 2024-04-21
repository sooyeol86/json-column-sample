package com.example.testproduct.entity;

import java.util.List;
import java.util.Map;

import org.hibernate.annotations.Type;

import com.example.testproduct.model.ProductOptionDto;

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
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
@Table(name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "price_type", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "option")
	@Type(JsonBinaryType.class)
	private ProductOptionDto option;

	@Column(name = "paid_type")
	@Type(JsonBinaryType.class)
	private List<String> paidType;

	@Column(name = "price_type", insertable = false, updatable = false)
	private Integer priceType;
}