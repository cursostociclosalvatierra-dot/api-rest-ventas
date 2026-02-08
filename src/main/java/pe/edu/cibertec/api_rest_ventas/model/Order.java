package pe.edu.cibertec.api_rest_ventas.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderid;
	private LocalDateTime orderdate;
	private LocalDateTime requireddate;
	private LocalDateTime shippeddate;
	private Integer shipvia;
	private Double freight;
	private String shipname;
	private String shipaddress;
	private String shipcity;
	private String shipregion;
	private String shippostalcode;
	private String shipcountry;	
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name="employeeid")
	private Employee employee;
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public LocalDateTime getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(LocalDateTime orderdate) {
		this.orderdate = orderdate;
	}
	public LocalDateTime getRequireddate() {
		return requireddate;
	}
	public void setRequireddate(LocalDateTime requireddate) {
		this.requireddate = requireddate;
	}
	public LocalDateTime getShippeddate() {
		return shippeddate;
	}
	public void setShippeddate(LocalDateTime shippeddate) {
		this.shippeddate = shippeddate;
	}
	public Integer getShipvia() {
		return shipvia;
	}
	public void setShipvia(Integer shipvia) {
		this.shipvia = shipvia;
	}
	public Double getFreight() {
		return freight;
	}
	public void setFreight(Double freight) {
		this.freight = freight;
	}
	public String getShipname() {
		return shipname;
	}
	public void setShipname(String shipname) {
		this.shipname = shipname;
	}
	public String getShipaddress() {
		return shipaddress;
	}
	public void setShipaddress(String shipaddress) {
		this.shipaddress = shipaddress;
	}
	public String getShipcity() {
		return shipcity;
	}
	public void setShipcity(String shipcity) {
		this.shipcity = shipcity;
	}
	public String getShipregion() {
		return shipregion;
	}
	public void setShipregion(String shipregion) {
		this.shipregion = shipregion;
	}
	public String getShippostalcode() {
		return shippostalcode;
	}
	public void setShippostalcode(String shippostalcode) {
		this.shippostalcode = shippostalcode;
	}
	public String getShipcountry() {
		return shipcountry;
	}
	public void setShipcountry(String shipcountry) {
		this.shipcountry = shipcountry;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
}
