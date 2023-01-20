package com.bancoDeSangue.service.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class LocalDateServiceImpl {
	public LocalDate now() {
		return LocalDate.now();
	}
}
