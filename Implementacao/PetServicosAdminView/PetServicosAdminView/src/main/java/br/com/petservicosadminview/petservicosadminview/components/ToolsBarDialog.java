package br.com.petservicosadminview.petservicosadminview.components;

import com.sun.awt.AWTUtilities;
import java.awt.Dialog;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ToolsBarDialog
        extends JDialog {

    private static final long serialVersionUID = 1L;
    private final int WIDTH_TOOLSBAR = 92;
    private final int HEIGHT_TOOLSBAR = 600;
    private final JPanel pnlPricipal;
    private JToggleButton btnHide;
    private final int Y_BUTTONS = 40;
    private final int SPACE_BUTTONS = 2;

    public ToolsBarDialog(JComponent... componet) {
        setDefaultCloseOperation(0);
        setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setUndecorated(true);
        sizeDefault();
        setLayout(null);
        this.pnlPricipal = new JPanel(null);
        this.pnlPricipal.setBounds(0, 0, this.WIDTH_TOOLSBAR, this.HEIGHT_TOOLSBAR);
        this.pnlPricipal.setOpaque(false);
        createBtnHide();
        alignButtons(componet);
        loadImagem();
        add(this.pnlPricipal);
        setAlwaysOnTop(true);
        addMouseListener(actionMouseExited());
        addMouseListener(actionMouseEntered());
        AWTUtilities.setWindowOpaque(this, false);
    }

    private void alignButtons(JComponent[] button) {
        int x = 0;
        int y = this.Y_BUTTONS;
        for (JComponent jButton : button) {
            x = getBounds().width / 2 - jButton.getSize().width / 2;
            jButton.setBounds(x, y, jButton.getBounds().width, jButton.getBounds().height);
            jButton.addMouseListener(actionMouseExited());
            jButton.addMouseListener(actionMouseEntered());
            this.pnlPricipal.add(jButton);
            y += this.SPACE_BUTTONS + jButton.getSize().height;
        }
    }

    private MouseAdapter actionMouseEntered() {
        return new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                ToolsBarDialog.this.sizeDefault();
            }
        };
    }

    private MouseAdapter actionMouseExited() {
        return new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent evt) {
                if ((!ToolsBarDialog.this.btnHide.isSelected()) && ((evt.getXOnScreen() < ToolsBarDialog.this.getBounds().x) || (evt.getYOnScreen() < ToolsBarDialog.this.getBounds().y) || (evt.getYOnScreen() > ToolsBarDialog.this.getBounds().y + ToolsBarDialog.this.getBounds().height))) {
                    try {
                        Thread.sleep(1000L);
                        ToolsBarDialog.this.sizeHide();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ToolsBarDialog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
    }

    private void createBtnHide() {
        this.btnHide = new JToggleButton();
        this.btnHide.setOpaque(false);
        this.btnHide.setContentAreaFilled(false);
        this.btnHide.setBorderPainted(false);
        this.btnHide.setBounds(17, 15, 23, 20);
        this.btnHide.setSelected(true);
        this.btnHide.addMouseListener(actionMouseEntered());
        this.btnHide.addMouseListener(actionMouseExited());
        this.btnHide.addActionListener((ActionEvent e) -> {
            if (ToolsBarDialog.this.btnHide.isSelected()) {
                ToolsBarDialog.this.btnHide.setIcon(new ImageIcon("img\\pin1.png"));
            } else {
                ToolsBarDialog.this.btnHide.setIcon(new ImageIcon("img\\pin.png"));
            }
        });
        this.btnHide.setIcon(new ImageIcon("img\\pin1.png"));
        this.pnlPricipal.add(this.btnHide);
    }

    private void loadImagem() {
        JLabel lblImagem = new JLabel(new ImageIcon("img\\bg_transparent.png"));
        lblImagem.setBounds(0, 0, this.WIDTH_TOOLSBAR, this.HEIGHT_TOOLSBAR);
        this.pnlPricipal.add(lblImagem);
    }

    private void sizeHide() {
        Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        int width = 2;
        int x = winSize.width - width;
        int y = winSize.height / 2 - this.HEIGHT_TOOLSBAR / 2;
        setBounds(x, y, width, this.HEIGHT_TOOLSBAR);
        repaint();
    }

    private void sizeDefault() {
        Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        int x = winSize.width - this.WIDTH_TOOLSBAR;
        int y = winSize.height / 2 - this.HEIGHT_TOOLSBAR / 2;
        setBounds(x, y, this.WIDTH_TOOLSBAR, this.HEIGHT_TOOLSBAR);
        repaint();
    }
}
