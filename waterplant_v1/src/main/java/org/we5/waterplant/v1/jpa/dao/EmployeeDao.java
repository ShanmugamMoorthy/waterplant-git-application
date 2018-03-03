/**
 * 
 */
package org.we5.waterplant.v1.jpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.we5.waterplant.v1.jpa.bean.Employee;

/**
 * @author KARNA
 *
 */
@Repository
public interface EmployeeDao {

	public void saveEmployee(Employee employee);

	public List<Employee> findAllEmployees();

	public void deleteEmployeeById(String id);

	public Employee findById(String id);

	public void updateEmployee(Employee employee);
}
