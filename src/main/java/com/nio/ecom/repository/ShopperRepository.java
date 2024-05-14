package com.nio.ecom.repository;

import com.nio.ecom.entity.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopperRepository extends JpaRepository<Shopper, String> {
}
