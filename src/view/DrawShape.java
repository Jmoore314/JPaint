package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import model.ShapeShadingType;
import model.interfaces.IShape;
import view.gui.PaintCanvas;
import view.interfaces.IDrawStrategy;

public class DrawShape {
	
	public static void draw(IShape shape) {
		PaintCanvas canvas = PaintCanvas.getInstance();
		Graphics2D g2d = canvas.getGraphics2D();
		g2d.setStroke(new BasicStroke(2));
		IDrawStrategy strat = null;
		
		if(shape.getShade() == ShapeShadingType.OUTLINE) {
			strat = new DrawOutlineStrategy(shape, g2d);
		} else if (shape.getShade() == ShapeShadingType.FILLED_IN) {
			strat = new DrawFillStrategy(shape, g2d);
		} else if(shape.getShade() == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
			strat = new DrawFillAndOutlineStrategy(shape, g2d);
		}
		
		strat.draw();
	}
	
	public static void select(IShape shape) {
		PaintCanvas canvas = PaintCanvas.getInstance();
		Graphics2D g2d = canvas.getGraphics2D();
		float[] dash1 = { 2f, 0f, 2f };
	    BasicStroke bs1 = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);
	    g2d.setStroke(bs1);
	    int offSet = 5;
	    
	    g2d.setColor(Color.black);
		int x = shape.getMinX() - offSet; 
		int y = shape.getMinY() - offSet; 
		int w = shape.getWidth() + offSet + offSet; 
		int h = shape.getHeight() + offSet + offSet;
		
		g2d.drawRect(x, y, w, h);
	}
}
