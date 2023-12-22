package TimeItems;

import ObserverItems.Interfaces.Observer;
import javafx.scene.text.Text;

import java.util.Date;


public class Time implements Observer {
    private final Text text = new Text();

    @Override
    public void update(Date date) {
        text.setText(date.toString());
    }

    public Text getTime(){
        return this.text;
    }
}