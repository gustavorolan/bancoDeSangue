package com.BancoDeSangue.util.factory;

import static com.BancoDeSangue.model.TipoSanguineo.*;

import java.util.List;

import com.BancoDeSangue.model.TipoSanguineo;

public class TipoSanguineoFactory {
	public static List<TipoSanguineo> obterPossivelDoarAPositivo() {
		return List.of(A_B_POSITIVO, A_POSITIVO);
	}
	public static List<TipoSanguineo> obterListaPossivelReceberAPositivo() {
		return List.of(A_NEGATIVO, A_POSITIVO, O_POSITIVO, O_NEGATIVO);
	}

	public static List<TipoSanguineo> obterPossivelDoarBPositivo() {
		return List.of(B_POSITIVO, A_B_POSITIVO);
	}
	public static List<TipoSanguineo> obterListaPossivelReceberBPositivo() {
		return List.of(B_POSITIVO, B_NEGATIVO, O_POSITIVO, O_NEGATIVO);
	}

	public static List<TipoSanguineo> obterPossivelDoarABPositivo() {
		return List.of(A_B_POSITIVO);
	}
	public static List<TipoSanguineo> obterListaPossivelReceberABPositivo() {
		return List.of(A_POSITIVO, B_POSITIVO, O_POSITIVO, A_B_POSITIVO, A_NEGATIVO, B_NEGATIVO, O_NEGATIVO, A_B_NEGATIVO);
	}

	public static List<TipoSanguineo> obterPossivelDoarOPositivo() {
		return List.of(A_POSITIVO, B_POSITIVO, O_POSITIVO, A_B_POSITIVO);
	}

	public static List<TipoSanguineo> obterListaPossivelReceberOPositivo() {
		return List.of(O_POSITIVO, O_NEGATIVO);
	}

	public static List<TipoSanguineo> obterPossivelDoarONegativo() {
		return List.of(A_POSITIVO, B_POSITIVO, O_POSITIVO, A_B_POSITIVO, A_NEGATIVO, B_NEGATIVO, O_NEGATIVO, A_B_NEGATIVO);
	}

	public static List<TipoSanguineo> obterListaPossivelReceberONegativo() {
		return List.of(O_NEGATIVO);
	}

	public static List<TipoSanguineo> obterListaPossivelDoarABNegativo() {
		return List.of(A_B_POSITIVO, A_NEGATIVO);
	}

	public static List<TipoSanguineo> obterListaPossivelReceberABNegativo() {
		return List.of(A_NEGATIVO, B_NEGATIVO, O_NEGATIVO, A_B_NEGATIVO);
	}


	public static List<TipoSanguineo> obterListaPossivelDoarBNegativo() {
		return List.of(B_POSITIVO, B_NEGATIVO, A_B_POSITIVO, A_B_NEGATIVO);
	}

	public static List<TipoSanguineo> obterListaPossivelReceberBNegativo() {
		return List.of(B_NEGATIVO, O_NEGATIVO);
	}


	public static List<TipoSanguineo> obterListaPossivelDoarANegativo() {
		return List.of(A_POSITIVO, A_NEGATIVO, A_B_POSITIVO, A_B_NEGATIVO);
	}

	public static List<TipoSanguineo> obterListaPossivelReceberANegativo() {
		return List.of(A_NEGATIVO, O_NEGATIVO);
	}
}
