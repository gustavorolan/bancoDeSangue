package com.BancoDeSangue.dtos.response;

import com.BancoDeSangue.model.Estado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoResponse {
	private Estado sigla;
	private String nome;
}
