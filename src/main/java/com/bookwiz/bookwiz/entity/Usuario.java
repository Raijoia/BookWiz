/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookwiz.bookwiz.entity;

/**
 *
 * @author rai
 */
public class Usuario implements Comparable<Usuario>{
    private String nome, email, senha;
    private int id, pref, idade, acesso, ativo, sexo;
    
    public Usuario(String nome, String senha, String email, int sexo, int pref, int idade){
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.sexo = sexo;
        this.pref = pref;
        this.idade = idade;
    }
    
    public Usuario(String nome,String senha, String email, int sexo, int pref, int idade, int acesso, int ativo, int id) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.sexo = sexo;
        this.pref = pref;
        this.idade = idade;
        this.acesso = acesso;
        this.ativo = ativo;
        this.id = id;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPref() {
        return pref;
    }

    public void setPref(int pref) {
        this.pref = pref;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }
    
    @Override
    public int compareTo(Usuario outroUsuario) {
        return this.nome.compareTo(outroUsuario.getNome());
    }
}
