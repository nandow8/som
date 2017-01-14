/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Beans.FuncionariosBeans;
import Controle.FuncionarioControle;
import DAO.FuncionariosDAO;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class TelaFuncionarios extends javax.swing.JInternalFrame {

    MaskFormatter formatoTel;
    SimpleDateFormat formatoData;
    Date dataAtual;
    FuncionariosBeans funcionarioB;
    FuncionarioControle funcionarioC;
    FuncionariosDAO funcionarioD;
    DefaultTableModel modelo;

    public TelaFuncionarios() {
        initComponents();
        this.getContentPane().setBackground(Color.darkGray);
        tabelaFuncionarios.setBackground(Color.darkGray);
        jpainelClientes.getViewport().setBackground(Color.darkGray);

        funcionarioB = new FuncionariosBeans();
        funcionarioC = new FuncionarioControle();

        formatoData = new SimpleDateFormat("dd/MM/yyyy");
        dataAtual = new Date();                              // posso colocar isso no botao "NOVO" 
        txt_data.setText(formatoData.format(dataAtual));
        habilitarCampos(false);
        modelo = (DefaultTableModel) tabelaFuncionarios.getModel();
        funcionarioC.listar(txt_pesquisa.getText(), modelo);
    }

    void preparaSalvar() {
        funcionarioB.setBairro(txt_bairro.getText());
        funcionarioB.setData(txt_data.getText());
        funcionarioB.setEndereco(txt_endereco.getText());
        funcionarioB.setNome(txt_nome.getText());
        funcionarioB.setNumero(txt_numero.getText());
        funcionarioB.setTelefone(txt_telefone.getText());
        funcionarioB.setUsuario(txt_usuario.getText());
        funcionarioB.setSenha(txt_senha.getText());
        funcionarioB.setStatus(cb_cargo.getSelectedItem().toString());
    }

    void limparCampos() {
        txt_bairro.setText(null);
        txt_endereco.setText(null);
        txt_nome.setText(null);
        txt_numero.setText(null);
        txt_telefone.setText(null);
        txt_senha.setText(null);
        txt_usuario.setText(null);
        cb_cargo.setSelectedIndex(0);
    }

    final void habilitarCampos(boolean habilitado) {
        txt_bairro.setEnabled(habilitado);
        txt_endereco.setEnabled(habilitado);
        txt_nome.setEnabled(habilitado);
        txt_numero.setEnabled(habilitado);
        txt_telefone.setEnabled(habilitado);
        txt_data.setEnabled(habilitado);
        txt_codigo.setEnabled(habilitado);
        txt_usuario.setEnabled(habilitado);
        txt_senha.setEnabled(habilitado);
        cb_cargo.setEnabled(habilitado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_codigo = new javax.swing.JLabel();
        lbl_nome = new javax.swing.JLabel();
        lbl_endereco = new javax.swing.JLabel();
        lbl_telefone = new javax.swing.JLabel();
        lbl_numero = new javax.swing.JLabel();
        lbl_bairro = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_nome = new javax.swing.JTextField();
        txt_endereco = new javax.swing.JTextField();
        try {
            formatoTel = new MaskFormatter("(##) #####-####");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Campo personalizado", "Erro", 0);
        }
        txt_telefone = new JFormattedTextField(formatoTel);
        txt_numero = new javax.swing.JTextField();
        txt_bairro = new javax.swing.JTextField();
        txt_data = new javax.swing.JTextField();
        lbl_data = new javax.swing.JLabel();
        jpainelClientes = new javax.swing.JScrollPane();
        tabelaFuncionarios = new javax.swing.JTable();
        btn_excluir = new javax.swing.JButton();
        btn_novo = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_salvar = new javax.swing.JButton();
        lbl_pesquisa = new javax.swing.JLabel();
        txt_pesquisa = new javax.swing.JTextField();
        lbl_imgCliente = new javax.swing.JLabel();
        lbl_codigo1 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        lbl_codigo2 = new javax.swing.JLabel();
        txt_senha = new javax.swing.JTextField();
        lbl_codigo3 = new javax.swing.JLabel();
        cb_cargo = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Cadastro de Funcionarios");
        setPreferredSize(new java.awt.Dimension(762, 641));

        lbl_codigo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_codigo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo.setText("Código");

        lbl_nome.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_nome.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nome.setText("Nome");

        lbl_endereco.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_endereco.setForeground(new java.awt.Color(255, 255, 255));
        lbl_endereco.setText("Endereço");

        lbl_telefone.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_telefone.setForeground(new java.awt.Color(255, 255, 255));
        lbl_telefone.setText("Telefone");

        lbl_numero.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_numero.setForeground(new java.awt.Color(255, 255, 255));
        lbl_numero.setText("Numero");

        lbl_bairro.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_bairro.setForeground(new java.awt.Color(255, 255, 255));
        lbl_bairro.setText("Bairro");

        lbl_data.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_data.setForeground(new java.awt.Color(255, 255, 255));
        lbl_data.setText("Data");

        tabelaFuncionarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaFuncionarios.setForeground(new java.awt.Color(255, 255, 255));
        tabelaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Cargo", "Telefone"
            }
        ));
        tabelaFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaFuncionariosMousePressed(evt);
            }
        });
        jpainelClientes.setViewportView(tabelaFuncionarios);

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

        lbl_pesquisa.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_pesquisa.setForeground(new java.awt.Color(255, 255, 255));
        lbl_pesquisa.setText("Pesquisa");

        txt_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesquisaKeyReleased(evt);
            }
        });

        lbl_imgCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/users.png"))); // NOI18N

        lbl_codigo1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_codigo1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo1.setText("Usuário");

        lbl_codigo2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_codigo2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo2.setText("Senha");

        lbl_codigo3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbl_codigo3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo3.setText("Cargo");

        cb_cargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Funcionario", "Gerente" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_codigo1)
                        .addGap(233, 233, 233)
                        .addComponent(lbl_codigo2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpainelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(72, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_codigo)
                                        .addComponent(lbl_nome))
                                    .addGap(33, 33, 33))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lbl_endereco)
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_bairro)
                                .addGap(41, 41, 41)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_bairro)
                            .addComponent(txt_nome)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_numero)
                            .addComponent(lbl_telefone)
                            .addComponent(lbl_data)
                            .addComponent(lbl_codigo3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_senha)
                            .addComponent(txt_telefone, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(txt_numero)
                            .addComponent(txt_data)
                            .addComponent(cb_cargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(55, 55, 55)
                        .addComponent(lbl_imgCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_editar, btn_excluir, btn_novo, btn_salvar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_codigo)
                                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_codigo3)
                                    .addComponent(cb_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nome)
                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_telefone)
                            .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_endereco)
                            .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_numero)
                            .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_bairro)
                            .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_data)
                            .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_imgCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_codigo1)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_codigo2)
                    .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jpainelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        funcionarioC.salvar(funcionarioB);
        limparCampos();
        txt_codigo.setText(funcionarioC.proximoCodigo());
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed
        habilitarCampos(true);
        txt_codigo.setText(funcionarioC.proximoCodigo());
        limparCampos();
    }//GEN-LAST:event_btn_novoActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        preparaSalvar();
        funcionarioC.editar(funcionarioB);
        limparCampos();
    }//GEN-LAST:event_btn_editarActionPerformed
    private void txt_pesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisaKeyReleased
        modelo.setNumRows(0);
        funcionarioC.listar(txt_pesquisa.getText(), modelo);
    }//GEN-LAST:event_txt_pesquisaKeyReleased

    private void tabelaFuncionariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFuncionariosMousePressed
        funcionarioB = funcionarioC.preencherCampos(Integer.parseInt(modelo.getValueAt(tabelaFuncionarios.getSelectedRow(), 0).toString()));
        txt_codigo.setText(funcionarioB.getId() + "");
        txt_nome.setText(funcionarioB.getNome());
        txt_endereco.setText(funcionarioB.getEndereco());
        txt_numero.setText(funcionarioB.getNumero());
        txt_bairro.setText(funcionarioB.getBairro());
        txt_telefone.setText(funcionarioB.getTelefone());
        txt_data.setText(funcionarioB.getData());
        txt_usuario.setText(funcionarioB.getUsuario());
        txt_senha.setText(funcionarioB.getSenha());
        cb_cargo.setSelectedItem(funcionarioB.getStatus());
        habilitarCampos(true);
    }//GEN-LAST:event_tabelaFuncionariosMousePressed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
             funcionarioC.excluir(funcionarioB);
    }//GEN-LAST:event_btn_excluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JComboBox<String> cb_cargo;
    private javax.swing.JScrollPane jpainelClientes;
    private javax.swing.JLabel lbl_bairro;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_codigo1;
    private javax.swing.JLabel lbl_codigo2;
    private javax.swing.JLabel lbl_codigo3;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_endereco;
    private javax.swing.JLabel lbl_imgCliente;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_numero;
    private javax.swing.JLabel lbl_pesquisa;
    private javax.swing.JLabel lbl_telefone;
    private javax.swing.JTable tabelaFuncionarios;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_data;
    private javax.swing.JTextField txt_endereco;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JTextField txt_pesquisa;
    private javax.swing.JTextField txt_senha;
    private javax.swing.JTextField txt_telefone;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
