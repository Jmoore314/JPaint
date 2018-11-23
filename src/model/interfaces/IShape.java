package model.interfaces;

import model.ShapeColor;
import model.ShapeShadingType;

public interface IShape {
	int getMinX();
	int getMinY();
	int getWidth();
	int getHeight();
	ShapeColor getPrimaryColor();
	ShapeColor getSecondaryColor(); 
	ShapeShadingType getShade();
	void setMinX(int newXMin);
	void setMinY(int newYMin);
	void setWidth(int newWidth);
	void setHeight(int newHeight);
	void setPrimaryColor(ShapeColor newPrimaryColor);
	void setSecondaryColor(ShapeColor newSecondaryColor); 
	void setShade(ShapeShadingType newShade);
	String toString();
}
