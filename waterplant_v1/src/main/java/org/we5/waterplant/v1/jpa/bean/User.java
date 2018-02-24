package org.we5.waterplant.v1.jpa.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the waterplant_user database table.
 * 
 */
@Entity
@Table(name="waterplant_user", schema = "waterplant")
@NamedQuery(name="WaterplantUser.findAll", query="SELECT w FROM WaterplantUser w")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userID;

	private Timestamp date_of_creation;

	private String userName;

	private String userPassword;

	//bi-directional many-to-one association to WaterplantEmployee
	@OneToMany(mappedBy="waterplantUser")
	private Set<Employee> waterplantEmployees;

	//bi-directional many-to-one association to WaterplantUserrole
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Role_id")
	private Userrole waterplantUserrole;

	public User() {
	}

	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Timestamp getDate_of_creation() {
		return this.date_of_creation;
	}

	public void setDate_of_creation(Timestamp date_of_creation) {
		this.date_of_creation = date_of_creation;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Set<Employee> getWaterplantEmployees() {
		return this.waterplantEmployees;
	}

	public void setWaterplantEmployees(Set<Employee> waterplantEmployees) {
		this.waterplantEmployees = waterplantEmployees;
	}

	public Employee addWaterplantEmployee(Employee waterplantEmployee) {
		getWaterplantEmployees().add(waterplantEmployee);
		waterplantEmployee.setWaterplantUser(this);

		return waterplantEmployee;
	}

	public Employee removeWaterplantEmployee(Employee waterplantEmployee) {
		getWaterplantEmployees().remove(waterplantEmployee);
		waterplantEmployee.setWaterplantUser(null);

		return waterplantEmployee;
	}

	public Userrole getWaterplantUserrole() {
		return this.waterplantUserrole;
	}

	public void setWaterplantUserrole(Userrole waterplantUserrole) {
		this.waterplantUserrole = waterplantUserrole;
	}

}