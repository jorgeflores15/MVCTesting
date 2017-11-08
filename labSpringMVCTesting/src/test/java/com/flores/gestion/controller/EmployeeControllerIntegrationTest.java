package com.flores.gestion.controller;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/dispatcher-servlet.xml")
@WebAppConfiguration
public class EmployeeControllerIntegrationTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
    @Test
    public void givenWac_whenServletContext_thenItProvidesGreetController() {
    ServletContext servletContext = wac.getServletContext();
     
    Assert.assertNotNull(servletContext);
    Assert.assertTrue(servletContext instanceof MockServletContext);
    Assert.assertNotNull(wac.getBean("employeeController"));
    }
    
    @Test
	public void list() throws Exception {
		mockMvc.perform(get("/admin/emp/list"))
				.andExpect(status().isOk())
				.andExpect(view().name("admin/emp/list"))
				.andExpect(forwardedUrl("/WEB-INF/views/admin/emp/list.jsp"))
				.andExpect(model().attribute("employees", hasSize(180)))
				.andExpect(model().attribute("employees",
						hasItem(allOf(  
										hasProperty("employeeId", is(100)),
										hasProperty("login", is("jgomez")),
										hasProperty("password", is("123456")),
										hasProperty("firstname", is("Jaime")),
										hasProperty("lastname", is("Gomez")), 
										hasProperty("salary", is(2505)) //,
										//hasProperty("department",hasProperty("departmentId", is(12)))
									))));
	}

}

