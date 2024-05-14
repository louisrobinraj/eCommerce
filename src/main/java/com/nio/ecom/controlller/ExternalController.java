package com.nio.ecom.controlller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nio.ecom.dto.ProductDto;
import com.nio.ecom.service.IExternalService;

import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("api/ecom/external")
@Slf4j
public class ExternalController {

	private IExternalService externalService;

	@GetMapping("retrive-products")
	public ResponseEntity<List<ProductDto>> retriveShopperProduct(
			@RequestParam(value = "shopperID", required = true, defaultValue = "") String shopperID,
			@RequestParam(value = "category", required = false, defaultValue = "") String category,
			@RequestParam(value = "brand", required = false, defaultValue = "") String brand,
			@RequestParam(value = "limit", required = false, defaultValue = "10") @Max(value = 100, message = "Limit should be below 100") int limit) {
		log.info("Shopper Id :" + shopperID + " Category :" + category + " Brand :" + brand + " Limit :" + limit);
		return ResponseEntity.status(HttpStatus.OK)
				.body(externalService.retriveProducts(shopperID, category, brand, limit));
	}
}
