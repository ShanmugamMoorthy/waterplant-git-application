/**
 * 
 */
package org.we5.waterplant.v1.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.we5.waterplant.v1.jpa.bean.User;

/**
 * @author KARNA
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
