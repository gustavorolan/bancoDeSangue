package com.BancoDeSangue.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.BancoDeSangue.model.Usuario;
import com.BancoDeSangue.service.IdadeService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IdadeServiceImpl implements IdadeService {

	private final LocalDateServiceImpl localDateServiceImpl;

	@Override
	public Usuario preencher(Usuario usuario) {
		LocalDate nascimento = converterParaLocalDate(usuario.getInformacoesPessoais().getData_nasc());
		LocalDate hoje = localDateServiceImpl.now();
		LocalDate aniversario = LocalDate.of(hoje.getYear(),nascimento.getMonth(), nascimento.getDayOfMonth());
		int idade = hoje.compareTo(nascimento);

		if(aniversario.isAfter(hoje)) idade--;
		usuario.setIdade(idade);
		return usuario;
	}

	private LocalDate converterParaLocalDate(String dataNascimento) {
		List<String> split = List.of(dataNascimento.split("/"));
		List<Integer> numerosData = split.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		Integer ano = numerosData.get(2);
		Integer mes = numerosData.get(1);
		Integer dia = numerosData.get(0);
		return LocalDate.of(ano, mes, dia);
	}
}
