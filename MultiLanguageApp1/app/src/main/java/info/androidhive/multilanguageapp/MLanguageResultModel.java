package info.androidhive.multilanguageapp;

public class MLanguageResultModel {

    private boolean isChange;
    private String message;

    public MLanguageResultModel(boolean isChange, String message) {
        this.isChange = isChange;
        this.message = message;
    }

    public boolean isChange() {
        return isChange;
    }

    public void setChange(boolean change) {
        isChange = change;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
