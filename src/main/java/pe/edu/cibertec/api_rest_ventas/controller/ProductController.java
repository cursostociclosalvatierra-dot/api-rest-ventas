package pe.edu.cibertec.api_rest_ventas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.api_rest_ventas.dto.EntityDto;
import pe.edu.cibertec.api_rest_ventas.dto.GenericResponseDto;
import pe.edu.cibertec.api_rest_ventas.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	//localhost:8061/api/v1/product
	@GetMapping
	public ResponseEntity<GenericResponseDto<List<EntityDto>>>
		getAllProducts(){
		List<EntityDto> dtoList = productService.getAllProducts();
		if(dtoList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		GenericResponseDto<List<EntityDto>> response = 
				new GenericResponseDto<>();
		response.setResponse(dtoList);
		return ResponseEntity.ok(response);
	}
	
	

}
