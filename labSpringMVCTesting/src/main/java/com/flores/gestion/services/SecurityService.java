package com.flores.gestion.services;

import com.flores.gestion.exception.DAOException;
import com.flores.gestion.exception.LoginException;
import com.flores.gestion.model.Employee;

public interface SecurityService {

	Employee validate(String idEmployee, String clave) throws LoginException, DAOException;

}
