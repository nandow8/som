package Controle;

import Beans.ClientesBeans;
import Beans.FuncionariosBeans;
import Beans.ProdutosBeans;
import DAO.ClientesDAO;
import DAO.FuncionariosDAO;
import DAO.ProdutosDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FuncionarioControle {

    FuncionariosDAO funcionarioD;

    public FuncionarioControle() {
        funcionarioD = new FuncionariosDAO();
    }

    public boolean salvar(FuncionariosBeans funcionario) {
        if (funcionario.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "ERRO", 0);
            return false;
        }
        if (funcionario.getBairro().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Bairro", "ERRO", 0);
            return false;
        }
        if (funcionario.getEndereco().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo endereço", "ERRO", 0);
            return false;
        }
        if (funcionario.getNumero().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Numero", "ERRO", 0);
            return false;
        }
        if (funcionario.getTelefone().equals("(  )      -    ")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "ERRO", 0);
            return false;
        }
        
        
        funcionarioD.salvar(funcionario);
        return true;
    }

    public boolean editar(FuncionariosBeans funcionario) {
        if (funcionario.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "ERRO", 0);
            return false;
        }
        if (funcionario.getBairro().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Bairro", "ERRO", 0);
            return false;
        }
        if (funcionario.getEndereco().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo endereço", "ERRO", 0);
            return false;
        }
        if (funcionario.getNumero().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Numero", "ERRO", 0);
            return false;
        }
        if (funcionario.getTelefone().equals("(  )      -    ")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "ERRO", 0);
            return false;
        }
        if (funcionario.getUsuario().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo endereço", "ERRO", 0);
            return false;
        }
        if (funcionario.getSenha().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo endereço", "ERRO", 0);
            return false;
        }
         
        if (JOptionPane.showConfirmDialog(null, "Editar dados do funcionario ?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            funcionarioD.editar(funcionario);
        } 
        return true;
    }

    public String proximoCodigo() {
        return funcionarioD.proximoCodigo();
    }

    public void listar(String Pesquisa, DefaultTableModel modelo) {
        funcionarioD.listar(Pesquisa, modelo);
    }
    
    public FuncionariosBeans preencherCampos(int codigo){
                return funcionarioD.preencherCampos(codigo);
        }
    
    public void excluir(FuncionariosBeans funcionario){
        if (JOptionPane.showConfirmDialog(null, "Deletar produto ?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                funcionarioD.excluir(funcionario);
        } 
    }
    
}
