package pe.edu.cibertec.api_rest_ventas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.api_rest_ventas.dto.CategoryDto;
import pe.edu.cibertec.api_rest_ventas.dto.GenericResponseDto;
import pe.edu.cibertec.api_rest_ventas.exception.ResourceNotFoundException;
import pe.edu.cibertec.api_rest_ventas.service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
	
	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	//localhost:8061/api/v1/category
	@GetMapping
	public ResponseEntity<GenericResponseDto<List<CategoryDto>>>
		getAllCategories(){
		List<CategoryDto> categoryDtos =categoryService.getAllCategories();
		if(categoryDtos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		GenericResponseDto<List<CategoryDto>> response = 
				new GenericResponseDto<>();
		response.setResponse(categoryDtos);
		return ResponseEntity.ok(response);
	}
	//localhost:8061/api/v1/category/1
	@GetMapping("/{id}")
	public ResponseEntity<GenericResponseDto<CategoryDto>> 
		getCategoryById(@PathVariable Integer id){
		CategoryDto dto = categoryService.getCategoryById(id)
				.orElseThrow(() -> 
					new ResourceNotFoundException("La categoria con Id="
				+id+", no existe"));
		GenericResponseDto<CategoryDto> response = 
				new GenericResponseDto<>();
		response.setResponse(dto);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<GenericResponseDto<CategoryDto>> 
		registerCategory(@RequestBody CategoryDto dto){
		GenericResponseDto<CategoryDto> response = 
				new GenericResponseDto<>();
		response.setResponse(categoryService.saveCategory(dto));
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<GenericResponseDto<CategoryDto>> 
		updateCategory(@RequestBody CategoryDto dto,
				@PathVariable Integer id){	
		categoryService.getCategoryById(id)
		.orElseThrow(() -> 
			new ResourceNotFoundException("La categoria con Id="
		+id+", no existe"));
		dto.setId(id);
		GenericResponseDto<CategoryDto> response = 
				new GenericResponseDto<>();		
		response.setResponse(categoryService.saveCategory(dto));
		return ResponseEntity.ok(response);
	}
	
	

}
