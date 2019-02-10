package sample;

import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Drop {
    private int speed;
    private Line line;
    private Random rn = new Random();

    public Drop() {
        speed = rn.nextInt(3) + 1;
        long x = rn.nextInt(Main.W);
        long y = -rn.nextInt(700);
        long len = rn.nextInt(20) + 10;
        line = new Line(x, y, x, y + len);
        line.setStroke(Color.WHITE);
        //super(x, y, x, y + len);


        //super.setLayoutX();
    }

    public void fall() {
        if (line.getLayoutY() >= Main.H) {
            line.setLayoutY(0);
            speed = rn.nextInt(3) + 1;
        }
        else {
            line.setLayoutY(line.getLayoutY() + speed);
            speed++;
        }
    }

    public Line getLine() {
        return line;
    }
}
