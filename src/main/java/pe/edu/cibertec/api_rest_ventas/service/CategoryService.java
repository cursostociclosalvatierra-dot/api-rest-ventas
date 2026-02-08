package pe.edu.cibertec.api_rest_ventas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import pe.edu.cibertec.api_rest_ventas.dto.CategoryDto;
import pe.edu.cibertec.api_rest_ventas.model.Category;
import pe.edu.cibertec.api_rest_ventas.repository.CategoryRepository;
import pe.edu.cibertec.api_rest_ventas.util.MapperDto;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	
	public List<CategoryDto> getAllCategories(){
		List<Category> categoryList = categoryRepository.findAll();
		List<CategoryDto> categoryDtos = new ArrayList<>();
		for(Category cat: categoryList) {
			categoryDtos.add(MapperDto.convertCategoryDto(cat));
		}
		return categoryDtos;
	}
	
	public Optional<CategoryDto> getCategoryById(Integer id){
		Category category = categoryRepository.findById(id).orElse(null);
		if(category != null ) {
			return Optional.of(MapperDto.convertCategoryDto(category));
		}else {
			return Optional.empty();
		}
	}
	
	public CategoryDto saveCategory(CategoryDto dto) {
		Category category = categoryRepository.save(
				MapperDto.convertCategory(dto));
		return MapperDto.convertCategoryDto(category);		
	}
	
	
	

}
