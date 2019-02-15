/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicosadminview.petservicosadminview.buttons;

import br.com.ferafln.clientepetservicos.JerseyDao;
import br.com.ferafln.clientepetservicos.exception.ClientePetServicoException;
import br.com.ferafln.clientepetservicos.exception.InternoPetServicosException;
import br.com.petservicos.domain.GenericDomain;
import br.com.petservicosadminview.petservicosadminview.components.Message;
import br.com.petservicosadminview.petservicosadminview.enums.StatusTelaEnum;
import br.com.petservicosadminview.petservicosadminview.main;
import java.awt.event.ActionEvent;

/**
 *
 * @author Lina
 * @param <T>
 */
public class Salvar<T extends GenericDomain> extends BotaoCrud<T> {

    public Salvar(StatusTelaEnum statusTelaEnum) {
        super(statusTelaEnum);
        super.setBounds(main.DEFAULT_SIZE_BUTTON);
        super.setFont(main.DEFAULT_FONT);
        super.setText("Salvar");
        super.addActionListener((ActionEvent e) -> {
            JerseyDao dao = new JerseyDao(getEntidade().getClass(), main.URL_SERVER);
//           try {
                if (null != getStatus()) switch (getStatus()) {
                    case INCLUIR:
                       // dao.add(getEntidade());
                        setStatus(StatusTelaEnum.PESQUISAR);
                        break;
                    case ALTERAR:
//                        dao.update(getEntidade());
                        setStatus(StatusTelaEnum.PESQUISAR);
                        break;
                    default:
                        Message.showMessageError(mensgem,null);
                        break;
                }
//            } catch (InternoPetServicosException ex) {
//                Message.showMessageError(ex);
//            } catch (ClientePetServicoException ex) {
//                Message.showMessageError("Erro inesperado ao salvar.",ex.getMessage());
//                
//            }
        });
    }

}
