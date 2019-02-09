package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {

    private final int W = 800, H = 600;
    Line line = new Line(W/2, 0, W/2, 20);
    private float speed = 3;

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Rain Animation");
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(W, H);
        root.setStyle("-fx-background-color: black");

        line.setStroke(Color.WHITE);

        root.getChildren().addAll(line);

        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 10_000_000) {
                    update();
                    lastUpdate = now;
                }
            }
        };

        timer.start();


        return root;
    }

    private void update() {
        if (line.getLayoutY() >= H)
            line.setLayoutY(0);
        else
            line.setLayoutY(line.getLayoutY() + speed);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
