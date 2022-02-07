package cs301.birthdaycake;
import android.view.View;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    CakeController newController;
    CakeModel sharedCakeModel;
    Switch switchHasCandles;
    SeekBar howManyCandles;
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

        switchHasCandles= findViewById(R.id.candlesswitch);
        switchHasCandles.setOnCheckedChangeListener(newController);

        howManyCandles = findViewById(R.id.seekbarID);
        howManyCandles.setOnSeekBarChangeListener(newController);





    }
    public void goodbye(View button) {
        Log.i("button", "Goodbye");
    }

}
