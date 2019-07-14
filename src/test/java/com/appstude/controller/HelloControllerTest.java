package com.appstude.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.appstude.dto.HelloDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
public class HelloControllerTest {

	
	private MockMvc mockMvc;
	
	
	
	@InjectMocks
	private HelloController helloController;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
	}
	
	@Test
	public void getDataTest() throws Exception {
		
		mockMvc.perform(
				MockMvcRequestBuilders.get("/api/hello")
				).andExpect(MockMvcResultMatchers.status().isOk()
				).andExpect(MockMvcResultMatchers.content().string("Hello Wrold"));
	}
	
	@Test
	public void getDataTest2() throws Exception {
		
		mockMvc.perform(get("/api/hello")
				).andExpect(status().isOk()
				).andExpect(content().string("Hello Wrold"));
	}
	
	@Test
	public void getJsonDataTest() throws Exception {
		
		mockMvc.perform(get("/api/jsonData")
				.accept(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk())
				 .andExpect(jsonPath("$.title", Matchers.is("Greetings")))
				 .andExpect(jsonPath("$.value", Matchers.is("Hello World")));
	}
	
	  @Test
	    public void postDataTest() throws Exception {
	        //String json = "{\n" +"  \"title\": \"Greetings\",\n" +"  \"value\": \"Hello World\"\n" +"}";
		    ObjectMapper objectMapper = new ObjectMapper();
	        HelloDto helloDto = new HelloDto("Greetings","Hello World");
	        
	        mockMvc.perform(post("/api/postData")
	                .contentType(MediaType.APPLICATION_JSON)
	              //  .content(json))
	                .content(objectMapper.writeValueAsString(helloDto)))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.title", Matchers.is("Greetings")))
	                .andExpect(jsonPath("$.value", Matchers.is("Hello World")))
	                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
	    }
	
}
