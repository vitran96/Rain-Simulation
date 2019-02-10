package sample;

import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Drop extends Line {

    private long speed = new Random().nextInt(4) + 2;
    private long y;

    public Drop (long x, long y, long endX, long endY) {
        super(x, y, endX, endY);
        this.y = y;
        super.setStroke(Color.WHITE);
    }

    public void fall() {
        if (super.getLayoutY() + y >= Main.H) {
            super.setLayoutY(0);
            speed = new Random().nextInt(3) + 1;
        }
        else {
            super.setLayoutY(super.getLayoutY() + speed);
            speed += 0.9;
        }
    }
}
