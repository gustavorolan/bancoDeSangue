package com.bancoDeSangue.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LocalDateServiceImplTest {

	@InjectMocks
	private LocalDateServiceImpl localDateService;

	@Test
	@DisplayName("Deve testar a localDateService")
	void now() {
		assertEquals(localDateService.now(), LocalDate.now());
	}
}