package game.character;

public class SC extends Character{

    private boolean isFriendly;
    private String dialog;

    public SC() {
    }

    public boolean isFriendly() {
        return isFriendly;
    }

    public String getDialog() {
        return dialog;
    }

    @Override
    public String toString() {
        return name + ": životy: " + health;
    }

    public void setFriendly(boolean friendly) {
        isFriendly = friendly;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }
}
