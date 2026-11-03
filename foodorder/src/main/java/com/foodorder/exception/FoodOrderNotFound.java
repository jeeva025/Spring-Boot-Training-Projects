package com.foodorder.exception;

public class FoodOrderNotFound extends RuntimeException {
    public FoodOrderNotFound(String message) {
        super(message);
    }
}
