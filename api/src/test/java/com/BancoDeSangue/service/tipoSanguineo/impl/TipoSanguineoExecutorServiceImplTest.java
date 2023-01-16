package com.BancoDeSangue.service.tipoSanguineo.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.BancoDeSangue.model.TipoSanguineo;
import com.BancoDeSangue.service.tipoSanguineo.TipoSanguineoService;
import com.BancoDeSangue.util.factory.TipoSanguineoFactory;

@ExtendWith(MockitoExtension.class)
class TipoSanguineoExecutorServiceImplTest {

	private final ABNegativoServiceImpl abNegativoService = new ABNegativoServiceImpl();

	private final ABPositivoServiceImpl abPositivoService = new ABPositivoServiceImpl();

	private final ANegativoServiceImpl aNegativoService =  new ANegativoServiceImpl();

	private final APositivoServiceImpl aPositivoService = new APositivoServiceImpl();

	private final BNegativoServiceImpl bNegativoService = new BNegativoServiceImpl();

	private final BPositivoServiceImpl bPositivoService = new BPositivoServiceImpl();

	private final ONegativoServiceImpl oNegativoService = new ONegativoServiceImpl();

	private final OPositivoServiceImpl oPositivoService = new OPositivoServiceImpl();

	private final List<TipoSanguineoService> tipoSanguineoService =  List.of(
			abNegativoService,
			abPositivoService,
			aNegativoService,
			aPositivoService,
			bNegativoService,
			bPositivoService,
			oNegativoService,
			oPositivoService
	);

	@InjectMocks
	private TipoSanguineoExecutorServiceImpl tipoSanguineoExecutorService =
			new TipoSanguineoExecutorServiceImpl(tipoSanguineoService);

	@Test
	@DisplayName("Obter Lista de Tipos de sangue que esse tipo pode doar, TipoSanguineo.A_POSITIVO")
	void obterListaPossivelDoarAPositivo() {
		List<TipoSanguineo> listaDeTiposSanguineosEsperados = TipoSanguineoFactory.obterPossivelDoarAPositivo();
		List<TipoSanguineo> listaDeTiposSanguineo = tipoSanguineoExecutorService.obterListaPossivelDoar(TipoSanguineo.A_POSITIVO);
		assertEquals(listaDeTiposSanguineosEsperados,listaDeTiposSanguineo);
	}

	@Test
	@DisplayName("Obter Lista de Tipos de sangue que esse tipo pode receber, TipoSanguineo.A_POSITIVO")
	void obterListaPossivelReceberAPostivo() {
		List<TipoSanguineo> listaDeTiposSanguineosEsperados = TipoSanguineoFactory.obterListaPossivelReceberAPositivo();
		List<TipoSanguineo> listaDeTiposSanguineo = tipoSanguineoExecutorService.obterListaPossivelReceber(TipoSanguineo.A_POSITIVO);
		assertEquals(listaDeTiposSanguineosEsperados,listaDeTiposSanguineo);
	}

	@Test
	@DisplayName("Obter Lista de Tipos de sangue que esse tipo pode doar, TipoSanguineo.B_POSITIVO")
	void obterListaPossivelDoarBPositivo() {
		List<TipoSanguineo> listaDeTiposSanguineosEsperados = TipoSanguineoFactory.obterPossivelDoarBPositivo();
		List<TipoSanguineo> listaDeTiposSanguineo = tipoSanguineoExecutorService.obterListaPossivelDoar(TipoSanguineo.B_POSITIVO);
		assertEquals(listaDeTiposSanguineosEsperados,listaDeTiposSanguineo);
	}

	@Test
	@DisplayName("Obter Lista de Tipos de sangue que esse tipo pode receber, TipoSanguineo.B_POSITIVO")
	void obterListaPossivelReceberBPositivo() {
		List<TipoSanguineo> listaDeTiposSanguineosEsperados = TipoSanguineoFactory.obterListaPossivelReceberBPositivo();
		List<TipoSanguineo> listaDeTiposSanguineo = tipoSanguineoExecutorService.obterListaPossivelReceber(TipoSanguineo.B_POSITIVO);
		assertEquals(listaDeTiposSanguineosEsperados,listaDeTiposSanguineo);
	}

