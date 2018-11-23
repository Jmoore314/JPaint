package model;

import model.interfaces.IShape;
import model.shapes.Circle;
import model.shapes.Ellipse;
import model.shapes.IsoscelesTriangle;
import model.shapes.Rectangle;
import model.shapes.RightTriangle;
import model.shapes.Square;

public class ShapeFactory {
	
	public static IShape createEllipse(ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shade, int xMin, int xMax, int yMin, int yMax) {
		return new Ellipse(primaryColor, secondaryColor, shade, xMin, xMax, yMin, yMax);
	}
	
    public static IShape createCircle(ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shade, int xMin, int xMax, int yMin, int yMax) {
    	return new Circle(primaryColor, secondaryColor, shade, xMin, xMax, yMin, yMax);
    }
    
    public static IShape createRectangle(ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shade, int xMin, int xMax, int yMin, int yMax) {
    	return new Rectangle(primaryColor, secondaryColor, shade, xMin, xMax, yMin, yMax);
    }
    
    public static IShape createSquare(ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shade, int xMin, int xMax, int yMin, int yMax) {
    	return new Square(primaryColor, secondaryColor, shade, xMin, xMax, yMin, yMax);
    }
    
    public static IShape createRightTriangle(ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shade, int xMin, int xMax, int yMin, int yMax) {
    	return new RightTriangle(primaryColor, secondaryColor, shade, xMin, xMax, yMin, yMax);
    }
    
    public static IShape createIsoscelesTriangle(ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shade, int xMin, int xMax, int yMin, int yMax) {
    	return new IsoscelesTriangle(primaryColor, secondaryColor, shade, xMin, xMax, yMin, yMax);
    }
}
