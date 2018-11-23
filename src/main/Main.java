package main;

import controller.CommandController;
import controller.IJPaintController;
import controller.JPaintController;
import controller.KeyHandler;
import controller.MouseHandler;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
        PaintCanvas canvas = PaintCanvas.getInstance();
        IGuiWindow guiWindow = new GuiWindow();
        IUiModule uiModule = new Gui(guiWindow);
        IApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();

        MouseHandler mouse = new MouseHandler();
        KeyHandler key = new KeyHandler();
        canvas.addMouseListener(mouse);
        canvas.addMouseMotionListener(mouse);
        canvas.addKeyListener(key);
        canvas.requestFocus();
        CommandController.setup(mouse, appState);
    }
}
