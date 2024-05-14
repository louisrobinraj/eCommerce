package com.nio.ecom.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopperDto {

	private String shopperId;

	@Valid
	@NotNull(message = "The Products is required.")
	private List<ProductDto> products = new ArrayList<>();

	@Override
	public String toString() {
		return "ShopperDto [shopperId=" + shopperId + ", products=" + products + "]";
	}
}
