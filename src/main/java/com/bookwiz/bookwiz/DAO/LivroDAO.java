/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookwiz.bookwiz.DAO;

import com.bookwiz.bookwiz.ConnectionFactory;
import com.bookwiz.bookwiz.entity.Livro;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rai
 */
public class LivroDAO {
    public void adicionarLivro(Livro livro) throws SQLException, Exception {
        String sql = "INSERT INTO TB_LIVRO (LV_TITULO, LV_AUTOR, LV_DESC, LV_GEN, LV_DTCAD) VALUES (?, ?, ?, ?, NOW());";
        
        try (
            var factory = ConnectionFactory.conectar();
            var ps = factory.prepareStatement(sql);
        ){
            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getAutor());
            ps.setString(3, livro.getDescricao());
            ps.setInt(4, livro.getGenero());
            
            ps.execute();
        }
    }
    
    public Livro[] obterLivros() throws Exception {
        String sql = "SELECT * FROM TB_LIVRO";
        
        try (
            var factory = ConnectionFactory.conectar();
            var ps = factory.prepareStatement(
                    sql, 
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            ResultSet rs = ps.executeQuery();
        ){
            int totalLivros = 0;
            if (rs.last()){
                totalLivros = rs.getRow();
            }
            Livro[] livros = new Livro[totalLivros];
            rs.beforeFirst();
            for (int cont = 0; rs.next(); cont++) {
                int id = rs.getInt("LV_ID");
                String titulo = rs.getString("LV_TITULO");
                String autor = rs.getString("LV_AUTOR");
                int genero = rs.getInt("LV_GEN");
                String dtcad = rs.getString("LV_DTCAD");
                String descricao = rs.getString("LV_DESC");
                Livro livro = new Livro(id, titulo, autor, genero, dtcad, descricao);
                livros[cont] = livro;
            }
            return livros;
        }
    }
}
