package com.flores.gestion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flores.gestion.dao.EmployeeDAO;
import com.flores.gestion.exception.DAOException;
import com.flores.gestion.exception.LoginException;
import com.flores.gestion.model.Employee;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee validate(String login, String password) throws LoginException, DAOException {

		Employee emp = employeeDAO.validate(login, password);

		return emp;
	}

}

