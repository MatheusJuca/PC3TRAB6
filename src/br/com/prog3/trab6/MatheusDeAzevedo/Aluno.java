package br.com.prog3.trab6.MatheusDeAzevedo;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer matricula;
	private String nome;
	private String regiaoAdministrativa;

	public Aluno() {
	}

	public Aluno(Integer matricula, String nome, String regiaoAdministrativa) {
		this.matricula = matricula;
		this.nome = nome;
		this.regiaoAdministrativa = regiaoAdministrativa;
	}

	@Override
	public String toString() {
		return "Matricula: " + matricula + "\nNOME: " + nome + "\nRA: " + regiaoAdministrativa;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegiaoAdministrativa() {
		return regiaoAdministrativa;
	}

	public void setRegiaoAdministrativa(String regiaoAdministrativa) {
		this.regiaoAdministrativa = regiaoAdministrativa;
	}

}