package view;

//import from our codebase
import controller.Application;
import controller.BetSelectionButtonListener;
import controller.NewGameButtonListener;
import controller.PlayGameButtonListener;
import controller.RestartGameButtonListener;
import controller.ShowKeyButtonListener;
import controller.CardSelectionButtonListener;
import model.BlueCardFinderGame;

//import from java libraries
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class ApplicationWindow extends JFrame
{
    public static final String bettingTenAction = "$10";
    public static final String bettingTwentyAction = "$20";
    public static final String bettingThirtyAction = "$30";

    public static final String cardZeroAction = "Card0";
    public static final String cardOneAction = "Card1";
    public static final String cardTwoAction = "Card2";

    private ApplicationCanvas applicationCanvas;

    //top row
    public JRadioButton cardZeroButton;
    public JRadioButton cardOneButton;
    public JRadioButton cardTwoButton;

    //middle row
    public JRadioButton bettingTenButton;
    public JRadioButton bettingTwentyButton;
    public JRadioButton bettingThirtyButton;

    //bottom row
    private JCheckBox showKeyButton;
    private JButton playButton;
    private JButton newGameButton;
    private JButton restartButton;

    public void initalize()
    {
        Container contentPane = getContentPane();
        applicationCanvas = new ApplicationCanvas();
        contentPane.add(applicationCanvas, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(3, 1));
        contentPane.add(southPanel, BorderLayout.SOUTH);

        //||||||||||||||||||||||||||||||||| CARD SELECTION ROW |||||||||||||||||||||||||||||||||
        //||||||||||||||||||||||||||||||||| CARD SELECTION ROW |||||||||||||||||||||||||||||||||
        //||||||||||||||||||||||||||||||||| CARD SELECTION ROW |||||||||||||||||||||||||||||||||

        JPanel cardSelectionPanel = new JPanel();
        cardSelectionPanel.setBorder(new TitledBorder(""));

        cardZeroButton = new JRadioButton(cardZeroAction, false);
        cardOneButton = new JRadioButton(cardOneAction, false);
        cardTwoButton = new JRadioButton(cardTwoAction, false);

        CardSelectionButtonListener cardSelectionButtonListener = new CardSelectionButtonListener();
        cardZeroButton.addActionListener(cardSelectionButtonListener);
        cardOneButton.addActionListener(cardSelectionButtonListener);
        cardTwoButton.addActionListener(cardSelectionButtonListener);

        cardSelectionPanel.add(cardZeroButton);
        cardSelectionPanel.add(cardOneButton);
        cardSelectionPanel.add(cardTwoButton);

        southPanel.add(cardSelectionPanel);

        ButtonGroup cardSelectionButtonGroup = new ButtonGroup();
        cardSelectionButtonGroup.add(cardZeroButton);
        cardSelectionButtonGroup.add(cardOneButton);
        cardSelectionButtonGroup.add(cardTwoButton);

        //||||||||||||||||||||||||||||||||| BETTING AMOUNT SELECTION ROW |||||||||||||||||||||||||||||||||
        //||||||||||||||||||||||||||||||||| BETTING AMOUNT SELECTION ROW |||||||||||||||||||||||||||||||||
        //||||||||||||||||||||||||||||||||| BETTING AMOUNT SELECTION ROW |||||||||||||||||||||||||||||||||

        JPanel bettingAmountsPanel = new JPanel();
        bettingAmountsPanel.setBorder(new TitledBorder(""));

        bettingTenButton = new JRadioButton(bettingTenAction, false);
        bettingTwentyButton = new JRadioButton(bettingTwentyAction, false);
        bettingThirtyButton = new JRadioButton(bettingThirtyAction, false);

        BetSelectionButtonListener betSelectionButtonListener = new BetSelectionButtonListener();
        bettingTenButton.addActionListener(betSelectionButtonListener);
        bettingTwentyButton.addActionListener(betSelectionButtonListener);
        bettingThirtyButton.addActionListener(betSelectionButtonListener);

        bettingAmountsPanel.add(bettingTenButton);
        bettingAmountsPanel.add(bettingTwentyButton);
        bettingAmountsPanel.add(bettingThirtyButton);

        southPanel.add(bettingAmountsPanel);

        ButtonGroup bettingAmountsButtonGroup = new ButtonGroup();
        bettingAmountsButtonGroup.add(bettingTenButton);
        bettingAmountsButtonGroup.add(bettingTwentyButton);
        bettingAmountsButtonGroup.add(bettingThirtyButton);

        //||||||||||||||||||||||||||||||||| GAME ACTIONS ROW |||||||||||||||||||||||||||||||||
        //||||||||||||||||||||||||||||||||| GAME ACTIONS ROW |||||||||||||||||||||||||||||||||
        //||||||||||||||||||||||||||||||||| GAME ACTIONS ROW |||||||||||||||||||||||||||||||||

        JPanel actionPanel = new JPanel();

        showKeyButton = new JCheckBox("Show Key");
        playButton = new JButton("Play");
        newGameButton = new JButton("New Game");
        restartButton = new JButton("Restart");

        showKeyButton.addItemListener(new ShowKeyButtonListener());
        playButton.addActionListener(new PlayGameButtonListener());
        newGameButton.addActionListener(new NewGameButtonListener());
        restartButton.addActionListener(new RestartGameButtonListener());

        actionPanel.add(showKeyButton);
        actionPanel.add(playButton);
        actionPanel.add(newGameButton);
        actionPanel.add(restartButton);

        southPanel.add(actionPanel);

        updateWindow();
    }

    public void updateWindow()
    {
        BlueCardFinderGame blueCardFinderGame = Application.blueCardFinderGame;

        switch(blueCardFinderGame.getState())
        {
            case INITAL:
                showKeyButton.setEnabled(false);
                playButton.setEnabled(false);
                newGameButton.setEnabled(true);
                restartButton.setEnabled(false);

                bettingTenButton.setEnabled(false);
                bettingTwentyButton.setEnabled(false);
                bettingThirtyButton.setEnabled(false);

                cardZeroButton.setEnabled(false);
                cardOneButton.setEnabled(false);
                cardTwoButton.setEnabled(false);
                break;
            case BETTING:
                showKeyButton.setEnabled(true);
                playButton.setEnabled(true);
                newGameButton.setEnabled(false);
                restartButton.setEnabled(false);

                bettingTenButton.setEnabled(blueCardFinderGame.getUserBalance() >= 10);
                bettingTwentyButton.setEnabled(blueCardFinderGame.getUserBalance() >= 20);
                bettingThirtyButton.setEnabled(blueCardFinderGame.getUserBalance() >= 30);

                cardZeroButton.setEnabled(true);
                cardOneButton.setEnabled(true);
                cardTwoButton.setEnabled(true);
                break;
            case RESULTS:
                showKeyButton.setEnabled(false);
                playButton.setEnabled(false);
                newGameButton.setEnabled(true);
                restartButton.setEnabled(false);

                bettingTenButton.setEnabled(false);
                bettingTwentyButton.setEnabled(false);
                bettingThirtyButton.setEnabled(false);

                cardZeroButton.setEnabled(false);
                cardOneButton.setEnabled(false);
                cardTwoButton.setEnabled(false);
                break;
            case FINISHED:
                showKeyButton.setEnabled(false);
                playButton.setEnabled(false);
                newGameButton.setEnabled(false);
                restartButton.setEnabled(true);

                bettingTenButton.setEnabled(false);
                bettingTwentyButton.setEnabled(false);
                bettingThirtyButton.setEnabled(false);

                cardZeroButton.setEnabled(false);
                cardOneButton.setEnabled(false);
                cardTwoButton.setEnabled(false);
                break;
        }

        applicationCanvas.repaint();
    }
}
