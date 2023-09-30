package controller;

//import from our codebase
import model.GameState;

//import from java libraries
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent actionEvent) 
    {
        Application.blueCardFinderGame.start();
        //Application.blueCardFinderGame.setState(GameState.BETTING);
        Application.applicationWindow.updateWindow();

        //console debugging
        //System.out.println("New Game Button");
    }
}
