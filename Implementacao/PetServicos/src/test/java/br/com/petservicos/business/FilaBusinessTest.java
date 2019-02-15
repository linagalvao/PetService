/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.business;

import br.com.petservicos.business.fila.FilaBusiness;
import br.com.petservicos.business.fila.FilaBusinessException;
import br.com.petservicos.business.fila.FilaBusinessImpl;
import br.com.petservicos.business.utilitarios.enums.EspecieEnum;
import br.com.petservicos.business.utilitarios.enums.SexoEnum;
import br.com.petservicos.business.utilitarios.enums.StatusEnum;
import br.com.petservicos.business.utilitarios.enums.TipoServicoEnum;
import br.com.petservicos.dao.fila.FilaDao;
import br.com.petservicos.domain.Animal;
import br.com.petservicos.domain.Cliente;
import br.com.petservicos.domain.Fila;
import br.com.petservicos.domain.Funcionario;
import br.com.petservicos.domain.Raca;
import br.com.petservicos.domain.Servico;
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
public class FilaBusinessTest {
    
    private final FilaBusiness filaBusiness;
    private final FilaDao filaDao;
    
    public FilaBusinessTest(){
        this.filaDao = Mockito.mock(FilaDao.class);
        this.filaBusiness = new FilaBusinessImpl(this.filaDao);
    }
    
    public Fila generateObj(){
        Fila fila = new Fila();
        Animal a = new Animal();
        Servico s = new Servico();
        fila.setId(1L);
        
        a.setId("00002");
        fila.setAnimal(a);
        
        s.setId(2L);
        fila.setServico(s);
        
        fila.setStatus(StatusEnum.A);
        fila.setNumeroColeira(1);
        fila.setOrdem(1);
                        
        return fila;
        
    }
        
    @Test
    public void addSucesso() {
        try {
           Fila f = generateObj();
           filaBusiness.add(f);
           
        } catch (FilaBusinessException ex) {
            Assert.fail("Esse teste deveria ter dado certo.");
        }
    }
    
    @Test
    public void addTestFailEntidadeNull(){
        try{
            filaBusiness.add(null);
            Assert.fail("Não era para ter dado certo.");
        }catch(FilaBusinessException e){
            Assert.assertEquals("Entidade está nula.", e.getMessage());
        }
    }
    
    @Test
    public void addTestFailIdFilaNull(){
        try{
            Fila fila = generateObj();
            fila.setId(null);
            filaBusiness.add(fila);
            Assert.fail("Não era para ter dado certo");
        }catch(FilaBusinessException e){
            Assert.assertEquals("O código da fila não foi informado.", e.getMessage());
        }
    }
    
    @Test
    public void addTestFailEntidadeAnimalNull(){
        try{
            Fila fila = generateObj();
            fila.setAnimal(null);
            filaBusiness.add(fila);
        }catch(FilaBusinessException e){
            Assert.assertEquals("O animal não foi informado.", e.getMessage());
        }
    }
    
   @Test
    public void addTestFailIdAnimalNull(){
        try{
            Fila fila = generateObj();
            fila.getAnimal().setId(null);
            filaBusiness.add(fila);
            Assert.fail("Esse teste era para dar uma exceção.");
        }catch(FilaBusinessException e){
            Assert.assertEquals("O animal não foi informado.", e.getMessage());
        }
    }
    
    @Test
    public void addTestFailIdAnimalVazio(){
        try{
            Fila fila = generateObj();
            fila.getAnimal().setId(" ");
            filaBusiness.add(fila);
        }catch(FilaBusinessException e){
            Assert.assertEquals("O animal não foi informado.", e.getMessage());
        }
    } 
    
    @Test
    public void addTestFailEntidadeServicoNull(){
        try{
            Fila fila = generateObj();
            fila.setServico(null);
            filaBusiness.add(fila);
        }catch(FilaBusinessException e){
            Assert.assertEquals("O serviço não foi informado.", e.getMessage());
        }
    }
    
    @Test
    public void addTestFailServicoNull(){
        try{
            Fila fila = generateObj();
            fila.getServico().setId(null);
            filaBusiness.add(fila);
        }catch(FilaBusinessException e){
            Assert.assertEquals("O serviço não foi informado.", e.getMessage());
        }
    }
    
    @Test
    public void addTestFailStatusNull(){
        try{
           Fila fila = generateObj();
           fila.setStatus(null);
           filaBusiness.add(fila);
        }catch(FilaBusinessException e){
           Assert.assertEquals("O status do serviço não foi informado.", e.getMessage());
        }
    }
    
    @Test
    public void addTestFailNumeroColeiraZero(){
        try{
            Fila fila = generateObj();
            fila.setNumeroColeira(0);
            filaBusiness.add(fila);
        }catch(FilaBusinessException e){
            Assert.assertEquals("O número da coleira não foi informado.", e.getMessage());
        }
    }
    
    @Test
    public void addTestFailOrdemVazio(){
        try{
           Fila fila = generateObj();
           fila.setOrdem(0);
           filaBusiness.add(fila);
        }catch(FilaBusinessException e){
            Assert.assertEquals("A ordem não foi informada.", e.getMessage());
        }
    }
    
    @Test
    public void deleteTestSucess(){
        try{
            Fila fila = generateObj();
            filaBusiness.delete(fila);
        }catch(FilaBusinessException e){
            Assert.fail("O deleteSucess não deveria ter caído na exception." + e.getMessage());
        }
    }
    
    @Test
    public void deleteFailEntidadeNull(){
        try{
            filaBusiness.delete(null);
        }catch(FilaBusinessException e){
            Assert.assertEquals("Entidade está nula.", e.getMessage());
        }
    }
    
    @Test
    public void deleteFailIdNull(){
        try{
            Fila fila = generateObj();
            fila.setId(null);
            filaBusiness.delete(fila);
        }catch(FilaBusinessException e){
            Assert.assertEquals("O código da fila não foi informado.", e.getMessage());
        }
    }
    
    @Test
    public void updateSucess(){
        try{
            Fila fila = generateObj();
            filaBusiness.update(fila);
        }catch(FilaBusinessException e){
            Assert.fail("O updateSucess não deveria ter caído na exception. " + e.getMessage());
        }
    }
    
    @Test
    public void updateTestFailEntidadeNull(){
        try{
            filaBusiness.update(null);
        }catch(FilaBusinessException e){
            Assert.assertEquals("Entidade está nula.", e.getMessage());
        }
    }
    
    @Test
    public void updateTestFailIdNull(){
        try{
            Fila fila = generateObj();
            fila.setId(null);
            filaBusiness.update(fila);
        }catch(FilaBusinessException e){
            Assert.assertEquals("O código da fila não foi informado.", e.getMessage());
        }
    }
    
    @Test
    public void updateTestFailEntidadeAnimalNull(){
        try{
            Fila fila = generateObj();
            fila.setAnimal(null);
            filaBusiness.update(fila);
        }catch(FilaBusinessException e){
            Assert.assertEquals("O animal não foi informado.", e.getMessage());
        }
    }
//  
//    @Test
//    public void updateTestFail
}
