/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos;

import br.com.petservicos.business.utilitarios.enums.TipoServicoEnum;
import br.com.petservicos.dao.servico.ServicoDao;
import br.com.petservicos.domain.Servico;
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
public class ServicoDaoTeste {
    @Autowired
    public ServicoDao servicoDao;
    
    @Test
    public void insertAssertTrue(){
//        Assert.assertEquals(1, servicoDao.add(new Servico("banho master",TipoServicoEnum.B)));
    }
    
    @Test
    public void consultaSimplesAssertTrue(){
        Assert.assertEquals(4, servicoDao.list(new Servico()).size());
    }
    @Test
    public void consultaComIdAssertTrue(){
        List<Servico> list = servicoDao.list(new Servico(2L));
        Assert.assertEquals(1, list.size());
        Assert.assertEquals("Banho Master", list.get(0).getNome());
    }
    @Test
    public void consultaComNomeAssertTrue(){
        Servico s = new Servico();
        s.setNome("Banho");
        List<Servico> list = servicoDao.list(s);
        Assert.assertEquals(2,list.size());
        Assert.assertEquals("Banho Master",list.get(0).getNome());
        Assert.assertEquals("Banho Simples",list.get(1).getNome());
        
    }
    @Test
    public void consultaComTipoServicoAssertTrue(){
        Servico s = new Servico();
        s.setTipoServico(TipoServicoEnum.T);
        List<Servico> list = servicoDao.list(s);
        Assert.assertEquals(2,list.size());
        Assert.assertEquals("Tosa bebe",list.get(0).getNome());
        Assert.assertEquals("Tosa chinesa",list.get(1).getNome());
        
    }
    @Test
    public void consultaComDescricaoAssertTrue(){
        Servico s = new Servico();
        s.setDescricao("do pet");
        List<Servico> list = servicoDao.list(s);
        Assert.assertEquals(2,list.size());
        Assert.assertEquals(new Long(2),list.get(0).getId());
        Assert.assertEquals(new Long(3),list.get(1).getId());
        Assert.assertEquals("Banho Master",list.get(0).getNome());
        Assert.assertEquals("Banho Simples",list.get(1).getNome());
        Assert.assertEquals("Melhor banhoo do pet",list.get(0).getDescricao());
        Assert.assertEquals("Banho Inicial do pet",list.get(1).getDescricao());
        Assert.assertEquals(TipoServicoEnum.B,list.get(0).getTipoServico());
        Assert.assertEquals(TipoServicoEnum.B,list.get(1).getTipoServico());
    }
    @Test
    public void deleteComIdAssertTrue(){
        Servico s = new Servico(2L);
        int i = servicoDao.delete(s);
        Assert.assertEquals(1,i);
        
    }
    @Test
    public void updateComIdAssertTrue(){
        Servico s = new Servico(2L);
        s.setNome("Novo servico");
        s.setTipoServico(TipoServicoEnum.B);
        int i = servicoDao.update(s);
        Assert.assertEquals(1,i);
        
    }
    
    
}
