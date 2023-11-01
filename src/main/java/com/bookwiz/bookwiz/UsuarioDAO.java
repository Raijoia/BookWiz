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
    public Usuario verificarUsuario(String usuario, String senha) throws Exception{
        String sql = "SELECT USU_NOME, USU_SENHA, USU_EMAIL, USU_SEXO, USU_PREF, USU_IDADE, TP_ID, USU_ATIVO, USU_ID FROM TB_USER WHERE USU_NOME = ? && USU_SENHA = ?;";
        
        try (
            var factory = ConnectionFactory.conectar();
            var ps = factory.prepareStatement(sql);
        ){
            ps.setString(1, usuario);
            ps.setString(2, senha);
            
            
            ResultSet rs = ps.executeQuery();
            if(!rs.next()) {
                return null;
            }
            
            var usuarioReconhecido = new Usuario(
                rs.getString("USU_NOME"),
                rs.getString("USU_SENHA"),
                rs.getString("USU_EMAIL"),
                rs.getString("USU_SEXO"),
                rs.getInt("USU_PREF"),
                rs.getInt("USU_IDADE"),
                rs.getInt("TP_ID"),
                rs.getInt("USU_ATIVO"),
                rs.getInt("USU_ID")
            );
            
            return usuarioReconhecido;
        }
    }
}
