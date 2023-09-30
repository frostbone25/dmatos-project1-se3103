package model;

//import from java libraries
import java.util.Random;

public class BlueCardFinderGame 
{
    private int blueCardIndex;
    private int userCardIndex;
    private int userBalance;
    private int previousUserBalance;
    private int currentBetAmount;
    private boolean showKeyOn;
    private GameState state;

    public BlueCardFinderGame()
    {
        blueCardIndex = -1;
        userCardIndex = -1;
        showKeyOn = false;
        userBalance = 50;
        previousUserBalance = userBalance;
        state = GameState.INITAL;
    }

    public void start()
    {
        blueCardIndex = generateNewBlueCardIndex();
        userCardIndex = -1;
        state = GameState.BETTING;
    }

    public void restart()
    {
        blueCardIndex = generateNewBlueCardIndex();
        userCardIndex = -1;
        userBalance = 50;
        previousUserBalance = userBalance;
        state = GameState.BETTING;
    }

    private int generateNewBlueCardIndex()
    {
        Random random = new Random();
        int newBlueCardIndex;

        do
        {
            newBlueCardIndex = random.nextInt(3);
        } 
        while(newBlueCardIndex == blueCardIndex);

        return newBlueCardIndex;
    }

    public void setInitalBet(int userBetAmount)
    {
        currentBetAmount = userBetAmount;
    }

    public void setInitalCardGeuss(int userCardIndexGeuss)
    {
        userCardIndex = userCardIndexGeuss;
    }

    public int getEstimatedBalance()
    {
        return userBalance - currentBetAmount;
    }

    public int getBalanceDifference()
    {
        return userBalance - previousUserBalance;
    }

    public boolean hasLostMoneyFromBet()
    {
        return userBalance - previousUserBalance < 0;
    }

    public void play()
    {
        this.state = GameState.RESULTS;
        this.previousUserBalance = this.userBalance;

        if(userCardIndex == blueCardIndex)
        {
            this.userBalance += currentBetAmount;
        }
        else
        {
            this.userBalance -= currentBetAmount;

            if(this.userBalance <= 0)
            {
                this.userBalance = 0;
                this.state = GameState.FINISHED;
            }
        }
    }

    public GameState getState()
    {
        return state;
    }

    public void setState(GameState state)
    {
        this.state = state;
    }

    public boolean isShowKeyOn()
    {
        return showKeyOn;
    }

    public void setShowKeyOn(boolean showKeyOn)
    {
        this.showKeyOn = showKeyOn;
    }

    public int getUserCardIndex()
    {
        return userCardIndex;
    }

    public void setUserCardIndex(int userCardIndex)
    {
        this.userCardIndex = userCardIndex;
    }

    public int getBlueCardIndex()
    {
        return blueCardIndex;
    }

    public void setBlueCardIndex(int blueCardIndex)
    {
        this.blueCardIndex = blueCardIndex;
    }

    public int getUserBalance()
    {
        return userBalance;
    }

    public void setUserBalance(int userBalance)
    {
        this.userBalance = userBalance;
    }

    public int getCurrentBetAmount()
    {
        return currentBetAmount;
    }

    public void setCurrentBetAmount(int currentBetAmount)
    {
        this.currentBetAmount = currentBetAmount;
    }

    @Override
    public String toString()
    {
        //return String.format("key(%d) guess(%d) attempts(%d)", key, geuss, attempts);
        return "";
    }
}
