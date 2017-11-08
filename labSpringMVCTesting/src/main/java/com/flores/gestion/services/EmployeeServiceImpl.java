package com.flores.gestion.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flores.gestion.dao.EmployeeDAO;
import com.flores.gestion.exception.DAOException;
import com.flores.gestion.exception.EmptyResultException;
import com.flores.gestion.model.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService  {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee find(int employee_id) throws DAOException, EmptyResultException {
		
		Employee emp = employeeDAO.findEmployee(employee_id);

		return emp;
	}
	/*
	@Override
	public Employee findEmployeesByName(String first_name) throws DAOException, EmptyResultException {
		Employee emp = employeeDAO.findEmployeesByName(first_name);
		return emp;
	}
	
	@Override
	public Employee findEmployeesByNameLastNameOrSalary(String first_name,String last_name, int salary) throws DAOException, EmptyResultException {
		Employee emp = employeeDAO.findEmployeesByNameLastNameOrSalary(first_name,last_name,salary);
		return emp;
	}
	*/
	@Override
	public List<Employee> findAll() throws DAOException, EmptyResultException {
		
		List<Employee> emp = employeeDAO.findAllEmployees();

		return emp;
	}
	@Override
	public void update(String login, String password, String lastname, String firstname, int salary, int dptId)
			throws DAOException {
	
		employeeDAO.update(login, password, lastname, firstname, salary, dptId);
	}

}
