/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicosadminview.petservicosadminview;

import br.com.petservicosadminview.petservicosadminview.components.JButtonShadow;
import br.com.petservicosadminview.petservicosadminview.components.ToolsBarDialog;
import br.com.petservicosadminview.petservicosadminview.prototipos.ProtFuncionario;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Lina
 */
public class main {
    public static Font DEFAULT_FONT = new Font("Tahoma", 1, 9);
    public static Rectangle DEFAULT_SIZE_BUTTON = new Rectangle(80, 25);
    public static String URL_SERVER = "http://lina-pc:8080/PetServicos/rest";
    public static void main(String[] args) {
        try {
            LookAndFeelInfo[] plafs = UIManager.getInstalledLookAndFeels();
            for (UIManager.LookAndFeelInfo info : plafs) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());

                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
        new main();
    }

    public main() {
        JButtonShadow release = newJButton("img\\icone\\fila_pet.png", "Fila Pet");
//        release.addActionListener(actionButtonRelease());
        JButtonShadow button2 = newJButton("img\\icone\\cadastro_pet.png", "Clientes");
//        button2.addActionListener(actionButtonSvn());
        JButtonShadow button3 = newJButton("img\\icone\\animais.png", "Animais");
//        button3.addActionListener(actionButtonBranches());
        JButtonShadow button4 = newJButton("img\\icone\\servicos.png", "Serviços");
//        button4.addActionListener(actionButtonUsuarios());
        JButtonShadow button5 = newJButton("img\\icone\\raca.png", "Raças");
//        button5.addActionListener(actionButtonEmpacotador());
        JButtonShadow button6 = newJButton("img\\icone\\funcionarios.png", "Funcionários");
        button6.addActionListener(actionButtonGrupos());
        JSeparator jSeparator = new JSeparator();
        jSeparator.setSize(90, 3);
        JButtonShadow button7 = newJButton("img\\icone\\gear.png", "Setup");
//        button7.addActionListener(actionButtonOpcoes());
        JButtonShadow button8 = newJButton("img\\icone\\Shutdown.png", "Sair");
        button8.addActionListener(actionButtonSair());
        ToolsBarDialog barDialog = new ToolsBarDialog(new JComponent[]{release, button2, button3, button5, button4, button6, jSeparator, button7, button8});
        barDialog.setVisible(true);
    }

    private JButtonShadow newJButton(String iconFile, String label) {
        final JButtonShadow button = new JButtonShadow(label, iconFile);
        button.setFont(new Font("Tahoma", 1, 9));
        button.setBounds(0, 0, 78, 65);
        button.setForeground(Color.white);
        button.setOpaque(true);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        button.setText(label);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                button.setBorder(BorderFactory.createEmptyBorder());
            }

            @Override
            public void mousePressed(MouseEvent evt) {
                button.setBorder(BorderFactory.createEmptyBorder());
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
                button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
            }
        });
        button.setIconTextGap(10);
        return button;
    }

    private ActionListener actionButtonSair() {
        return (ActionEvent e) -> {
            System.exit(0);
        };
    }

    private ActionListener actionButtonGrupos() {
        return (ActionEvent e) -> {
            ProtFuncionario pf = new ProtFuncionario();
            pf.setVisible(true);
        };
    }

}
