/**
 * 
 */
package org.we5.waterplant.v1.jpa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.we5.waterplant.v1.jpa.bean.User;
import org.we5.waterplant.v1.jpa.dao.UserDao;

/**
 * @author KARNA
 *
 */
@Repository
public class UserDaoImpl extends AbstractDao implements UserDao {

	public void saveUser(User user) {
		persist(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = getSession().createCriteria(User.class);
		return (List<User>) criteria.list();
	}

	public void deleteUserById(String id) {
		Query query = getSession().createSQLQuery(" ");
		query.setString("id", id);
		query.executeUpdate();
	}

	public User findById(String id) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("userID", id));
		return (User) criteria.uniqueResult();
	}

	public void updateUser(User User) {
		getSession().update(User);
	}

}
