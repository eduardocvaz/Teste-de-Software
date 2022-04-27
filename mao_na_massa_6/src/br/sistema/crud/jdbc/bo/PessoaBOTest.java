package br.sistema.crud.jdbc.bo;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.sistema.crud.jdbc.dao.PessoaDAO;
import br.sistema.crud.jdbc.dto.PessoaDTO;
import br.sistema.crud.jdbc.exception.NegocioException;
import br.sistema.crud.jdbc.exception.PersistenciaExcpetion;

public class PessoaBOTest {
	
	
	DateFormat dateFormat;
	PessoaDAO pessoaDAO = new PessoaDAO();
	
	@Before
	public void SetUp() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	}

	@Test
	public void testCadastrandoPessoa() throws ParseException, NegocioException, PersistenciaExcpetion {
		PessoaDTO pessoa = new PessoaDTO();
		pessoa.setCpf(Long.parseLong("11111111111"));
		pessoa.setDtNascimento(dateFormat.parse("10/11/2000"));
		pessoa.setNome("Nome Teste");
		pessoa.setSexo('F');
		
		new PessoaBO().cadastrar(pessoa, pessoaDAO);
		
		assertEquals(pessoa.getNome(), pessoaDAO.buscarPorId(1).getNome());
		assertEquals(pessoa.getCpf(), pessoaDAO.buscarPorId(1).getCpf());
		assertEquals(pessoa.getDtNascimento(), pessoaDAO.buscarPorId(1).getDtNascimento());
		assertEquals(pessoa.getSexo(), pessoaDAO.buscarPorId(1).getSexo());
		
	}

}
