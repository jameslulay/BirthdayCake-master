package cs301.birthdaycake;

import android.graphics.Paint;

public class CakeModel {

    public boolean candleLit = true; //turns candlelight on or off

    public int numCandles = 2;

    public boolean frosting = true;

    public boolean hasCandles = true;


    public int xx;
    public int yy;

    //public Paint modelPaint;

   // public String displayText = "touch";


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
