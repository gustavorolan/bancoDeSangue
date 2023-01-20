package com.bancoDeSangue.service.tipoSanguineo;

import java.util.List;

import com.bancoDeSangue.model.TipoSanguineo;

public interface TipoSanguineoExecutorService {
	List<TipoSanguineo> obterListaPossivelDoar(TipoSanguineo tipoSanguineo);
	List<TipoSanguineo> obterListaPossivelReceber(TipoSanguineo tipoSanguineo);
}
