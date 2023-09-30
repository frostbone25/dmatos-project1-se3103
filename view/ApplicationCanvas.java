package view;

//import from our codebase
import controller.Application;
import model.BlueCardFinderGame;

//import from java libraries
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class ApplicationCanvas extends JPanel
{
    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;

    final Color blueTextColor = Color.BLUE;
    final Color blueCardColor = Color.BLUE;
    final Color greenCardColor = Color.GREEN;
    final Color hiddenCardColor = new Color(70, 70, 70, 255);

    public ApplicationCanvas()
    {
        Dimension windowDimensions = new Dimension(WIDTH, HEIGHT);
        setPreferredSize(windowDimensions);
    }

    private void drawCards(Graphics2D graphics2D, BlueCardFinderGame blueCardFinderGame)
    {
        for(int i = 0; i < 3; i++)
        {
            float xOffset = 100 * i;            

            Rectangle2D.Float cardGraphic = new Rectangle2D.Float(100 + xOffset, 125, 80, 125);
            Ellipse2D.Float cardCircleGraphic = new Ellipse2D.Float(100 + xOffset, 125, 25, 25);

            switch(blueCardFinderGame.getState())
            {
                case INITAL:
                case BETTING:
                    graphics2D.setColor(hiddenCardColor);
                    break;
                case RESULTS:
                case FINISHED:
                    graphics2D.setColor(blueCardFinderGame.getBlueCardIndex() == i ? blueCardColor : greenCardColor);
            }

            graphics2D.fill(cardGraphic);

            boolean circleKeyVisibility = blueCardFinderGame.isShowKeyOn();
            circleKeyVisibility = circleKeyVisibility && blueCardFinderGame.getBlueCardIndex() == i;

            if(circleKeyVisibility)
            {
                graphics2D.setColor(blueCardColor);
                graphics2D.fill(cardCircleGraphic);
            }
        }
    }

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics;

        BlueCardFinderGame blueCardFinderGame = Application.blueCardFinderGame;

        switch(blueCardFinderGame.getState())
        {
            case INITAL:
                drawInitalCanvas(graphics2D, blueCardFinderGame);
                break;
            case BETTING:
                drawBettingCanvas(graphics2D, blueCardFinderGame);
                break;
            case RESULTS:
                drawResultsCanvas(graphics2D, blueCardFinderGame);
                break;
            case FINISHED:
                drawFinishedCanvas(graphics2D, blueCardFinderGame);
                break;
        }
    }

    private void drawInitalCanvas(Graphics2D graphics2D, BlueCardFinderGame blueCardFinderGame)
    {
        graphics2D.setFont(new Font("Courier New", Font.BOLD, 20));
        graphics2D.setColor(blueTextColor);

        graphics2D.drawString("Welcome to <Where Is The Blue Card>!", 50, 100);
        graphics2D.drawString("Press <New Game> to start", 50, 150);
    }

    private void drawBettingCanvas(Graphics2D graphics2D, BlueCardFinderGame blueCardFinderGame)
    {
        graphics2D.setFont(new Font("Courier New", Font.BOLD, 16));
        graphics2D.setColor(blueTextColor);

        if(blueCardFinderGame.getEstimatedBalance() <= 0)
        {
            graphics2D.drawString("No funds available.", 50, 50);
        }
        else
        {
            //graphics2D.drawString("Availabe Balance: " + blueCardFinderGame.getUserBalance(), 50, 50);
            graphics2D.drawString("Availabe Balance: " + blueCardFinderGame.getEstimatedBalance(), 50, 50);
        }

        graphics2D.drawString("Select a Card and bet amount.", 50, 75);

        drawCards(graphics2D, blueCardFinderGame);
    }

    private void drawResultsCanvas(Graphics2D graphics2D, BlueCardFinderGame blueCardFinderGame)
    {
        graphics2D.setFont(new Font("Courier New", Font.BOLD, 16));
        graphics2D.setColor(blueTextColor);

        //graphics2D.drawString("No funds available.", 50, 50);
        graphics2D.drawString("Availabe Balance: " + blueCardFinderGame.getUserBalance(), 50, 50);

        if(blueCardFinderGame.hasLostMoneyFromBet())
        {
            graphics2D.drawString("You lost $" + blueCardFinderGame.getCurrentBetAmount(), 50, 75);
        }
        else
        {
            graphics2D.drawString("You won $" + blueCardFinderGame.getCurrentBetAmount(), 50, 75);
        }

        drawCards(graphics2D, blueCardFinderGame);
    }

    private void drawFinishedCanvas(Graphics2D graphics2D, BlueCardFinderGame blueCardFinderGame)
    {
        graphics2D.setFont(new Font("Courier New", Font.BOLD, 16));
        graphics2D.setColor(blueTextColor);

        graphics2D.drawString("No funds available.", 50, 50);
        graphics2D.drawString("You lost $" + blueCardFinderGame.getCurrentBetAmount(), 50, 75);
        graphics2D.drawString("You may Restart the game", 50, 90);

        drawCards(graphics2D, blueCardFinderGame);
    }
}
