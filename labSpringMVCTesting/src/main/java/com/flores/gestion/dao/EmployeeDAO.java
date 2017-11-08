package com.flores.gestion.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.flores.gestion.exception.DAOException;
import com.flores.gestion.exception.EmptyResultException;
import com.flores.gestion.exception.LoginException;
import com.flores.gestion.model.Employee;

@Repository
public interface EmployeeDAO {

	Employee findEmployee(int id) throws DAOException, EmptyResultException;

	void create(String login, String password, String lastname, String firstname, int salary, int dptId) throws DAOException;

	void delete(String login) throws DAOException;

	void update(String login, String password, String lastname, String firstname, int salary, int dptId) throws DAOException;

	Employee findEmployeeByLogin(String login) throws DAOException, EmptyResultException;

	List<Employee> findAllEmployees() throws DAOException, EmptyResultException;

	List<Employee> findEmployeesByNameLastNameOrSalary(String first_name, String last_name, int salarty) throws DAOException, EmptyResultException;
	
	List<Employee> findEmployeesByName(String name) throws DAOException, EmptyResultException;

	Employee validate(String idEmployee, String clave) throws LoginException, DAOException;
	
}
