package Controle;

import Beans.ClientesBeans;
import Beans.ProdutosBeans;
import DAO.ClientesDAO;
import DAO.ProdutosDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClienteControler {

    ClientesDAO clienteD;

    public ClienteControler() {
        clienteD = new ClientesDAO();
    }

    public boolean salvar(ClientesBeans cliente) {
        if (cliente.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "ERRO", 0);
            return false;
        }
        if (cliente.getBairro().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Bairro", "ERRO", 0);
            return false;
        }
        if (cliente.getEndereco().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo endereço", "ERRO", 0);
            return false;
        }
        if (cliente.getNumero().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Numero", "ERRO", 0);
            return false;
        }
        if (cliente.getTelefone().equals("(  )      -    ")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "ERRO", 0);
            return false;
        }
        
        
        clienteD.salvar(cliente);
        return true;
    }

    public boolean editar(ClientesBeans cliente) {
        if (cliente.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "ERRO", 0);
            return false;
        }
        if (cliente.getBairro().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Bairro", "ERRO", 0);
            return false;
        }
        if (cliente.getEndereco().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo endereço", "ERRO", 0);
            return false;
        }
        if (cliente.getNumero().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Numero", "ERRO", 0);
            return false;
        }
        if (cliente.getTelefone().equals("(  )      -    ")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "ERRO", 0);
            return false;
        }
         
        if (JOptionPane.showConfirmDialog(null, "Editar cliente ?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            clienteD.editar(cliente);
        } 
        return true;
    }

    public String proximoCodigo() {
        return clienteD.proximoCodigo();
    }

    public void listar(String Pesquisa, DefaultTableModel modelo) {
        clienteD.listar(Pesquisa, modelo);
    }
    
    public ClientesBeans preencherCampos(int codigo){
                return clienteD.preencherCampos(codigo);
        }
    
    public void excluir(ClientesBeans cliente){
        if (JOptionPane.showConfirmDialog(null, "Deletar produto ?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                clienteD.excluir(cliente);
        } 
    }
    
}
