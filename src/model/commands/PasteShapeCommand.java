package model.commands;

import java.util.ArrayList;

import model.ShapeColor;
import model.ShapeFactory;
import model.ShapeList;
import model.ShapeShadingType;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;

public class PasteShapeCommand implements ICommand, IUndoable {
	private static ShapeList shapeList;
	private ArrayList<IShape> oldShapes;
	private ArrayList<IShape> newShapes;
	private final int offSetCoordinates = 60;
	
	public PasteShapeCommand() {
		shapeList = ShapeList.getInstance();
		newShapes = new ArrayList<IShape>();
	}

	@Override
	public void undo() {
		for (IShape shape : newShapes) {
			shapeList.removeShape(shape);
		}
		shapeList.updateShapes();
	}

	@Override
	public void redo() {
		for (IShape shape : newShapes) {
			shapeList.addShape(shape);
		}
		shapeList.updateShapes();
	}

	@Override
	public void run() {
		oldShapes = shapeList.getCopiedShapes();
		
		for (IShape shape : oldShapes) {
			IShape copiedShape = createCopyShape(shape);
			newShapes.add(copiedShape);
			shapeList.addShape(copiedShape);
		}
		shapeList.setSelectedShapes(newShapes);
		shapeList.setCopiedShapes(newShapes);
		shapeList.updateShapes();
		CommandHistory.add(this);
	}
	
	public IShape createCopyShape(IShape shape) {
		int minX = shape.getMinX() + offSetCoordinates;
		int minY = shape.getMinY() + offSetCoordinates;
		int width = shape.getWidth();
		int height = shape.getHeight();
		ShapeColor primaryColor = shape.getPrimaryColor();
		ShapeColor secondaryColor = shape.getSecondaryColor(); 
		ShapeShadingType shade = shape.getShade();
		IShape copiedShape = null;

		switch(shape.toString()) {
		case "ELLIPSE":
			copiedShape = ShapeFactory.createEllipse(primaryColor, secondaryColor, shade, minX, minY, width, height);
			break;
		case "CIRCLE":
			copiedShape = ShapeFactory.createCircle(primaryColor, secondaryColor, shade, minX, minY, width, height);
			break;
		case "RECTANGLE":
			copiedShape = ShapeFactory.createRectangle(primaryColor, secondaryColor, shade, minX, minY, width, height);
			break;
		case "SQUARE":
			copiedShape = ShapeFactory.createSquare(primaryColor, secondaryColor, shade, minX, minY, width, height);
			break;
		case "RIGHT_TRIANGLE":
			copiedShape = ShapeFactory.createRightTriangle(primaryColor, secondaryColor, shade, minX, minY, width, height);
			break;
		case "ISOSCELES_TRIANGLE":
			copiedShape = ShapeFactory.createIsoscelesTriangle(primaryColor, secondaryColor, shade, minX, minY, width, height);
			break;
		}

		return copiedShape;
	}

}
