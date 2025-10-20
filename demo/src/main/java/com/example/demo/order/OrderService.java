package com.example.demo.order;

import com.example.demo.order.dto.OrderCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    //@Transactional
    public Long createOrder(OrderCreateRequest request) {
        // 로그인 아이디를 받아와서 존재하는지 체크
        Order existingOrder = orderRepository.findByLoginId(request.getLoginId());
        if (existingOrder != null) {
            throw new RuntimeException("이미 존재하는 주문입니다.");
        }
        Order order = new Order(
                request.getLoginId(),
                request.getSpec()
        );
        orderRepository.save(order);
        return order.getId();
    }

    //@Transactional(readOnly = true)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    //@Transactional(readOnly = ture)
    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id);
        if (order == null) {
            throw new RuntimeException("주문을 찾을 수 없습니다. ");
        }
        return order;
    }
    //@Transactional
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id);
        if (order == null) {
            throw new RuntimeException("주문을 찾을 수 없습니다. ");
        }
        orderRepository.deleteById(id);
    }
}
