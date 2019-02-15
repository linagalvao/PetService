/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos;

import br.com.petservicos.business.utilitarios.enums.EspecieEnum;
import br.com.petservicos.business.utilitarios.enums.SexoEnum;
import br.com.petservicos.dao.animal.AnimalDao;
import br.com.petservicos.domain.Animal;
import br.com.petservicos.domain.Cliente;
import br.com.petservicos.domain.Raca;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class AnimalDaoTeste {
    @Autowired
    public AnimalDao animalDao;
    
    @Test
    public void insertAssertTrue(){

    }
    
    @Test
    public void consultaSimplesAssertTrue(){
        Assert.assertEquals(2, animalDao.list(new Animal()).size());
    }
    
    @Test
    public void consultaComIdAssertTrue(){
        List<Animal> list = animalDao.list(new Animal("00001"));
        Assert.assertEquals(1, list.size());
        Assert.assertEquals("Sansa", list.get(0).getNome());
        
    }
    
    @Test
    public void consultaComNomeAssertTrue(){
        Animal a = new Animal();
        a.setNome("Sansa");
        List<Animal> list = animalDao.list(a);
        Assert.assertEquals(1,list.size());
        Assert.assertEquals("Sansa",list.get(0).getNome());
               
    }
    
    @Test
    public void consultaComSexoAssertTrue(){
        Animal a = new Animal();
        a.setSexo(SexoEnum.F);
        List<Animal> list = animalDao.list(a);
        Assert.assertEquals(1,list.size());
        Assert.assertEquals(SexoEnum.F,list.get(0).getSexo());
               
    }
    
    @Test
    public void consultaComDataNascAssertTrue(){
        Animal a = new Animal();
        Date data = new GregorianCalendar(2013, Calendar.JULY, 1).getTime();
        a.setDataNasc(data);
        List<Animal> list = animalDao.list(a);
        Assert.assertEquals(1,list.size());
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.JULY, 1).getTime(),list.get(0).getDataNasc());
               
    }
    
    @Test
    public void consultaComRacaAssertTrue(){
        Animal a = new Animal();
        Raca raca = new Raca();
        
        raca.setId(1L);
        a.setRaca(raca);
        
        List<Animal>list = animalDao.list(a);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(raca, list.get(0).getRaca());
    }
 
    @Test
    public void consultaComClienteAssertTrue(){
        Animal a = new Animal();
        Cliente cliente = new Cliente();
        
        cliente.setId(1L);
        a.setCliente(cliente);
        
        List<Animal>list = animalDao.list(a);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(cliente, list.get(0).getCliente());
    }
    
    @Test
    public void updateAssertTrue(){
        Animal a = new Animal();
        Raca raca = new Raca();
        Cliente cliente = new Cliente();
        Date data = new GregorianCalendar(2013, Calendar.JULY, 1).getTime();
        
        raca.setId(1L);
        cliente.setId(1L);
        
        a.setId("00001");
        a.setNome("Sansa");
        a.setSexo(SexoEnum.F);
        a.setDataNasc(data);
        a.setRaca(raca);
        a.setCliente(cliente);
        
        Assert.assertEquals(1, animalDao.update(a));
    }
    
    @Test
    public void deleteComIdAssertTrue(){
        Animal a = new Animal();
        int i = animalDao.delete(a);
        Assert.assertEquals(0,i);
        
    }
    
    
}
