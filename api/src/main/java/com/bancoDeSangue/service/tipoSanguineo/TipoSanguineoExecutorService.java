package com.BancoDeSangue.service.tipoSanguineo;

import java.util.List;

import com.BancoDeSangue.model.TipoSanguineo;

public interface TipoSanguineoExecutorService {
	List<TipoSanguineo> obterListaPossivelDoar(TipoSanguineo tipoSanguineo);
	List<TipoSanguineo> obterListaPossivelReceber(TipoSanguineo tipoSanguineo);
}
