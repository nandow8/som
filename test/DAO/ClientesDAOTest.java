/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.ClientesBeans;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Fernando
 */
public class ClientesDAOTest {
    
    public ClientesDAOTest() {
    }

    @Test
    @Ignore
    public void salvarCliente() {
        ClientesBeans cliente = new ClientesBeans();
        cliente.setNome("Fatima Berbardes");
        cliente.setBairro("Vila Fatma");
        cliente.setEndereco("Dua masatsuka ida");
        cliente.setNumero("36");
        cliente.setTelefone("985003448");
        cliente.setData("19/09/2016");
        try {
        ClientesDAO cdao = new ClientesDAO();
        cdao.salvar(cliente);
            System.out.println("bum");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void deletarCliente(){
        ClientesBeans cliente = new ClientesBeans();
        cliente.setId(1);
        try {
        ClientesDAO cdao = new ClientesDAO();
        cdao.excluir(cliente);
            System.out.println("bum");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
}
