package Builder;

import Builder.Interfaces.IBuilder;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class JokeBuilder implements IBuilder {

    private final String fileTopic = new File("src//main//resources//Images//").getAbsolutePath() + "\\";
    private Joke joke = new Joke();
    private Text txt = new Text();

    private final List<Color> colors = List.of(Color.WHITE, Color.LIGHTBLUE, Color.BLACK, Color.LIGHTSEAGREEN, Color.LIGHTGREEN);
    private List<String> jokes = List.of("- Вы думаете, что я вас не переиграю?\n" +
                    "- Что я вас не уничтожу?\n",
            "Не, ну ты видел?\n Видел!?\n",
            "Думай... Главное \n думай...\n",
            "Мандарины и оливье на новый год\n",
            "У тебя не украдут код\n Если ты не будешь его разрабатывать\n");

    @Override
    public void setImage() {
        Image image = new Image(Paths.get(fileTopic + new Random().nextInt(1,5)  + ".jpg").toUri().toString());
        this.joke.addImage(image);
    }

    @Override
    public void setText() {
        txt.setText(jokes.get(new Random().nextInt(0, jokes.size())));
        this.joke.addText(txt);
    }

    @Override
    public void setFont() {
        txt.fontProperty().setValue(Font.font("Times New Roman", FontWeight.BOLD, 12));
    }

    @Override
    public void setColor() {
        txt.setFill(colors.get(new Random().nextInt(0,colors.size())));
    }

    @Override
    public Joke build() {
        return this.joke;
    }
}
