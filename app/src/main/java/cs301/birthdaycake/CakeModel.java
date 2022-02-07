package cs301.birthdaycake;

public class CakeModel {

    public boolean candleLit = true; //turns candlelight on or off

    public int numCandles = 2;

    public boolean frosting = true;

    public boolean hasCandles = true;


    public boolean getCandleLit(){ //getter for candle light
        return candleLit;
    }

    public void changeCandleLit(boolean candleLit){ //sets candle light
        this.candleLit = candleLit;
    }

    public void changeHasCandles(boolean hasCandles){
        this.hasCandles = hasCandles;
    }

    public boolean getHasCandles(){
        return hasCandles;
    }






}
