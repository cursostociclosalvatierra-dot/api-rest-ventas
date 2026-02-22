package pe.edu.cibertec.api_rest_ventas.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.api_rest_ventas.dto.GenericResponseDto;
import pe.edu.cibertec.api_rest_ventas.projection.OrderByDateProjection;
import pe.edu.cibertec.api_rest_ventas.service.OrderDetailService;

@RestController
@RequestMapping("/api/v1/order-detail")
public class OrderDetailController {
	
	private final OrderDetailService orderDetailService;

	public OrderDetailController(OrderDetailService orderDetailService) {
		this.orderDetailService = orderDetailService;
	}
	//localhost:8062/api/v1/order-detail/by-date?inicio=&fin
	@GetMapping("/by-date")
	public ResponseEntity<GenericResponseDto<List<OrderByDateProjection>>>
		getOrdersByDate(
				@RequestParam 
				@DateTimeFormat(pattern = "dd-MM-yyyy") 
				LocalDate inicio,
				@RequestParam 
				@DateTimeFormat(pattern = "dd-MM-yyyy") 
				LocalDate fin){
		GenericResponseDto<List<OrderByDateProjection>> response 
			= new GenericResponseDto<>();
		response.setResponse(orderDetailService.getOrderByDate(inicio,
				fin));
		return ResponseEntity.ok(response);
	}
	
	

}
