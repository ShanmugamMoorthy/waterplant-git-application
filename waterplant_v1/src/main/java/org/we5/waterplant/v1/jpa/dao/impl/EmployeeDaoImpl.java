/**
 * 
 */
package org.we5.waterplant.v1.jpa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.we5.waterplant.v1.jpa.bean.Employee;
import org.we5.waterplant.v1.jpa.dao.EmployeeDao;

/**
 * @author KARNA
 *
 */

@Repository
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao {

	public void saveEmployee(Employee employee) {
		persist(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		Criteria criteria = getSession().createCriteria(Employee.class);
		return (List<Employee>) criteria.list();
	}

	public void deleteEmployeeById(String id) {
		Query query = getSession().createSQLQuery("");
		query.setString("", "");
		query.executeUpdate();
	}

	public Employee findById(String id) {
		Criteria criteria = getSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("", ""));
		return (Employee) criteria.uniqueResult();
	}

	public void updateEmployee(Employee employee) {
		getSession().update(employee);
	}

}
