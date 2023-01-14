package com.BancoDeSangue.service;

import static com.BancoDeSangue.model.TipoSanguineo.A_B_POSITIVO;
import static com.BancoDeSangue.model.TipoSanguineo.A_NEGATIVO;
import static com.BancoDeSangue.model.TipoSanguineo.A_POSITIVO;

import org.springframework.stereotype.Service;

import com.BancoDeSangue.model.TipoSanguineo;

@Service
public class APositivoService {
	boolean isPossivelDoar(TipoSanguineo tipoSanguineo){
		return tipoSanguineo == A_B_POSITIVO || tipoSanguineo == A_POSITIVO;
	}

	boolean isPossivelReceber(TipoSanguineo tipoSanguineo){
		return tipoSanguineo == A_NEGATIVO ||
				tipoSanguineo == A_POSITIVO ||
				tipoSanguineo == A_B_POSITIVO ||
				tipoSanguineo == A_POSITIVO;;
	}
}
