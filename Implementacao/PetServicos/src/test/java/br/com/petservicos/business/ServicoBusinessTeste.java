/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.business;

import br.com.petservicos.business.servico.ServicoBusiness;
import br.com.petservicos.business.servico.ServicoBusinessException;
import br.com.petservicos.business.servico.ServicoBusinessImpl;
import br.com.petservicos.business.utilitarios.enums.TipoServicoEnum;
import br.com.petservicos.dao.servico.ServicoDao;
import br.com.petservicos.domain.Servico;
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
public class ServicoBusinessTeste {
    
    private ServicoBusiness servicoBusiness;
    private ServicoDao servicoDao;
    
    public ServicoBusinessTeste(){
        this.servicoDao = Mockito.mock(ServicoDao.class);
        this.servicoBusiness = new ServicoBusinessImpl(this.servicoDao);       
    }
    
    @Test
    public void testSucessConstrutor() {
        servicoBusiness = new ServicoBusinessImpl();
        Assert.assertEquals(servicoBusiness != null, true);
    }
    
    @Test
    public void addTestSucessDescricaoNula(){
        try {
            Servico s = new Servico();
            s.setNome("banho master");
            s.setTipoServico(TipoServicoEnum.T);
            servicoBusiness.add(s);
            
        } catch (ServicoBusinessException ex) {
            Assert.fail("Esse teste deveria ter dado certo.");
        }
        
    }
    
    @Test
    public void addTestSucessDescricaoVazia(){
        try {
            Servico s = new Servico();
            s.setNome("banho master");
            s.setTipoServico(TipoServicoEnum.T);
            s.setDescricao("");
            servicoBusiness.add(s);
            
        } catch (ServicoBusinessException ex) {
            Assert.fail("Esse teste deveria ter dado certo.");
        }
        
    }

    
    @Test
    public void addTestFailEntidadeNull(){
        try {
            servicoBusiness.add(null);
            Assert.fail("Não era para ter dado certo.");
        } catch (ServicoBusinessException ex) {
            Assert.assertEquals("Entidade está nula.", ex.getMessage());
        }
    }
    
    @Test
    public void addTestFailNomeVazio(){
        try{
            Servico s = new Servico();
            s.setNome("");
            servicoBusiness.add(s);
            Assert.fail("O add não é para dar certo porque não informei o nome.");
        } catch (ServicoBusinessException ex) {
            Assert.assertEquals("O nome do serviço não foi informado.", ex.getMessage());
        }
              
    }
    
    @Test
    public void addTestFailNomeNull(){
        try{
            Servico s = new Servico();
            servicoBusiness.add(s);
            Assert.fail("O add não é para dar certo porque o nome está nulo.");
        }catch(ServicoBusinessException ex){
            Assert.assertEquals("O nome do serviço não foi informado.", ex.getMessage());
        }
    }
    
    
    @Test
    public void addTestFailTipoServicoNull(){
        try{
            Servico s = new Servico();
            s.setNome("banho");
            servicoBusiness.add(s);
            Assert.fail("O add não é para dar certo porque o nome está nulo.");
        }catch(ServicoBusinessException ex){
            Assert.assertEquals("O tipo do serviço não foi informado.", ex.getMessage());
        }
    }
    
    
    @Test
    public void deleteTestSucess(){
        Servico s = new Servico(1L);
        try {
            servicoBusiness.delete(s);
        } catch (ServicoBusinessException ex) {
            Assert.fail("O deleteSucess não deveria ter caído na exception. " + ex.getMessage());
        }
          
    }
    
    @Test
    public void deleteFailEntidadeNull() {
        try {
            servicoBusiness.delete(null);
            Assert.fail("O deleteFailEntidadeNull não deveria ter dado certo. ");
        } catch (ServicoBusinessException e) {
            Assert.assertEquals("Entidade está nula.",e.getMessage());
        }
    }
    
    @Test
    public void deleteFailIdNull() {
        try {
            Servico s = new Servico();
            servicoBusiness.delete(s);
            Assert.fail("O deleteFailEntidadeNull não deveria ter dado certo. ");
        } catch (ServicoBusinessException e) {
            Assert.assertEquals("O código do serviço não foi informado.",e.getMessage());
        }
    }
    
    
    @Test
    public void updateSucess(){
        try{
            Servico s = new Servico ();
            s.setId(1L);
            s.setNome("banho master");
            s.setTipoServico(TipoServicoEnum.T);
            servicoBusiness.update(s);
                      
        }catch (ServicoBusinessException e){
            Assert.fail("O updateSucess não deveria ter caído na exception. " + e.getMessage());
        }
        
    }
    
    @Test
    public void updateFailEntidadeNull(){
       try {
            servicoBusiness.delete(null);
            Assert.fail("O deleteFailEntidadeNull não deveria ter dado certo. ");
        } catch (ServicoBusinessException e) {
            Assert.assertEquals("Entidade está nula.",e.getMessage());
        }
    }
    
    @Test
    public void updateFailIdNull(){
        try{
            Servico s = new Servico();
            servicoBusiness.update(s);
            Assert.fail("O update não deveria ter dado certo. ");
        
        }catch (ServicoBusinessException e){
            Assert.assertEquals("O código do serviço não foi informado.", e.getMessage());
        }
    }
    
    @Test
    public void updateFailNomeNull() {
        try {
            Servico s = new Servico();
            s.setId(1L);
            s.setNome(null);
            servicoBusiness.update(s);
            Assert.fail("O update não é para dar certo porque não informei o nome. ");
        } catch (ServicoBusinessException ex) {
            Assert.assertEquals("O nome do serviço não foi informado.", ex.getMessage());
        }
    }
    
    @Test
    public void updateFailNomeVazio() {
        try {
            Servico s = new Servico();
            s.setId(1L);
            s.setNome("");
            servicoBusiness.update(s);
            Assert.fail("O update não é para dar certo porque não informei o nome. ");
        } catch (ServicoBusinessException ex) {
            Assert.assertEquals("O nome do serviço não foi informado.", ex.getMessage());
        }
    }
    
    @Test
    public void updateTestFailTipoServicoNull(){
        try{
            Servico s = new Servico();
            s.setId(1L);
            s.setNome("banho");
            s.setTipoServico(null);
            
            servicoBusiness.update(s);
            Assert.fail("O update não é para dar certo porque o nome está nulo.");
        }catch(ServicoBusinessException ex){
            Assert.assertEquals("O tipo do serviço não foi informado.", ex.getMessage());
        }
    }
}
