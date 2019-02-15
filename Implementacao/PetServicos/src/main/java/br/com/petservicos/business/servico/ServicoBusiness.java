/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.business.servico;

import br.com.petservicos.business.generic.GenericBusiness;
import br.com.petservicos.domain.Servico;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lina
 */
@Service
public interface ServicoBusiness extends GenericBusiness<Servico, ServicoBusinessException> {
    
}
