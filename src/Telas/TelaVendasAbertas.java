 
package Telas;
 
import Beans.VendasBeans;
import Controle.VendasControle;
import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class TelaVendasAbertas extends javax.swing.JInternalFrame {
 
    VendasControle vendasC;
    DefaultTableModel modelo;
    MaskFormatter formatoTel;
    SimpleDateFormat formatoData;
    VendasBeans vendasB;
    
    public TelaVendasAbertas() {
        initComponents();
        vendasC = new VendasControle();
        modelo = (DefaultTableModel) tb_tabelaVendas.getModel();
        this.getContentPane().setBackground(Color.darkGray);
        tb_tabelaVendas.setBackground(Color.darkGray);
        jsTabela.getViewport().setBackground(Color.darkGray);
        vendasC.listar(txt_pesquisa.getText(), modelo);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jsTabela = new javax.swing.JScrollPane();
        tb_tabelaVendas = new javax.swing.JTable();
        txt_pesquisa = new javax.swing.JTextField();
        lbl_codigo = new javax.swing.JLabel();
        lbl_nome = new javax.swing.JLabel();
        lbl_bairro = new javax.swing.JLabel();
        txt_valor = new javax.swing.JTextField();
        txt_cliente = new javax.swing.JTextField();
        txt_codigo = new javax.swing.JTextField();
        try {
            formatoTel = new MaskFormatter("(##) #####-####");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Campo personalizado", "Erro", 0);
        }
        txt_hora = new JFormattedTextField(formatoTel);
        txt_data = new javax.swing.JTextField();
        lbl_data = new javax.swing.JLabel();
        lbl_telefone = new javax.swing.JLabel();
        lbl_endereco1 = new javax.swing.JLabel();
        txt_funcionario = new javax.swing.JTextField();
        lbl_bairro1 = new javax.swing.JLabel();
        lbl_telefone1 = new javax.swing.JLabel();
        txt_status = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Tabela Vendas");
        setPreferredSize(new java.awt.Dimension(762, 641));

        tb_tabelaVendas.setForeground(new java.awt.Color(255, 255, 255));
        tb_tabelaVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cliente", "Funcionario", "Hora", "Data", "Valor", "Status"
            }
        ));
        tb_tabelaVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tb_tabelaVendasMousePressed(evt);
            }
        });
        jsTabela.setViewportView(tb_tabelaVendas);

        txt_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesquisaKeyReleased(evt);
            }
        });

        lbl_codigo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo.setText("Código");

        lbl_nome.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nome.setText("Cliente");

        lbl_bairro.setForeground(new java.awt.Color(255, 255, 255));
        lbl_bairro.setText("Valor");

        lbl_data.setForeground(new java.awt.Color(255, 255, 255));
        lbl_data.setText("Data");

        lbl_telefone.setForeground(new java.awt.Color(255, 255, 255));
        lbl_telefone.setText("Hora");

        lbl_endereco1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_endereco1.setText("Funcionario");

        lbl_bairro1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_bairro1.setText("Pesquisar");

        lbl_telefone1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_telefone1.setText("Status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(lbl_telefone1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_codigo)
                                    .addComponent(lbl_nome)
                                    .addComponent(lbl_bairro))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_valor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                        .addComponent(txt_cliente, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_endereco1)
                                    .addComponent(lbl_telefone)
                                    .addComponent(lbl_data))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(txt_funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jsTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(lbl_bairro1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_telefone1)
                    .addComponent(txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_codigo)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_endereco1)
                    .addComponent(txt_funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nome)
                    .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_telefone)
                    .addComponent(txt_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_bairro)
                    .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_data)
                    .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addComponent(jsTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_bairro1))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_pesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisaKeyReleased
        modelo.setNumRows(0);
        vendasC.listar(txt_pesquisa.getText(), modelo);
    }//GEN-LAST:event_txt_pesquisaKeyReleased

    private void tb_tabelaVendasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_tabelaVendasMousePressed
        vendasB = vendasC.preencherCampos(Integer.parseInt(modelo.getValueAt(tb_tabelaVendas.getSelectedRow(), 0).toString()));
        txt_codigo.setText(vendasB.getId() + "");
        txt_cliente.setText(vendasB.getClienteNome());
        txt_status.setText(vendasB.getStatus());
        txt_valor.setText(vendasB.getValor() + "");
        txt_hora.setText(vendasB.getHora());
        txt_data.setText(vendasB.getData());
        txt_funcionario.setText(vendasB.getFun_id() +"");
    }//GEN-LAST:event_tb_tabelaVendasMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jsTabela;
    private javax.swing.JLabel lbl_bairro;
    private javax.swing.JLabel lbl_bairro1;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_endereco1;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_telefone;
    private javax.swing.JLabel lbl_telefone1;
    private javax.swing.JTable tb_tabelaVendas;
    private javax.swing.JTextField txt_cliente;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_data;
    private javax.swing.JTextField txt_funcionario;
    private javax.swing.JTextField txt_hora;
    private javax.swing.JTextField txt_pesquisa;
    private javax.swing.JTextField txt_status;
    private javax.swing.JTextField txt_valor;
    // End of variables declaration//GEN-END:variables
}
