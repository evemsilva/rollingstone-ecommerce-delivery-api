package com.rollingstone.spring.controller;

import com.rollingstone.events.DeliveryEvent;
import com.rollingstone.exceptions.HTTP404Exception;
import com.rollingstone.spring.model.Delivery;
import com.rollingstone.spring.service.DeliveryService;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/delivery")
public class DeliveryController
		extends AbstractController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
	this.deliveryService = deliveryService;
    }

    /*---Add new Delivery---*/
    @PostMapping
    public ResponseEntity<?> createDelivery(@RequestBody Delivery delivery) {
	Delivery savedDelivery = deliveryService.save(delivery);
	DeliveryEvent deliveryCreatedEvent = new DeliveryEvent(this, "DeliveryCreatedEvent", delivery);
	eventPublisher.publishEvent(deliveryCreatedEvent);
	return ResponseEntity.ok().body("New delivery has been saved with ID:" + savedDelivery.getId());
    }

    /*---Get a Delivery by id---*/
    @GetMapping("/{id}")
    public ResponseEntity<Delivery> getDelivery(@PathVariable("id") long id) {
	Optional<Delivery> returnedDelivery = deliveryService.get(id);
	Delivery delivery = returnedDelivery.orElseThrow(() -> new HTTP404Exception("Resource Not Found"));

	DeliveryEvent retrievedCreatedEvent = new DeliveryEvent(this, "DeliveryRetrievedEvent", delivery);
	eventPublisher.publishEvent(retrievedCreatedEvent);
	return ResponseEntity.ok().body(delivery);
    }

    /*---get all Delivery---*/
    @GetMapping
    public @ResponseBody
    Page<Delivery> getDeliveriesByPage(@RequestParam(value = "pagenumber", defaultValue = DEFAULT_PAGE_NUMBER) Integer pageNumber,
				    @RequestParam(value = "pagesize", defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize) {
	return deliveryService.getDeliveriesByPage(pageNumber, pageSize);
    }

    /*---Update a Delivery by id---*/
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDelivery(@PathVariable("id") long id, @RequestBody Delivery delivery) {
	checkResourceFound(this.deliveryService.get(id));
	deliveryService.update(id, delivery);
	return ResponseEntity.ok().body("Delivery has been updated successfully.");
    }

    /*---Delete a Delivery by id---*/
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDelivery(@PathVariable("id") long id) {
	checkResourceFound(this.deliveryService.get(id));
	deliveryService.delete(id);
	return ResponseEntity.ok().body("Delivery has been deleted successfully.");
    }
}