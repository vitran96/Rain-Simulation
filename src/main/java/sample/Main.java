package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main extends Application {

    public static final int W = 800, H = 600;
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

        for (int i = 0; i < 500; i++) {
            Random rn = new Random();
            long x = rn.nextInt(Main.W);
            long y = -rn.nextInt(500) - 400;
            long len = rn.nextInt(20) + 10;
            drops.add(new Drop(x, y, x, y + len));

        }

        root.getChildren().addAll(drops);

        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 2_000_000) {
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
    }

    public static void main(String[] args) {
        launch(args);
    }
}
