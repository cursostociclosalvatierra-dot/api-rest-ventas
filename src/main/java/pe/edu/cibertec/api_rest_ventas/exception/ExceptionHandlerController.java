package pe.edu.cibertec.api_rest_ventas.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import pe.edu.cibertec.api_rest_ventas.dto.ErrorMessage;

@RestControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(
			ResourceNotFoundException.class)
	@ResponseStatus(
			value = HttpStatus.NOT_FOUND)
	public ErrorMessage resourceNotFoundException(
			ResourceNotFoundException ex,
			WebRequest request) {
		ErrorMessage error = new ErrorMessage();
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setDateError(LocalDate.now());
		return error;
	}

}
