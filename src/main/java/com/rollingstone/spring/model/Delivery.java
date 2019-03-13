package com.rollingstone.spring.model;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ROLLINGSTONE_DELIVERY")
public class Delivery {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "OFFERID", nullable = false)
    private Long offerId;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    @Column(name = "IS_AVAILABLE", nullable = false)
    private boolean isAvailable;

    @Temporal(TemporalType.DATE)
    @Column(name = "AVAILABLE_DATE", unique = true, nullable = false)
    private Date availableDate;

    @Column(name = "DAYS_IN_TRANSIT", nullable = false)
    private int daysInTransit;

    @Column(name = "DELIVERY_CHARGE", nullable = false)
    private Double deliveryCharge;

    @Column(name = "IS_FREE_FOR_MEMBERS", nullable = false)
    private boolean isFreeForMembers;

    @Column(name = "HAUL_AWAY_MESSAGE", nullable = false)
    private String haulAwayMessage;

    @Column(name = "HAS_SPECIAL_OFFERS", nullable = false)
    private boolean hasSpecialOffers;

    public Delivery() {
    }

    public Delivery(Long offerId, Long productId, boolean isAvailable, Date availableDate, int daysInTransit, Double deliveryCharge,
		    boolean isFreeForMembers, String haulAwayMessage, boolean hasSpecialOffers) {
	this.offerId = offerId;
	this.productId = productId;
	this.isAvailable = isAvailable;
	this.availableDate = availableDate;
	this.daysInTransit = daysInTransit;
	this.deliveryCharge = deliveryCharge;
	this.isFreeForMembers = isFreeForMembers;
	this.haulAwayMessage = haulAwayMessage;
	this.hasSpecialOffers = hasSpecialOffers;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public Long getOfferId() {
	return offerId;
    }

    public void setOfferId(Long offerId) {
	this.offerId = offerId;
    }

    public Long getProductId() {
	return productId;
    }

    public void setProductId(Long productId) {
	this.productId = productId;
    }

    public boolean isAvailable() {
	return isAvailable;
    }

    public void setAvailable(boolean available) {
	isAvailable = available;
    }

    public Date getAvailableDate() {
	return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
	this.availableDate = availableDate;
    }

    public int getDaysInTransit() {
	return daysInTransit;
    }

    public void setDaysInTransit(int daysInTransit) {
	this.daysInTransit = daysInTransit;
    }

    public Double getDeliveryCharge() {
	return deliveryCharge;
    }

    public void setDeliveryCharge(Double deliveryCharge) {
	this.deliveryCharge = deliveryCharge;
    }

    public boolean isFreeForMembers() {
	return isFreeForMembers;
    }

    public void setFreeForMembers(boolean freeForMembers) {
	isFreeForMembers = freeForMembers;
    }

    public String getHaulAwayMessage() {
	return haulAwayMessage;
    }

    public void setHaulAwayMessage(String haulAwayMessage) {
	this.haulAwayMessage = haulAwayMessage;
    }

    public boolean isHasSpecialOffers() {
	return hasSpecialOffers;
    }

    public void setHasSpecialOffers(boolean hasSpecialOffers) {
	this.hasSpecialOffers = hasSpecialOffers;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	Delivery delivery = (Delivery)o;
	return id == delivery.id
			&& isAvailable == delivery.isAvailable
			&& daysInTransit == delivery.daysInTransit
			&& isFreeForMembers == delivery.isFreeForMembers
			&& hasSpecialOffers == delivery.hasSpecialOffers
			&& Objects.equals(offerId, delivery.offerId)
			&& Objects.equals(productId, delivery.productId)
			&& Objects.equals(availableDate, delivery.availableDate)
			&& Objects.equals(deliveryCharge, delivery.deliveryCharge)
			&& Objects.equals(haulAwayMessage, delivery.haulAwayMessage);
    }

    @Override
    public int hashCode() {
	return Objects.hash(id, offerId, productId, isAvailable, availableDate, daysInTransit, deliveryCharge, isFreeForMembers,
			    haulAwayMessage, hasSpecialOffers);
    }

    @Override
    public String toString() {
	return "Delivery{"
			+ "id="
			+ id
			+ ", offerId="
			+ offerId
			+ ", productId="
			+ productId
			+ ", isAvailable="
			+ isAvailable
			+ ", availableDate="
			+ availableDate
			+ ", daysInTransit="
			+ daysInTransit
			+ ", deliveryCharge="
			+ deliveryCharge
			+ ", isFreeForMembers="
			+ isFreeForMembers
			+ ", haulAwayMessage='"
			+ haulAwayMessage
			+ '\''
			+ ", hasSpecialOffers="
			+ hasSpecialOffers
			+ '}';
    }
}
