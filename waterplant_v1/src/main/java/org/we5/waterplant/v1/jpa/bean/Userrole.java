package org.we5.waterplant.v1.jpa.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the waterplant_userrole database table.
 * 
 */
@Entity
@Table(name="waterplant_userrole")
@NamedQuery(name="WaterplantUserrole.findAll", query="SELECT w FROM WaterplantUserrole w")
public class Userrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String userRole;

	//bi-directional many-to-one association to WaterplantUser
	@OneToMany(mappedBy="waterplantUserrole")
	private Set<User> waterplantUsers;

	public Userrole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Set<User> getWaterplantUsers() {
		return this.waterplantUsers;
	}

	public void setWaterplantUsers(Set<User> waterplantUsers) {
		this.waterplantUsers = waterplantUsers;
	}

	public User addWaterplantUser(User waterplantUser) {
		getWaterplantUsers().add(waterplantUser);
		waterplantUser.setWaterplantUserrole(this);

		return waterplantUser;
	}

	public User removeWaterplantUser(User waterplantUser) {
		getWaterplantUsers().remove(waterplantUser);
		waterplantUser.setWaterplantUserrole(null);

		return waterplantUser;
	}

}