package pe.edu.cibertec.api_rest_ventas.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.cibertec.api_rest_ventas.projection.OrderByDateProjection;
import pe.edu.cibertec.api_rest_ventas.repository.OrderDetailRepository;

@Service
public class OrderDetailService {
	
	private final OrderDetailRepository orderDetailRepository;

	public OrderDetailService(OrderDetailRepository orderDetailRepository) {		
		this.orderDetailRepository = orderDetailRepository;
	}
	public List<OrderByDateProjection> getOrderByDate(
			LocalDate fechaInicio, LocalDate fechaFin){
		if(fechaInicio == null || fechaFin == null) {
			throw new IllegalArgumentException("Fecha inicio y fin obligatorios");
		}
		if(fechaFin.isBefore(fechaInicio)) {
			throw new IllegalArgumentException("La Fecha fin debe ser mayor a la de inicio");
		}
		return orderDetailRepository.getOrderByDate(fechaInicio, fechaFin);
	}

}
