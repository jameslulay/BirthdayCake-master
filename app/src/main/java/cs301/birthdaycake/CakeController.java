package cs301.birthdaycake;

import android.util.Log;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class CakeController implements CompoundButton.OnCheckedChangeListener,View.OnClickListener,
        SeekBar.OnSeekBarChangeListener,View.OnTouchListener {

    private CakeView androidsCakeView; //declares a cakeView variable
    private CakeModel sharedCakeModel; //declares a cakemodel variable
    public SeekBar currentBar;



    public CakeModel getCakeModel(){
        return sharedCakeModel;
    } //might not use, should use cakeview's


    public CakeController(CakeView createdCakeView){  //ctor
    androidsCakeView = createdCakeView;               //instantiates the shared cake view
    sharedCakeModel = androidsCakeView.getCakeModel(); //gets the shared cake model
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

        return false;
    }
}
