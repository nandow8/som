package Telas;

import Beans.ClientesBeans;
import Beans.ProdutosBeans;
import Controle.ClienteControler;
import Controle.VendasControle;
import Controle.ProdutosControle;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.Desktop; 
import java.io.File;

public class TelaVendas extends javax.swing.JInternalFrame {

    MaskFormatter formatoTel;
    SimpleDateFormat formatoData;
    ClientesBeans clienteB;
    ClienteControler clienteC;
    DefaultTableModel modelo, modeloPorNome, modeloCompra;
    Date dataAtual;
    ProdutosBeans produtoB;
    ProdutosControle produtoC;
    VendasControle pedidoC;
    
    public TelaVendas() {
        initComponents();
        btn_pedidos.setEnabled(false);
        painelClientes.setBackground(Color.darkGray);
        painelPedidos.setBackground(Color.darkGray);
        tabelaClientes.setBackground(Color.darkGray);
        tabelaProdutosCompra.setBackground(Color.darkGray);
        tabelaPorNome.setBackground(Color.darkGray);
        tabelaPorNome.setBackground(Color.darkGray);
        jpClientes.getViewport().setBackground(Color.darkGray);
        jp_PorNome.getViewport().setBackground(Color.darkGray);
        jp_produtosCompra.getViewport().setBackground(Color.darkGray);
        
        txt_quantidade.setText("1");

        clienteB = new ClientesBeans();
        clienteC = new ClienteControler();
        produtoB = new ProdutosBeans();
        produtoC = new ProdutosControle();
        pedidoC = new VendasControle();
        
        formatoData = new SimpleDateFormat("dd/MM/yyyy");
        dataAtual = new Date();                               
        txt_data.setText(formatoData.format(dataAtual));
        modelo = (DefaultTableModel) tabelaClientes.getModel();
        modeloCompra = (DefaultTableModel) tabelaProdutosCompra.getModel();
        modeloPorNome = (DefaultTableModel) tabelaPorNome.getModel();
        clienteC.listar(txt_pesquisa.getText(), modelo);
        produtoC.listarNaTelaPedidos(txt_pesquisaPorNome.getText(), modeloPorNome);
        painelPrincipal.setEnabledAt(1, false);
        btn_finalizarPedido.setEnabled(false);
        btn_orcamento.setEnabled(false);
        btn_adicionar.setEnabled(false);
        btn_remover.setEnabled(false);
                
        txt_funcionario.setText(TelaPrincipal.txt_funcionario.getText());
    }

    public void CalcularTotal() {
        double TotalPedido = 0;
        for (int i = 0; i < tabelaProdutosCompra.getRowCount(); i++) {
            TotalPedido += Double.parseDouble(tabelaProdutosCompra.getValueAt(i, 4).toString());
        }
        if (TotalPedido > 0) {
            btn_finalizarPedido.setEnabled(true);
            btn_orcamento.setEnabled(true);
        }
        txt_total.setText(TotalPedido + "");
    }
    
