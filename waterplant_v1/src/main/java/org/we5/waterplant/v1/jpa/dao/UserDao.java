/**
 * 
 */
package org.we5.waterplant.v1.jpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.we5.waterplant.v1.jpa.bean.User;

/**
 * @author KARNA
 *
 */
@Repository
public interface UserDao {

	public void saveUser(User user);

	public List<User> findAllUsers();

	public void deleteUserById(String id);

	public User findById(String id);

	public void updateUser(User user);

}
