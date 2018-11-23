package model;

import java.util.ArrayList;

import model.interfaces.IShape;
import view.DrawShape;
import view.gui.PaintCanvas;

public class ShapeList {
	private static final ShapeList instance = new ShapeList();
	private final ArrayList<IShape> listOfShapes;
	private ArrayList<IShape> selectedShapeList;
	private ArrayList<IShape> copiedShapeList;
	
	private ShapeList() {
		listOfShapes = new ArrayList<IShape>();
		selectedShapeList = new ArrayList<IShape>();
	}
	
	public static ShapeList getInstance() {
		return instance;
	}
	
	public void addShape(IShape shape) {
		clearSelectedShapes();
		listOfShapes.add(shape);
	}
	
	public void removeShape(IShape shape) {
		clearSelectedShapes();
		listOfShapes.remove(shape);
	}
	
	public IShape findShape(IShape toFind) {
		return listOfShapes.get(listOfShapes.indexOf(toFind));
	}
	
	public void updateShapes() {
		PaintCanvas canvas = PaintCanvas.getInstance();
		canvas.clear();
		for (IShape shape : listOfShapes) {
			DrawShape.draw(shape);
		}
		drawSelectedBorders();
		canvas.requestFocus();
	}
	
	public ArrayList<IShape> selectShapes(int selectedMinX, int selectedMaxX, int selectedMinY, int selectedMaxY) {
		clearSelectedShapes();
		
		for (IShape shape : listOfShapes) {
			//get the top left point
			int shapeMinX = shape.getMinX();
			int shapeMinY = shape.getMinY();
			//get the bottom right point
			int shapeMaxX = shapeMinX + shape.getWidth();
			int shapeMaxY = shapeMinY + shape.getHeight();
			//check for shapes not inside bounds (shorter than if they are)
			if ((selectedMinX > shapeMaxX) || (shapeMinX > selectedMaxX)) {
				continue; // if one shape is to the left of the other, skip it
			}
			
			if ((selectedMinY > shapeMaxY) || (shapeMinY > selectedMaxY)) {
				continue; // if one shape is above the other, skip it;
			}
			
			selectedShapeList.add(shape); // otherwise add the shape to the list
		}
		drawSelectedBorders();
		return selectedShapeList;
	}
	
	public ArrayList<IShape> getSelectedShapes() {
		return selectedShapeList;
	}
	
	public void setSelectedShapes(ArrayList<IShape> newList) {
		selectedShapeList = newList;
		drawSelectedBorders();
	}
	
	public void drawSelectedBorders() {
		for (IShape selected: selectedShapeList) {
			DrawShape.select(selected);
		}
	}
	
	public void clearSelectedShapes() {
		if (selectedShapeList.size() != 0) {
			selectedShapeList = new ArrayList<IShape>();
			updateShapes();
		}
	}

	public ArrayList<IShape> getCopiedShapes() {
		return copiedShapeList;
	}

	public void setCopiedShapes(ArrayList<IShape> copiedShapes) {
		copiedShapeList = copiedShapes;
	}
	
	
}
