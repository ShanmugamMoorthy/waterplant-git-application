/**
 * 
 */
package org.we5.waterplant.v1.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.we5.waterplant.v1.jpa.bean.Employee;


/**
 * @author KARNA
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
