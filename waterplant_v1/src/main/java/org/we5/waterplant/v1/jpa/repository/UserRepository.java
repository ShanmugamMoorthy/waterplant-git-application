/**
 * 
 */
package org.we5.waterplant.v1.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.we5.waterplant.v1.jpa.bean.User;

/**
 * @author KARNA
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
