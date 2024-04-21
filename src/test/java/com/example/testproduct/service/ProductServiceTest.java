package com.example.testproduct.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.crossstore.ChangeSetPersister.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.test.context.ActiveProfiles;

import com.example.testproduct.model.ProductDto;
import com.example.testproduct.model.ProductDynamicPriceDto;
import com.example.testproduct.model.ProductNormalPriceDto;

@SpringBootTest
@ActiveProfiles({ "test" })
class ProductServiceTest {
	@Autowired
	ProductService service;

	@Test
	@DisplayName("전체 목록을 조회하면 목록이 존재한다.")
	void findAllSuccess() {
		List<ProductDto> products = service.findAll();

		Assertions.assertFalse(products.isEmpty());
	}

	@Test
	@DisplayName("전체 목록을 조회해서 하나씩 조회하면 type 에 따라 각각 다른 클래스가 로드된다.")
	void findAllAndCheckClass() {
		List<ProductDto> products = service.findAll();

		products.forEach(entity -> {
			if (entity.getPriceType() == 1) {
				assertEquals(ProductNormalPriceDto.class, entity.getClass());
			} else if (entity.getPriceType() == 2) {
				assertEquals(ProductDynamicPriceDto.class, entity.getClass());
			} else {
				assertEquals(ProductDto.class, entity.getClass());
			}
		});
	}

	@Test
	@DisplayName("ID가 존재하는 것으로 조회하면 성공한다.")
	void findByIdSuccess() throws NotFoundException {
		ProductDto product = service.findById(1L);

		Assertions.assertEquals(1L, product.getId());
	}

	@Test
	@DisplayName("ID가 존재하지 않는 것으로 조회하면 성공한다.")
	void findByIdFail() {
		assertThrows(NotFoundException.class, () -> {
			service.findById(10L);
		});
	}

	@Test
	@DisplayName("ID가 존재하는 것으로 Option의 값을 확인할 수 있다.")
	void findByIdAndCheckOption() throws NotFoundException {
		ProductDto product = service.findById(1L);

		Assertions.assertEquals(true, product.getOption().getIsPreApplyAble());
	}

	@Test
	@DisplayName("ID가 존재하는 것으로 paid type 값을 확인할 수 있다.")
	void findByIdAndCheckPaidType() throws NotFoundException {
		ProductDto product = service.findById(1L);

		Assertions.assertFalse(product.getPaidType().isEmpty());
	}

	@Test
	@DisplayName("ID가 존재하는 것으로 Option의 값을 확인할 수 있다.")
	void findByIdAndCheckDynamicPriceDetail() throws NotFoundException {
		ProductDto product = service.findById(3L);

		Assertions.assertEquals(ProductDynamicPriceDto.class, product.getClass());
		Assertions.assertFalse(((ProductDynamicPriceDto)product).getDetail().isEmpty());
		Assertions.assertTrue(((Integer)((ProductDynamicPriceDto)product).getDetail().getFirst().getPrice()) > 0);
	}
}