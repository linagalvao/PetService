/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos;

import br.com.petservicos.dao.funcionario.FuncionarioDao;
import br.com.petservicos.domain.Funcionario;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class FuncionarioDaoTeste {

    @Autowired
    public FuncionarioDao funcionarioDao;
    
    @Test
    public void insertAssertTrue(){
        Assert.assertEquals(1, funcionarioDao.add(new Funcionario("Teste1")));
    }
    @Test
    public void updateAssertTrue(){
        Assert.assertEquals(1, funcionarioDao.update(new Funcionario(1L,"Teste2")));
    }
    @Test
    public void consultaSimplesAssertTrue(){
        Assert.assertEquals(4, funcionarioDao.list(new Funcionario()).size());
    }
    @Test
    public void consultaComIdAssertTrue(){
        Assert.assertEquals(1, funcionarioDao.list(new Funcionario(1L)).size());
    }
    @Test
    public void consultaComNomeAssertTrue(){
        Assert.assertEquals(2, funcionarioDao.list(new Funcionario("teste")).size());
    }
}
