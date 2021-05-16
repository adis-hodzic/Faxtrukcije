package com.amteam.managementmicroservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
class ManagementmicroserviceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	private Logger logger = LoggerFactory.getLogger(ManagementmicroserviceApplicationTests.class);

	@Autowired
	private ObjectMapper objectMapper;
/*
	@Test
	void invalidAvgGrade() throws Exception{
		Instructor instructor = new Instructor("mujo","Hadzic",4.5,"Mujo je instruktor matematike","mujo","1234",2);
		MvcResult response = mockMvc.perform(post("/instructor")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(instructor)))
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value())).andReturn();
		logger.info(response.getResponse().getContentAsString());
		assertThat(true);
	}
	@Test
	void invalidPasswordClient() throws Exception{
		Client client = new Client("Asja", "Horozic", "asja","asja",3);
		MvcResult response = mockMvc.perform(post("/client")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(client)))
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value())).andReturn();
		logger.info(response.getResponse().getContentAsString());
		assertThat(true);
	}
	@Test
	void invalidPasswordLogin() throws Exception{
		Client client = new Client("Asja", "Horozic", "asja123","asja",3);
		mockMvc.perform(post("/client")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(client)))
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value()));

		LoginRequest loginRequest = new LoginRequest("asja","Wrong_password_123");
		MvcResult response = mockMvc.perform(post("/login")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(loginRequest)))
				.andExpect(status().is(HttpStatus.BAD_REQUEST.value())).andReturn();
		logger.info(response.getResponse().getContentAsString());
		assertThat(true);
	}
	@Test
	void noUserFoundLogin() throws Exception{
		LoginRequest loginRequest = new LoginRequest("asja1374345","Wrong_password_123");
		MvcResult response = mockMvc.perform(post("/login")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(loginRequest)))
				.andExpect(status().is(HttpStatus.NOT_FOUND.value())).andReturn();
		logger.info(response.getResponse().getContentAsString());
		assertThat(true);
	}
	@Test
	void noClientFound() throws Exception{
		MvcResult response = mockMvc.perform(get("/client/1212413542")
				.contentType("application/json"))
				.andExpect(status().is(HttpStatus.NOT_FOUND.value())).andReturn();
		logger.info(response.getResponse().getContentAsString());
		assertThat(true);
	}
	@Test
	void noInstructorFound() throws Exception{
		MvcResult response = mockMvc.perform(get("/instructor/1212413542")
				.contentType("application/json"))
				.andExpect(status().is(HttpStatus.NOT_FOUND.value())).andReturn();
		logger.info(response.getResponse().getContentAsString());
		assertThat(true);
	}
	@Test
	void listClients() throws Exception {
		MvcResult response = mockMvc.perform(get("/clients")
				.contentType("application/json"))
				.andExpect(status().is(HttpStatus.OK.value())).andReturn();
		logger.info(response.getResponse().getContentAsString());
		assertThat(true);
	}*/
}
