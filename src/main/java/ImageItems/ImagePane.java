package ImageItems;

import Builder.Joke;
import Builder.JokeBuilder;
import Builder.Director;
import javafx.animation.FadeTransition;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import ObserverItems.Interfaces.Observer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class ImagePane implements Observer {
    private Director jokeDirector;
    private final JokeBuilder jokeBuilder;
    private Joke joke;

    private Date date;
    private LocalTime time;
    private final FadeTransition fade = new FadeTransition();

    public ImagePane() {
        jokeBuilder = new JokeBuilder();
        jokeDirector = new Director();
        joke = jokeDirector.Construct(jokeBuilder);

        fade.setNode(this.joke.getPanel());
        fade.setCycleCount(1000);
    }

    public StackPane buildJoke() {
        return joke.getPanel();
    }


    @Override
    public void update() {
        time = LocalTime.now();
        if (time.getSecond() % 5 == 0){
            fade.setDuration(new Duration(1200));
            fade.setFromValue(0.0);
            fade.setToValue(1.0);
            fade.play();
            this.joke = new Director().Construct(jokeBuilder);
        }
        else{
            fade.stop();
        }
    }
}
