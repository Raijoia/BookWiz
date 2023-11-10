/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookwiz.bookwiz;

import java.sql.ResultSet;

/**
 *
 * @author rai
 */
public class NotaDAO {
    public void adicionarNota(Nota nota, Usuario usuario, Livro livro) throws Exception{
        String sql = "SELECT LV_ID FROM TB_LIVRO WHERE LV_TITULO = ? AND LV_AUTOR = ?;";
        String sql2 = "INSERT INTO TB_AVA (AVA_NOTA, USU_ID, LV_ID) VALUES (?, ?, ?);";
        
        try (
            var factory = ConnectionFactory.conectar();
            var ps = factory.prepareStatement(sql);
            var ps2 = factory.prepareStatement(sql2);
        ){
            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getAutor());
            
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            int livroId = rs.getInt("LV_ID");
            
            ps2.setInt(1, nota.getNota());
            ps2.setInt(2, usuario.getId());
            ps2.setInt(3, livroId);
            
            ps2.execute();
        }
    }
}
