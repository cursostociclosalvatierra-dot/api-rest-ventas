package pe.edu.cibertec.api_rest_ventas.util;

import pe.edu.cibertec.api_rest_ventas.dto.CategoryDto;
import pe.edu.cibertec.api_rest_ventas.model.Category;

public class MapperDto {
	
	public static CategoryDto 
		convertCategoryDto(Category category) {
		CategoryDto cat = new CategoryDto();
		cat.setId(category.getCategoryid());
		cat.setNombre(category.getCategoryname());
		cat.setDescripcion(category.getDescription());
		return cat;
	}
	
	public static Category 
		convertCategory(CategoryDto category) {
		Category cat = new Category();
		cat.setCategoryid(category.getId());
		cat.setCategoryname(category.getNombre());
		cat.setDescription(category.getDescripcion());
		return cat;
	}

}
