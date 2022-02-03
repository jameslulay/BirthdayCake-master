package cs301.birthdaycake;

public class CakeController {

    private Cakeview androidsCakeView;
    private CakeModel sharedCake = androidsCakeView.getCakeModel;


    public CakeController(Cakeview createdCakeView){
    androidsCakeView = createdCakeView;

    }

}
