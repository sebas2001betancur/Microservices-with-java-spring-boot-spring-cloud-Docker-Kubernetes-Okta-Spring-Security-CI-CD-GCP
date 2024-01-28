package com.dailycodebuffer.OrderService.service;

import com.daily.codebuffor.ProductService.model.ProductResponse;
import com.daily.codebuffor.ProductService.repository.ProductRepository;
import com.dailycodebuffer.OrderService.entity.Order;
import com.dailycodebuffer.OrderService.external.client.PaymentService;
import com.dailycodebuffer.OrderService.external.client.ProductService;
import com.dailycodebuffer.OrderService.repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ProductService productService;

    @Mock
    private PaymentService paymentService;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    OrderService orderService = new OrderServiceImpl();

    @DisplayName("Get Order - Success Scenario")
    @Test
    void test_When_Order_Success() {
        //Mocking
        Order order = getMockOrder();
        //Mockito.when(orderRepository.findById(ArgumentMatchers.anyLong()));  para que quedara presiono
        // click derecho y Add on-demand static para que solo aparezca anyLing() y lo mismo con Mockito.when()
        when(orderRepository.findById(anyLong()))
                .thenReturn(Optional.of(order));

        when(restTemplate.getForObject(
                "http://PRODUCT-SERVICE/product/" + order.getProductId(),
                ProductRepository.class
        )).thenReturn(getMockProductResponse());
  // video # 85 minuto 6:07
        //Actual
        orderService.getOrderDetails(1);
        //Verification
        //Assert
    }

    private ProductResponse getMockProductResponse() {
        return ProductResponse.builder()
                .productName("iPhone")
                .price(100)
                .quantity(200)
                .build();

    }

    private Order getMockOrder() {
        return Order.builder()
                .orderStatus("PLACED")
                .orderDate(Instant.now())
                .id(1)
                .amount(100)
                .quantity(200)
                .productId(2)
                .build();

    }


}