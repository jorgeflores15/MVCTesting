package com.flores.gestion.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flores.gestion.exception.DAOException;
import com.flores.gestion.exception.EmptyResultException;
import com.flores.gestion.model.Employee;

@Service
public interface EmployeeService {

	List<Employee> findAll() throws DAOException, EmptyResultException;
	
	Employee find(int employee_id) throws DAOException, EmptyResultException;
	

	void update(String login, String password, String lastname, String firstname, int salary, int dptId)
			throws DAOException;

	void delete(String login) throws DAOException;

	void create(String login, String password, String lastname, String firstname, int salary, int deptId) throws DAOException;

}
