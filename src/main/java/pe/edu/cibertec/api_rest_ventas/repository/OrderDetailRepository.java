package pe.edu.cibertec.api_rest_ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.cibertec.api_rest_ventas.model.OrderDetail;
import pe.edu.cibertec.api_rest_ventas.model.ProductOrderId;

public interface OrderDetailRepository
 extends JpaRepository<OrderDetail, ProductOrderId>{

}

