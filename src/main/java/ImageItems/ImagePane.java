package ImageItems;

import Builder.Joke;
import Builder.JokeBuilder;
import Builder.Director;
import javafx.animation.FadeTransition;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import ObserverItems.Interfaces.Observer;

import java.util.Date;

public class ImagePane implements Observer {
    private Director jokeDirector;
    private final JokeBuilder jokeBuilder;
    private Joke joke;
    private final FadeTransition fade = new FadeTransition();
    {
    fade.setDuration(new Duration(1200));
            fade.setFromValue(0.0);
            fade.setToValue(1.0);
    } // это инициализация
    
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
    public void update(Date date) {//  время считать самостоятельно в компоненте
        if (date.getSeconds() % 5 == 0){
           
            fade.play();
            this.joke = new Director().Construct(jokeBuilder);
        }
        else{
            fade.stop();
        }
    }
}
