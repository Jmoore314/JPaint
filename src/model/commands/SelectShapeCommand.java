package model.commands;

import java.util.ArrayList;

import controller.MouseHandler;
import model.ShapeColor;
import model.ShapeFactory;
import model.ShapeList;
import model.ShapeShadingType;
import model.interfaces.ICommand;
import model.interfaces.IShape;

public class SelectShapeCommand implements ICommand {
	private static MouseHandler mouse;
	private static ShapeList shapeList;
	
	public SelectShapeCommand(MouseHandler m) {
		mouse = m;
		shapeList = ShapeList.getInstance();
	}

	@Override
	public void run() {
		int minX = mouse.getMinX();
		int minY = mouse.getMinY();
		int width = mouse.getWidth();
		int height = mouse.getHeight();
		
		IShape shape = ShapeFactory.createRectangle(ShapeColor.WHITE, ShapeColor.WHITE, ShapeShadingType.OUTLINE, minX, minY, width, height);
		ArrayList<IShape> newList = new ArrayList<IShape>();
		newList.add(shape);
		shapeList.setSelectedShapes(newList);
	}
}