	@Test
	@DisplayName("Obter Lista de Tipos de sangue que esse tipo pode doar, TipoSanguineo.A_B_POSITIVO")
	void obterListaPossivelDoarABPositivo() {
		List<TipoSanguineo> listaDeTiposSanguineosEsperados = TipoSanguineoFactory.obterPossivelDoarABPositivo();
		List<TipoSanguineo> listaDeTiposSanguineo = tipoSanguineoExecutorService.obterListaPossivelDoar(TipoSanguineo.A_B_POSITIVO);
		assertEquals(listaDeTiposSanguineosEsperados,listaDeTiposSanguineo);
	}

	@Test
	@DisplayName("Obter Lista de Tipos de sangue que esse tipo pode receber, TipoSanguineo.A_B_POSITIVO")
	void obterListaPossivelReceberABPositivo() {
		List<TipoSanguineo> listaDeTiposSanguineosEsperados = TipoSanguineoFactory.obterListaPossivelReceberABPositivo();
		List<TipoSanguineo> listaDeTiposSanguineo = tipoSanguineoExecutorService.obterListaPossivelReceber(TipoSanguineo.A_B_POSITIVO);
		assertEquals(listaDeTiposSanguineosEsperados,listaDeTiposSanguineo);
	}

	@Test
	@DisplayName("Obter Lista de Tipos de sangue que esse tipo pode doar, TipoSanguineo.O_POSITIVO")
	void obterListaPossivelDoarOPositivo() {
		List<TipoSanguineo> listaDeTiposSanguineosEsperados = TipoSanguineoFactory.obterPossivelDoarOPositivo();
		List<TipoSanguineo> listaDeTiposSanguineo = tipoSanguineoExecutorService.obterListaPossivelDoar(TipoSanguineo.O_POSITIVO);
		assertEquals(listaDeTiposSanguineosEsperados,listaDeTiposSanguineo);
	}

	@Test
	@DisplayName("Obter Lista de Tipos de sangue que esse tipo pode receber, TipoSanguineo.O_POSITIVO")
	void obterListaPossivelReceberOPositivo() {
		List<TipoSanguineo> listaDeTiposSanguineosEsperados = TipoSanguineoFactory.obterListaPossivelReceberOPositivo();
		List<TipoSanguineo> listaDeTiposSanguineo = tipoSanguineoExecutorService.obterListaPossivelReceber(TipoSanguineo.O_POSITIVO);
		assertEquals(listaDeTiposSanguineosEsperados,listaDeTiposSanguineo);
	}

	@Test
	@DisplayName("Obter Lista de Tipos de sangue que esse tipo pode doar, TipoSanguineo.O_NEGATIVO")
	void obterListaPossivelDoarONegativo() {
		List<TipoSanguineo> listaDeTiposSanguineosEsperados = TipoSanguineoFactory.obterPossivelDoarONegativo();
		List<TipoSanguineo> listaDeTiposSanguineo = tipoSanguineoExecutorService.obterListaPossivelDoar(TipoSanguineo.O_NEGATIVO);
		assertEquals(listaDeTiposSanguineosEsperados,listaDeTiposSanguineo);
	}

	@Test
	@DisplayName("Obter Lista de Tipos de sangue que esse tipo pode receber, TipoSanguineo.O_NEGATIVO")
	void obterListaPossivelReceberONegativo() {
		List<TipoSanguineo> listaDeTiposSanguineosEsperados = TipoSanguineoFactory.obterListaPossivelReceberONegativo();
		List<TipoSanguineo> listaDeTiposSanguineo = tipoSanguineoExecutorService.obterListaPossivelReceber(TipoSanguineo.O_NEGATIVO);
		assertEquals(listaDeTiposSanguineosEsperados,listaDeTiposSanguineo);
	}

