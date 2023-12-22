package Builder;

public class Director {
    public Joke Construct(JokeBuilder builder){
        builder.setImage();
        builder.setFont();
        builder.setColor();
        builder.setText();
        return builder.build();
    }
}
