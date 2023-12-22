package ShapeSlideItems;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import ObserverItems.Interfaces.Observer;

import java.util.Date;

public class ShapeSlide extends StackPane implements Observer {
    private final double height = 300;

    private final double width = 300;

    private final double heightRect = 50;

    private final double widthRect = 100;

    Canvas canvas = new Canvas(width, height);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    @Override
    public void update(Date date) {
        if (date.getSeconds() % 2 == 0){
            this.drawRectangle(gc);
            System.out.println("Start rect");
        }
        else if (date.getSeconds() % 3 == 0)
        {
            this.drawCircle(gc);
            System.out.println("Start circle");
        }
    }
    public ShapeSlide() {

        this.panel.getChildren().add(canvas);

    }
    private final StackPane panel = new StackPane();
    public StackPane getPanel(){
        return this.panel;
    }

    public void drawRectangle(GraphicsContext gc){
        double centerX = width / 2;
        double centerY = height / 2;

        double rectX = centerX - widthRect / 2;
        double rectY = centerY - heightRect / 2;

        Rectangle rectangle = new Rectangle(rectX, rectY, widthRect, heightRect);
        rectangle.setStroke(Color.BLUE);

        gc.clearRect(0, 0, width, height);
        gc.setStroke(rectangle.getStroke());
        gc.strokeRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }

    public void drawCircle(GraphicsContext gc){
        double centerX = width / 2;
        double centerY = height / 2;
        double radius = Math.min(centerX, centerY) * 0.7;

        gc.clearRect(0, 0, width, height);


        gc.setStroke(Color.AQUA);
        gc.strokeOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
    }
}
