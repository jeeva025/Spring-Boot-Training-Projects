package com.foodorder.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrder {
    private Long orderId;

    @NotBlank(message = "Customer Name is required")
    private String customerName;


    @NotBlank(message = "Food Item Name can't be empty")
    private String foodItem;

    @NotNull(message = "Quantity required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

    @NotNull(message = "Price required")
    @Min(value = 0, message = "Price cannot be negative")
    private double price;
}
