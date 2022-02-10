package cs301.birthdaycake;

import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class CakeController implements CompoundButton.OnCheckedChangeListener,View.OnClickListener,
        SeekBar.OnSeekBarChangeListener,View.OnTouchListener {

    private CakeView androidsCakeView; //declares a cakeView variable
    public CakeModel sharedCakeModel; //declares a cakemodel variable
    public SeekBar currentBar;
    public Paint tempPaint = new Paint();
    public int x,y;
    public String touchLoc;




    public CakeModel getCakeModel(){
        return sharedCakeModel;
    } //might not use, should use cakeview's

//hyhyy
    public CakeController(CakeView createdCakeView){  //ctor
    androidsCakeView = createdCakeView;               //instantiates the shared cake view
    sharedCakeModel = androidsCakeView.getCakeModel(); //gets the shared cake model
        tempPaint.setColor(0xFFFF0000);
        tempPaint.setStyle(Paint.Style.FILL);
        tempPaint.setTextSize(50);
        sharedCakeModel.modelPaint = tempPaint;
    }

    @Override
    public void onClick(View button) {    //onclick method for "blow out" button.
        Log.d("button", "HEY this is a test");
        sharedCakeModel.changeCandleLit(false);
        androidsCakeView.invalidate();
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
            if (sharedCakeModel.getHasCandles() ==true) {
                sharedCakeModel.changeHasCandles(false);
                androidsCakeView.invalidate();
            }
            else {
            sharedCakeModel.changeHasCandles(true);
            androidsCakeView.invalidate();
            }
        }


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
    sharedCakeModel.numCandles = i;
    androidsCakeView.invalidate();

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        x = (int)motionEvent.getX();
        y = (int)motionEvent.getY();
        sharedCakeModel.displayText = touchLoc;

        sharedCakeModel.xx = x;
        sharedCakeModel.yy = y;

        androidsCakeView.invalidate();

        return false;
    }
}
