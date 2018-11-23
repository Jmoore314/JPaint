package model.strategies;

import java.util.ArrayList;

import controller.MouseHandler;
import model.ShapeList;
import model.interfaces.IMouseDragStrategy;
import model.interfaces.IShape;

public class DrawMouseDragStrategy implements IMouseDragStrategy {
	private MouseHandler mouse;

	public DrawMouseDragStrategy(MouseHandler m) {
		mouse = m;
	}

	@Override
	public void run() {
		ArrayList<IShape> selectedShapes = ShapeList.getInstance().getSelectedShapes();
		
		for (IShape shape : selectedShapes) {
			shape.setMinX(mouse.getMinX());
			shape.setMinY(mouse.getMinY());
			shape.setWidth(mouse.getWidth());
			shape.setHeight(mouse.getHeight());
		}
	}

}
