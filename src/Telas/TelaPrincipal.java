package Telas;

import java.text.DateFormat;
import java.util.Date;

public class TelaPrincipal extends javax.swing.JFrame {

    TelaCadastro cadastro;
    TelaClientes cliente;
    TelaFuncionarios funcionario;
    TelaAdministrador telaAdm;
    TelaVendas venda;
    TelaPedidos pedido;

    public TelaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_adm = new javax.swing.JButton();
        btn_cadastros = new javax.swing.JButton();
        DesktopP = new javax.swing.JPanel();
        lbl_usuarioImagem = new javax.swing.JLabel();
        lbl_horaIcone = new javax.swing.JLabel();
        lbl_hora = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        btn_pedidos = new javax.swing.JButton();
        lbl_fundo = new javax.swing.JLabel();
        txt_funcionario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_adm.setBackground(new java.awt.Color(0, 102, 102));
        btn_adm.setForeground(new java.awt.Color(0, 153, 153));
        btn_adm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/ico_adm.png"))); // NOI18N
        btn_adm.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Painel ADM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        btn_adm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_admActionPerformed(evt);
            }
        });
        getContentPane().add(btn_adm, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 140, 110));

        btn_cadastros.setBackground(new java.awt.Color(0, 102, 102));
        btn_cadastros.setForeground(new java.awt.Color(0, 153, 153));
        btn_cadastros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/cad.png"))); // NOI18N
        btn_cadastros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        btn_cadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cadastros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, 110));

        DesktopP.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout DesktopPLayout = new javax.swing.GroupLayout(DesktopP);
        DesktopP.setLayout(DesktopPLayout);
        DesktopPLayout.setHorizontalGroup(
            DesktopPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 762, Short.MAX_VALUE)
        );
        DesktopPLayout.setVerticalGroup(
            DesktopPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
        );

        getContentPane().add(DesktopP, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 9, 762, 641));

        lbl_usuarioImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/funcionario.png"))); // NOI18N
        getContentPane().add(lbl_usuarioImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 70, 70, 80));

        lbl_horaIcone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/data.png"))); // NOI18N
        getContentPane().add(lbl_horaIcone, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 430, 70, 80));

        lbl_hora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_hora.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hora.setText("Data");
        getContentPane().add(lbl_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 510, 90, 40));

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_usuario.setText("Usuario");
        getContentPane().add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 160, 100, 40));

        btn_pedidos.setBackground(new java.awt.Color(0, 102, 102));
        btn_pedidos.setForeground(new java.awt.Color(0, 153, 153));
        btn_pedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/carrinho (2).png"))); // NOI18N
        btn_pedidos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pedidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        btn_pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pedidosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_pedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 140, 110));

        lbl_fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fundo2.jpg"))); // NOI18N
        getContentPane().add(lbl_fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 660));

        txt_funcionario.setEditable(false);
        getContentPane().add(txt_funcionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 40, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrosActionPerformed
        cadastro = new TelaCadastro();
        DesktopP.add(cadastro);
        cadastro.setVisible(true);
        if (telaAdm != null) {
            telaAdm.dispose();
        }
        if (pedido != null) {
            pedido.dispose();
        }

    }//GEN-LAST:event_btn_cadastrosActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Date data = new Date();
        DateFormat formatoData = DateFormat.getDateInstance(DateFormat.MEDIUM);
        lbl_hora.setText(formatoData.format(data));
    }//GEN-LAST:event_formWindowActivated

    private void btn_admActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_admActionPerformed
        telaAdm = new TelaAdministrador();
        DesktopP.add(telaAdm);
        telaAdm.setVisible(true);
        if (pedido != null) {
            pedido.dispose();
        }
         if (cadastro != null) {
            cadastro.dispose();
        }
        
    }//GEN-LAST:event_btn_admActionPerformed

    private void btn_pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pedidosActionPerformed
         pedido  = new TelaPedidos();
         DesktopP.add(pedido );
         pedido.setVisible(true);
         if (telaAdm != null) {
            telaAdm.dispose();
        }
         if (cadastro != null) {
            cadastro.dispose();
        }
    }//GEN-LAST:event_btn_pedidosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel DesktopP;
    public static javax.swing.JButton btn_adm;
    private javax.swing.JButton btn_cadastros;
    private javax.swing.JButton btn_pedidos;
    private javax.swing.JLabel lbl_fundo;
    private javax.swing.JLabel lbl_hora;
    private javax.swing.JLabel lbl_horaIcone;
    public static javax.swing.JLabel lbl_usuario;
    private javax.swing.JLabel lbl_usuarioImagem;
    public static javax.swing.JTextField txt_funcionario;
    // End of variables declaration//GEN-END:variables
}
