package DAO;

import Beans.VendasBeans;
import Util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VendasDAO {

    public void salvarPedido(String nomeCliente, int codigoFuncionario, double total) {
        Date Data = new Date();
        SimpleDateFormat FormatoData = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat FormatoHora = new SimpleDateFormat("HH:mm:ss");
        try {
            String SQLInsert = "insert into pedidos(ped_cliente_nome, ped_funcionario_id, ped_hora, ped_data, ped_valor, ped_status) values (?,?,?,?,?,?)";
            PreparedStatement st;
            st = Conexao.getConnection().prepareStatement(SQLInsert);

            st.setString(1, nomeCliente);
            st.setInt(2, codigoFuncionario);
            st.setString(3, FormatoHora.format(Data));
            st.setString(4, FormatoData.format(Data));
            st.setDouble(5, total);
            st.setString(6, "Pedido Aberto");

            st.execute();

            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Salvo com Sucesso", "Salvo", 1);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            // JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Registro", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
    }

    public void listar(String Pesquisa, DefaultTableModel Modelo) {
        try {
            String SQLSelection = "select * from pedidos where ped_cliente_nome like '%" + Pesquisa + "%'";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                                                                             //Ordem que aparece na tabela
                Modelo.addRow(new Object[]{rs.getString("ped_id"), rs.getString("ped_cliente_nome"), rs.getString("ped_funcionario_id"), rs.getString("ped_hora"), rs.getString("ped_data"), rs.getString("ped_valor"), rs.getString("ped_status")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "4", "ERRO", 0);
        }
    }

    public VendasBeans preencherCampos(int Codigo) {
        VendasBeans venda = new VendasBeans();
        try {
            String SQLSelection = "select * from pedidos where ped_id = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1, Codigo);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                venda.setId(rs.getInt("ped_id"));
                venda.setClienteNome(rs.getString("ped_cliente_nome"));
                venda.setFun_id(rs.getInt("ped_funcionario_id"));
                venda.setHora(rs.getString("ped_hora"));
                venda.setData(rs.getString("ped_data"));
                venda.setValor(rs.getDouble("ped_valor"));
                venda.setStatus(rs.getString("ped_status"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "6", "Erro", 0);
        }
        return venda;
    }

}
