package br.edu.infnet.DTO;

import java.util.ArrayList;

public class Turma {

    private Integer id;
    private String nome;
    private ArrayList<Aluno> alunos;
    
    
    public Integer getId() {
            return id;
    }
    public void setId(Integer id) {
            this.id = id;
    }
    public String getNome() {
            return nome;
    }
    public void setNome(String nome) {
            this.nome = nome;
    }
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public boolean ContemAluno(String matricula) {
		boolean existe = false;
		
		if(alunos != null){
			for (Aluno aluno : alunos) {
				if(aluno.getMatricula().equalsIgnoreCase(matricula)){
					existe = true;
					break;
				}	
			}
		}
		
		return existe;
	}
}
