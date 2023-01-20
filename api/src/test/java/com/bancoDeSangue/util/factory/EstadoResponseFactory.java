package com.bancoDeSangue.util.factory;

import static com.bancoDeSangue.model.Estado.*;

import java.util.List;

import com.bancoDeSangue.dtos.response.EstadoResponse;

public class EstadoResponseFactory {
	public static List<EstadoResponse> obter(){
		return List.of(
				EstadoResponse.builder().sigla(AC).nome("Acre").build(),
				EstadoResponse.builder().sigla(AL).nome("Alagoas").build(),
				EstadoResponse.builder().sigla(AP).nome("Amapá").build(),
				EstadoResponse.builder().sigla(AM).nome("Amazonas").build(),
				EstadoResponse.builder().sigla(BA).nome("Bahia").build(),
				EstadoResponse.builder().sigla(CE).nome("Ceará").build(),
				EstadoResponse.builder().sigla(ES).nome("Espírito Santo").build(),
				EstadoResponse.builder().sigla(GO).nome("Goiás").build(),
				EstadoResponse.builder().sigla(MA).nome("Maranhão").build(),
				EstadoResponse.builder().sigla(MT).nome("Mato Grosso").build(),
				EstadoResponse.builder().sigla(MS).nome("Mato Grosso do Sul").build(),
				EstadoResponse.builder().sigla(MG).nome("Minas Gerais").build(),
				EstadoResponse.builder().sigla(PA).nome("Pará").build(),
				EstadoResponse.builder().sigla(PB).nome("Paraíba").build(),
				EstadoResponse.builder().sigla(PR).nome("Paraná").build(),
				EstadoResponse.builder().sigla(PE).nome("Pernambuco").build(),
				EstadoResponse.builder().sigla(PI).nome("Piauí").build(),
				EstadoResponse.builder().sigla(RJ).nome("Rio de Janeiro").build(),
				EstadoResponse.builder().sigla(RN).nome("Rio Grande do Norte").build(),
				EstadoResponse.builder().sigla(RS).nome("Rio Grande do Sul").build(),
				EstadoResponse.builder().sigla(RO).nome("Rondônia").build(),
				EstadoResponse.builder().sigla(RR).nome("Roraima").build(),
				EstadoResponse.builder().sigla(SC).nome("Santa Catarina").build(),
				EstadoResponse.builder().sigla(SP).nome("São Paulo").build(),
				EstadoResponse.builder().sigla(SE).nome("Sergipe").build(),
				EstadoResponse.builder().sigla(TO).nome("Tocantins").build(),
				EstadoResponse.builder().sigla(DF).nome("Distrito Federal").build()
		);
	}
}
