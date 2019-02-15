package br.com.petservicosadminview.petservicosadminview.components;

import br.com.ferafln.clientepetservicos.exception.ClientePetServicoException;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

public class Message
  extends JPanel
{
  private static String mens = "";
  private static String det = "";
  private static final long serialVersionUID = 1L;
  private final boolean showDetalhes = false;
  private JLabel jLabel1;
  private JLabel lblErro;
  private JScrollPane scrDetalhe;
  private JTextArea txtDetalhe;
  
  public Message()
  {
    initComponents();
    this.scrDetalhe.setVisible(true);
  }
  
  private void initComponents()
  {
    this.jLabel1 = new JLabel();
    this.scrDetalhe = new JScrollPane();
    this.txtDetalhe = new JTextArea();
    this.lblErro = new JLabel();
    
    this.jLabel1.setFont(new Font("Tahoma", 0, 10));
    this.jLabel1.setText("Detalhes:");
    this.jLabel1.setCursor(new Cursor(12));
    
    this.txtDetalhe.setColumns(20);
    this.txtDetalhe.setFont(new Font("Tahoma", 0, 10));
    this.txtDetalhe.setRows(5);
    this.scrDetalhe.setViewportView(this.txtDetalhe);
    
    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1, -2, 66, -2).addContainerGap()).addComponent(this.lblErro, -1, 384, 32767).addComponent(this.scrDetalhe, -1, 384, 32767));
    
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.lblErro, -2, 22, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.scrDetalhe, -2, 107, -2)));
  }
  
  private static void showMessage(String mensagem, String detalhe, String titulo, int tipo)
  {
    mens = mensagem;
    det = detalhe;
    if ((detalhe == null) || (detalhe.isEmpty()))
    {
      JOptionPane.showMessageDialog(null, mensagem, titulo, tipo);
    }
    else
    {
      Message m = new Message();
      m.txtDetalhe.setText(detalhe);
      m.lblErro.setText(mensagem);
      JOptionPane.showMessageDialog(null, m, titulo, tipo);
    }
  }
  
  private static int showMessageConfirDialog(String mensagem, String detalhe, String titulo, int tipo, int tipoOpcao)
  {
    mens = mensagem;
    det = detalhe;
    if ((detalhe == null) || (detalhe.isEmpty())) {
      return JOptionPane.showConfirmDialog(null, mensagem, titulo, tipoOpcao, tipo);
    }
    Message m = new Message();
    m.txtDetalhe.setText(detalhe);
    m.lblErro.setText(mensagem);
    return JOptionPane.showConfirmDialog(null, m, titulo, tipoOpcao, tipo);
  }
  
  public static void showMessageError(String mensagem, String detalhe)
  {
    showMessage(mensagem, detalhe, "Erro", 0);
  }
  
  public static int showMessageConfirmDialog(String mensagem, String detalhe, int tipoOpcao)
  {
    return showMessageConfirDialog(mensagem, detalhe, "Aviso", 1, tipoOpcao);
  }
  
  public static void showMessageInfo(String mensagem, String detalhe)
  {
    showMessage(mensagem, detalhe, "Aviso", 1);
  }
  
  public static void showMessageError(ClientePetServicoException businessException)
  {
    showMessageError(businessException.getMessage(), null);
  }
}
