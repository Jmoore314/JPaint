package model.shapes;

import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.IShape;

public class RightTriangle implements IShape {
	private int xMin;
	private int yMin;
	private int width;
	private int height;
	private ShapeColor primaryColor;
	private ShapeColor secondaryColor;
	private ShapeShadingType shade;
	
	public RightTriangle(ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shade, int xMin, int yMin, int width, int height) {
		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
		this.shade = shade;
		this.xMin = xMin;
		this.yMin = yMin;
		this.width = width;
		this.height = height;
	}
	
	public int getMinX() {
		return xMin;
	}
	
	public void setMinX(int newXMin) {
		this.xMin = newXMin;
	}
	
	public int getMinY() {
		return yMin;
	}
	
	public void setMinY(int newYMin) {
		this.yMin = newYMin;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int newWidth) {
		this.width = newWidth;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int newHeight) {
		this.height = newHeight;
	}
	
	public ShapeColor getPrimaryColor() {
		return primaryColor;
	}
	
	public void setPrimaryColor(ShapeColor newPrimaryColor) {
		this.primaryColor = newPrimaryColor;
	}
	
	public ShapeColor getSecondaryColor() {
		return secondaryColor;
	}
	
	public void setSecondaryColor(ShapeColor newSecondaryColor) {
		this.secondaryColor = newSecondaryColor;
	}
	
	public ShapeShadingType getShade() {
		return shade;
	}
	
	public void setShade(ShapeShadingType newShade) {
		this.shade = newShade;
	}
	
	public String toString() {
		return "RIGHT_TRIANGLE";
	}
}