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
        
        try (
            var factory = ConnectionFactory.conectar();
            var ps = factory.prepareStatement(sql);
        ){
            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getAutor());
            ps.setString(3, livro.getDesc());
            ps.setInt(4, livro.getGenero());
            
            ps.execute();
        }
    }
}
