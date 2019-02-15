/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos;

import br.com.petservicos.business.utilitarios.enums.EspecieEnum;
import br.com.petservicos.dao.raca.RacaDao;
import br.com.petservicos.domain.Raca;
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
public class RacaDaoTeste {
    @Autowired
    public RacaDao racaDao;
    
    @Test
    public void insertAssertTrue(){

    }
    
    @Test
    public void consultaSimplesAssertTrue(){
        Assert.assertEquals(2, racaDao.list(new Raca()).size());
    }
    @Test
    public void consultaComIdAssertTrue(){
        List<Raca> list = racaDao.list(new Raca(1L));
        Assert.assertEquals(1, list.size());
        Assert.assertEquals("Yorkshire", list.get(0).getNome());
    }
    @Test
    public void consultaComNomeAssertTrue(){
        Raca r = new Raca();
        r.setNome("Yorkshire");
        List<Raca> list = racaDao.list(r);
        Assert.assertEquals(1,list.size());
        Assert.assertEquals("Yorkshire",list.get(0).getNome());
               
    }
    
    @Test
    public void consultaComTipoEspecieAssertTrue(){
        Raca r = new Raca();
        r.setEspecie(EspecieEnum.C);
        List<Raca> list = racaDao.list(r);
        Assert.assertEquals(2,list.size());
        Assert.assertEquals("Poodle",list.get(0).getNome());
        Assert.assertEquals("Yorkshire",list.get(1).getNome());
               
    }
    
    @Test
    public void deleteComIdAssertTrue(){
        Raca r = new Raca(2L);
        int i = racaDao.delete(r);
        Assert.assertEquals(1,i);
        
    }
    @Test
    public void updateComIdAssertTrue(){
        Raca r = new Raca(2L);
        r.setNome("Nova raça");
        r.setEspecie(EspecieEnum.C);
        int i = racaDao.update(r);
        Assert.assertEquals(1,i);
        
    }
    
    
}
    

