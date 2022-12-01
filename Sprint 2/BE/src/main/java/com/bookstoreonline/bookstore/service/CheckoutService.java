package com.bookstoreonline.bookstore.service;

import com.bookstoreonline.bookstore.dto.Purchase;
import com.bookstoreonline.bookstore.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
