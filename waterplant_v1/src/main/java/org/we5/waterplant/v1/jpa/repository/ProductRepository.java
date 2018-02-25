/**
 * ProductRepository.java 
 * KARNA
 * waterplant-org-rest-api 11:34:42 PM
 * 19-Feb-2018
 *
 */
package org.we5.waterplant.v1.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.we5.waterplant.v1.jpa.bean.Product;

/**
 * @author KARNA
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
}

