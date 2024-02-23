package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class    OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/")
    public String showOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping("/saveOrder")
    public String saveOrder(Order order) {
        orderRepository.save(order);
        return "redirect:/orderList";
    }

    @GetMapping("/orderList")
    public String showOrderList(Model model) {
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "orderList";
    }
}