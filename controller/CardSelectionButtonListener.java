package controller;

//import from our codebase
import view.ApplicationWindow;

//import from java libraries
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardSelectionButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        String actionCommand = actionEvent.getActionCommand();

        switch(actionCommand)
        {
            case ApplicationWindow.cardZeroAction:
                Application.blueCardFinderGame.setInitalCardGeuss(0);
                break;
            case ApplicationWindow.cardOneAction:
                Application.blueCardFinderGame.setInitalCardGeuss(1);
                break;
            case ApplicationWindow.cardTwoAction:
                Application.blueCardFinderGame.setInitalCardGeuss(2);
                break;
        }

        Application.applicationWindow.updateWindow();

        //console debugging
        //System.out.println(event.getActionCommand());
    }
}