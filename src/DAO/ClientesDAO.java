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

public class ClientesDAO {

    public void salvar(ClientesBeans cliente) {
        try {
            String SQLInsertion = "insert into clientes(cli_nome, cli_bairro, cli_endereco, cli_numero, cli_telefone, cli_data) values(?,?,?,?,?,?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getBairro());
            st.setString(3, cliente.getEndereco());
            st.setString(4, cliente.getNumero());
            st.setString(5, cliente.getTelefone());
            st.setString(6, Corretores.ConverterParaSQL(cliente.getData()));
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "1", "ERRO", 0);
        }
    }

    public void editar(ClientesBeans cliente) {
        try {
            String SQLInsertion = "update clientes set cli_nome = ?, cli_bairro = ?, cli_endereco = ?, cli_numero = ?, cli_telefone = ? where cli_id = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getBairro());
            st.setString(3, cliente.getEndereco());
            st.setString(4, cliente.getNumero());
            st.setString(5, cliente.getTelefone());
            st.setInt(6, cliente.getId());

            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Editado com Sucesso", "Salvo", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao editar Produto", "Erro", 0);
        }
    }

    public String proximoCodigo() {									        //quando clicar no botao NOVO, o campo codigo mostra o proximo id do banco de dados
        String SQLSelection = "select * from clientes order by cli_id desc limit 1";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return (Integer.parseInt(rs.getString("cli_id")) + 1) + "";
            } else {
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "3", "Erro", 0);
            return "0";
        }
    }
    
    public void listar(String Pesquisa, DefaultTableModel Modelo){                                      
        try {
            String SQLSelection = "select * from clientes where cli_nome like '%" + Pesquisa + "%'";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while(rs.next()){                                                                             //Ordem que aparece na tabela
                Modelo.addRow(new Object[]{rs.getString("cli_id"),rs.getString("cli_nome"),rs.getString("cli_bairro"),rs.getString("cli_telefone")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "4","ERRO", 0);
        }
      }
    
     public ClientesBeans preencherCampos(int Codigo){
        ClientesBeans cliente = new ClientesBeans();
         try {
            String SQLSelection = "select * from clientes where cli_id = ?";  
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1, Codigo);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
               cliente.setId(rs.getInt("cli_id"));
               cliente.setNome(rs.getString("cli_nome")); 
               cliente.setBairro(rs.getString("cli_bairro"));
               cliente.setEndereco(rs.getString("cli_endereco"));
               cliente.setNumero(rs.getString("cli_numero"));
               cliente.setTelefone(rs.getString("cli_telefone"));
               cliente.setData(Corretores.ConverterParaJava(rs.getString("cli_data")));
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "6", "Erro", 0 );
        } 
         return cliente;
     }
     
     public void excluir(ClientesBeans cliente) {
        try {
            String SQL = "delete from clientes where cli_id = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQL);
            st.setInt(1, cliente.getId());
            st.execute();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!", "Sucesso", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar cliente", "ERRO", 0);
        }
    }

}
