package com.example.questionario;

public class LAluno {

    int codigo;
    String nome;
    String matricula;
    String email;
    String senha;

    public Aluno(){

    }
    public Aluno(int _codigo, String _nome, String _matricula, String _email, String _senha){
        this.codigo = _codigo;
        this.nome = _nome;
        this.matricula = _matricula;
        this.email = _email;
        this.senha = _senha;
    }
    public Aluno(String _nome, String _matricula, String _email, String _senha){
        this.nome = _nome;
        this.matricula = _matricula;
        this.email = _email;
        this.senha = _senha;
    }
    //================================================================
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

