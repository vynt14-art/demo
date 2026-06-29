package uef.edu.vn.service;

import java.util.List;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uef.edu.vn.model.Order;
import uef.edu.vn.model.OrderDetail;
import uef.edu.vn.dto.OrderHistoryDTO;
import uef.edu.vn.repository.OrderDetailRepository;
import uef.edu.vn.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository detailRepository;

    public List<Order> findAll() {

        return orderRepository.findAll();
    }

    public Order findById(
            int id) {

        return orderRepository.findById(id);
    }

    public int getLastOrderId() {

        return orderRepository.getLastOrderId();
    }

    public void saveDetail(OrderDetail detail) {
        detailRepository.save(detail);
    }

    public int save(
            Order order) {

        return orderRepository.save(order);
    }

    public int update(
            Order order) {

        return orderRepository.update(order);
    }

    public int updateStatus(
            int id,
            String status) {

        return orderRepository.updateStatus(
                id,
                status);
    }

    public int delete(
            int id) {

        detailRepository.deleteByOrderId(id);

        return orderRepository.delete(id);
    }

    public List<Order> findByStatus(
            String status) {

        return orderRepository.findByStatus(
                status);
    }

    public int countAll() {

        return orderRepository.countAll();
    }

    public int countByStatus(
            String status) {

        return orderRepository.countByStatus(
                status);
    }

    public List<Order> findByEmployeeId(
            int employeeId) {

        return orderRepository.findByEmployeeId(
                employeeId);
    }

    public List<OrderDetail> findDetails(
            int orderId) {

        return detailRepository.findByOrderId(
                orderId);
    }

    public List<OrderHistoryDTO> findOrderHistory(
            Date fromDate,
            Date toDate) {

        return orderRepository.findOrderHistory(
                fromDate,
                toDate);
    }

  

}
