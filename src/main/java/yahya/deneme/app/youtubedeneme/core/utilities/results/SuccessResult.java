package yahya.deneme.app.youtubedeneme.core.utilities.results;

public class SuccessResult extends Result{

    public SuccessResult(boolean success) {
        super(success);
    }

    public SuccessResult(String message) {
        super(true,message);
    }
}
