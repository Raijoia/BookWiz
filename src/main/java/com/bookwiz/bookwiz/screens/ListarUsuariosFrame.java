/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.bookwiz.bookwiz.screens;

import com.bookwiz.bookwiz.DAO.UsuarioDAO;
import com.bookwiz.bookwiz.entity.Usuario;
import java.awt.event.ItemEvent;
import java.util.Arrays;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author rai
 */
public class ListarUsuariosFrame extends javax.swing.JFrame {
    Usuario usuario, usuarioSelecionado;
    String email, sexo;
    int idade, id, pref;
    Usuario[] usuarios;
    
    /**
     * Creates new form ListarUsuariosFrame
     */
    public ListarUsuariosFrame() {
        initComponents();
    }
    
    public ListarUsuariosFrame(Usuario usuario) {
        this();
        buscarUsuarios();
        setLocationRelativeTo(null);
        this.usuario = usuario;
    }
    
    private void buscarUsuarios() {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarios = usuarioDAO.obterUsuarios();
            Arrays.sort(usuarios);
            listarUsuariosComboBox.setModel(
                    new DefaultComboBoxModel<>(usuarios)
            );
            usuarioSelecionado = usuarios[0];
            
            email = usuarioSelecionado.getEmail();
            sexo = usuarioSelecionado.getSexo();
            idade = usuarioSelecionado.getIdade();
            id = usuarioSelecionado.getId();
            pref = usuarioSelecionado.getPref();
            
            generoPreferidoUsuarioLabel.setText(Integer.toString(pref));
            emailUsuarioLabel.setText(email);
            idUsuarioLabel.setText(Integer.toString(id));
            sexoUsuarioLabel.setText(sexo);
            idadeUsuarioLabel.setText(Integer.toString(idade));
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(
            null, 
            "não encontrei lista de usuarios");
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listarUsuariosComboBox = new javax.swing.JComboBox<>();
        idUsuarioLabel = new javax.swing.JLabel();
        emailUsuarioLabel = new javax.swing.JLabel();
        sexoUsuarioLabel = new javax.swing.JLabel();
        idadeUsuarioLabel = new javax.swing.JLabel();
        generoPreferidoUsuarioLabel = new javax.swing.JLabel();
        voltarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listarUsuariosComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listarUsuariosComboBoxItemStateChanged(evt);
            }
        });

        idUsuarioLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("ID"));

        emailUsuarioLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("E-mail"));

        sexoUsuarioLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Sexo"));

        idadeUsuarioLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Idade"));

        generoPreferidoUsuarioLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Genero Preferido"));

        voltarButton.setText("Voltar");
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listarUsuariosComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(emailUsuarioLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(sexoUsuarioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 7, Short.MAX_VALUE)))
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(generoPreferidoUsuarioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idUsuarioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(idadeUsuarioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(voltarButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(listarUsuariosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(generoPreferidoUsuarioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(idUsuarioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailUsuarioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sexoUsuarioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idadeUsuarioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(voltarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listarUsuariosComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listarUsuariosComboBoxItemStateChanged
         if(evt.getStateChange() == ItemEvent.SELECTED){
            usuarioSelecionado = (Usuario)evt.getItem();
            email = usuarioSelecionado.getEmail();
            sexo = usuarioSelecionado.getSexo();
            idade = usuarioSelecionado.getIdade();
            id = usuarioSelecionado.getId();
            pref = usuarioSelecionado.getPref();
        }
        generoPreferidoUsuarioLabel.setText(Integer.toString(pref));
        emailUsuarioLabel.setText(email);
        idUsuarioLabel.setText(Integer.toString(id));
        sexoUsuarioLabel.setText(sexo);
        idadeUsuarioLabel.setText(Integer.toString(idade));
    }//GEN-LAST:event_listarUsuariosComboBoxItemStateChanged

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        AdminFrame screen = new AdminFrame(usuario);
        screen.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ListarUsuariosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarUsuariosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarUsuariosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarUsuariosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarUsuariosFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel emailUsuarioLabel;
    private javax.swing.JLabel generoPreferidoUsuarioLabel;
    private javax.swing.JLabel idUsuarioLabel;
    private javax.swing.JLabel idadeUsuarioLabel;
    private javax.swing.JComboBox<Usuario> listarUsuariosComboBox;
    private javax.swing.JLabel sexoUsuarioLabel;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
