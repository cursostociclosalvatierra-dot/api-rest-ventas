package pe.edu.cibertec.api_rest_ventas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productid;
	private String productname;
	private String quantityperunit;
	private Double unitprice;
	private Integer unitsinstock;
	private Integer unitsonorder;
	private Integer reorderlevel;
	private Boolean discontinued;	
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;	
	@ManyToOne
	@JoinColumn(name = "supplierid")
	private Supplier supplier;
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
	public Integer getUnitsonorder() {
		return unitsonorder;
	}
	public void setUnitsonorder(Integer unitsonorder) {
		this.unitsonorder = unitsonorder;
	}
	public Integer getReorderlevel() {
		return reorderlevel;
	}
	public void setReorderlevel(Integer reorderlevel) {
		this.reorderlevel = reorderlevel;
	}
	public Boolean getDiscontinued() {
		return discontinued;
	}
	public void setDiscontinued(Boolean discontinued) {
		this.discontinued = discontinued;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	

}
