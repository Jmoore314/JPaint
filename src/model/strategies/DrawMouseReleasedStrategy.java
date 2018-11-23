package model.strategies;

import model.ShapeList;
import model.interfaces.IMouseReleasedStrategy;

public class DrawMouseReleasedStrategy implements IMouseReleasedStrategy {
	private ShapeList shapeList;
	
	public DrawMouseReleasedStrategy() {
		shapeList = ShapeList.getInstance();
	}

	@Override
	public void run() {
		shapeList.clearSelectedShapes();
	}
}
