package DAO;

import Beans.ClientesBeans;
import Beans.FuncionariosBeans;
import Beans.ProdutosBeans;
import Util.Conexao;
import Util.Corretores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FuncionariosDAO {

    public void salvar(FuncionariosBeans funcionario) {
        try {
            String SQLInsertion = "insert into funcionarios(fun_nome, fun_endereco, fun_numero, fun_bairro, fun_telefone, fun_data, fun_status, fun_usuario, fun_senha) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, funcionario.getNome());
            st.setString(2, funcionario.getBairro());
            st.setString(3, funcionario.getEndereco());
            st.setString(4, funcionario.getNumero());
            st.setString(5, funcionario.getTelefone());
            st.setString(6, Corretores.ConverterParaSQL(funcionario.getData()));
            st.setString(7, funcionario.getStatus());
            st.setString(8, funcionario.getUsuario());
            st.setString(9, funcionario.getSenha());
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "1", "ERRO", 0);
        }
    }

    public void editar(FuncionariosBeans funcionario) {
        try {
            String SQLInsertion = "update funcionarios set fun_nome = ?, fun_endereco = ?, fun_numero = ?, fun_bairro = ?, fun_telefone = ?,"
                    + " fun_status = ?, fun_usuario = ?, fun_senha = ? where fun_id = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, funcionario.getNome());
            st.setString(2, funcionario.getEndereco());
            st.setString(3, funcionario.getNumero());
            st.setString(4, funcionario.getBairro());
            st.setString(5, funcionario.getTelefone());
            st.setString(6, funcionario.getStatus());
            st.setString(7, funcionario.getUsuario());
            st.setString(8, funcionario.getSenha());
            st.setInt(9, funcionario.getId());

            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Editado com Sucesso", "Salvo", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "2", "Erro", 0);
        }
    }

    public String proximoCodigo() {									        //quando clicar no botao NOVO, o campo codigo mostra o proximo id do banco de dados
        String SQLSelection = "select * from funcionarios order by fun_id desc limit 1";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return (Integer.parseInt(rs.getString("fun_id")) + 1) + "";
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
            String SQLSelection = "select * from funcionarios where fun_nome like '%" + Pesquisa + "%'";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while(rs.next()){                                                                             //Ordem que aparece na tabela
                Modelo.addRow(new Object[]{rs.getString("fun_id"),rs.getString("fun_nome"),rs.getString("fun_status"),rs.getString("fun_telefone")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "4","ERRO", 0);
        }
      }
    
     public FuncionariosBeans preencherCampos(int Codigo){
        FuncionariosBeans funcionario = new FuncionariosBeans();
         try {
            String SQLSelection = "select * from funcionarios where fun_id = ?";  
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1, Codigo);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
               funcionario.setId(rs.getInt("fun_id"));
               funcionario.setNome(rs.getString("fun_nome")); 
               funcionario.setEndereco(rs.getString("fun_endereco"));
               funcionario.setNumero(rs.getString("fun_numero"));
               funcionario.setBairro(rs.getString("fun_bairro"));
               funcionario.setTelefone(rs.getString("fun_telefone"));
               funcionario.setData(Corretores.ConverterParaJava(rs.getString("fun_data")));
               funcionario.setStatus(rs.getString("fun_status"));
               funcionario.setUsuario(rs.getString("fun_usuario"));
               funcionario.setSenha(rs.getString("fun_senha"));
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "6", "Erro", 0 );
        } 
         return funcionario;
     }
     
     public void excluir(FuncionariosBeans cliente) {
        try {
            String SQL = "delete from funcionarios where fun_id = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQL);
            st.setInt(1, cliente.getId());
            st.execute();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!", "Sucesso", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar cliente", "ERRO", 0);
        }
    }

}
