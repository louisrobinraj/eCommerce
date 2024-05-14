package com.nio.ecom.controlller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nio.ecom.dto.ShopperDto;
import com.nio.ecom.service.IInternalService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("api/ecom/internal")
@Slf4j
public class InternalController {

	private IInternalService internalService;

	@PostMapping("store-products")
	public ResponseEntity<ShopperDto> storeShopperProduct(@Valid @RequestBody ShopperDto shopperDto) {
		log.info("Request Body :" + shopperDto.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(internalService.storeShopperProduct(shopperDto));
	}
}
