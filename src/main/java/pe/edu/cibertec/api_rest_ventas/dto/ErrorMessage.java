package pe.edu.cibertec.api_rest_ventas.dto;

import java.time.LocalDate;

public class ErrorMessage {
	
	private Integer statusCode;
	private LocalDate dateError;
	private String message;
	
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public LocalDate getDateError() {
		return dateError;
	}
	public void setDateError(LocalDate dateError) {
		this.dateError = dateError;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
