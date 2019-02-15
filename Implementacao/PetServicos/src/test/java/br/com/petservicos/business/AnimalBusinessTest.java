/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.business;

import br.com.petservicos.dao.animal.AnimalDao;
import br.com.petservicos.business.animal.AnimalBusiness;
import br.com.petservicos.business.animal.AnimalBusinessException;
import br.com.petservicos.business.animal.AnimalBusinessImpl;
import br.com.petservicos.business.utilitarios.enums.EspecieEnum;
import br.com.petservicos.business.utilitarios.enums.SexoEnum;
import br.com.petservicos.domain.Animal;
import br.com.petservicos.domain.Cliente;
import br.com.petservicos.domain.Raca;
import java.util.Date;
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
public class AnimalBusinessTest {

    private AnimalBusiness animalBusiness;
    private AnimalDao animalDao;

    public AnimalBusinessTest(){
        this.animalDao = Mockito.mock(AnimalDao.class);
        this.animalBusiness = new AnimalBusinessImpl(this.animalDao); 
    }
    
    private Animal generateObj(){
           Animal a = new Animal();
           Date dataNasc = new Date();
           Raca raca = new Raca();
           Cliente cliente = new Cliente();
           
           raca.setEspecie(EspecieEnum.C);
           raca.setId(1L);
           raca.setNome("Yorkshire");
           a.setRaca(raca);
           
           cliente.setId(1L);
           cliente.setNome("Lina");
           cliente.setEmail("lina.galvao85@gmail.com");
           cliente.setTelefone1("85981315737");
           cliente.setTelefone2("85996155508");
           a.setCliente(cliente);
           
           a.setId("00001");
           a.setNome("Sui");
           a.setSexo(SexoEnum.M);
           a.setDataNasc(dataNasc);
          
           return a;
    }
    
    @Test
    public void testSucessConstrutor(){
        animalBusiness = new AnimalBusinessImpl();
        Assert.assertEquals(true,animalBusiness != null);
    }
    
    @Test
    public void addTestSucess(){
        try{
            Animal a = generateObj();
            animalBusiness.add(a);
        }catch (AnimalBusinessException e) {
            Assert.fail("Esse teste deveria ter dado certo.");
        }
    }
        
    @Test
    public void addTestFailEntidadeNull(){
        try{
            animalBusiness.add(null);
            Assert.fail("Não era para ter dado certo.");
        } catch (AnimalBusinessException e) {
            Assert.assertEquals("Entidade está nula.", e.getMessage());
        }
    }
    
    @Test
    public void addTestFailIdVazio(){
        try{
            Animal a = generateObj();
            a.setId("");
            animalBusiness.add(a);
            Assert.fail("O add não é para dar certo porque não informei o id.");   
        }catch(AnimalBusinessException e){
            Assert.assertEquals("O código do animal não foi informado.", e.getMessage());
        }
    }
    
    @Test
    public void addTestFailIdNull(){
        try{
            Animal a = generateObj();
            a.setId(null);
            animalBusiness.add(a);
            Assert.fail("O add não é para dar certo porque o id está nulo.");
        }catch(AnimalBusinessException e){
            Assert.assertEquals("O código do animal não foi informado.", e.getMessage());
        }
    }
    
    @Test
    public void addTestFailNomeVazio(){
        try{
           Animal a = generateObj();
           a.setNome("");
           animalBusiness.add(a);
           Assert.fail("O add não é para dar certo porque não informei o nome.");
           
        }catch(AnimalBusinessException e){
            Assert.assertEquals("O nome do animal não foi informado.", e.getMessage());            
        }
    }
    
    @Test
    public void addTestFailNomeNull(){
        try{
            Animal a = generateObj();
            a.setNome(null);
            animalBusiness.add(a);
            Assert.fail("O add não é para dar certo porque o nome está nulo.");
        
        }catch(AnimalBusinessException e){
            Assert.assertEquals("O nome do animal não foi informado.", e.getMessage());
        }
    }
    
    @Test
    public void addTestFailSexoNull(){
        try{
            Animal a = generateObj();
            a.setSexo(null);
            animalBusiness.add(a);
            Assert.fail("O add não é para dar certo porque o sexo está nulo.");
        }catch(AnimalBusinessException e){
            Assert.assertEquals("O sexo do animal não foi informado.", e.getMessage());
        }
    }
    
