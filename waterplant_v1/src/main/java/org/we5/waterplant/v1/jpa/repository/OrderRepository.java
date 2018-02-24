/**
 * 
 */
package org.we5.waterplant.v1.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.we5.waterplant.v1.jpa.bean.Order;

/**
 * @author KARNA
 *
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
