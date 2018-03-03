/**
 * 
 */
package org.we5.waterplant.v1.inquiry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.we5.waterplant.v1.exception.RestExceptionHandler;
import org.we5.waterplant.v1.jpa.bean.User;
import org.we5.waterplant.v1.jpa.dao.UserDao;

/**
 * @author KARNA
 *
 */
@Service
public class WaterPlantInquiryMgmtService {

	@Autowired
	RestExceptionHandler exceptionHandler;

	@Autowired
	UserDao userDao;

	@Transactional
	public User getUserByUserId(String userId) {

		User userObject = null;
		try {
			userObject = userDao.findById(userId);
		} catch (Exception ex) {
			exceptionHandler.handleServiceException(ex);
		}

		return userObject;
	}

	@Transactional
	public List<User> getUsers() {

		List<User> userList = null;
		try {
			userList = userDao.findAllUsers();
		} catch (Exception ex) {
			exceptionHandler.handleServiceException(ex);
		}

		return userList;
	}

}
