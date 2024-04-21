package com.example.testproduct.service;

import static org.springframework.data.crossstore.ChangeSetPersister.*;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.testproduct.entity.Product;
import com.example.testproduct.mapper.ProductMapper;
import com.example.testproduct.model.ProductDto;
import com.example.testproduct.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository repository;
	private final ProductMapper mapper;

	public List<ProductDto> findAll() {
		List<Product> products = repository.findAll();

		return products
			.stream()
			.map(mapper::toModel)
			.toList();
	}

	public ProductDto findById(Long id) throws NotFoundException {
		Optional<Product> find = repository.findById(id);

		if (find.isEmpty()) {
			throw new NotFoundException();
		}

		return mapper.toModel(find.get());
	}
}
