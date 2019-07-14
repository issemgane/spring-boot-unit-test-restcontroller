package com.appstude.integrationtest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.appstude.SpringBootUnitTestRestcontrollerApplication;
import com.appstude.controller.UsersResource;
import com.appstude.repositories.UsersRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment=WebEnvironment.RANDOM_PORT,
		classes=SpringBootUnitTestRestcontrollerApplication.class
)
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application-test.properties")
public class UsersResourceTest {
	
	@Autowired
	private MockMvc mockMvc;
	

	
	@Test
	public void getDataTest() throws Exception {
		
	
		
		 MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/rest/users/all")
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		 
		 
		 System.out.println(mvcResult.getResponse());
		 
		 //verify that usersRepository.findAll() was called
	
	}

}
