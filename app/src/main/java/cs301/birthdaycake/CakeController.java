package cs301.birthdaycake;

import android.util.Log;

import android.view.View;
import android.widget.TextView;

public class CakeController implements View.OnClickListener {

    private CakeView androidsCakeView;
    private CakeModel sharedCakeModel;

    public CakeModel getCakeModel(){
        return sharedCakeModel;
    }


    public CakeController(CakeView createdCakeView){
    androidsCakeView = createdCakeView;
    sharedCakeModel = androidsCakeView.getCakeModel();
    }

    @Override
    public void onClick(View button) {
        Log.d("button2", "HEY this is a test");
    }

}
