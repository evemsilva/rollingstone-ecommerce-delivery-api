package com.rollingstone.spring.dao;

import com.rollingstone.spring.model.Delivery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DeliveryDaoRepository
		extends PagingAndSortingRepository<Delivery, Long> {

	Page<Delivery> findAll(Pageable pageable);
}
