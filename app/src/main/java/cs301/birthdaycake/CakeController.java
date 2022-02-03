package cs301.birthdaycake;

public class CakeController {

    private CakeView androidsCakeView;
    private CakeModel sharedCake = androidsCakeView.getCakeModel();


    public CakeController(CakeView createdCakeView){
    androidsCakeView = createdCakeView;

    }

}
