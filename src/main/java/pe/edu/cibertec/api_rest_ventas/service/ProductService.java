package pe.edu.cibertec.api_rest_ventas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pe.edu.cibertec.api_rest_ventas.dto.EntityDto;
import pe.edu.cibertec.api_rest_ventas.dto.ProductDto;
import pe.edu.cibertec.api_rest_ventas.model.Category;
import pe.edu.cibertec.api_rest_ventas.model.Product;
import pe.edu.cibertec.api_rest_ventas.projection.ProductContactProjection;
import pe.edu.cibertec.api_rest_ventas.repository.ProductRepository;
import pe.edu.cibertec.api_rest_ventas.util.ModelMapperDto;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	


	
	
	public List<EntityDto> getAllProducts(){
		List<EntityDto> dtoList = new ArrayList<>();
		dtoList = productRepository.findAll()
				.stream()
				.map(p ->  ModelMapperDto.convertirDto(
						p, new ProductDto()))
				.collect(Collectors.toList());
		if(dtoList.isEmpty())
			return null;
		return dtoList;
	}
	
	
	public List<Product> getProductByDiscontinued(Boolean discontinued){
		return productRepository.getProductsNonDiscontinuedSQL(discontinued);
	}
	
	public List<ProductContactProjection> getProductsByStockDiscontinued(
			Integer stock, Boolean discontinued){
		return productRepository.getProductsByStockDiscontinued(stock,
				discontinued);
	}
	
	public void updateStockProductsById(Integer stock, 
			Integer productid) {
		productRepository.updateStockProductsById(stock, productid);
	}

}
