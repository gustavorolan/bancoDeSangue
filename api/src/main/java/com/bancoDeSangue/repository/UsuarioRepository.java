package com.BancoDeSangue.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BancoDeSangue.model.Estado;
import com.BancoDeSangue.model.Sexo;
import com.BancoDeSangue.model.TipoSanguineo;
import com.BancoDeSangue.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByEmail(String email);

	@Query("select u from Usuario u where (u.endereco.estado=?1)  order by u.nome desc")
	Page<Usuario> findByEstado(Estado estado, Pageable pageable);

	@Query("select count(u) from Usuario u where (u.endereco.estado=?1)")
	Long contadorPorEstado(Estado estado);

	@Query("select count(u) from Usuario u where (u.informacoesPessoais.sexo=?1) and (u.isObeso=?2)")
	Long contadorPorSexoAndObesidade(Sexo sexo,boolean isObeso);

	@Query("select count(u) from Usuario u where (u.informacoesPessoais.sexo=?1)")
	Long contadorPorSexo(Sexo sexo);

	@Query("select count(u) from Usuario u where ((u.informacoesPessoais.tipoSanguineo in (?1) ) and (u.isPermitidoDoar=?2))")
	Long contadorPorListaDeTipoSanguineo(List<TipoSanguineo> listaTipoSanguineo, boolean isPermitidoDoar);
	@Query("select u.idade from Usuario u where (u.informacoesPessoais.tipoSanguineo=?1)")
	List<Integer> listaDeIdadePorTipoSanguineo(TipoSanguineo tipoSanguineo);

	@Query("select u from Usuario u where (u.idade>=?1) and (u.idade<=?2)")
	List<Usuario> listaDeUsuariosPorIdade(Integer idadeMin, Integer idadeMax);

	Usuario findFirstByOrderByIdadeDesc();
}
