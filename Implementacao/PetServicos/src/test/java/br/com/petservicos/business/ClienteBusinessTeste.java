/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.business;

import br.com.petservicos.business.cliente.ClienteBusiness;
import br.com.petservicos.business.cliente.ClienteBusinessException;
import br.com.petservicos.business.cliente.ClienteBusinessImpl;
import br.com.petservicos.dao.cliente.ClienteDao;
import br.com.petservicos.domain.Cliente;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Lina
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContextTest.xml"})
public class ClienteBusinessTeste {
   
    private final ClienteBusiness clienteBusiness;
    private final ClienteDao clienteDao;
    
    public ClienteBusinessTeste(){
        this.clienteDao = Mockito.mock(ClienteDao.class);
        this.clienteBusiness = new ClienteBusinessImpl(this.clienteDao);
    }
    
    private Cliente generateObj(){
        Cliente c = new Cliente();
        c.setNome("Lina");
        c.setEmail("lina.galvao85@gmail.com");
        c.setTelefone1("85981315737");
        c.setTelefone2("8596155508");
        
        return c;
    }
    
    @Test
    public void addTestSucess(){
        try{
            Cliente c = generateObj();
            clienteBusiness.add(c);
        }catch(ClienteBusinessException e){
            Assert.fail("Esse teste não deveria cair aqui!");
        }
    }
    
    @Test
    public void addTestFailEntidadeNull(){
        try{
            clienteBusiness.add(null);
            Assert.fail("Não era para ter dado certo.");
        } catch (ClienteBusinessException e) {
            Assert.assertEquals("Entidade está nula.", e.getMessage());
        }
    }
    
    @Test
    public void addTestFailNomeNull(){
        try{
            Cliente c = generateObj();
            c.setNome(null);
            clienteBusiness.add(c);
            Assert.fail("O add não é para dar certo porque não informei o nome do cliente.");   
        }catch(ClienteBusinessException e){
            Assert.assertEquals("O nome do cliente não foi informado.", e.getMessage());
        }
    }
    
    @Test
    public void addTestFailNomeVazio(){
        try{
            Cliente c = generateObj();
            c.setNome("");
            clienteBusiness.add(c);
            Assert.fail("O add não é para dar certo porque não informei o nome do cliente.");
        }catch(ClienteBusinessException e){
            Assert.assertEquals("O nome do cliente não foi informado.", e.getMessage());
        }
    }
    
    @Test
    public void deleteTestSucess(){
        try{
            Cliente c = generateObj();
            c.setId(1L);
            clienteBusiness.delete(c);
        }catch(ClienteBusinessException e){
            Assert.fail("O deleteSucess não deveria ter caído na exception." + e.getMessage());
        }
    }
    
    @Test
    public void deleteTestFailEntidadeNull(){
        try{
            clienteBusiness.delete(null);
        }catch(ClienteBusinessException e){
            Assert.assertEquals("Entidade está nula.", e.getMessage());
        }
    }
    
    @Test
    public void deleteTestFailIdNull(){
        try{
            Cliente c = generateObj();
            c.setId(null);
            clienteBusiness.delete(c);
            Assert.fail("O deleteFailEntidadeNull não deveria ter dado certo.");
        }catch(ClienteBusinessException e){
            Assert.assertEquals("O código do cliente não foi informado.", e.getMessage());
        }
    }
    
    @Test
    public void updateTestSucess(){
        try{
            Cliente c = generateObj();
            c.setId(1L);
            clienteBusiness.update(c);
        }catch(ClienteBusinessException e){
            Assert.fail("O updateSucess não deveria ter caído na exception. " + e.getMessage());
        }
    }
    
    @Test
    public void updateTestFailEntidadeNull(){
        try{
            clienteBusiness.update(null);
        }catch(ClienteBusinessException e){
            Assert.assertEquals("Entidade está nula.", e.getMessage());
        }
    }
    
    @Test
    public void updateTestFailIdNull(){
        try{
            Cliente c = generateObj();
            c.setId(null);
            clienteBusiness.update(c);
            Assert.fail("Não deveria ter caído aqui!");
        }catch(ClienteBusinessException e){
            Assert.assertEquals("O código do cliente não foi informado.", e.getMessage());
        }
    }
    
    @Test
    public void updateTestFailNomeNull(){
        try{
            Cliente c = generateObj();
            c.setId(1L);
            c.setNome(null);
            clienteBusiness.update(c);
            Assert.fail("Não deveria ter caído aqui!");
        }catch(ClienteBusinessException e){
            Assert.assertEquals("O nome do cliente não foi informado.", e.getMessage());
        }
    }
}
