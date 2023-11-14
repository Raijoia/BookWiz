/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookwiz.bookwiz.DAO;

import com.bookwiz.bookwiz.ConnectionFactory;
import com.bookwiz.bookwiz.entity.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    
    public void adicionarUsuario(Usuario user) throws SQLException, Exception {
        String sql = "INSERT INTO TB_USER (USU_NOME, USU_SENHA, USU_IDADE, USU_SEXO, USU_EMAIL, USU_PREF, TP_ID) VALUES (?, ?, ?, ?, ?, ?, 2);";
        
        try (
            var factory = ConnectionFactory.conectar();
            var ps = factory.prepareStatement(sql);
        ){
            ps.setString(1, user.getNome());
            ps.setString(2, user.getSenha());
            ps.setInt(3, user.getIdade());
            ps.setString(4, user.getSexo());
            ps.setString(5, user.getEmail());
            ps.setInt(6, user.getPref());
            
            ps.execute();
        }
    }
}
