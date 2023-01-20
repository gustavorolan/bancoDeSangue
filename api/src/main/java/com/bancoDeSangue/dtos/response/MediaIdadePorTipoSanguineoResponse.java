package com.bancoDeSangue.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MediaIdadePorTipoSanguineoResponse {
	private Float media;
	private String tipoSanguineo;
}
