package com.BancoDeSangue.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaIdadePorTipoSanguineoResponse {
	private Float media;
	private String tipoSanguineo;
}
