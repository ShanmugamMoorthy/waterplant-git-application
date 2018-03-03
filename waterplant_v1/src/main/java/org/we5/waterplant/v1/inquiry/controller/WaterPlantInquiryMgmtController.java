/**
 * 
 */
package org.we5.waterplant.v1.inquiry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.we5.waterplant.v1.inquiry.constants.InquiryConstants;
import org.we5.waterplant.v1.inquiry.service.WaterPlantInquiryMgmtService;
import org.we5.waterplant.v1.jpa.bean.User;

/**
 * @author KARNA
 *
 */
@RestController
@EnableWebMvc
@RequestMapping(value = InquiryConstants.BASE_INQUIRY_URL)
public class WaterPlantInquiryMgmtController {

    @Autowired
    WaterPlantInquiryMgmtService inquryService;

    @RequestMapping(method = RequestMethod.GET, value = InquiryConstants.URL_USERS, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<User> getUsers() {
	List<User> usersList = null;
	usersList = this.inquryService.getUsers();

	return usersList;
    }

    @RequestMapping(method = RequestMethod.GET, value = InquiryConstants.URL_USER_BY_ID, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User getUserByUserId(@PathVariable String userId) {
	User userObject = null;
	userObject = this.inquryService.getUserByUserId(userId);

	return userObject;
    }

}
