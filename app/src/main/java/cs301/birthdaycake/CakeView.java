package cs301.birthdaycake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class CakeView extends SurfaceView {

   private CakeModel sharedCakeModel;

    /* These are the paints we'll use to draw the birthday cake below */
    Paint cakePaint = new Paint();
    Paint frostingPaint = new Paint();
    Paint candlePaint = new Paint();
    Paint outerFlamePaint = new Paint();
    Paint innerFlamePaint = new Paint();
    Paint wickPaint = new Paint();
    //lab4 paint
    Paint checkerRed = new Paint();
    Paint checkerGreen = new Paint();
    Paint baloonRect = new Paint();






    /* These constants define the dimensions of the cake.  While defining constants for things
        like this is good practice, we could be calculating these better by detecting
        and adapting to different tablets' screen sizes and resolutions.  I've deliberately
        stuck with hard-coded values here to ease the introduction for CS371 students.
     */
    public static final float cakeTop = 400.0f;
    public static final float cakeLeft = 100.0f;
    public static final float cakeWidth = 1200.0f;
    public static final float layerHeight = 200.0f;
    public static final float frostHeight = 50.0f;
    public static final float candleHeight = 300.0f;
    public static final float candleWidth = 60.0f;
    public static final float wickHeight = 30.0f;
    public static final float wickWidth = 6.0f;
    public static final float outerFlameRadius = 30.0f;
    public static final float innerFlameRadius = 15.0f;



    /**
     * ctor must be overridden here as per standard Java inheritance practice.  We need it
     * anyway to initialize the member variables
     */
    public CakeView(Context context, AttributeSet attrs) {




        super(context, attrs);

        sharedCakeModel = new CakeModel();                  //the New cakeModel used for everything

        //This is essential or your onDraw method won't get called
        setWillNotDraw(false);

        //Setup our palette
        //cakePaint.setColor(0xFFC755B5);  //violet-red
        cakePaint.setColor(0xFF32CD32);     //new color for lab 4
        cakePaint.setStyle(Paint.Style.FILL);
        frostingPaint.setColor(0xFFFFFACD);  //pale yellow
        frostingPaint.setStyle(Paint.Style.FILL);
        candlePaint.setColor(0xFF32CD32);  //lime green
        candlePaint.setStyle(Paint.Style.FILL);
        outerFlamePaint.setColor(0xFFFFD700);  //gold yellow
        outerFlamePaint.setStyle(Paint.Style.FILL);
        innerFlamePaint.setColor(0xFFFFA500);  //orange
        innerFlamePaint.setStyle(Paint.Style.FILL);
        wickPaint.setColor(Color.BLACK);
        wickPaint.setStyle(Paint.Style.FILL);
        //lab4 colors
        checkerRed.setColor(0xFFFF1111);
        checkerRed.setStyle(Paint.Style.FILL);
        checkerGreen.setColor(0xFF11FF11);
        checkerGreen.setStyle(Paint.Style.FILL);
        baloonRect.setColor(Color.BLUE);
        baloonRect.setStyle(Paint.Style.FILL);
        baloonRect.setStrokeWidth(33);

        setBackgroundColor(Color.WHITE);  //better than black default

    }


    public CakeModel getCakeModel(){
        return sharedCakeModel;
    }


    /**
     * draws a candle at a specified position.  Important:  the left, bottom coordinates specify
     * the position of the bottom left corner of the candle
     */
    public void drawCandle(Canvas canvas, float left, float bottom) {


        canvas.drawText(sharedCakeModel.displayText,1500,700,sharedCakeModel.modelPaint);

        if (sharedCakeModel.getHasCandles() == true) {
            canvas.drawRect(left, bottom - candleHeight, left + candleWidth, bottom, candlePaint);

            if (sharedCakeModel.getCandleLit() == true) {
                //draw the outer flame
                float flameCenterX = left + candleWidth / 2;
                float flameCenterY = bottom - wickHeight - candleHeight - outerFlameRadius / 3;
                canvas.drawCircle(flameCenterX, flameCenterY, outerFlameRadius, outerFlamePaint);

                //draw the inner flame
                flameCenterY += outerFlameRadius / 3;
                canvas.drawCircle(flameCenterX, flameCenterY, innerFlameRadius, innerFlamePaint);


            }
            //draw the wick
            float wickLeft = left + candleWidth / 2 - wickWidth / 2;
            float wickTop = bottom - wickHeight - candleHeight;
            canvas.drawRect(wickLeft, wickTop, wickLeft + wickWidth, wickTop + wickHeight, wickPaint);
        }
        }




    /**
     * onDraw is like "paint" in a regular Java program.  While a Canvas is
     * conceptually similar to a Graphics in javax.swing, the implementation has
     * many subtle differences.  Show care and read the documentation.
     *
     * This method will draw a birthday cake
     */



    @Override
    public void onDraw(Canvas canvas)
    {


        //top and bottom are used to keep a running tally as we progress down the cake layers
        float top = cakeTop;
        float bottom = cakeTop + frostHeight;

        //Frosting on top
        canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, frostingPaint);
        top += frostHeight;
        bottom += layerHeight;

        //Then a cake layer
        canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, cakePaint);
        top += layerHeight;
        bottom += frostHeight;

        //Then a second frosting layer
        canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, frostingPaint);
        top += frostHeight;
        bottom += layerHeight;

        //Then a second cake layer
        canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, cakePaint);



        //right candle
        if(sharedCakeModel.numCandles >0) {
            drawCandle(canvas, 700, cakeTop);

            if(sharedCakeModel.numCandles > 1) {
                drawCandle(canvas, cakeLeft + (3*cakeWidth/10), cakeTop);

                if(sharedCakeModel.numCandles >2) {
                    drawCandle(canvas, cakeLeft + (7*cakeWidth/10), cakeTop);

                    if(sharedCakeModel.numCandles>3) {

                        drawCandle(canvas, cakeLeft +  (cakeWidth / 10) - candleWidth / 3, cakeTop);

                        if(sharedCakeModel.numCandles>4) {
                            drawCandle(canvas, cakeLeft + (9*cakeWidth/10), cakeTop);
                        }
                    }

                }
            }
        }

        //person c
        canvas.drawRect(sharedCakeModel.xx, sharedCakeModel.yy - 200, sharedCakeModel.xx +200, sharedCakeModel.yy, checkerRed);
        canvas.drawRect(sharedCakeModel.xx, sharedCakeModel.yy + 200, sharedCakeModel.xx + 200, sharedCakeModel.yy, checkerGreen);
        canvas.drawRect(sharedCakeModel.xx - 200, sharedCakeModel.yy + 200, sharedCakeModel.xx, sharedCakeModel.yy, checkerRed);
        canvas.drawRect(sharedCakeModel.xx - 200, sharedCakeModel.yy - 200, sharedCakeModel.xx, sharedCakeModel.yy , checkerGreen);
        //person b
        canvas.drawLine(sharedCakeModel.xx,sharedCakeModel.yy,sharedCakeModel.xx, sharedCakeModel.yy+400,baloonRect);
        canvas.drawCircle(sharedCakeModel.xx, sharedCakeModel.yy, 100,baloonRect);
    }//onDraw

}//class CakeView

