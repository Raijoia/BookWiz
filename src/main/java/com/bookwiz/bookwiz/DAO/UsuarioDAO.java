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
    
    public Usuario[] obterUsuarios() throws Exception {
        String sql = "SELECT * FROM TB_USER WHERE USU_ATIVO = 1 AND TP_ID = 2;";
        
        try (
            var factory = ConnectionFactory.conectar();
            var ps = factory.prepareStatement(
                    sql, 
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            ResultSet rs = ps.executeQuery();
        ){
            int totalUsuario = 0;
            if (rs.last()){
                totalUsuario = rs.getRow();
            }
            Usuario[] usuarios = new Usuario[totalUsuario];
            rs.beforeFirst();
                
            for (int cont = 0; rs.next(); cont++) {
                int id = rs.getInt("USU_ID");
                String nome = rs.getString("USU_NOME");
                int generoPreferido = rs.getInt("USU_PREF");
                int idade = rs.getInt("USU_IDADE");
                String email = rs.getString("USU_EMAIL");
                String sexo = rs.getString("USU_SEXO");
                int ativo = rs.getInt("USU_ATIVO");
                String senha = rs.getString("USU_SENHA");
                int acesso = rs.getInt("TP_ID");
                
                Usuario usuario = new Usuario(nome, senha, email, sexo, generoPreferido, idade, acesso, ativo, id);
                usuarios[cont] = usuario;
            }
            return usuarios;
        }
    }
    
    public Usuario[] obterUsuariosInativos() throws Exception {
        String sql = "SELECT * FROM TB_USER WHERE USU_ATIVO = 0 AND TP_ID = 2;";
        
        try (
            var factory = ConnectionFactory.conectar();
            var ps = factory.prepareStatement(
                    sql, 
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            ResultSet rs = ps.executeQuery();
        ){
            int totalUsuario = 0;
            if (rs.last()){
                totalUsuario = rs.getRow();
            }
            Usuario[] usuarios = new Usuario[totalUsuario];
            rs.beforeFirst();
                
            for (int cont = 0; rs.next(); cont++) {
                int id = rs.getInt("USU_ID");
                String nome = rs.getString("USU_NOME");
                int generoPreferido = rs.getInt("USU_PREF");
                int idade = rs.getInt("USU_IDADE");
                String email = rs.getString("USU_EMAIL");
                String sexo = rs.getString("USU_SEXO");
                int ativo = rs.getInt("USU_ATIVO");
                String senha = rs.getString("USU_SENHA");
                int acesso = rs.getInt("TP_ID");
                
                Usuario usuario = new Usuario(nome, senha, email, sexo, generoPreferido, idade, acesso, ativo, id);
                usuarios[cont] = usuario;
            }
            return usuarios;
        }
    }
    
    public void ativarUsuario(Usuario user) throws Exception {
        String sql = "UPDATE TB_USER SET USU_ATIVO = 1 WHERE USU_ID = ? AND USU_NOME = ?;";
        
        try (
            var factory = ConnectionFactory.conectar();
            var ps = factory.prepareStatement(sql);
        ){
            ps.setInt(1, user.getId());
            ps.setString(2, user.getNome());
            
            ps.execute();
        }
    }
    
    public void desativarUsuario(Usuario user) throws Exception {
        String sql = "UPDATE TB_USER SET USU_ATIVO = 0 WHERE USU_ID = ? AND USU_NOME = ?;";
        
        try (
            var factory = ConnectionFactory.conectar();
            var ps = factory.prepareStatement(sql);
        ){
            ps.setInt(1, user.getId());
            ps.setString(2, user.getNome());
            
            ps.execute();
        }
    }
}
