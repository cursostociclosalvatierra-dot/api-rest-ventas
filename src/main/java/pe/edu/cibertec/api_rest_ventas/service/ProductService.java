package pe.edu.cibertec.api_rest_ventas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pe.edu.cibertec.api_rest_ventas.dto.EntityDto;
import pe.edu.cibertec.api_rest_ventas.dto.ProductDto;
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

}
