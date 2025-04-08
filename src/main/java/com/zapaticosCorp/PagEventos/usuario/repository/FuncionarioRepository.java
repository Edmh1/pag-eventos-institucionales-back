package com.zapaticosCorp.PagEventos.usuario.repository;

import com.zapaticosCorp.PagEventos.usuario.model.Funcionario;
import com.zapaticosCorp.PagEventos.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Usuario> {

    Funcionario findByIdUsuarioFuncionario(Integer idUserFuncionario);
}
