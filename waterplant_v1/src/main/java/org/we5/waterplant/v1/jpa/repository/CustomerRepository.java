/**
 * 
 */
package org.we5.waterplant.v1.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.we5.waterplant.v1.jpa.bean.Customer;

/**
 * @author KARNA
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
