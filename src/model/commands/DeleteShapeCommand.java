package model.commands;

import java.util.ArrayList;

import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IUndoable;

public class DeleteShapeCommand implements ICommand, IUndoable {
	private static ShapeList shapeList;
	private ArrayList<IShape> deletedShapes;
	
	public DeleteShapeCommand() {
		shapeList = ShapeList.getInstance();
	}

	@Override
	public void undo() {
		for (IShape shape : deletedShapes) {
			shapeList.addShape(shape);
		}
		shapeList.updateShapes();
	}

	@Override
	public void redo() {
		for (IShape shape : deletedShapes) {
			shapeList.removeShape(shape);
		}
		shapeList.updateShapes();
	}

	@Override
	public void run() {
		deletedShapes = shapeList.getSelectedShapes();
		
		for (IShape shape : deletedShapes) {
			shapeList.removeShape(shape);
		}
		
		shapeList.updateShapes();
		CommandHistory.add(this);
	}


}
