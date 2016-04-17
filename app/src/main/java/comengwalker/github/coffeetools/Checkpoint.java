package comengwalker.github.coffeetools;

/**
 * Created by jeremy on 4/16/16.
 * Class used as checkpoint entries in timer and recipes
 */
public class Checkpoint {
    private long time;
    private String label;

    Checkpoint() {
        setTime(0);
        setLabel("");
    }

    Checkpoint(long time, String label) {
        setTime(time);
        setLabel(label);
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String text) {
        label = text;
    }
}
