package com.metrics.view.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.metrics.persistence.model.Role;
import com.metrics.persistence.model.User;
import com.metrics.persistence.service.IUserService;

@Named
@RequestScoped
public class RegistrationController {
	private static final Log log = LogFactory
			.getLog(RegistrationController.class);

	@Inject
	private IUserService service;

	private User user = new User();

	{
		final Role role = new Role(Role.ROLE_USER);
		user.setRole(role);
	}

	public void doRegister() {
		log.info("Registering...");
		service.create(user);
		log.info("Registration success");
	}

	public User getUser() {
		return user;
	}

}
