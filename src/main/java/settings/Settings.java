package settings;

public class Settings {
    private boolean isDisplayingHelpMessages;

    public Settings() {
        isDisplayingHelpMessages = true;
    }

    public void setDisplayingHelpMessages(boolean isDisplayingHelpMessages) {
        this.isDisplayingHelpMessages = isDisplayingHelpMessages;
    }

    public boolean getDisplayingHelpMessages() {
        return this.isDisplayingHelpMessages;
    }
}
