package model.strategies;

import java.util.ArrayList;

import controller.MouseHandler;
import model.ShapeList;
import model.commands.MoveShapeCommand;
import model.interfaces.ICommand;
import model.interfaces.IMouseDragStrategy;
import model.interfaces.IShape;

public class MoveMouseDragStrategy implements IMouseDragStrategy {
	private MouseHandler mouse;
	private ICommand command;
	
	
	public MoveMouseDragStrategy(MouseHandler m, ICommand c) {
		mouse = m;
		command = c;
	}
	
	@Override
	public void run() {
		ArrayList<IShape> selectedShapes = ShapeList.getInstance().getSelectedShapes();
		MoveShapeCommand move = (MoveShapeCommand)command;
		
		int newDeltaX = mouse.getEndingX() - mouse.getStartingX();
		int newDeltaY = mouse.getEndingY() - mouse.getStartingY();
		move.setDeltaX(newDeltaX);
		move.setDeltaY(newDeltaY);
		
		for (IShape shape : selectedShapes) {
			int tempX = move.getOriginXMap().get(shape);
			int tempY = move.getOriginYMap().get(shape);
			shape.setMinX(tempX + newDeltaX);
			shape.setMinY(tempY + newDeltaY);
		}
	}

}
