package com.BancoDeSangue.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.BancoDeSangue.dtos.request.CriarNovoUsuarioRequest;
import com.BancoDeSangue.model.Usuario;
import com.BancoDeSangue.util.factory.UsuarioFactory;

@ExtendWith(MockitoExtension.class)
class UsuarioMapperTest {

	@InjectMocks
	private UsuarioMapper usuarioMapper;

	@Test
	@DisplayName("Deve fazer map para entity")
	void toEntity() {
		CriarNovoUsuarioRequest request = UsuarioFactory.obterCriarNovoUsuarioRequest();
		Usuario usuarioEsperado = UsuarioFactory.obterUsuario();
		Usuario resultado = usuarioMapper.toEntity(request);
		assertEquals(usuarioEsperado.toString(),resultado.toString());
	}
}