    @Test
    public void addTestFailRacaNull(){
        try{
            Animal a = generateObj();
            a.setRaca(null);
            animalBusiness.add(a);
            Assert.fail("O add não é para dar certo porque a raça está nula.");
        }catch(AnimalBusinessException e){
            Assert.assertEquals("A raça do animal não foi informada.", e.getMessage());
        }
    } 
    
    @Test
    public void addTestFailClienteNull(){
        try{
            Animal a = generateObj();
            a.setCliente(null);
            animalBusiness.add(a);
            Assert.fail("O add não é para dar certo porque o cliente está nulo.");
        }catch(AnimalBusinessException e){
            Assert.assertEquals("O dono do animal não foi informado.", e.getMessage());
        }
    } 
    @Test
    public void deleteTestSucess(){
        try{
            Animal a = generateObj();
            animalBusiness.delete(a);
        }catch(AnimalBusinessException e){
            Assert.fail("O deleteSucess não deveria ter caído na exception. " + e.getMessage());
        }
    }
    
    @Test
    public void deleteFailEntidadeNull() {
        try {
            animalBusiness.delete(null);
            Assert.fail("O deleteFailEntidadeNull não deveria ter dado certo. ");
        } catch (AnimalBusinessException e) {
            Assert.assertEquals("Entidade está nula.",e.getMessage());
        }
    }

    @Test
    public void deleteFailIdNull() {
        try {
            Animal a = generateObj();
            a.setId(null);
            animalBusiness.delete(a);
            Assert.fail("O deleteFailEntidadeNull não deveria ter dado certo. ");
        } catch (AnimalBusinessException e) {
            Assert.assertEquals("O código do animal não foi informado.",e.getMessage());
        }
    }  
    
    @Test
    public void updateTestSucess(){
        try{
            Animal a = generateObj();
            animalBusiness.update(a);
        }catch(AnimalBusinessException e){
            Assert.fail("O updateSucess não deveria ter caído na exception. " + e.getMessage());
        }
    }

    @Test
    public void updateFailIdNull() {
        try {
            Animal a = generateObj();
            a.setId(null);
            animalBusiness.update(a);
            Assert.fail("O updateFailEntidadeNull não deveria ter dado certo. ");
        } catch (AnimalBusinessException e) {
            Assert.assertEquals("O código do animal não foi informado.",e.getMessage());
        }
    } 
    
    @Test
    public void updateFailNomeNull() {
        try {
            Animal a = generateObj();
            a.setNome(null);
            animalBusiness.update(a);
            Assert.fail("O updateFailEntidadeNull não deveria ter dado certo. ");
        } catch (AnimalBusinessException e) {
            Assert.assertEquals("O nome do animal não foi informado.",e.getMessage());
        }
    }
    
    @Test
    public void updateFailNomeVazio() {
        try {
            Animal a = generateObj();
            a.setNome("");
            animalBusiness.update(a);
            Assert.fail("O updateFailEntidadeNull não deveria ter dado certo. ");
        } catch (AnimalBusinessException e) {
            Assert.assertEquals("O nome do animal não foi informado.",e.getMessage());
        }
    }

    @Test
    public void updateFailSexoNull() {
        try {
            Animal a = generateObj();
            a.setSexo(null);
            animalBusiness.update(a);
            Assert.fail("O updateFailEntidadeNull não deveria ter dado certo. ");
        } catch (AnimalBusinessException e) {
            Assert.assertEquals("O sexo do animal não foi informado.",e.getMessage());
        }
    }
    
    @Test
    public void updateFaiRacaNull() {
        try {
            Animal a = generateObj();
            a.setRaca(null);
            animalBusiness.update(a);
            Assert.fail("O updateFailEntidadeNull não deveria ter dado certo. ");
        } catch (AnimalBusinessException e) {
            Assert.assertEquals("A raça do animal não foi informada.",e.getMessage());
        }
    }
    
    @Test
    public void updateFaiClienteNull() {
        try {
            Animal a = generateObj();
            a.setCliente(null);
            animalBusiness.update(a);
            Assert.fail("O updateFailEntidadeNull não deveria ter dado certo. ");
        } catch (AnimalBusinessException e) {
            Assert.assertEquals("O dono do animal não foi informado.",e.getMessage());
        }
    }
    
}
