package com.flores.gestion.dao.jdbc;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.flores.gestion.dao.EmployeeDAO;
import com.flores.gestion.exception.DAOException;
import com.flores.gestion.exception.EmptyResultException;
import com.flores.gestion.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/dispatcher-servlet.xml")
@WebAppConfiguration
public class EmployeeDAOTest {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOTest.class);

	@Autowired
	private EmployeeDAO employeeDAO;

	
	@BeforeClass	
	public static void beforeClass() {
		logger.info("Antes de todos los metodos");

	}
	
	@Before
	public  void before() {
		logger.info("Antes de cada metodo");
	}
	
	//@Test
	public void testFindEmployeeById() {

		try {
			//
			Employee emp = employeeDAO.findEmployee(100);

			Assert.assertNotNull(emp);

			Assert.assertEquals("jgomez", emp.getLogin());
			Assert.assertEquals("123456", emp.getPassword());
			Assert.assertEquals("Jaime", emp.getFirstname());
			Assert.assertEquals("Gomez", emp.getLastname());
			Assert.assertEquals(2505, emp.getSalary());

			logger.info(emp.toString());

		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}

	}
	
	//@Test
	public void testFindEmployeeByNameAndSalary() {

		try {
			//
			Employee emp = (Employee) employeeDAO.findEmployeesByNameLastNameOrSalary("jaime","gomez",2500);

		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}

	}

	//@Test
	public void testFindEmployeeByUser() {

		try {
  			
			Employee emp = employeeDAO.findEmployeeByLogin("jgomez");
			Employee emp2 = employeeDAO.findEmployeeByLogin("jflores");
  
 			Assert.assertEquals("123456", emp.getPassword());
 			Assert.assertEquals("Jaime", emp.getFirstname());
 			Assert.assertEquals("Gomez", emp.getLastname());
 			Assert.assertEquals(2505, emp.getSalary());
 			Assert.assertEquals("contraseña", emp2.getPassword());
 			Assert.assertEquals("Jorge", emp2.getFirstname());
 			Assert.assertEquals("Flores", emp2.getLastname());
 			Assert.assertEquals(5500, emp2.getSalary());
  
  			logger.info(emp.toString());
  		} catch (EmptyResultException e) {
  			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}
	
	
	@After
	public void after() {
		logger.info("Despues de cada metodo");
	}
	
	@AfterClass
	public static void afterClass() {
		logger.info("Despues de todos los metodos");
	}
}
