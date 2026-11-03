package com.foodorder.controller;

import com.foodorder.model.FoodOrder;
import com.foodorder.service.FoodOrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foodorders")

public class FoodOrderController {

    @Autowired
    private FoodOrderService foodOrderService;

//· GET → Get all orders
//· GET by ID
//· POST → Add order
//· PUT → Update order
//· DELETE → Delete order
//· PATCH à Partial Updation

    @GetMapping
    public List<FoodOrder> getAllFoodOrders(){
        return foodOrderService.getAllFoodOrders();
    }

    @GetMapping("{id}")
    public FoodOrder getFoodOrderById(@PathVariable int id){
        return foodOrderService.getFoodOrderById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FoodOrder addFoodOrder(@Valid @RequestBody FoodOrder foodOrder){
        return foodOrderService.addFoodOrder(foodOrder);
    }

    @PutMapping("{id}")
    public FoodOrder updateFoodOrder(@PathVariable int id, @Valid  @RequestBody FoodOrder foodOrder){
        return foodOrderService.updateFoodOrder(id,foodOrder);
    }

    @DeleteMapping("{id}")
    public String deleteById(@PathVariable int id){
        return foodOrderService.deleteById(id);
    }

    @PatchMapping("{id}")
    public FoodOrder modifyOrder(@PathVariable int id,  @RequestBody FoodOrder foodOrder){
        return foodOrderService.modifyOrder(id, foodOrder);
    }
}
