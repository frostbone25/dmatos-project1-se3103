package controller;

//import from our codebase
import model.BlueCardFinderGame;
import view.ApplicationWindow;

//import from java libraries
import javax.swing.JFrame;

//main application class
public class Application 
{
    public static final ApplicationWindow applicationWindow = new ApplicationWindow();
    public static final BlueCardFinderGame blueCardFinderGame = new BlueCardFinderGame();

    public static void main(String[] args)
    {
        applicationWindow.initalize();
        applicationWindow.setTitle("Find the Blue Card");
        applicationWindow.setLocation(300, 200);
        applicationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationWindow.pack();
        applicationWindow.setVisible(true);
        applicationWindow.setResizable(false);
    }
}