	@Test
	@DisplayName("Obter Lista de Tipos de sangue que esse tipo pode doar, TipoSanguineo.A_B_NEGATIVO")
	void obterListaPossivelDoarABNegativo() {
		List<TipoSanguineo> listaDeTiposSanguineosEsperados = TipoSanguineoFactory.obterListaPossivelDoarABNegativo();
		List<TipoSanguineo> listaDeTiposSanguineo = tipoSanguineoExecutorService.obterListaPossivelDoar(TipoSanguineo.A_B_NEGATIVO);
		assertEquals(listaDeTiposSanguineosEsperados,listaDeTiposSanguineo);
	}

	@Test
	@DisplayName("Obter Lista de Tipos de sangue que esse tipo pode receber, TipoSanguineo.A_B_NEGATIVO")
	void obterListaPossivelReceberABNegativo() {
		List<TipoSanguineo> listaDeTiposSanguineosEsperados = TipoSanguineoFactory.obterListaPossivelReceberABNegativo();
		List<TipoSanguineo> listaDeTiposSanguineo = tipoSanguineoExecutorService.obterListaPossivelReceber(TipoSanguineo.A_B_NEGATIVO);
		assertEquals(listaDeTiposSanguineosEsperados,listaDeTiposSanguineo);
	}

	@Test
	@DisplayName("Obter Lista de Tipos de sangue que esse tipo pode doar, TipoSanguineo.B_NEGATIVO")
	void obterListaPossivelDoarBNegativo() {
		List<TipoSanguineo> listaDeTiposSanguineosEsperados = TipoSanguineoFactory.obterListaPossivelDoarBNegativo();
		List<TipoSanguineo> listaDeTiposSanguineo = tipoSanguineoExecutorService.obterListaPossivelDoar(TipoSanguineo.B_NEGATIVO);
		assertEquals(listaDeTiposSanguineosEsperados,listaDeTiposSanguineo);
	}

	@Test
	@DisplayName("Obter Lista de Tipos de sangue que esse tipo pode receber, TipoSanguineo.B_NEGATIVO")
	void obterListaPossivelReceberBNegativo() {
		List<TipoSanguineo> listaDeTiposSanguineosEsperados = TipoSanguineoFactory.obterListaPossivelReceberBNegativo();
		List<TipoSanguineo> listaDeTiposSanguineo = tipoSanguineoExecutorService.obterListaPossivelReceber(TipoSanguineo.B_NEGATIVO);
		assertEquals(listaDeTiposSanguineosEsperados,listaDeTiposSanguineo);
	}

	@Test
	@DisplayName("Obter Lista de Tipos de sangue que esse tipo pode doar, TipoSanguineo.A_NEGATIVO")
	void obterListaPossivelDoarANegativo() {
		List<TipoSanguineo> listaDeTiposSanguineosEsperados = TipoSanguineoFactory.obterListaPossivelDoarANegativo();
		List<TipoSanguineo> listaDeTiposSanguineo = tipoSanguineoExecutorService.obterListaPossivelDoar(TipoSanguineo.A_NEGATIVO);
		assertEquals(listaDeTiposSanguineosEsperados,listaDeTiposSanguineo);
	}

	@Test
	@DisplayName("Obter Lista de Tipos de sangue que esse tipo pode receber, TipoSanguineo.A_NEGATIVO")
	void obterListaPossivelReceberANegativo() {
		List<TipoSanguineo> listaDeTiposSanguineosEsperados = TipoSanguineoFactory.obterListaPossivelReceberANegativo();
		List<TipoSanguineo> listaDeTiposSanguineo = tipoSanguineoExecutorService.obterListaPossivelReceber(TipoSanguineo.A_NEGATIVO);
		assertEquals(listaDeTiposSanguineosEsperados,listaDeTiposSanguineo);
	}
}