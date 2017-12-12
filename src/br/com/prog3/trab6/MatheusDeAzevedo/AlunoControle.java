package br.com.prog3.trab6.MatheusDeAzevedo;

import java.util.List;

import javax.faces.bean.ManagedBean;


@ManagedBean(name = "alunoControle", eager = true)
public class AlunoControle {

	private Integer matricula;
	private String nome;
	private String regiaoAdministrativa;
	private Aluno aluno;
	private String mensagem;

	public void addAluno() {
		Aluno aluno = new Aluno(matricula, nome, regiaoAdministrativa);
		AlunoDAOImp ad = new AlunoDAOImp();
		setMensagem(ad.save(aluno));
		aluno = new Aluno();
	}

	public void editAluno() {
		Aluno aluno = new Aluno(matricula, nome, regiaoAdministrativa);
		AlunoDAOImp ad = new AlunoDAOImp();
		setMensagem(ad.update(aluno));
	}

	public void deleteAluno() {
		AlunoDAOImp ad = new AlunoDAOImp();
		setMensagem(ad.delete(matricula));
	}

	public List<Aluno> getAlunos() {
		AlunoDAOImp ad = new AlunoDAOImp();
		return ad.list();
	}

	public Aluno findAluno() {
		AlunoDAOImp ad = new AlunoDAOImp();
		setMensagem(ad.findByMatricula(matricula).toString());
		return ad.findByMatricula(matricula);
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

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}