package co.edu.uptc.view.body.user;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

public class ShapedButtonMenuHover extends BasicButtonUI {
	private Color background;
	
	public ShapedButtonMenuHover(Color background) {
		this.background = background;
	}
	
	@Override
	public void paint(Graphics g, JComponent c) {
	Graphics2D g2d = (Graphics2D) g;
	Shape buttonShape = null;
	buttonShape = new Rectangle2D.Double(0, 0, c.getWidth(), c.getHeight());
	g2d.setPaint(background);
	g2d.fill(buttonShape);
	super.paint(g2d, c);
	}
}
