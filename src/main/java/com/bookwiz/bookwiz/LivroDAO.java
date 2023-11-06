/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookwiz.bookwiz;

import java.sql.SQLException;

/**
 *
 * @author rai
 */
public class LivroDAO {
    public void adicionarLivro(Livro livro) throws SQLException, Exception {
        String sql = "INSERT INTO TB_LIVRO (LV_TITULO, LV_AUTOR, LV_DESC, LV_GEN, LV_DTCAD) VALUES (?, ?, ?, ?, NOW());";
        String sql2 = "INSERT INTO TB_AVA (AVA_DESC) VALUES (?)";
        
        try (
            var factory = ConnectionFactory.conectar();
            var ps = factory.prepareStatement(sql);
            var ps2 = factory.prepareStatement(sql2);
        ){
            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getAutor());
            ps.setString(3, livro.getDesc());
            ps.setInt(4, livro.getGenero());
            ps2.setInt(1, livro.getNota());
            
            ps.execute();
            ps2.execute();
        }
    }
}
