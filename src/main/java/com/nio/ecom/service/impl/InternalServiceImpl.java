package com.nio.ecom.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nio.ecom.convertor.ShopperDtoToEntityConvertor;
import com.nio.ecom.dto.ShopperDto;
import com.nio.ecom.entity.Shopper;
import com.nio.ecom.repository.ShopperRepository;
import com.nio.ecom.service.IInternalService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class InternalServiceImpl implements IInternalService {

	private ShopperRepository shopperRepository;
	private ShopperDtoToEntityConvertor shopperDtoToEntityConvertor;

	@Override
	@Transactional
	public ShopperDto storeShopperProduct(ShopperDto shopperProduct) {
		Shopper shopper = null;
		ShopperDto shopperDto = null;
		try {
			shopper = shopperDtoToEntityConvertor.convertDtoToEntity(shopperProduct);
			shopperDto = shopperDtoToEntityConvertor.convertEntityToDto(shopperRepository.save(shopper));
		} catch (RuntimeException exception) {
			log.error("Something went wrong" + exception.getMessage());
			throw new RuntimeException("Something went wrong " + exception.getMessage());
		}
		return shopperDto;
	}

}
