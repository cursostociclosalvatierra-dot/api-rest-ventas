package pe.edu.cibertec.api_rest_ventas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.api_rest_ventas.dto.EntityDto;
import pe.edu.cibertec.api_rest_ventas.dto.GenericResponseDto;
import pe.edu.cibertec.api_rest_ventas.model.Product;
import pe.edu.cibertec.api_rest_ventas.projection.ProductContactProjection;
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
	//localhost:8061/api/v1/product/exists?discontinued=true
	@GetMapping("/exists")
	public ResponseEntity<GenericResponseDto<List<Product>>>
	 getProductsByDiscontinued(@RequestParam Boolean discontinued){
		List<Product> productList = productService
				.getProductByDiscontinued(discontinued);
		if(productList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		GenericResponseDto<List<Product>> response = 
				new GenericResponseDto<>();
		response.setResponse(productList);
		return ResponseEntity.ok(response);
	}
	//localhost:8061/api/v1/product/supplier?stock=10&discontinued=true
	@GetMapping("/supplier")
	public ResponseEntity<GenericResponseDto<List<ProductContactProjection>>>
	getProductsByStockDiscontinued(
			@RequestParam Integer stock,
			@RequestParam Boolean discontinued){
		List<ProductContactProjection> productList = productService
				.getProductsByStockDiscontinued(stock, discontinued);
		if(productList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		GenericResponseDto<List<ProductContactProjection>> response = 
				new GenericResponseDto<>();
		response.setResponse(productList);
		return ResponseEntity.ok(response);
	}	
	//localhost:8061/api/v1/product/12?stock=10
	@PatchMapping("/{id}")
	public ResponseEntity<GenericResponseDto<String>> 
	updateStockProductsById(@PathVariable Integer id,
			@RequestParam Integer stock){
		productService.updateStockProductsById(stock, id);
		GenericResponseDto<String> response = 
				new GenericResponseDto<>();
		response.setResponse("Stock actualizado correctamente");
		return ResponseEntity.ok(response);
	}
	

}
