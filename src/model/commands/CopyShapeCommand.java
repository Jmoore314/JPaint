package model.commands;

import java.util.ArrayList;

import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;

public class CopyShapeCommand implements ICommand {
	private static ShapeList shapeList;
	private ArrayList<IShape> copiedShapes;
	
	public CopyShapeCommand() {
		shapeList = ShapeList.getInstance();
	}

	@Override
	public void run() {
		copiedShapes = shapeList.getSelectedShapes();
		shapeList.setCopiedShapes(copiedShapes);
	}
}