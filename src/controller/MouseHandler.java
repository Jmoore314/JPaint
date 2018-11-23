package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {
	private int startingX;
	private int startingY;
	private int endingX;
	private int endingY;
	private int minY;
	private int minX;
	private int width;
	private int height;
	private boolean reverse;
	
	public MouseHandler() {
		super();
	}
	
	public void calculateValues() {
		minX = Math.min(startingX, endingX);
		minY = Math.min(startingY, endingY);
		width = Math.abs(startingX - endingX); 
		height = Math.abs(startingY - endingY);
	}
	
	public int getMinX() {
		return minX;
	}
	
	public int getMinY() {
		return minY;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getStartingX() {
		return startingX;
	}
	
	public int getStartingY() {
		return startingY;
	}
	
	public int getEndingX() {
		return endingX;
	}
	
	public int getEndingY() {
		return endingY;
	}
	
	public boolean getReverse() {
		return reverse;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		startingX = e.getX();
		startingY = e.getY();
		endingX = e.getX();
		endingY = e.getY();
		reverse = (e.getButton() == 3) ? true : false;
		calculateValues();
		CommandController.mousePressed();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		endingX = e.getX();
		endingY = e.getY();
		calculateValues();
		CommandController.mouseReleased();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		endingX = e.getX();
		endingY = e.getY();
		calculateValues();
		CommandController.mouseDragged();
	}
}
