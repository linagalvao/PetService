/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.business;

import br.com.petservicos.business.funcionario.FuncionarioBusiness;
import br.com.petservicos.business.funcionario.FuncionarioBusinessException;
import br.com.petservicos.business.funcionario.FuncionarioBusinessImpl;
import br.com.petservicos.dao.funcionario.FuncionarioDao;
import br.com.petservicos.domain.Funcionario;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FuncionarioBusinessTeste {

    private FuncionarioBusiness funcionarioBusiness;
    private FuncionarioDao funcionarioDao;

    public FuncionarioBusinessTeste() {
        this.funcionarioDao = Mockito.mock(FuncionarioDao.class);
        this.funcionarioBusiness = new FuncionarioBusinessImpl(this.funcionarioDao);
    }

    @Test
    public void testSucessConstrutor() {
        funcionarioBusiness = new FuncionarioBusinessImpl();
        Assert.assertEquals(funcionarioBusiness != null, true);
    }

    @Test
    public void addSucesso() {
        try {
            Funcionario f = new Funcionario("lina");
            funcionarioBusiness.add(f);
        } catch (FuncionarioBusinessException ex) {
            Assert.fail();
        }
    }

    @Test
    public void addFailNomeVazio() {
        try {
            Funcionario f = new Funcionario();
            f.setNome("");
            funcionarioBusiness.add(f);
            Assert.fail("O add não é para dar certo porque não informei o nome.");
        } catch (FuncionarioBusinessException ex) {
            Assert.assertEquals("O nome do funcionário não foi informado.", ex.getMessage());
        }
    }

    @Test
    public void addFailNomeNull() {
        try {
            Funcionario f = new Funcionario();
            funcionarioBusiness.add(f);
            Assert.fail("O add não é para dar certo porque não informei o nome. ");
        } catch (FuncionarioBusinessException ex) {
            Assert.assertEquals("O nome do funcionário não foi informado.", ex.getMessage());
        }
    }

    @Test
    public void addFailNull() {
        try {
//            Funcionario f = new Funcionario();
            funcionarioBusiness.add(null);
            Assert.fail("O add não é para dar certo porque não informei o nome. ");
        } catch (FuncionarioBusinessException ex) {
            Assert.assertEquals("Entidade está nula.", ex.getMessage());
        }
    }

    @Test
    public void deleteSucess() {
        Funcionario f = new Funcionario(1L);
        try {
            funcionarioBusiness.delete(f);
        } catch (FuncionarioBusinessException e) {
            Assert.fail("O deleteSucess não deveria ter caído na exception. " + e.getMessage());
        }
    }
    @Test
    public void deleteFailEntidadeNull() {
        try {
            funcionarioBusiness.delete(null);
            Assert.fail("O deleteFailEntidadeNull não deveria ter dado certo. ");
        } catch (FuncionarioBusinessException e) {
            Assert.assertEquals("Entidade está nula.",e.getMessage());
        }
    }
    @Test
    public void deleteFailEntidadeIdNull() {
        try {
            Funcionario f = new Funcionario();
            funcionarioBusiness.delete(f);
            Assert.fail("O deleteFailEntidadeIdNull não deveria ter dado certo. ");
        } catch (FuncionarioBusinessException e) {
            Assert.assertEquals("O código do funcionário não foi informado.",e.getMessage());
        }
    }
    
    @Test
    public void updateSucess(){
        try{
            Funcionario f = new Funcionario(1L,"lina");
            funcionarioBusiness.update(f);
            
        }catch (FuncionarioBusinessException e){
            Assert.fail("O updateSucess não deveria ter caído na exception. " + e.getMessage());
        }
        
    }
    
    @Test
    public void updateFailEntidadeNull(){
        try{
            
            funcionarioBusiness.update(null);
          
        }catch (FuncionarioBusinessException e){
            Assert.assertEquals("Entidade está nula.",e.getMessage());
        }
    }
    
    @Test
    public void updateFailIdNull(){
        try{
            Funcionario f = new Funcionario();
            funcionarioBusiness.update(f);
            Assert.fail("O update não deveria ter dado certo. ");
        
        }catch (FuncionarioBusinessException e){
            Assert.assertEquals("O código do funcionário não foi informado.", e.getMessage());
        }
    }
    
    @Test
    public void updateFailNomeNull() {
        try {
            Funcionario f = new Funcionario(1L, null);
            funcionarioBusiness.update(f);
            Assert.fail("O update não é para dar certo porque não informei o nome. ");
        } catch (FuncionarioBusinessException ex) {
            Assert.assertEquals("O nome do funcionário não foi informado.", ex.getMessage());
        }
    }

}
