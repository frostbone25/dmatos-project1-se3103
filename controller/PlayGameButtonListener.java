package controller;

//import from our codebase
import model.GameState;

//import from java libraries
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class PlayGameButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent actionEvent) 
    {
        boolean isCardSelectionChecked = Application.applicationWindow.cardZeroButton.isSelected();
        isCardSelectionChecked = isCardSelectionChecked | Application.applicationWindow.cardOneButton.isSelected();
        isCardSelectionChecked = isCardSelectionChecked | Application.applicationWindow.cardTwoButton.isSelected();

        boolean isBetSelectionChecked = Application.applicationWindow.bettingTenButton.isSelected();
        isBetSelectionChecked = isBetSelectionChecked | Application.applicationWindow.bettingTwentyButton.isSelected();
        isBetSelectionChecked = isBetSelectionChecked | Application.applicationWindow.bettingThirtyButton.isSelected();

        if(isCardSelectionChecked && isBetSelectionChecked)
        {
            Application.blueCardFinderGame.play();
        }
        else
        {
            if(!isCardSelectionChecked)
            {
                JOptionPane.showMessageDialog(Application.applicationWindow, "Error: Select a card.");
            }
            else if(!isBetSelectionChecked)
            {
                JOptionPane.showMessageDialog(Application.applicationWindow, "Error: Select a Bet Amount.");
            }
        }

        Application.applicationWindow.updateWindow();

        //console debugging
        //System.out.println("New Game Button");
    }
}
