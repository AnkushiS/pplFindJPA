package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CUSTOMERS database table.
 * 
 */
@Entity
@Table(name="CUSTOMERS", schema="TESTDB")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CUST_ID")
	private long custId;

	private Double cityid;

	private Double companyid;

	private String emailaddress;

	private String firstname;

	private String fullname;

	private String lastname;

	@Column(name="\"POSITION\"")
	private String position;

	private Double stateid;

	private String streetaddress;

	private String title;

	private Double zipcode;

	public Customer() {
	}

	public long getCustId() {
		return this.custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public Double getCityid() {
		return this.cityid;
	}

	public void setCityid(Double cityid) {
		this.cityid = cityid;
	}

	public Double getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(Double companyid) {
		this.companyid = companyid;
	}

	public String getEmailaddress() {
		return this.emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Double getStateid() {
		return this.stateid;
	}

	public void setStateid(Double stateid) {
		this.stateid = stateid;
	}

	public String getStreetaddress() {
		return this.streetaddress;
	}

	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(Double zipcode) {
		this.zipcode = zipcode;
	}

}