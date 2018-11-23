package controller;

import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.InputMap;
import javax.swing.KeyStroke;
import javax.swing.event.*;

public class KeyHandler extends KeyAdapter {
    private final Set<Integer> pressed = new HashSet<Integer>();
    private final Set<Integer> undoPC = new HashSet<Integer>() {{ add(KeyEvent.VK_CONTROL); add(KeyEvent.VK_Z); }};
    private final Set<Integer> undoMac = new HashSet<Integer>() {{ add(157); add(KeyEvent.VK_Z); }}; //Mac Command is key 157
    private final Set<Integer> redoPC = new HashSet<Integer>() {{ add(KeyEvent.VK_CONTROL); add(KeyEvent.VK_Y); }};
    private final Set<Integer> redoMac = new HashSet<Integer>() {{ add(157); add(KeyEvent.VK_Y); }}; //Mac Command is key 157
    private final Set<Integer> copyPC = new HashSet<Integer>() {{ add(KeyEvent.VK_CONTROL); add(KeyEvent.VK_C); }};
    private final Set<Integer> copyMac = new HashSet<Integer>() {{ add(157); add(KeyEvent.VK_C); }}; //Mac Command is key 157
    private final Set<Integer> pastePC = new HashSet<Integer>() {{ add(KeyEvent.VK_CONTROL); add(KeyEvent.VK_V); }};
    private final Set<Integer> pasteMac = new HashSet<Integer>() {{ add(157); add(KeyEvent.VK_V); }}; //Mac Command is key 157
    private final Set<Integer> deletePC = new HashSet<Integer>() {{ add(KeyEvent.VK_DELETE); }};
    private final Set<Integer> deleteMac = new HashSet<Integer>() {{ add(8); }}; //Mac Delete is key 8
    
	
	public KeyHandler() {
		super();
	}
	
    @Override
    public synchronized void keyPressed(KeyEvent key) {
//    	System.out.println(key.getKeyCode());
//    	System.out.println("Delete key is: " + KeyEvent.VK_DELETE);
        pressed.add(key.getKeyCode());
        if (pressed.size() > 1) {
        	if (pressed.containsAll(undoPC) || pressed.containsAll(undoMac)) {
        		CommandController.undo();
        	} else if (pressed.containsAll(redoPC) || pressed.containsAll(redoMac)) {
        		CommandController.redo();
        	} else if (pressed.containsAll(copyPC) || pressed.containsAll(copyMac)) {
        		CommandController.copyShape();
        	} else if (pressed.containsAll(pastePC) || pressed.containsAll(pasteMac)) {
        		CommandController.pasteShape();
        	}
        } else {
        	if (pressed.containsAll(deletePC) || pressed.containsAll(deleteMac)) {
        		CommandController.deleteShape();
        	}
        }
    }

    @Override
    public synchronized void keyReleased(KeyEvent key) {
        pressed.remove(key.getKeyCode());
    }
}
