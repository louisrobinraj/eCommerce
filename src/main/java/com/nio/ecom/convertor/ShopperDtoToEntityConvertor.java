package com.nio.ecom.convertor;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.nio.ecom.dto.ProductDto;
import com.nio.ecom.dto.ShopperDto;
import com.nio.ecom.entity.Product;
import com.nio.ecom.entity.Shopper;

@Component
public class ShopperDtoToEntityConvertor {

	/*
	 * this method is used to convert DTO to entry object argument is DTO object
	 * return is Entity object
	 */
	public Shopper convertDtoToEntity(ShopperDto shopperProduct) {
		Shopper shopper = new Shopper();
		String shopperId = generateAlphNumeric();
		shopper.setShopperId(shopperId);
		List<Product> products = shopperProduct.getProducts().stream().map(product -> {
			String productId = generateAlphNumeric();
			return new Product(productId, product.getCategory(), product.getBrand());
		}).collect(Collectors.toList());
		shopper.setProducts(products);
		return shopper;
	}

	/*
	 * this method is used to convert Entity to DTO object argument is Entity object
	 * return is DTO object
	 */
	public ShopperDto convertEntityToDto(Shopper shopper) {
		ShopperDto shopperDto = new ShopperDto();
		List<ProductDto> products = shopper.getProducts().stream().map(product -> {
			return new ProductDto(product.getProductId(), product.getCategory(), product.getBrand());
		}).collect(Collectors.toList());
		shopperDto.setProducts(products);
		shopperDto.setShopperId(shopper.getShopperId());
		return shopperDto;
	}

	/*
	 * This method is used to generate the unique code. return random unique code
	 */
	public static String generateAlphNumeric() {
		String capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String numbers = "0123456789";
		String values = capitalChars + numbers;
		Random random = new Random();
		int charsLength = 10;
		StringBuilder password = new StringBuilder();
		for (int i = 0; i < charsLength; i++) {
			password.append(values.charAt(random.nextInt(values.length())));
		}
		return password.toString();
	}
}
