package view.gui;

import javax.swing.JComponent;
import java.awt.*;

public class PaintCanvas extends JComponent {
	private static final PaintCanvas instance = new PaintCanvas();
	
	private PaintCanvas() { }
	
    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }
    
    public static PaintCanvas getInstance() {
    	return instance;
    }
    
    public void clear() {
    	Graphics2D g2d = instance.getGraphics2D();
    	g2d.setColor(Color.white);
    	g2d.setStroke(new BasicStroke(5));
    	g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
}
