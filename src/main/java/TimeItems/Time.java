package TimeItems;

import ObserverItems.Interfaces.Observer;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


public class Time implements Observer {
    private final Text text = new Text();

    private LocalTime time;

    @Override
    public void update() {
        time = LocalTime.now();
        text.setText(time.toString());
    }

    public Text getTime(){
        return this.text;
    }
}