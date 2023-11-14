/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookwiz.bookwiz.entity;

/**
 *
 * @author rai
 */
public class Livro {
    private String titulo, autor, dtcad, descricao;
    private int id, genero;
    private Nota nota;
    
    public Livro (String titulo, String autor, String descricao, int genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.descricao = descricao;
        this.genero = genero;
    }
    
    public Livro (int id, String titulo, String autor, int genero, String dtcad, String descricao, Nota nota) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.dtcad = dtcad;
        this.descricao = descricao;
        this.nota = nota;
    }
    
    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }
    
    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDtcad() {
        return dtcad;
    }

    public void setDtcad(String dtcad) {
        this.dtcad = dtcad;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String toString() {
        return this.titulo;
    }
}
