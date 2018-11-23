package model.commands;

import java.util.ArrayList;
import java.util.HashMap;

import controller.MouseHandler;
import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;

public class MoveShapeCommand implements ICommand, IUndoable {
	private static MouseHandler mouse;
	private static ShapeList shapeList;
	private ArrayList<IShape> moveShapes;
	private HashMap<IShape, Integer> originX;
	private HashMap<IShape, Integer> originY;
	private int deltaX;
	private int deltaY;
	
	public MoveShapeCommand(MouseHandler m) {
		mouse = m;
		shapeList = ShapeList.getInstance();
		originX = new HashMap<IShape, Integer>();
		originY = new HashMap<IShape, Integer>();
	}

	@Override
	public void undo() {
		for (IShape shape : moveShapes) {
			int tempX = shape.getMinX();
			int tempY = shape.getMinY();
			shape.setMinX(tempX - deltaX);
			shape.setMinY(tempY - deltaY);
		}
		shapeList.updateShapes();
	}

	@Override
	public void redo() {
		for (IShape shape : moveShapes) {
			int tempX = shape.getMinX();
			int tempY = shape.getMinY();
			shape.setMinX(tempX + deltaX);
			shape.setMinY(tempY + deltaY);
		}
		shapeList.updateShapes();
	}

	@Override
	public void run() {
		moveShapes = shapeList.getSelectedShapes();
		
		int startingX = mouse.getStartingX();
		int startingY = mouse.getStartingY();
		int endingX = mouse.getEndingX();
		int endingY = mouse.getEndingY();
		deltaX = endingX - startingX;
		deltaY = endingY - startingY;
		
		for (IShape shape : moveShapes) {
			originX.put(shape, shape.getMinX());
			originY.put(shape, shape.getMinY());
			int tempX = originX.get(shape);
			int tempY = originY.get(shape);
			shape.setMinX(tempX + deltaX);
			shape.setMinY(tempY + deltaY);
		}
		shapeList.updateShapes();
		CommandHistory.add(this);
	}
	
	public void setDeltaX(int newDeltaX) {
		deltaX = newDeltaX;
	}
	
	public void setDeltaY(int newDeltaY) {
		deltaY = newDeltaY;
	}
	
	public HashMap<IShape, Integer> getOriginXMap() {
		return originX;
	}
	
	public HashMap<IShape, Integer> getOriginYMap() {
		return originY;
	}

}
