/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.business;

import br.com.petservicos.dao.raca.RacaDao;
import br.com.petservicos.business.raca.RacaBusiness;
import br.com.petservicos.business.raca.RacaBusinessException;
import br.com.petservicos.business.raca.RacaBusinessImpl;
import br.com.petservicos.business.utilitarios.enums.EspecieEnum;
import br.com.petservicos.domain.Raca;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Lina
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContextTest.xml"})
public class RacaBusinessTeste {
    
    private RacaBusiness racaBusiness;
    private RacaDao racaDao;
    
    public RacaBusinessTeste(){
        this.racaDao = Mockito.mock (RacaDao.class);
        this.racaBusiness = new RacaBusinessImpl (this.racaDao);
    }
    
    @Test
    public void testSucessConstrutor(){
        racaBusiness = new RacaBusinessImpl();
        Assert.assertEquals(true,racaBusiness != null);
    }
    
    @Test
    public void addTestSucess() {
        
        try {
            Raca r = new Raca();
            r.setNome("yorkshire");
            r.setEspecie(EspecieEnum.C);
            racaBusiness.add(r);
        } catch (RacaBusinessException e) {
            Assert.fail("Esse teste deveria ter dado certo.");
        }
    }
       
    @Test
    public void addTestFailEntidadeNull(){
        try {
            racaBusiness.add(null);
            Assert.fail("Não era para ter dado certo.");
        } catch (RacaBusinessException e) {
            Assert.assertEquals("Entidade está nula.", e.getMessage());
        }
    }
    
    @Test
    public void addTestFailNomeVazio(){
        try{
            Raca r = new Raca();
            r.setNome("");
            racaBusiness.add(r);
            Assert.fail("O add não é para dar certo porque não informei o nome.");
        } catch (RacaBusinessException e) {
            Assert.assertEquals("O nome da raça não foi informado.", e.getMessage());
        }
              
    }
    
    @Test
    public void addTestFailNomeNull(){
        try{
            Raca r = new Raca();
            racaBusiness.add(r);
            Assert.fail("O add não é para dar certo porque o nome está nulo.");
        }catch(RacaBusinessException e){
            Assert.assertEquals("O nome da raça não foi informado.", e.getMessage());
        }
    }
    
    @Test
    public void addTestFailTipoEspecieNull(){
        try{
            Raca r = new Raca();
            r.setNome("Yorkshire");
            r.setEspecie(null);
            racaBusiness.add(r);
            Assert.fail("O add não é para dar certo porque o nome está nulo.");
        }catch(RacaBusinessException e){
            Assert.assertEquals("A espécie não foi informada.", e.getMessage());
        }
    }
    
    @Test
    public void deleteTestSucess(){
        Raca r = new Raca(1L);
        try {
            racaBusiness.delete(r);
        } catch (RacaBusinessException e) {
            Assert.fail("O deleteSucess não deveria ter caído na exception. " + e.getMessage());
        }
          
    }
    
    
    @Test
    public void deleteFailEntidadeNull() {
        try {
            racaBusiness.delete(null);
            Assert.fail("O deleteFailEntidadeNull não deveria ter dado certo. ");
        } catch (RacaBusinessException e) {
            Assert.assertEquals("Entidade está nula.",e.getMessage());
        }
    }
    
    
    @Test
    public void deleteFailIdNull() {
        try {
            Raca r = new Raca();
            racaBusiness.delete(r);
            Assert.fail("O deleteFailEntidadeNull não deveria ter dado certo. ");
        } catch (RacaBusinessException e) {
            Assert.assertEquals("O código da raça não foi informado.",e.getMessage());
        }
    }
    
    
    @Test
    public void updateSucess(){
        try{
            Raca r = new Raca();
            r.setId(1L);
            r.setNome("Yorkshire");
            r.setEspecie(EspecieEnum.C);
            racaBusiness.update(r);
                      
        }catch (RacaBusinessException e){
            Assert.fail("O updateSucess não deveria ter caído na exception. " + e.getMessage());
        }
        
    }
        
    @Test
    public void updateFailEntidadeNull(){
       try {
            racaBusiness.delete(null);
            Assert.fail("O deleteFailEntidadeNull não deveria ter dado certo. ");
        } catch (RacaBusinessException e) {
            Assert.assertEquals("Entidade está nula.",e.getMessage());
        }
    }
    
    
    @Test
    public void updateFailIdNull(){
        try{
            Raca r = new Raca();
            racaBusiness.update(r);
            Assert.fail("O update não deveria ter dado certo. ");
        
        }catch (RacaBusinessException e){
            Assert.assertEquals("O código da raça não foi informado.", e.getMessage());
        }
    }
    
    
    @Test
    public void updateFailNomeNull() {
        try {
            Raca r = new Raca();
            r.setId(1L);
            r.setNome(null);
            racaBusiness.update(r);
            Assert.fail("O update não é para dar certo porque não informei o nome. ");
        } catch (RacaBusinessException ex) {
            Assert.assertEquals("O nome da raça não foi informado.", ex.getMessage());
        }
    }
    
    @Test
    public void updateFailNomeVazio() {
        try {
            Raca r = new Raca();
            r.setId(1L);
            r.setNome("");
            racaBusiness.update(r);
            Assert.fail("O update não é para dar certo porque não informei o nome. ");
        } catch (RacaBusinessException ex) {
            Assert.assertEquals("O nome da raça não foi informado.", ex.getMessage());
        }
    }
    
    
    @Test
    public void updateTestFailTipoServicoNull(){
        try{
            Raca r = new Raca();
            r.setId(1L);
            r.setNome("Yorkshire");
            r.setEspecie(null);
            
            racaBusiness.update(r);
            Assert.fail("O update não é para dar certo porque o nome está nulo.");
        }catch(RacaBusinessException ex){
            Assert.assertEquals("A espécie não foi informada.", ex.getMessage());
        }
    }
}
