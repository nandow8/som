package DAO;

import Beans.ClientesBeans;
import Beans.ProdutosBeans;
import Util.Conexao;
import Util.Corretores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProdutosDAO {

    public void salvar(ProdutosBeans produto) {
        try {
            String SQLInsertion = "insert into produtos(pro_nome, pro_tipo, pro_quantidade, pro_valor) values(?,?,?,?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, produto.getNome());
            st.setString(2, produto.getTipo());
            st.setInt(3, produto.getQuantidade());
            st.setDouble(4, produto.getValor());
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "1", "ERRO", 0);
        }
    }

    public void editar(ProdutosBeans produto) {
        try {
            String SQLInsertion = "update produtos set pro_nome = ?, pro_tipo = ?, pro_quantidade = ?, pro_valor = ? where pro_id = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, produto.getNome());
            st.setString(2, produto.getTipo());
            st.setInt(3, produto.getQuantidade());
            st.setDouble(4, produto.getValor());
            st.setInt(5, produto.getId());

            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Editado com Sucesso", "Salvo", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao editar Produto", "Erro", 0);
        }
    }

    public String proximoCodigo() {									        //quando clicar no botao NOVO, o campo codigo mostra o proximo id do banco de dados
        String SQLSelection = "select * from produtos order by pro_id desc limit 1";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return (Integer.parseInt(rs.getString("pro_id")) + 1) + "";
            } else {
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "3", "Erro", 0);
            return "0";
        }
    }

    public void listar(String Pesquisa, DefaultTableModel Modelo) {
        try {
            String SQLSelection = "select * from produtos where pro_nome like '%" + Pesquisa + "%'";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                                                                             //Ordem que aparece na tabela
                Modelo.addRow(new Object[]{rs.getString("pro_id"), rs.getString("pro_nome"), rs.getString("pro_valor"), rs.getString("pro_quantidade"), rs.getString("pro_tipo")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "4", "ERRO", 0);
        }
    }

    public void listarNaTelaPedidos(String pesquisa, DefaultTableModel modelo) {
        try {
            String SQLSelection = "select * from produtos where pro_nome like '%" + pesquisa + "%'";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                                                                             //Ordem que aparece na tabela
                modelo.addRow(new Object[]{rs.getString("pro_id"), rs.getString("pro_nome"), rs.getString("pro_valor"), rs.getString("pro_quantidade"), rs.getString("pro_tipo")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "5", "ERRO", 0);
        }
    }
    
    public void listarPorCategoria(String pesquisa, DefaultTableModel modelo) {
        try {
            String SQLSelection = "select * from produtos where pro_tipo like '%" + pesquisa + "%'";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                                                                             //Ordem que aparece na tabela
                modelo.addRow(new Object[]{rs.getString("pro_nome"), rs.getString("pro_valor"), rs.getString("pro_quantidade"), rs.getString("pro_tipo")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "5", "ERRO", 0);
        }
    }
    
    public ProdutosBeans preencherCampos(int Codigo) {
        ProdutosBeans produto = new ProdutosBeans();
        try {
            String SQLSelection = "select * from produtos where pro_id = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1, Codigo);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                produto.setId(rs.getInt("pro_id"));
                produto.setNome(rs.getString("pro_nome"));
                produto.setTipo(rs.getString("pro_tipo"));
                produto.setQuantidade(rs.getInt("pro_quantidade"));
                produto.setValor(rs.getDouble("pro_valor"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "6", "Erro", 0);
        }
        return produto;
    }
    
    public void excluir(ProdutosBeans produto) {
        try {
            String SQL = "delete from produtos where pro_id = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQL);
            st.setInt(1, produto.getId());
            st.execute();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!", "Sucesso", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar cliente", "ERRO", 0);
        }
    }

}
