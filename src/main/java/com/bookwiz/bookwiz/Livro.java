/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookwiz.bookwiz;

/**
 *
 * @author rai
 */
public class Livro {
    private String titulo, autor, dtcad, desc;
    private int id, nota, genero;
    
    public Livro (String titulo, String autor, String desc, int genero, int nota) {
        this.titulo = titulo;
        this.autor = autor;
        this.desc = desc;
        this.genero = genero;
        this.nota = nota;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
