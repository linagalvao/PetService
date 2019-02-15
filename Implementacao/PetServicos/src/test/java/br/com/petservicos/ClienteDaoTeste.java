/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos;

import br.com.petservicos.dao.cliente.ClienteDao;
import br.com.petservicos.domain.Cliente;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lina
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContextTest.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ClienteDaoTeste {
    
    @Autowired
    public ClienteDao clienteDao;
    
    @Test
    public void insertAssertTrue(){

    }
    
    @Test
    public void updateAssertTrue(){
        Cliente c = new Cliente();
        c.setId(1L);
        c.setNome("Lina");
        c.setEmail("lina.galvao85@gmail.com");
        c.setTelefone1("85981315737");
        c.setTelefone2("85996155508");
        Assert.assertEquals(1, clienteDao.update(c));
    }
       
    @Test
    public void consultaSimplesAssertTrue(){
        Assert.assertEquals(1, clienteDao.list(new Cliente()).size());
    }
    
    @Test
    public void consultaComIdAssertTrue(){
        List<Cliente> list = clienteDao.list(new Cliente(1L));
        Assert.assertEquals(1, list.size());
        Assert.assertEquals("Lina", list.get(0).getNome());
    }

    @Test
    public void consultaComNomeAssertTrue(){
        Cliente c = new Cliente();
        c.setNome("Lina");
        List<Cliente> list = clienteDao.list(c);
        Assert.assertEquals(1,list.size());
        Assert.assertEquals("Lina",list.get(0).getNome());
    }
    
    @Test
    public void consultaComEmailAssertTrue(){
        Cliente c = new Cliente();
        c.setEmail("lina.galvao85@gmail.com");
        List<Cliente> list = clienteDao.list(c);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals("lina.galvao85@gmail.com", list.get(0).getEmail());
    }
    
    @Test
    public void consultaComTelefone1AssertTrue(){
        Cliente c = new Cliente();
        c.setTelefone1("85981315737");
        List<Cliente> list = clienteDao.list(c);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals("85981315737", list.get(0).getTelefone1());
    }
    
    @Test
    public void consultaComTelefone2AssertTrue(){
        Cliente c = new Cliente();
        c.setTelefone2("85996155508");
        List<Cliente> list = clienteDao.list(c);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals("85996155508", list.get(0).getTelefone2());
    }
}
