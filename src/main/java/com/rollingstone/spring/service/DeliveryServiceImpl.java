package com.rollingstone.spring.service;

import com.rollingstone.spring.dao.DeliveryDaoRepository;
import com.rollingstone.spring.model.Delivery;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl
		implements DeliveryService {

    @Autowired private DeliveryDaoRepository deliveryDao;

    @Override
    public Delivery save(Delivery delivery) {
	return deliveryDao.save(delivery);
    }

    @Override
    public Optional<Delivery> get(long id) {
	return deliveryDao.findById(id);
    }

    @Override
    public Page<Delivery> getDeliveriesByPage(Integer pageNumber, Integer pageSize) {
	Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("productId").descending());
	return deliveryDao.findAll(pageable);
    }

    @Override
    public void update(long id, Delivery delivery) {
	deliveryDao.save(delivery);
    }

    @Override
    public void delete(long id) {
	deliveryDao.deleteById(id);
    }

}
