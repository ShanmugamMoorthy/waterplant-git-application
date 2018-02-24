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
import org.we5.waterplant.v1.jpa.repository.UserRepository;

/**
 * @author KARNA
 *
 */
@Service
public class WaterPlantInquiryMgmtService {

	@Autowired
	RestExceptionHandler exceptionHandler;

	@Autowired
	UserRepository userRepository;

	@Transactional("transactionManager")
	public User getUserByUserId(String userId) {

		User userObject = null;
		try {
			userObject = userRepository.getOne(Integer.parseInt(userId));
		} catch (Exception ex) {
			exceptionHandler.handleServiceException(ex);
		}

		return userObject;
	}

	@Transactional("transactionManager")
	public List<User> getUsers() {

		List<User> userList = null;
		try {
			userList = userRepository.findAll();
		} catch (Exception ex) {
			exceptionHandler.handleServiceException(ex);
		}

		return userList;
	}

}
