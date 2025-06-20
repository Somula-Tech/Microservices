package com.app;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ApplicationGatewayApplicationTests {

	@InjectMocks
	ApplicationGatewayApplication applicationGatewayApplication;

	@Test
	void contextLoads() {
		assertNotNull(applicationGatewayApplication);
	}

}
