package top.yigumoyan.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yigumoyan.entities.Order;
import top.yigumoyan.resp.ResultData;
import top.yigumoyan.service.OrderService;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/order/create")
    public ResultData create(Order order) {
        orderService.create(order);
        return ResultData.success(order);
    }
}