package com.bookstoreonline.bookstore.dto;

import lombok.Data;

@Data
public class PurchaseResponse {
    private final String orderTrackingNumber;

    public PurchaseResponse(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }
}
