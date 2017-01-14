package Controle;

import Beans.VendasBeans;
import DAO.VendasDAO;
import javax.swing.table.DefaultTableModel;

public class VendasControle {

    VendasDAO vendasD;

    public VendasControle() {
        vendasD = new VendasDAO();
    }

    public void salvarPedido(String nome, int idFun, double valor) {
        vendasD.salvarPedido(nome, idFun, valor);
    }

    public void listar(String Pesquisa, DefaultTableModel modelo) {
        vendasD.listar(Pesquisa, modelo);
    }

    public VendasBeans preencherCampos(int codigo) {
        return vendasD.preencherCampos(codigo);
    }

}
