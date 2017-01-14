 
package Telas;

import Beans.ProdutosBeans;
import Controle.ProdutosControle;
import DAO.ProdutosDAO;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

public class TelaProdutos extends javax.swing.JInternalFrame {

    ProdutosBeans produtoB;
    ProdutosControle produtoC;
    ProdutosDAO funcionarioD;
    DefaultTableModel modelo;

    public TelaProdutos() {
        initComponents();
        this.getContentPane().setBackground(Color.darkGray);
        tabelaProdutos.setBackground(Color.darkGray);
        jpProdutos.getViewport().setBackground(Color.darkGray);

        produtoB = new ProdutosBeans();
        produtoC = new ProdutosControle();

        habilitarCampos(false);
        modelo = (DefaultTableModel) tabelaProdutos.getModel();
        produtoC.listar(txt_pesquisa.getText(), modelo);
        
    }

    void preparaSalvar() {
        produtoB.setNome(txt_nome.getText());
        produtoB.setQuantidade(Integer.parseInt(txt_quantidade.getText()));
        produtoB.setValor(Double.parseDouble(txt_valor.getText()));
        produtoB.setTipo(cb_categoria.getSelectedItem().toString());
    }

    void limparCampos() {
        txt_nome.setText(null);
        txt_quantidade.setText(null);
        txt_valor.setText(null);
        cb_categoria.setSelectedIndex(0);
    }

    final void habilitarCampos(boolean habilitado) {
        txt_nome.setEnabled(habilitado);
        txt_quantidade.setEnabled(habilitado);
        txt_codigo.setEnabled(habilitado);
        txt_valor.setEnabled(habilitado);
        cb_categoria.setEnabled(habilitado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_codigo = new javax.swing.JLabel();
        lbl_nome = new javax.swing.JLabel();
        lbl_telefone = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_nome = new javax.swing.JTextField();
        jpProdutos = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        btn_excluir = new javax.swing.JButton();
        btn_novo = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_salvar = new javax.swing.JButton();
        lbl_pesquisa = new javax.swing.JLabel();
        txt_pesquisa = new javax.swing.JTextField();
        lbl_imgCliente = new javax.swing.JLabel();
        lbl_codigo3 = new javax.swing.JLabel();
        cb_categoria = new javax.swing.JComboBox<>();
        txt_quantidade = new javax.swing.JTextField();
        lbl_codigo1 = new javax.swing.JLabel();
        txt_valor = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Cadastro de Produtos");
        setPreferredSize(new java.awt.Dimension(762, 641));

        lbl_codigo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo.setText("Código");

        lbl_nome.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nome.setText("Nome");

        lbl_telefone.setForeground(new java.awt.Color(255, 255, 255));
        lbl_telefone.setText("Quantidade");

        tabelaProdutos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaProdutos.setForeground(new java.awt.Color(255, 255, 255));
        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Preço", "Quantidade", "Categoria"
            }
        ));
        tabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaProdutosMousePressed(evt);
            }
        });
        jpProdutos.setViewportView(tabelaProdutos);

        btn_excluir.setBackground(new java.awt.Color(0, 0, 0));
        btn_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/excluir2.png"))); // NOI18N
        btn_excluir.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Excluir", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        btn_novo.setBackground(new java.awt.Color(0, 0, 0));
        btn_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/novo2.png"))); // NOI18N
        btn_novo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Novo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        btn_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoActionPerformed(evt);
            }
        });

        btn_editar.setBackground(new java.awt.Color(0, 0, 0));
        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/editar2.png"))); // NOI18N
        btn_editar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_salvar.setBackground(new java.awt.Color(0, 0, 0));
        btn_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/salvarIcone.png"))); // NOI18N
        btn_salvar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salvar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        lbl_pesquisa.setForeground(new java.awt.Color(255, 255, 255));
        lbl_pesquisa.setText("Pesquisa");

        txt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pesquisaActionPerformed(evt);
            }
        });
        txt_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesquisaKeyReleased(evt);
            }
        });

        lbl_imgCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/auto falante caixa.png"))); // NOI18N

        lbl_codigo3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo3.setText("Categoria");

        cb_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Som", "Alarme", "Material" }));

        lbl_codigo1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo1.setText("Preço");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(lbl_pesquisa)
                                .addGap(39, 39, 39)
                                .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(btn_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btn_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jpProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 62, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_codigo)
                                    .addComponent(lbl_nome)
                                    .addComponent(lbl_codigo1))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_telefone)
                                    .addComponent(lbl_codigo3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_categoria, 0, 111, Short.MAX_VALUE)
                                    .addComponent(txt_quantidade))
                                .addGap(18, 18, 18)
                                .addComponent(lbl_imgCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_editar, btn_excluir, btn_novo, btn_salvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lbl_imgCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_codigo)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nome)
                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_telefone)
                            .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_codigo1)
                                .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_codigo3)
                                .addComponent(cb_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)))
                .addComponent(jpProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_pesquisa)
                    .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_excluir))
                .addGap(27, 27, 27))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_editar, btn_excluir, btn_novo, btn_salvar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        preparaSalvar();
        produtoC.salvar(produtoB);
        txt_codigo.setText(produtoC.proximoCodigo());
            limparCampos();
            habilitarCampos(false);
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed
        habilitarCampos(true);
        txt_codigo.setText(produtoC.proximoCodigo());
        limparCampos();
        txt_quantidade.setText("0");
    }//GEN-LAST:event_btn_novoActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        preparaSalvar();
        produtoC.editar(produtoB);
        txt_quantidade.setText("0");
    }//GEN-LAST:event_btn_editarActionPerformed
    private void txt_pesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisaKeyReleased
        modelo.setNumRows(0);
        produtoC.listar(txt_pesquisa.getText(), modelo);
    }//GEN-LAST:event_txt_pesquisaKeyReleased

    private void tabelaProdutosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutosMousePressed
        produtoB = produtoC.preencherCampos(Integer.parseInt(modelo.getValueAt(tabelaProdutos.getSelectedRow(), 0).toString()));
        txt_codigo.setText(produtoB.getId() + "");
        txt_nome.setText(produtoB.getNome());
        txt_valor.setText(produtoB.getValor()+ "");
        txt_quantidade.setText(produtoB.getQuantidade() + "");
        cb_categoria.setSelectedItem(produtoB.getTipo());
        habilitarCampos(true);
    }//GEN-LAST:event_tabelaProdutosMousePressed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
             produtoC.excluir(produtoB);
    }//GEN-LAST:event_btn_excluirActionPerformed

    private void txt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pesquisaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JComboBox<String> cb_categoria;
    private javax.swing.JScrollPane jpProdutos;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_codigo1;
    private javax.swing.JLabel lbl_codigo3;
    private javax.swing.JLabel lbl_imgCliente;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_pesquisa;
    private javax.swing.JLabel lbl_telefone;
    private javax.swing.JTable tabelaProdutos;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_pesquisa;
    private javax.swing.JTextField txt_quantidade;
    private javax.swing.JTextField txt_valor;
    // End of variables declaration//GEN-END:variables
}
