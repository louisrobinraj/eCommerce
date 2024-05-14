package com.nio.ecom.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

	private String productId;

	@NotBlank(message = "[Product] Category is mandatory")
	private String category;

	@NotBlank(message = "[Product] Brand is mandatory")
	private String brand;

	public ProductDto(String category, String brand) {
		this.category = category;
		this.brand = brand;
	}
}
