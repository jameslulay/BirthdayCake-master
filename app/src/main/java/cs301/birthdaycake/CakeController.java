package cs301.birthdaycake;

import android.util.Log;

import android.view.View;
import android.widget.TextView;

public class CakeController implements View.OnClickListener {

    private CakeView androidsCakeView; //declares a cakeView variable
    private CakeModel sharedCakeModel; //declares a cakemodel variable


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

}
