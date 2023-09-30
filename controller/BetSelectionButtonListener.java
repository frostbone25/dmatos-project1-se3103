package controller;

//import from our codebase
import view.ApplicationWindow;

//import from java libraries
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BetSelectionButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        String actionCommand = actionEvent.getActionCommand();

        switch(actionCommand)
        {
            case ApplicationWindow.bettingTenAction:
                Application.blueCardFinderGame.setCurrentBetAmount(10);
                break;
            case ApplicationWindow.bettingTwentyAction:
                Application.blueCardFinderGame.setCurrentBetAmount(20);
                break;
            case ApplicationWindow.bettingThirtyAction:
                Application.blueCardFinderGame.setCurrentBetAmount(30);
                break;
        }

        Application.applicationWindow.updateWindow();

        //console debugging
        //System.out.println(event.getActionCommand());
    }
}