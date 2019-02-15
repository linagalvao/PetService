/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicosadminview.petservicosadminview.buttons;

import br.com.petservicos.domain.GenericDomain;
import br.com.petservicosadminview.petservicosadminview.enums.StatusTelaEnum;
import java.awt.event.ActionEvent;

/**
 *
 * @author Lina
 * @param <T>
 */
public class Cancelar <T extends GenericDomain> extends BotaoCrud<T> {

    public Cancelar(StatusTelaEnum statusTelaEnum) {
        super(statusTelaEnum);
        super.setText("Cancelar");
        super.addActionListener((ActionEvent e) -> {
            setStatus(StatusTelaEnum.PESQUISAR);
        });
    }
}
