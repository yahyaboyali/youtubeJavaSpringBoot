package yahya.deneme.app.youtubedeneme.core.utilities.results;

public class ErrorResult extends Result{

    public ErrorResult(boolean success) {
        super(success);
    }

    public ErrorResult(String message) {
        super(false, message);
    }
}
