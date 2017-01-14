package Controle;

import Beans.ClientesBeans;
import Beans.ProdutosBeans;
import DAO.ClientesDAO;
import DAO.ProdutosDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProdutosControle {

    ProdutosDAO produtoD;

    public ProdutosControle() {
        produtoD = new ProdutosDAO();
    }

    public boolean salvar(ProdutosBeans produto) {
        if (produto.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "ERRO", 0);
            return false;
        }
        if (produto.getTipo().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione uma categoria", "ERRO", 0);
            return false;
        }
        if (produto.getQuantidade() == 0) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Quantidade", "ERRO", 0);
            return false;
        }
        if (produto.getValor() == 0) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Preço", "ERRO", 0);
            return false;
        }
        produtoD.salvar(produto);
        return true;
    }

    public boolean editar(ProdutosBeans produto) {
        if (produto.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "ERRO", 0);
            return false;
        }
        if (produto.getTipo().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione uma categoria", "ERRO", 0);
            return false;
        }
        if (produto.getQuantidade() == 0) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Quantidade", "ERRO", 0);
            return false;
        }
        if (produto.getValor() == 0) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Preço", "ERRO", 0);
            return false;
        }
         
        if (JOptionPane.showConfirmDialog(null, "Editar cliente ?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            produtoD.editar(produto);
        } 
        return true;
    }

    public String proximoCodigo() {
        return produtoD.proximoCodigo();
    }

    public void listar(String Pesquisa, DefaultTableModel modelo) {
        produtoD.listar(Pesquisa, modelo);
    }
    
    public void listarNaTelaPedidos(String pesquisa, DefaultTableModel Modelo) {
        produtoD.listarNaTelaPedidos(pesquisa, Modelo);
    }
    
     public void listarPorCategoria(String pesquisa, DefaultTableModel Modelo) {
        produtoD.listarPorCategoria(pesquisa, Modelo);
    }
    
    public ProdutosBeans preencherCampos(int codigo){
                return produtoD.preencherCampos(codigo);
        }
    
    public void excluir(ProdutosBeans produto){
        if (JOptionPane.showConfirmDialog(null, "Deletar produto ?", "WARNING",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                produtoD.excluir(produto);
        } 
    }
    
}
