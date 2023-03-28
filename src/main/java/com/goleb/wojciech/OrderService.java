package com.goleb.wojciech;

import java.time.LocalDateTime;
import java.util.List;

public class OrderService {
    CastCalculator castCalculator = new CastCalculator();
    OrderRepository orderRepository = new OrderRepository();
    public void createOrderAndUpdateOrderLog(String customerName, List<Figure> list ){
        orderRepository.addToOrderLogAndSaveToFile(
                new Order(customerName,list,castCalculator.calculationOfPrice(list), LocalDateTime.now()));
    }
}
