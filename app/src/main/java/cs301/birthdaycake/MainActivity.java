package cs301.birthdaycake;
import android.view.View;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    CakeController newController;
    CakeModel sharedCakeModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        CakeView cakeRef = findViewById(R.id.cakeview);
        newController = new CakeController(cakeRef);

        Button blowButton = findViewById(R.id.button);
        blowButton.setOnClickListener(newController);

        sharedCakeModel = cakeRef.getCakeModel();
        boolean candleLit = sharedCakeModel.getCandleLit();





    }
    public void goodbye(View button) {
        Log.i("button", "Goodbye");
    }

}
