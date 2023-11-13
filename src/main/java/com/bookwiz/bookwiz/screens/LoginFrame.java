/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.bookwiz.bookwiz.screens;

import com.bookwiz.bookwiz.UsuarioDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author koishi
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginTextField = new javax.swing.JTextField();
        passwordTextPassword = new javax.swing.JPasswordField();
        okButtomOk = new javax.swing.JToggleButton();
        sairButtomSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        loginTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));
        loginTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        loginTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginTextFieldActionPerformed(evt);
            }
        });

        passwordTextPassword.setBorder(javax.swing.BorderFactory.createTitledBorder("Senha"));
        passwordTextPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextPasswordActionPerformed(evt);
            }
        });

        okButtomOk.setText("Entrar");
        okButtomOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtomOkActionPerformed(evt);
            }
        });

        sairButtomSair.setText("Sair");
        sairButtomSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairButtomSairActionPerformed(evt);
            }
        });

        jLabel1.setText("Bem-Vindo ao BookWiz!!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(loginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordTextPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okButtomOk, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sairButtomSair, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addGap(67, 67, 67)
                .addComponent(loginTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(passwordTextPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(okButtomOk, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(sairButtomSair, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addGap(154, 154, 154))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordTextPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextPasswordActionPerformed

    private void okButtomOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtomOkActionPerformed
        String login = loginTextField.getText();
        String senha = new String(passwordTextPassword.getPassword());
        var usuarioDAO = new UsuarioDAO();
        try{
            var usuario = usuarioDAO.verificarUsuario(login, senha);
            if (usuario == null) {
                JOptionPane.showMessageDialog(null, "Login e/ou Senha está inválido");
            } else {
                if (usuario.getAtivo() == 1){
                    JOptionPane.showMessageDialog(null, "Bem-Vindo " + usuario.getNome() + "!!");
                    int acesso = usuario.getAcesso();
                    switch(acesso){
                        case 1: {
                            AdminFrame screenAdm = new AdminFrame(usuario);
                            this.dispose();
                            screenAdm.setVisible(true);
                            break;
                        }
                        
                        case 2: {
                            MenuFrame screenPrincipal = new MenuFrame(usuario);
                            this.dispose();
                            screenPrincipal.setVisible(true);
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Essa conta foi desativada\nEntre em contato com um administrador caso queira ativa-lá");
                }
            }
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
    }//GEN-LAST:event_okButtomOkActionPerformed

    private void sairButtomSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairButtomSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_sairButtomSairActionPerformed

    private void loginTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginTextFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField loginTextField;
    private javax.swing.JToggleButton okButtomOk;
    private javax.swing.JPasswordField passwordTextPassword;
    private javax.swing.JButton sairButtomSair;
    // End of variables declaration//GEN-END:variables
}
