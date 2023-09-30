package controller;

//import from our codebase
import model.GameState;

//import from java libraries
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartGameButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent actionEvent) 
    {
        Application.blueCardFinderGame.restart();
        //Application.blueCardFinderGame.setState(GameState.INITAL);
        Application.applicationWindow.updateWindow();

        //console debugging
        //System.out.println("New Game Button");
    }
}
