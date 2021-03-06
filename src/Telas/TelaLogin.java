 
package Telas;

import Util.Conexao;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.scene.layout.Background;
import javax.swing.JOptionPane;
 
public class TelaLogin extends javax.swing.JFrame {
    TelaPrincipal principal;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaLogin() {
        initComponents();
        conexao = Conexao.getConnection();
        setLocationRelativeTo(null);
    }

    public void logar() {
        String sql = "select * from funcionarios where fun_usuario = ? and fun_senha = ? ";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txt_usuario.getText());
            pst.setString(2, txt_senha.getText());

            //executar a query - consulta
            rs = pst.executeQuery();

            if (rs.next()) {
                String perfil = rs.getString(8);
                if (perfil.equals("Gerente")) {
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    TelaPrincipal.btn_adm.setEnabled(true);
                    TelaPrincipal.lbl_usuario.setText(rs.getString(2));
                    TelaPrincipal.txt_funcionario.setText(rs.getString(1));
                    TelaPrincipal.lbl_usuario.setForeground(Color.orange);
                    this.dispose();
                } else {
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    TelaPrincipal.lbl_usuario.setText(rs.getString(2));
                    TelaPrincipal.txt_funcionario.setText(rs.getString(1));
                    this.dispose();
                } 
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou Senha inválidos");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        btn_logar = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        txt_usuario = new javax.swing.JTextField();
        txt_senha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_logar.setText("Logar");
        btn_logar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_logar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 70, 30));

        btn_sair.setText("Sair");
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });
        getContentPane().add(btn_sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 70, 30));

        txt_usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 150, 30));
        getContentPane().add(txt_senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 150, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/telalogin.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_sairActionPerformed

    private void btn_logarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logarActionPerformed
        logar();
    }//GEN-LAST:event_btn_logarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_logar;
    private javax.swing.JButton btn_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField txt_senha;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
