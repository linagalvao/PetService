/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicosadminview.petservicosadminview.prototipos;

import br.com.ferafln.clientepetservicos.JerseyDao;
import br.com.ferafln.clientepetservicos.exception.ClientePetServicoException;
import br.com.ferafln.clientepetservicos.exception.InternoPetServicosException;
import br.com.petservicos.domain.Funcionario;
import br.com.petservicosadminview.petservicosadminview.components.Message;
import br.com.petservicosadminview.petservicosadminview.enums.StatusTelaEnum;
import br.com.petservicosadminview.petservicosadminview.main;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lina
 */
public class ProtFuncionario extends javax.swing.JFrame {

    private StatusTelaEnum statusAtual;
    private List<Funcionario> listFuncionarios;
    private DefaultTableModel model;
    private Funcionario funcionario;

    /**
     * Creates new form ProtFuncionario
     */
    public ProtFuncionario() {
        initComponents();
        actionClickTable();
        actionNovo();
        actionSalvar();
        actionAlterar();
        actionCancelar();
        actionExcluir();

    }

    private void actionAlterar() {
        btnAlterar.addActionListener((java.awt.event.ActionEvent evt) -> {
            statusAtual = StatusTelaEnum.ALTERAR;
            setStatusAlterar();
        });
    }

    private void actionCancelar() {
        btnCancelar.addActionListener((java.awt.event.ActionEvent evt) -> {
            statusAtual = StatusTelaEnum.PESQUISAR;
            setStatusCancelar();
        });
    }

