/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.business.funcionario;

import br.com.petservicos.domain.Funcionario;
import br.com.petservicos.business.generic.GenericBusinessImpl;
import br.com.petservicos.dao.funcionario.FuncionarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lina
 */
@Service
public class FuncionarioBusinessImpl extends GenericBusinessImpl<Funcionario, FuncionarioDao, FuncionarioBusinessException> implements FuncionarioBusiness {
    @Autowired
    private FuncionarioDao funcionarioDao;
    
    public FuncionarioBusinessImpl(FuncionarioDao genericDao) {
        super();
        this.funcionarioDao=genericDao;
    }

    public FuncionarioBusinessImpl() {
    }

    @Override
    protected FuncionarioDao getGenericDao() {
        return funcionarioDao;
    }
    


}
