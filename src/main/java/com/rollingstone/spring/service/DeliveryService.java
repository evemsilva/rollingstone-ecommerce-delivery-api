package com.rollingstone.spring.service;

import com.rollingstone.spring.model.Delivery;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface DeliveryService {

    Delivery save(Delivery delivery);

    Optional<Delivery> get(long id);

    Page<Delivery> getDeliveriesByPage(Integer pageNumber, Integer pageSize);

    void update(long id, Delivery delivery);

    void delete(long id);
}