    public void GerarOrcamento(){
        Document documento = new Document();
        try {
            PdfWriter.getInstance(documento, new FileOutputStream("teste.pdf"));

            documento.open();
            Paragraph para = new Paragraph();
            para.add("                                      Som E Alarme Nandao\n \n");
            para.add("Código do funcionario: " + txt_funcionario.getText() + "\n");
            para.add("Cliente: " + txt_nome.getText() + "\n \n");

            modeloCompra.getValueAt(0, 1);
            String[] itens = new String[100];
            for (int i = 0; i < tabelaProdutosCompra.getRowCount(); i++) {
                itens[i] = (String) tabelaProdutosCompra.getValueAt(i, 1) + "    Quantidade: " + tabelaProdutosCompra.getValueAt(i,2)+ 
                        "  Preço R$ " +  tabelaProdutosCompra.getValueAt(i, 3);
                para.add(itens[i] + "\n");
            }
            para.add("\n Total: " + txt_total.getText());

            documento.add(para);
            documento.close();
            Desktop.getDesktop().open(new File("teste.pdf"));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JTabbedPane();
        painelClientes = new javax.swing.JPanel();
        lbl_codigo = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        lbl_nome = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        try {
            formatoTel = new MaskFormatter("(##) #####-####");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Campo personalizado", "Erro", 0);
        }
        txt_telefone = new JFormattedTextField(formatoTel);
        txt_numero = new javax.swing.JTextField();
        txt_data = new javax.swing.JTextField();
        lbl_data = new javax.swing.JLabel();
        lbl_numero = new javax.swing.JLabel();
        lbl_telefone = new javax.swing.JLabel();
        txt_endereco = new javax.swing.JTextField();
        txt_bairro = new javax.swing.JTextField();
        lbl_bairro = new javax.swing.JLabel();
        lbl_endereco = new javax.swing.JLabel();
        lbl_imgCliente = new javax.swing.JLabel();
        jpClientes = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        txt_pesquisa = new javax.swing.JTextField();
        lbl_pesquisa = new javax.swing.JLabel();
        btn_pedidos = new javax.swing.JButton();
        btn_fechar = new javax.swing.JButton();
        painelPedidos = new javax.swing.JPanel();
        jp_PorNome = new javax.swing.JScrollPane();
        tabelaPorNome = new javax.swing.JTable();
        lbl_telefone1 = new javax.swing.JLabel();
        txt_quantidade = new javax.swing.JTextField();
        txt_pesquisaPorNome = new javax.swing.JTextField();
        lbl_pesquisa1 = new javax.swing.JLabel();
        lbl_telefone2 = new javax.swing.JLabel();
        txt_preco = new javax.swing.JTextField();
        jp_produtosCompra = new javax.swing.JScrollPane();
        tabelaProdutosCompra = new javax.swing.JTable();
        btn_adicionar = new javax.swing.JButton();
        btn_remover = new javax.swing.JButton();
        btn_orcamento = new javax.swing.JButton();
        txt_total = new javax.swing.JTextField();
        btn_finalizarPedido = new javax.swing.JButton();
        txt_codigo2 = new javax.swing.JTextField();
        lbl_telefone3 = new javax.swing.JLabel();
        lbl_telefone4 = new javax.swing.JLabel();
        txt_nomeCliente = new javax.swing.JTextField();
        txt_funcionario = new javax.swing.JTextField();
        lbl_codigo2 = new javax.swing.JLabel();
        txt_nomeProduto = new javax.swing.JTextField();
        lbl_telefone5 = new javax.swing.JLabel();
        lbl_telefone6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(762, 641));

        lbl_codigo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo.setText("Código");

        txt_codigo.setEditable(false);

        lbl_nome.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nome.setText("Nome");

        txt_nome.setEditable(false);

        txt_telefone.setEditable(false);

        txt_numero.setEditable(false);

        txt_data.setEditable(false);

        lbl_data.setForeground(new java.awt.Color(255, 255, 255));
        lbl_data.setText("Data");

        lbl_numero.setForeground(new java.awt.Color(255, 255, 255));
        lbl_numero.setText("Numero");

        lbl_telefone.setForeground(new java.awt.Color(255, 255, 255));
        lbl_telefone.setText("Telefone");

        txt_endereco.setEditable(false);

        txt_bairro.setEditable(false);

        lbl_bairro.setForeground(new java.awt.Color(255, 255, 255));
        lbl_bairro.setText("Bairro");

        lbl_endereco.setForeground(new java.awt.Color(255, 255, 255));
        lbl_endereco.setText("Endereço");

        lbl_imgCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/icon_clientes.png"))); // NOI18N

        tabelaClientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaClientes.setForeground(new java.awt.Color(255, 255, 255));
        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Bairro", "Telefone"
            }
        ));
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaClientesMousePressed(evt);
            }
        });
        jpClientes.setViewportView(tabelaClientes);

        txt_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesquisaKeyReleased(evt);
            }
        });

        lbl_pesquisa.setForeground(new java.awt.Color(255, 255, 255));
        lbl_pesquisa.setText("Pesquisa");

        btn_pedidos.setBackground(new java.awt.Color(0, 0, 0));
        btn_pedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/next.png"))); // NOI18N
        btn_pedidos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pedidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        btn_pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pedidosActionPerformed(evt);
            }
        });

        btn_fechar.setBackground(new java.awt.Color(0, 0, 0));
        btn_fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/fechar.png"))); // NOI18N
        btn_fechar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fechar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        btn_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelClientesLayout = new javax.swing.GroupLayout(painelClientes);
        painelClientes.setLayout(painelClientesLayout);
        painelClientesLayout.setHorizontalGroup(
            painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClientesLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelClientesLayout.createSequentialGroup()
                        .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(painelClientesLayout.createSequentialGroup()
                                    .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_codigo)
                                        .addComponent(lbl_nome))
                                    .addGap(33, 33, 33))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelClientesLayout.createSequentialGroup()
                                    .addComponent(lbl_endereco)
                                    .addGap(18, 18, 18)))
                            .addGroup(painelClientesLayout.createSequentialGroup()
                                .addComponent(lbl_bairro)
                                .addGap(41, 41, 41)))
                        .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_bairro, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_nome, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_endereco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_numero)
                            .addComponent(lbl_telefone)
                            .addComponent(lbl_data))
                        .addGap(31, 31, 31)
                        .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_telefone)
                            .addComponent(txt_numero)
                            .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(lbl_imgCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(painelClientesLayout.createSequentialGroup()
                        .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(painelClientesLayout.createSequentialGroup()
                                .addComponent(btn_pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btn_fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jpClientes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelClientesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_pesquisa)
                .addGap(43, 43, 43)
                .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
        );
        painelClientesLayout.setVerticalGroup(
            painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClientesLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelClientesLayout.createSequentialGroup()
                        .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_codigo)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nome)
                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_telefone)
                            .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_endereco)
                            .addComponent(txt_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_numero)
                            .addComponent(txt_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_bairro)
                            .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_data)
                            .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_imgCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jpClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelClientesLayout.createSequentialGroup()
                        .addGroup(painelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_pesquisa))
                        .addGap(37, 37, 37)
                        .addComponent(btn_pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelPrincipal.addTab("Clientes", painelClientes);

        tabelaPorNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaPorNome.setForeground(new java.awt.Color(255, 255, 255));
        tabelaPorNome.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Preço", "Quantidade", "Categoria"
            }
        ));
        tabelaPorNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaPorNomeMousePressed(evt);
            }
        });
        jp_PorNome.setViewportView(tabelaPorNome);

        lbl_telefone1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_telefone1.setText("Quantidade");

        txt_pesquisaPorNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesquisaPorNomeKeyReleased(evt);
            }
        });

        lbl_pesquisa1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_pesquisa1.setText("Pesquisar");

        lbl_telefone2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_telefone2.setText("Total");

        txt_preco.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tabelaProdutosCompra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaProdutosCompra.setForeground(new java.awt.Color(255, 255, 255));
        tabelaProdutosCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Quantidade", "Valor Unitario", "Valor"
            }
        ));
        tabelaProdutosCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaProdutosCompraMousePressed(evt);
            }
        });
        jp_produtosCompra.setViewportView(tabelaProdutosCompra);

        btn_adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/inserir-32.png"))); // NOI18N
        btn_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarActionPerformed(evt);
            }
        });

        btn_remover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/ico_sair.png"))); // NOI18N
        btn_remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removerActionPerformed(evt);
            }
        });

        btn_orcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/pdf.png"))); // NOI18N
        btn_orcamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Orçamento"));
        btn_orcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_orcamentoActionPerformed(evt);
            }
        });

        txt_total.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N

        btn_finalizarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/pdf.png"))); // NOI18N
        btn_finalizarPedido.setBorder(javax.swing.BorderFactory.createTitledBorder("Finalizar Pedido"));
        btn_finalizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finalizarPedidoActionPerformed(evt);
            }
        });

        lbl_telefone3.setForeground(new java.awt.Color(255, 255, 255));
        lbl_telefone3.setText("Código");

        lbl_telefone4.setForeground(new java.awt.Color(255, 255, 255));
        lbl_telefone4.setText("Cliente");

        txt_nomeCliente.setEditable(false);
        txt_nomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomeClienteActionPerformed(evt);
            }
        });

        txt_funcionario.setEditable(false);

        lbl_codigo2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_codigo2.setText("Funcionario");

        lbl_telefone5.setForeground(new java.awt.Color(255, 255, 255));
        lbl_telefone5.setText("Nome");

        lbl_telefone6.setForeground(new java.awt.Color(255, 255, 255));
        lbl_telefone6.setText("Preço");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/carrinhowa.png"))); // NOI18N

        javax.swing.GroupLayout painelPedidosLayout = new javax.swing.GroupLayout(painelPedidos);
        painelPedidos.setLayout(painelPedidosLayout);
        painelPedidosLayout.setHorizontalGroup(
            painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPedidosLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPedidosLayout.createSequentialGroup()
                        .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelPedidosLayout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addComponent(btn_adicionar)
                                .addGap(29, 29, 29)
                                .addComponent(btn_remover))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPedidosLayout.createSequentialGroup()
                                .addComponent(lbl_telefone3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_codigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_telefone5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_telefone1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_telefone6)
                                .addGap(10, 10, 10)
                                .addComponent(txt_preco, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPedidosLayout.createSequentialGroup()
                        .addComponent(lbl_codigo2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(lbl_telefone4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painelPedidosLayout.createSequentialGroup()
                        .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelPedidosLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jp_PorNome, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPedidosLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lbl_pesquisa1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_pesquisaPorNome, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(167, 167, 167)))
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
            .addGroup(painelPedidosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jp_produtosCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_orcamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_finalizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPedidosLayout.createSequentialGroup()
                        .addComponent(lbl_telefone2)
                        .addGap(28, 28, 28)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelPedidosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_adicionar, btn_remover});

        painelPedidosLayout.setVerticalGroup(
            painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPedidosLayout.createSequentialGroup()
                .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_codigo2)
                    .addComponent(txt_funcionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_telefone4)
                    .addComponent(txt_nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelPedidosLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_pesquisa1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_pesquisaPorNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jp_PorNome, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_codigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_telefone1)
                            .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_telefone3)
                            .addComponent(txt_preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_telefone6)
                            .addComponent(lbl_telefone5))
                        .addGap(19, 19, 19)
                        .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_adicionar)
                            .addComponent(btn_remover))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(painelPedidosLayout.createSequentialGroup()
                                .addComponent(btn_orcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(painelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_telefone2))
                                .addGap(18, 18, 18)
                                .addComponent(btn_finalizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jp_produtosCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13))
        );

        painelPedidosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_adicionar, btn_remover});

        painelPrincipal.addTab("Pedidos", painelPedidos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMousePressed
        clienteB = clienteC.preencherCampos(Integer.parseInt(modelo.getValueAt(tabelaClientes.getSelectedRow(), 0).toString()));
        txt_codigo.setText(clienteB.getId() + "");
        txt_nome.setText(clienteB.getNome());
        txt_endereco.setText(clienteB.getEndereco());
        txt_numero.setText(clienteB.getNumero());
        txt_bairro.setText(clienteB.getBairro());
        txt_telefone.setText(clienteB.getTelefone());
        txt_data.setText(clienteB.getData());
        btn_pedidos.setEnabled(true);
    }//GEN-LAST:event_tabelaClientesMousePressed

    private void txt_pesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisaKeyReleased
        modelo.setNumRows(0);
        clienteC.listar(txt_pesquisa.getText(), modelo);
    }//GEN-LAST:event_txt_pesquisaKeyReleased

    private void btn_pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pedidosActionPerformed
        painelPrincipal.setEnabledAt(1, true);
        painelPrincipal.setEnabledAt(0, false);
        painelPrincipal.setSelectedIndex(1);
        txt_nomeCliente.setText(txt_nome.getText());
    }//GEN-LAST:event_btn_pedidosActionPerformed

    private void btn_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fecharActionPerformed
       dispose();
    }//GEN-LAST:event_btn_fecharActionPerformed

    private void tabelaPorNomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPorNomeMousePressed
        produtoB = produtoC.preencherCampos(Integer.parseInt(modeloPorNome.getValueAt(tabelaPorNome.getSelectedRow(), 0).toString()));
        txt_codigo2.setText(produtoB.getId() + "");
        txt_preco.setText(produtoB.getValor() + "");
        txt_nomeProduto.setText(produtoB.getNome());
        btn_adicionar.setEnabled(true);
        
    }//GEN-LAST:event_tabelaPorNomeMousePressed

    private void txt_pesquisaPorNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisaPorNomeKeyReleased
        modeloPorNome.setNumRows(0);
        produtoC.listarNaTelaPedidos(txt_pesquisaPorNome.getText(), modeloPorNome);
    }//GEN-LAST:event_txt_pesquisaPorNomeKeyReleased

    private void tabelaProdutosCompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutosCompraMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaProdutosCompraMousePressed

    private void btn_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarActionPerformed
        double n1 = Double.parseDouble(txt_preco.getText());
        int n2 = Integer.parseInt(txt_quantidade.getText());
        double total = n1 * n2 ;
        
        if(txt_preco.getText().equals("") || txt_quantidade.getText().equals("") || txt_codigo2.getText().equals("") ){
            JOptionPane.showMessageDialog(null, "Selecione um item na tabela");
        } else {
            modeloCompra.addRow(new Object[]{txt_codigo2.getText(), txt_nomeProduto.getText(), txt_quantidade.getText(), txt_preco.getText(), total});
        }
        CalcularTotal();
        btn_remover.setEnabled(true);
    }//GEN-LAST:event_btn_adicionarActionPerformed

    private void btn_finalizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finalizarPedidoActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Cadastrar pedido ?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
              pedidoC.salvarPedido(txt_nomeCliente.getText(), Integer.parseInt(txt_funcionario.getText()), Double.parseDouble(txt_total.getText())  );
        } 
        GerarOrcamento();
    }//GEN-LAST:event_btn_finalizarPedidoActionPerformed

    private void txt_nomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomeClienteActionPerformed

    private void btn_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removerActionPerformed
        modeloCompra.removeRow(tabelaProdutosCompra.getSelectedRow());
