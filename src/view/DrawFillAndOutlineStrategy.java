package view;

import java.awt.Graphics2D;

import model.ColorMap;
import model.interfaces.IShape;
import view.interfaces.IDrawStrategy;

public class DrawFillAndOutlineStrategy implements IDrawStrategy {
	private IShape shape;
	private Graphics2D g2d;
	
	public DrawFillAndOutlineStrategy(IShape shape, Graphics2D g2d) {
		this.shape = shape;
		this.g2d = g2d;
	}
	
	public void draw() {
		g2d.setColor(ColorMap.getColor(shape.getPrimaryColor()));
		int x = shape.getMinX(); 
		int y = shape.getMinY(); 
		int w = shape.getWidth(); 
		int h = shape.getHeight();
		
		switch(shape.toString()) {
		case "RECTANGLE":
			g2d.drawRect(x, y, w, h);
			g2d.setColor(ColorMap.getColor(shape.getSecondaryColor()));
			g2d.fillRect(x, y, w, h);
			break;
		case "ELLIPSE":
			g2d.drawOval(x, y, w, h);
			g2d.setColor(ColorMap.getColor(shape.getSecondaryColor()));
			g2d.fillOval(x, y, w, h);
			break;
		case "SQUARE":
			if (Math.min(w, h) == w) {
				y = y + ((h - w) / 2);
			} else {
				x = x + ((w - h) / 2);
				w = h;
			}
			g2d.drawRect(x, y, w, w);
			g2d.setColor(ColorMap.getColor(shape.getSecondaryColor()));
			g2d.fillRect(x, y, w, w);
			shape.setMinX(x);
			shape.setMinY(y);
			shape.setWidth(w);
			shape.setHeight(w);
			break;
		case "CIRCLE":
			if (Math.min(w, h) == w) {
				y = y + ((h - w) / 2);
			} else {
				x = x + ((w - h) / 2);
				w = h;
			}
			g2d.drawOval(x, y, w, w);
			g2d.setColor(ColorMap.getColor(shape.getSecondaryColor()));
			g2d.fillOval(x, y, w, w);
			shape.setMinX(x);
			shape.setMinY(y);
			shape.setWidth(w);
			shape.setHeight(w);
			break;
		case "RIGHT_TRIANGLE":
			int[] xPoints = {x + w, x, x + w};
			int[] yPoints = {y , y+ h, y + h};
			g2d.drawPolygon(xPoints, yPoints, 3);
			g2d.setColor(ColorMap.getColor(shape.getSecondaryColor()));
			g2d.fillPolygon(xPoints, yPoints, 3);
			break;
		case "ISOSCELES_TRIANGLE":
			int[] aPoints = {x, x + w, x + (w/2)};
			int[] bPoints = {y + h, y + h, y};
			g2d.drawPolygon(aPoints, bPoints, 3);
			g2d.setColor(ColorMap.getColor(shape.getSecondaryColor()));
			g2d.fillPolygon(aPoints, bPoints, 3);
			break;
		default:
			break;
		}
	}
}
