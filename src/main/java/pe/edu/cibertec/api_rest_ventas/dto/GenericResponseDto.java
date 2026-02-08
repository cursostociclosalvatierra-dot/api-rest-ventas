package pe.edu.cibertec.api_rest_ventas.dto;

public class GenericResponseDto<T> {
	
	private T response;
	private ErrorMessage error;
	
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	public ErrorMessage getError() {
		return error;
	}
	public void setError(ErrorMessage error) {
		this.error = error;
	}
	
	

}
