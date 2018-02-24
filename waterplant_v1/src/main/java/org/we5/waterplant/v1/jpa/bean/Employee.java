package org.we5.waterplant.v1.jpa.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the waterplant_employee database table.
 * 
 */
@Entity
@Table(name="waterplant_employee")
@NamedQuery(name="WaterplantEmployee.findAll", query="SELECT w FROM WaterplantEmployee w")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empID;

	private String address;

	private int age;

	private String email;

	private String mobileNumber;

	private String name;

	//bi-directional many-to-one association to WaterplantUser
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="UserId")
	private User waterplantUser;

	public Employee() {
	}

	public int getEmpID() {
		return this.empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getWaterplantUser() {
		return this.waterplantUser;
	}

	public void setWaterplantUser(User waterplantUser) {
		this.waterplantUser = waterplantUser;
	}

}