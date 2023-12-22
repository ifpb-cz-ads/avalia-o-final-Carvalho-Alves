/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Supermercado.view;

import Supermercado.model.Usuario;
import Supermercado.controller.UsuarioController;
import Supermercado.dao.ExceptionDAO;
import Supermercado.dao.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Thekingolias
 */
public class TelaLoginSupermercado extends javax.swing.JFrame {

    /**
     * Creates new form TelaLoginSupermercado
     */
    public TelaLoginSupermercado() {
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

        jTextField1Email = new javax.swing.JTextField();
        jTextField2Senha = new javax.swing.JTextField();
        jButton1Entrar = new javax.swing.JButton();
        jButton2CriarConta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TelaLoginUsuario");

        jTextField1Email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1Email.setText("E-mail");
        jTextField1Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1EmailActionPerformed(evt);
            }
        });

        jTextField2Senha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2Senha.setText("Senha");
        jTextField2Senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2SenhaActionPerformed(evt);
            }
        });

        jButton1Entrar.setBackground(new java.awt.Color(51, 255, 51));
        jButton1Entrar.setText("Entrar");
        jButton1Entrar.setToolTipText("");
        jButton1Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1EntrarActionPerformed(evt);
            }
        });

        jButton2CriarConta.setBackground(new java.awt.Color(255, 255, 102));
        jButton2CriarConta.setText("Criar Conta");
        jButton2CriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2CriarContaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1Email)
                    .addComponent(jTextField2Senha))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2CriarConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1Entrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jTextField1Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2Senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1Entrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2CriarConta)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1EmailActionPerformed

    private void jTextField2SenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2SenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2SenhaActionPerformed

    private void jButton1EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1EntrarActionPerformed
        String email = jTextField1Email.getText();
        String senhaChars = jTextField2Senha.getText();
        String senha = new String(senhaChars);

    try {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.buscarUsuarioPorEmail(email);

        if (usuario != null && usuario.getSenha().equals(senha)) {
            JOptionPane.showMessageDialog(null, "Login bem-sucedido!");

            TelaMenuSupermercado telaMenuSupermercado = new TelaMenuSupermercado();
            telaMenuSupermercado.setVisible(true);
            this.dispose(); 

        } else {
            JOptionPane.showMessageDialog(null, "Credenciais inválidas. Tente novamente.");
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro durante o login: " + ex.getMessage());
    }

    }//GEN-LAST:event_jButton1EntrarActionPerformed

    private void jButton2CriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2CriarContaActionPerformed
        TelaCadastroSupermercado telaCadastroSupermercado = new TelaCadastroSupermercado(this);
        telaCadastroSupermercado.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2CriarContaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLoginSupermercado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLoginSupermercado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLoginSupermercado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLoginSupermercado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLoginSupermercado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1Entrar;
    private javax.swing.JButton jButton2CriarConta;
    private javax.swing.JTextField jTextField1Email;
    private javax.swing.JTextField jTextField2Senha;
    // End of variables declaration//GEN-END:variables

   
}
