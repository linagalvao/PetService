/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicosadminview.petservicosadminview.buttons;

import br.com.petservicos.domain.GenericDomain;
import br.com.petservicosadminview.petservicosadminview.enums.StatusTelaEnum;
import br.com.petservicosadminview.petservicosadminview.main;
import javax.swing.JButton;

/**
 *
 * @author Lina
 * @param <T>
 */
public class BotaoCrud<T extends GenericDomain> extends JButton {

    private T entidade;
    private StatusTelaEnum status;
    protected final String mensgem="Não é possivel executar esse comando nesse status.";
    
    public BotaoCrud(StatusTelaEnum statusTelaEnum) {
        super();
        super.setBounds(main.DEFAULT_SIZE_BUTTON);
        this.status=statusTelaEnum;
        super.setFont(main.DEFAULT_FONT);
    }

    public T getEntidade() {
        return entidade;
    }
    public void setEntidade(T entidade) {
        this.entidade = entidade;
    }

    public StatusTelaEnum getStatus() {
        return status;
    }

    protected void setStatus(StatusTelaEnum status) {
        this.status = status;
    }

}
