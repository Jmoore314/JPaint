package model;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class ColorMap {
	private static Map <ShapeColor, Color> colorMap = new HashMap<>();
	
	public static void setupColorMap() {
		colorMap.put(ShapeColor.BLACK, Color.black);
		colorMap.put(ShapeColor.BLUE, Color.blue);
		colorMap.put(ShapeColor.CYAN, Color.cyan);
		colorMap.put(ShapeColor.DARK_GRAY, Color.darkGray);
		colorMap.put(ShapeColor.GRAY, Color.gray);
		colorMap.put(ShapeColor.GREEN, Color.green);
		colorMap.put(ShapeColor.LIGHT_GRAY, Color.lightGray);
		colorMap.put(ShapeColor.MAGENTA, Color.magenta);
		colorMap.put(ShapeColor.ORANGE, Color.orange);
		colorMap.put(ShapeColor.PINK, Color.pink);
		colorMap.put(ShapeColor.RED, Color.red);
		colorMap.put(ShapeColor.WHITE, Color.white);
		colorMap.put(ShapeColor.YELLOW, Color.yellow);
	}
	
	public static Color getColor(ShapeColor col) {
		if(colorMap.isEmpty()) {
			setupColorMap();
		}
		return colorMap.get(col);
	}	
}
