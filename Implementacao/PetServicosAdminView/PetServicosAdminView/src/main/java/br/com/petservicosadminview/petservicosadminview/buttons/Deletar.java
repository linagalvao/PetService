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
import javax.swing.JOptionPane;

/**
 *
 * @author Lina
 * @param <T>
 */
public class Deletar<T extends GenericDomain> extends BotaoCrud<T> {

    public Deletar(StatusTelaEnum statusTelaEnum) {
        super(statusTelaEnum);
        super.setText("Deletar");
        super.addActionListener((ActionEvent e) -> {
//            try {
                if (!StatusTelaEnum.PESQUISADO.equals(getStatus())) {
                    if(getEntidade()==null){
                        Message.showMessageError("Nenhum registro foi informado.", null);
                        return;
                    }
                    int i = JOptionPane.showConfirmDialog(null, "Deseja deletar o registro?", "Aviso", JOptionPane.YES_NO_OPTION);
                    if (i == JOptionPane.NO_OPTION) {
                        return;
                    }
                }
                JerseyDao dao = new JerseyDao(getEntidade().getClass(), main.URL_SERVER);
//                dao.delete(getEntidade());
                setStatus(StatusTelaEnum.PESQUISAR);
//            } catch (InternoPetServicosException ex) {
//                Message.showMessageError(ex);
//            } catch (ClientePetServicoException ex) {
//                Message.showMessageError("Erro inesperado ao pesquisar.", ex.getMessage());
//
//            }
        });
    }

}
