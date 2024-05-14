package com.nio.ecom.service;

import java.util.List;

import com.nio.ecom.dto.ProductDto;

public interface IExternalService {

	public List<ProductDto> retriveProducts(String shopperId, String category, String brand, int limit);

}
