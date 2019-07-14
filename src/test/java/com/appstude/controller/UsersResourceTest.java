package com.appstude.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.appstude.repositories.UsersRepository;
@RunWith(SpringRunner.class)
@WebMvcTest(UsersResource.class)
public class UsersResourceTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
    UsersRepository usersRepository;
	
	@Test
	public void getDataTest() throws Exception {
		
		when(usersRepository.findAll()).thenReturn(
			Collections.emptyList()	
			);
		
		 MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/rest/users/all")
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		 
		 
		 System.out.println(mvcResult.getResponse());
		 
		 //verify that usersRepository.findAll() was called
		verify(usersRepository).findAll();
	}
}
