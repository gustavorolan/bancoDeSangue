package com.BancoDeSangue.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class LocalDateService {
	public LocalDate now() {
		return LocalDate.now();
	}
}
