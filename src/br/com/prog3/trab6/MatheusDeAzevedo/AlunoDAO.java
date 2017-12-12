package br.com.prog3.trab6.MatheusDeAzevedo;

import java.util.List;

public interface AlunoDAO {

		public String save(Aluno aluno);

		public String delete(int matricula);

		public String update(Aluno aluno);

		public List<Aluno> list();

		public Aluno findByMatricula(int matricula);

}