/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.bookwiz.bookwiz.screens;

import com.bookwiz.bookwiz.DAO.LivroDAO;
import com.bookwiz.bookwiz.DAO.NotaDAO;
import com.bookwiz.bookwiz.entity.Livro;
import com.bookwiz.bookwiz.entity.Nota;
import com.bookwiz.bookwiz.entity.Usuario;
import java.awt.event.ItemEvent;
import java.util.Arrays;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author rai
 */
public class ListarLivrosFrame extends javax.swing.JFrame {
    Usuario usuario;
    String descricao, autor;
    int nota, genero;
    Livro livro;

    /**
     * Creates new form listarLivrosFrame
     */
    public ListarLivrosFrame() {
        initComponents();
    }
    
    public ListarLivrosFrame(Usuario usuario) {
        this();
        buscarLivros();
        setLocationRelativeTo(null);
        this.usuario = usuario;
    }
    
    private void buscarLivros() {
        try {
            LivroDAO livroDAO = new LivroDAO();
            Livro[] livros = livroDAO.obterLivros();
            Arrays.sort(livros);
            livrosComboBox.setModel(
                    new DefaultComboBoxModel<>(livros)
            );
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(
            null, 
            "não encontrei lista de livros");
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

        livrosComboBox = new javax.swing.JComboBox<>();
        descricaoLabel = new javax.swing.JLabel();
        notaMediaLabel = new javax.swing.JLabel();
        addNotaButton = new javax.swing.JButton();
        autorLabel = new javax.swing.JLabel();
        addNotaTextField = new javax.swing.JTextField();
        voltarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        livrosComboBox.setToolTipText("");
        livrosComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                livrosComboBoxItemStateChanged(evt);
            }
        });
        livrosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                livrosComboBoxActionPerformed(evt);
            }
        });

        descricaoLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));

        notaMediaLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Nota média do livro"));

        addNotaButton.setText("Adicionar nota");
        addNotaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNotaButtonActionPerformed(evt);
            }
        });

        autorLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Autor do livro"));

        addNotaTextField.setBorder(javax.swing.BorderFactory.createTitledBorder("Dê sua nota para o livro"));

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(descricaoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(livrosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(notaMediaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(addNotaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                    .addComponent(addNotaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(autorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(165, 165, 165))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(voltarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(livrosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(notaMediaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(autorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descricaoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addNotaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addNotaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(voltarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void livrosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_livrosComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_livrosComboBoxActionPerformed

    private void livrosComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_livrosComboBoxItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            descricao = ((Livro)evt.getItem()).getDescricao();
            autor = ((Livro)evt.getItem()).getAutor();
            nota = ((Livro)evt.getItem()).getNota().getNota();
            genero = ((Livro)evt.getItem()).getGenero();
            livro = (Livro)evt.getItem();
        }
        descricaoLabel.setText(descricao);
        notaMediaLabel.setText(Integer.toString(nota));
        autorLabel.setText(autor);
    }//GEN-LAST:event_livrosComboBoxItemStateChanged

    private void addNotaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNotaButtonActionPerformed
        try {
            Nota novaNota = new Nota(Integer.parseInt(addNotaTextField.getText()));
            NotaDAO notaDAO = new NotaDAO();
            notaDAO.adicionarNota(novaNota, usuario, livro);
            JOptionPane.showMessageDialog(null, "Nota " + novaNota.getNota() + " foi adicionada no livro " + livro.getTitulo() + " do autor " + livro.getAutor());
            buscarLivros();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }//GEN-LAST:event_addNotaButtonActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        MenuFrame screen = new MenuFrame();
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
            java.util.logging.Logger.getLogger(ListarLivrosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarLivrosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarLivrosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarLivrosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarLivrosFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNotaButton;
    private javax.swing.JTextField addNotaTextField;
    private javax.swing.JLabel autorLabel;
    private javax.swing.JLabel descricaoLabel;
    private javax.swing.JComboBox<Livro> livrosComboBox;
    private javax.swing.JLabel notaMediaLabel;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
