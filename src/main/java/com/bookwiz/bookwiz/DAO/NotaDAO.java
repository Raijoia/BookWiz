/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookwiz.bookwiz.DAO;

import com.bookwiz.bookwiz.ConnectionFactory;
import com.bookwiz.bookwiz.entity.Livro;
import com.bookwiz.bookwiz.entity.Nota;
import com.bookwiz.bookwiz.entity.Usuario;
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
            
            int notaInt = (int) nota.getNota();
            
            ps2.setInt(1, notaInt);
            ps2.setInt(2, usuario.getId());
            ps2.setInt(3, livroId);
            
            ps2.execute();
        }
    }
    
    public Nota pegarNotaGeralDoLivro(int id) throws Exception{
        String sql = "SELECT AVA_NOTA FROM TB_AVA WHERE LV_ID = ?;";
        
        try (
            var factory = ConnectionFactory.conectar();
            var ps = factory.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
        ){
            ps.setInt(1, id);
            ps.execute();
            
            ResultSet rs = ps.executeQuery();
            
            int nota = 0;
            int numeroDeNotas = 0;
            
            for (int cont = 1; rs.next(); cont++) {
                nota += rs.getInt("AVA_NOTA");
                numeroDeNotas = cont;
            }
            
            int notaGeral = nota / numeroDeNotas;
            
            return new Nota(notaGeral);
        }
    }
}
