package com.nio.ecom.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nio.ecom.dto.ProductDto;
import com.nio.ecom.entity.Product;
import com.nio.ecom.service.IExternalService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ExternalServiceImpl implements IExternalService {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	@Cacheable(value = "products", key = "#shopperId.concat('-').concat(#category).#brand.concat('-').concat(#limit)")
	public List<ProductDto> retriveProducts(String shopperId, String category, String brand, int limit) {
		List<ProductDto> productsDto = new ArrayList<>();
		try {
			StringBuilder criteriaQuery = new StringBuilder(
					"select product from Product product inner join Shopper shopper on shopper.shopperId='" + shopperId
							+ "'");
			if (null != category && category.length() > 0) {
				criteriaQuery.append(" where product.category='" + category + "'");
			}
			if (null != brand && brand.length() > 0) {
				criteriaQuery.append(" and product.brand='" + brand + "'");
			}
			criteriaQuery.append(" ORDER BY product.productId ASC LIMIT " + limit);
			List<Product> products = entityManager.createQuery(criteriaQuery.toString()).getResultList();
			if (null != products) {
				productsDto = products.stream().map(
						product -> new ProductDto(product.getProductId(), product.getCategory(), product.getBrand()))
						.collect(Collectors.toList());
			}
			return productsDto;
		} catch (RuntimeException exception) {
			log.error("Something went wrong " + exception.getMessage());
			throw new RuntimeException("Something went wrong" + exception.getMessage());
		}
	}

}
