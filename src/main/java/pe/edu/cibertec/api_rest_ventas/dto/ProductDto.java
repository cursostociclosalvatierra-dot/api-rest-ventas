package pe.edu.cibertec.api_rest_ventas.dto;

public class ProductDto implements EntityDto {
	
	private Integer productid;
	private String productname;
	private String quantityperunit;
	private Double unitprice;
	private Integer unitsinstock;
	
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getQuantityperunit() {
		return quantityperunit;
	}
	public void setQuantityperunit(String quantityperunit) {
		this.quantityperunit = quantityperunit;
	}
	public Double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}
	public Integer getUnitsinstock() {
		return unitsinstock;
	}
	public void setUnitsinstock(Integer unitsinstock) {
		this.unitsinstock = unitsinstock;
	}
	
	

}
