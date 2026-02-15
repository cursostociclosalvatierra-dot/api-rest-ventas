package pe.edu.cibertec.api_rest_ventas.projection;


public interface ProductContactProjection {
	//product_name
	//@Value("#{target.product_name}")
	String getProductName();
	Integer getUnitsInStock();
	Double getUnitPrice();
	String getCategoryName();
	String getContactName();
}
