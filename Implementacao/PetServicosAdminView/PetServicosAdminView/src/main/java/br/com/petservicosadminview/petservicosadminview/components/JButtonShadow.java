package br.com.petservicosadminview.petservicosadminview.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JButtonShadow
  extends JButton
{
  private String text;
  private Font font;
  private boolean invertColors = false;
  private Color frontColor = Color.white;
  private Color backColor = Color.black;
  private Image img;
  private int widthImage = 40;
  private int heidhtImage = 40;
  private static final long serialVersionUID = 1L;
  
  public JButtonShadow(String text, ImageIcon icon)
  {
    super(text, icon);
  }
  
  public JButtonShadow(String text, String icon)
  {
    try
    {
      this.text = (text == null ? new String() : text);
      this.font = new Font("Tahoma", 1, 8);
      this.img = ImageIO.read(new File(icon));
    }
    catch (IOException ex)
    {
      Logger.getLogger(JButtonShadow.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  @Override
  public void setFont(Font f)
  {
    this.font = f;
  }
  
  @Override
  public Font getFont()
  {
    return this.font;
  }
  
  public int getHeidhtImage()
  {
    return this.heidhtImage;
  }
  
  public void setHeidhtImage(int heidhtImage)
  {
    this.heidhtImage = heidhtImage;
  }
  
  public int getWidthImage()
  {
    return this.widthImage;
  }
  
  public void setWidthImage(int widthImage)
  {
    this.widthImage = widthImage;
  }
  
  @Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Graphics2D g2D = (Graphics2D)g.create();
    FontMetrics fm = g2D.getFontMetrics(this.font);
    int heidhtTxt = (int)fm.getStringBounds(this.text, g).getHeight();
    int x_img = getBounds().width / 2 - this.widthImage / 2;
    int y_img = getBounds().height / 2 - (this.heidhtImage + getIconTextGap() + heidhtTxt) / 2;
    int x_txt = getBounds().width / 2 - fm.stringWidth(this.text) / 2;
    int y_txt = y_img + this.heidhtImage + getIconTextGap();
    
    g2D.drawImage(this.img, x_img, y_img, 40, 40, null);
    
    g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    if (this.invertColors)
    {
      g2D.setFont(this.font);
      g2D.setColor(this.frontColor);
      g2D.drawString(this.text, x_txt + 2, y_txt + 1);
      g2D.setColor(this.backColor);
      g2D.drawString(this.text, x_txt, y_txt);
    }
    else
    {
      g2D.setFont(this.font);
      g2D.setColor(this.backColor);
      g2D.drawString(this.text, x_txt + 2, y_txt + 1);
      g2D.setColor(this.frontColor);
      g2D.drawString(this.text, x_txt, y_txt);
    }
    g2D.dispose();
    super.paintComponent(g2D);
  }
  
  public Color getBackColor()
  {
    return this.backColor;
  }
  
  public void setBackColor(Color backColor)
  {
    this.backColor = backColor;
  }
  
  public Color getFrontColor()
  {
    return this.frontColor;
  }
  
  public void setFrontColor(Color frontColor)
  {
    this.frontColor = frontColor;
  }
  
  public void setInvertColors(boolean invertColors)
  {
    this.invertColors = invertColors;
  }
  
  @Override
  public void setText(String text)
  {
    this.text = text;
    
    repaint();
  }
}