    private void actionClickTable() {
        tblCargo.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setStatusPreencher();

            }
        });
        tblCargo.addKeyListener(new java.awt.event.KeyAdapter() {

            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                int key = evt.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                    setStatusPreencher();
                }
            }
        });
    }

    private void actionExcluir() {
        btnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (tblCargo.getSelectedRows().length > 0 && tblCargo.getSelectedRows().length < 5) {
                    int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir esse(s) registro(s)?", "Aviso", 0);
                    if (resposta == 0) {
                        for (int i = 0; i < tblCargo.getSelectedRows().length; i++) {

                            try {
                                JerseyDao dao = new JerseyDao(Funcionario.class, main.URL_SERVER);
                                dao.delete(listFuncionarios.get(tblCargo.getSelectedRows()[i]));
                            } catch (InternoPetServicosException ex) {
                                Message.showMessageError(ex.getMessage(), null);
                            } catch (ClientePetServicoException ex) {
                                Message.showMessageError("Erro inesperado ao consultar", ex.getMessage());
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Registro(s) excluído(s) com sucesso.", "Aviso", 1);
                        setStatusDeletar();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Escolha no minimo 1 e no maximo 5 registros para exclusão.", "Erro", 0);

                }

            }
        }
        );

    }

    protected void salvar() throws ClientePetServicoException {
        JerseyDao dao = new JerseyDao(Funcionario.class, main.URL_SERVER);
        if (statusAtual.equals(StatusTelaEnum.INCLUIR)) {
            dao.add(new Funcionario(txtNomeCargo.getText()));
            JOptionPane.showMessageDialog(null, "Registro inserido com sucesso.", "Aviso", 1);
        } else if (statusAtual.equals(StatusTelaEnum.ALTERAR)) {
            funcionario.setNome(txtNomeCargo.getText());
            dao.update(funcionario);
            JOptionPane.showMessageDialog(null, "Registro atualizado com sucesso.", "Aviso", 1);
        }

    }

    private void actionSalvar() {
        btnSalvar.addActionListener((java.awt.event.ActionEvent evt) -> {
            try {
                salvar();
                setStatusSalvar();
            } catch (ClientePetServicoException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCargo = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtNomePesquisa = new javax.swing.JTextField();
        btnPesquisa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeCargo = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa"));
        jPanel6.setLayout(null);

        tblCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCargo.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblCargo);
        if (tblCargo.getColumnModel().getColumnCount() > 0) {
            tblCargo.getColumnModel().getColumn(0).setResizable(false);
            tblCargo.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel6.add(jScrollPane2);
        jScrollPane2.setBounds(10, 60, 410, 130);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel14.setText("Nome:");
        jPanel6.add(jLabel14);
        jLabel14.setBounds(20, 20, 50, 20);

        txtNomePesquisa.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtNomePesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomePesquisaKeyPressed(evt);
            }
        });
        jPanel6.add(txtNomePesquisa);
        txtNomePesquisa.setBounds(60, 20, 260, 23);

        btnPesquisa.setText("Pesquisar");
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });
        jPanel6.add(btnPesquisa);
        btnPesquisa.setBounds(330, 20, 90, 23);

        getContentPane().add(jPanel6);
        jPanel6.setBounds(0, 0, 430, 200);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Funcionario"));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setText("Nome: ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(12, 27, 110, 13);

        txtNomeCargo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtNomeCargo.setEnabled(false);
        jPanel1.add(txtNomeCargo);
        txtNomeCargo.setBounds(12, 40, 280, 23);

        btnNovo.setText("Novo");
        jPanel1.add(btnNovo);
        btnNovo.setBounds(20, 100, 73, 23);

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        jPanel1.add(btnAlterar);
        btnAlterar.setBounds(100, 100, 65, 23);

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        jPanel1.add(btnSalvar);
        btnSalvar.setBounds(170, 100, 70, 23);

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        jPanel1.add(btnExcluir);
        btnExcluir.setBounds(245, 100, 70, 23);

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(320, 100, 80, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 200, 430, 150);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar);
        btnFechar.setBounds(320, 360, 80, 23);

        setSize(new java.awt.Dimension(448, 432));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomePesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomePesquisaKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            setStatusPesquisar();
        }
    }//GEN-LAST:event_txtNomePesquisaKeyPressed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        setVisible(false);
        txtNomePesquisa.setText("");
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        pesquisa();
    }//GEN-LAST:event_btnPesquisaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProtFuncionario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProtFuncionario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProtFuncionario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProtFuncionario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProtFuncionario().setVisible(true);
            }
        });
    }

    public void setEnabledObjctes(boolean valor) {
        txtNomeCargo.setEnabled(valor);
    }

    public void setEmptyObjects() {
        txtNomeCargo.setText("");
    }

    private void actionNovo() {
        btnNovo.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusAtual = StatusTelaEnum.INCLUIR;
                setStatusNovo();
            }
        });
    }

    protected void setStatusNovo() {
        btnCancelar.setEnabled(true);
        btnSalvar.setEnabled(true);
        btnNovo.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);
        setEnabledObjctes(true);
        setEmptyObjects();
    }

    protected void setStatusPreencher() {
        btnNovo.setEnabled(true);
        btnAlterar.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnSalvar.setEnabled(false);
        setEnabledObjctes(false);
        preencher();
    }

    protected void setStatusAlterar() {
        btnCancelar.setEnabled(true);
        btnSalvar.setEnabled(true);
        btnNovo.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);
        setEnabledObjctes(true);

    }

    protected void setStatusSalvar() {
        btnNovo.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);
        setEmptyObjects();
        setEnabledObjctes(false);
        if (tblCargo.getModel().getRowCount() != 0) {
            pesquisa();
        }
    }

    protected void setStatusInicial() {
        btnNovo.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);
        setEmptyObjects();
        setEnabledObjctes(false);
        model.setRowCount(0);
    }

    protected void setStatusCancelar() {
        btnNovo.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);
        setEmptyObjects();
        setEnabledObjctes(false);
        tblCargo.getSelectionModel().removeSelectionInterval(0, tblCargo.getRowCount());
    }

    protected void setStatusDeletar() {
        btnNovo.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);
        setEnabledObjctes(false);
        setEmptyObjects();
        pesquisa();
    }

    private void pesquisa() {
        try {

            model = (DefaultTableModel) tblCargo.getModel();

            model.setRowCount(0);
            JerseyDao dao = new JerseyDao(Funcionario.class, main.URL_SERVER);
            listFuncionarios = dao.list(new Funcionario(txtNomePesquisa.getText()));
            for (Funcionario funcionario : listFuncionarios) {
                Object[] row = {funcionario.getId(), funcionario.getNome()};
                model.addRow(row);

            }
        } catch (InternoPetServicosException ex) {
            Message.showMessageError(ex.getMessage(), null);
        } catch (ClientePetServicoException ex) {
            Message.showMessageError("Erro inesperado ao consultar", ex.getMessage());
        }
    }

    protected void setStatusPesquisar() {
        btnNovo.setEnabled(true);
        btnCancelar.setEnabled(false);
        btnSalvar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);
        setEnabledObjctes(false);
        setEmptyObjects();
        pesquisa();
    }

    private void preencher() {
        if (tblCargo.getSelectedRow() < 0) {
            return;
        }
        funcionario = listFuncionarios.get(tblCargo.getSelectedRow());
        txtNomeCargo.setText(funcionario.getNome());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCargo;
    private javax.swing.JTextField txtNomeCargo;
    private javax.swing.JTextField txtNomePesquisa;
    // End of variables declaration//GEN-END:variables
}
