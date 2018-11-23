package controller;

import model.ShapeList;
import model.commands.CopyShapeCommand;
import model.commands.CreateShapeCommand;
import model.commands.DeleteShapeCommand;
import model.commands.MoveShapeCommand;
import model.commands.PasteShapeCommand;
import model.commands.RedoCommand;
import model.commands.SelectShapeCommand;
import model.commands.UndoCommand;
import model.interfaces.IApplicationState;
import model.interfaces.ICommand;
import model.interfaces.IMouseDragStrategy;
import model.interfaces.IMouseReleasedStrategy;
import model.strategies.DrawMouseDragStrategy;
import model.strategies.DrawMouseReleasedStrategy;
import model.strategies.MoveMouseDragStrategy;
import model.strategies.MoveMouseReleasedStrategy;
import model.strategies.SelectMouseDragStrategy;
import model.strategies.SelectMouseReleasedStrategy;

public class CommandController {
	private static MouseHandler mouse;
	private static IApplicationState app;
	private static ShapeList shapeList;
	private static ICommand command = null;

	public static void setup(MouseHandler m, IApplicationState a) {
		mouse = m;
		app = a;
		shapeList = ShapeList.getInstance();
	}
	
	public static void mousePressed() {
		
		switch(app.getActiveStartAndEndPointMode()) {
		case DRAW:
			command = new CreateShapeCommand(mouse, app);
			break;
		case SELECT:
			command = new SelectShapeCommand(mouse);
			break;
		case MOVE:
			command = new MoveShapeCommand(mouse);
			break;
		default:
			break;
		}
		
		command.run();
	}
	
	public static void mouseDragged() {
		IMouseDragStrategy strat = null;
		
		switch(app.getActiveStartAndEndPointMode()) {
		case DRAW:
			strat = new DrawMouseDragStrategy(mouse);
			break;
		case SELECT:
			strat = new SelectMouseDragStrategy(mouse);
			break;
		case MOVE:
			strat = new MoveMouseDragStrategy(mouse, command);
			break;
		default:
			break;
		}
		
		strat.run();
		shapeList.updateShapes();
	}
	
	public static void mouseReleased() {
		IMouseReleasedStrategy strat = null;
		
		switch(app.getActiveStartAndEndPointMode()) {
		case DRAW:
			strat = new DrawMouseReleasedStrategy();
			break;
		case SELECT:
			strat = new SelectMouseReleasedStrategy(mouse);
			break;
		case MOVE:
			strat = new MoveMouseReleasedStrategy();
			break;
		default:
			break;
		}
		
		strat.run();
		shapeList.updateShapes();
	}
	
	public static void copyShape() {
		command = new CopyShapeCommand();
		command.run();
	}
	
	public static void pasteShape() {
		command = new PasteShapeCommand();
		command.run();
	}
	
	public static void deleteShape() {
		command = new DeleteShapeCommand();
		command.run();
	}
	
	public static void undo() {
		command = new UndoCommand();
		command.run();
	}
	
	public static void redo() {
		command = new RedoCommand();
		command.run();
	}
}
