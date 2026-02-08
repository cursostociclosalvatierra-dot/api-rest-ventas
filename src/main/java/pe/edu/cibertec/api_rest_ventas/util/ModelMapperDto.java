package pe.edu.cibertec.api_rest_ventas.util;

import org.modelmapper.ModelMapper;

import pe.edu.cibertec.api_rest_ventas.dto.EntityDto;

public class ModelMapperDto {
	
	public static EntityDto convertirDto(
			Object object,
			EntityDto dto) {
		return new ModelMapper().map(object, 
				dto.getClass());
	}

}
