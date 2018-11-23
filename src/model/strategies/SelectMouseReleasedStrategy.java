package model.strategies;

import controller.MouseHandler;
import model.ShapeList;
import model.interfaces.IMouseReleasedStrategy;

public class SelectMouseReleasedStrategy implements IMouseReleasedStrategy {
	private ShapeList shapeList;
	private MouseHandler mouse;
	
	public SelectMouseReleasedStrategy(MouseHandler m) {
		mouse = m;
		shapeList = ShapeList.getInstance();
	}

	@Override
	public void run() {
		int minX = mouse.getMinX();
		int minY = mouse.getMinY();
		int maxX = minX + mouse.getWidth();
		int maxY = minY + mouse.getHeight();

		shapeList.selectShapes(minX, maxX, minY, maxY);
	}
}
