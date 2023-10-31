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
public class UsuarioDAO {
    public boolean verificarUsuario(String usuario, String senha) throws Exception{
        String sql = "SELECT USU_NOME, USU_SENHA FROM TB_USER WHERE USU_NOME = ? && USU_SENHA = ?;";
        
        try (
            var factory = ConnectionFactory.conectar();
            var ps = factory.prepareStatement(sql);
        ){
            ps.setString(1, usuario);
            ps.setString(2, senha);
            
            
            ResultSet rs = ps.executeQuery();
            if(!rs.next()) {
                return false;
            }
            String dbUsuario = rs.getString("USU_NOME");
            String dbSenha = rs.getString("USU_SENHA");
            
            return dbUsuario.equals(usuario) && dbSenha.equals(senha);
        }
    }
}
