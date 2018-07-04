package com.sos.service.business.util.validators;

import org.junit.Assert;
import org.junit.Test;

import com.sos.entities.Usuario;

public class UsuarioValidatorTest {

	@Test
	public void validarCamposPersonagemCamposVazios(){
		Personagem personagem = new Personagem();
		Assert.assertFalse(PersonagemValidator.validarCamposPersonagem(personagem).isValido());
	}
	
	@Test
	public void validarCamposUsuarioCamposNomeConfigurado(){
		Personagem personagem = new Personagem();
		personagem.setNome("Herói da Tiberia");
		Assert.assertFalse(PersonagemValidator.validarCamposPersonagem(personagem).isValido());
	}
	
	@Test
	public void validarCamposPersonagemCamposArmaConfigurada(){
		Personagem personagem = new Personagem();
		personagem.setArma("Arco e flecha elfica");
		
		Assert.assertFalse(PersonagemValidator.validarCamposPersonagem(personagem).isValido());
	}
	
	@Test
	public void validarCamposPersonagemCamposVidaConfigurada(){
		Personagem personagem = new Personagem();
		personagem.setVida("2000");
		
		Assert.assertFalse(UsuarioValidator.validarCamposUsuario(usuario).isValido());
	}
	
	@Test
	public void validarCamposUsuarioCamposSenhaVazia(){
		Usuario usuario = new Usuario();
		usuario.setNome("Diogo Peixoto");
		usuario.setEmail("diogopeixoto@diogopeixoto.com");
		Assert.assertFalse(UsuarioValidator.validarCamposUsuario(usuario).isValido());
	}
	
	@Test
	public void validarCamposUsuarioCamposEmailVazio(){
		Usuario usuario = new Usuario();
		usuario.setNome("Diogo Peixoto");
		usuario.setSenha("12345");
		Assert.assertFalse(UsuarioValidator.validarCamposUsuario(usuario).isValido());
	}
	
	@Test
	public void validarCamposUsuarioCamposNomeVazio(){
		Usuario usuario = new Usuario();
		usuario.setEmail("diogopeixoto@diogopeixoto.com");
		usuario.setSenha("12345");
		Assert.assertFalse(UsuarioValidator.validarCamposUsuario(usuario).isValido());
	}
	
	@Test
	public void validarCamposUsuarioCamposNomeAceitou(){
		Usuario usuario = new Usuario();
		usuario.setNome("Diogo Peixoto");
		usuario.setEmail("diogopeixoto@diogopeixoto.com");
		usuario.setSenha("12345");
		
		Assert.assertTrue(UsuarioValidator.validarCamposUsuario(usuario).isValido());
	}
}