//        double totalPedido = 0;
    }//GEN-LAST:event_btn_removerActionPerformed

    private void btn_orcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_orcamentoActionPerformed
        GerarOrcamento();
    }//GEN-LAST:event_btn_orcamentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_adicionar;
    private javax.swing.JButton btn_fechar;
    private javax.swing.JButton btn_finalizarPedido;
    private javax.swing.JButton btn_orcamento;
    private javax.swing.JButton btn_pedidos;
    private javax.swing.JButton btn_remover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jpClientes;
    private javax.swing.JScrollPane jp_PorNome;
    private javax.swing.JScrollPane jp_produtosCompra;
    private javax.swing.JLabel lbl_bairro;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_codigo2;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_endereco;
    private javax.swing.JLabel lbl_imgCliente;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_numero;
    private javax.swing.JLabel lbl_pesquisa;
    private javax.swing.JLabel lbl_pesquisa1;
    private javax.swing.JLabel lbl_telefone;
    private javax.swing.JLabel lbl_telefone1;
    private javax.swing.JLabel lbl_telefone2;
    private javax.swing.JLabel lbl_telefone3;
    private javax.swing.JLabel lbl_telefone4;
    private javax.swing.JLabel lbl_telefone5;
    private javax.swing.JLabel lbl_telefone6;
    private javax.swing.JPanel painelClientes;
    private javax.swing.JPanel painelPedidos;
    private javax.swing.JTabbedPane painelPrincipal;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JTable tabelaPorNome;
    private javax.swing.JTable tabelaProdutosCompra;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JTextField txt_codigo;
    public static javax.swing.JTextField txt_codigo2;
    private javax.swing.JTextField txt_data;
    private javax.swing.JTextField txt_endereco;
    public static javax.swing.JTextField txt_funcionario;
    private javax.swing.JTextField txt_nome;
    public static javax.swing.JTextField txt_nomeCliente;
    public static javax.swing.JTextField txt_nomeProduto;
    private javax.swing.JTextField txt_numero;
    private javax.swing.JTextField txt_pesquisa;
    private javax.swing.JTextField txt_pesquisaPorNome;
    public static javax.swing.JTextField txt_preco;
    public static javax.swing.JTextField txt_quantidade;
    private javax.swing.JTextField txt_telefone;
    public static javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
