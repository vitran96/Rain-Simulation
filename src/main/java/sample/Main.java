package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main extends Application {

    public static final int W = 800, H = 600;
    //Line line = new Line(W/2, 0, W/2, 20);
    //private float speed = 3;
    List<Drop> drops;

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

        drops = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            drops.add(new Drop());
        }

        //line.setStroke(Color.WHITE);

        root.getChildren().addAll(drops.stream().map(Drop::getLine).collect(Collectors.toList()));

        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 60_000_000) {
                    update();
                    lastUpdate = now;
                }
            }
        };

        timer.start();


        return root;
    }

    private void update() {
        drops.stream().forEach(Drop::fall);
//        if (line.getLayoutY() >= H)
//            line.setLayoutY(0);
//        else
//            line.setLayoutY(line.getLayoutY() + speed);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
