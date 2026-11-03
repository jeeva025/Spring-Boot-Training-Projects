package com.foodorder.service;

import com.foodorder.exception.FoodOrderNotFound;
import com.foodorder.model.FoodOrder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodOrderService {

    private long id = 1;

    List<FoodOrder> foodOrders = new ArrayList<>();

    public List<FoodOrder> getAllFoodOrders() {

        return foodOrders;
    }


    public FoodOrder getFoodOrderById(int id) {
        for (FoodOrder foodOrder : foodOrders){
            if (foodOrder.getOrderId() == id){
                return foodOrder;
            }
        }
        throw new FoodOrderNotFound("Food Order not found");
    }

    public FoodOrder addFoodOrder(FoodOrder request) {
        FoodOrder foodOrder = new FoodOrder(
                id++,
                request.getCustomerName(),
                request.getFoodItem(),
                request.getQuantity(),
                request.getPrice()
        );
        foodOrders.add(foodOrder);
        return foodOrder;
    }

    public FoodOrder updateFoodOrder(int id, FoodOrder newOrder) {
           FoodOrder foodOrder = getFoodOrderById(id);

           foodOrder.setCustomerName(newOrder.getCustomerName());
           foodOrder.setFoodItem(newOrder.getFoodItem());
           foodOrder.setQuantity(newOrder.getQuantity());
           foodOrder.setPrice(newOrder.getPrice());
           return foodOrder;
    }

    public String deleteById(int deleteId) {
        FoodOrder foodOrder = getFoodOrderById(deleteId);
        foodOrders.remove(foodOrder);

        return "Food Order Deleted with ID : "+deleteId;

    }

    public FoodOrder modifyOrder(int id, FoodOrder newOrder) {
        FoodOrder existingOrder = getFoodOrderById(id);

        if (newOrder.getCustomerName() != null){
            existingOrder.setCustomerName(newOrder.getCustomerName());
        }
        if (newOrder.getFoodItem() != null){
            existingOrder.setFoodItem(newOrder.getFoodItem());
        }
        if (newOrder.getQuantity() > 0){
            existingOrder.setQuantity(newOrder.getQuantity());
        }
        if (newOrder.getPrice() > 0){
            existingOrder.setPrice(newOrder.getPrice());
        }
        return existingOrder;
    }
}
