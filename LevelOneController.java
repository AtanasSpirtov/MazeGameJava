package sample;

import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class LevelOneController {


    @FXML
    Arc levelOneArc;
    @FXML
    Rectangle rectLevel1B;
    @FXML
    Rectangle rectLevel1A;
    @FXML
    Button buttonFinish;

    @FXML
    ToggleButton toggleStart;
    @FXML
    Rectangle gameField;

    PathTransition firstLevelaAnim1 = new PathTransition();
    PathTransition firstLevelaAnim2 = new PathTransition();
    RotateTransition firstLevelAnim3 = new RotateTransition();

    @FXML
    void onMouseExcited(MouseEvent mouseEvent) {


        if(!toggleStart.isSelected())
        {
            return;
        }
        stopGame();


        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("loseDialog.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Hello World");
        stage.setScene(new Scene(root));
        stage.show();
    }



    void stopGame() {
        toggleStart.setSelected(false);
        toggleStart.setText("Start");
        System.out.println("Game Over");


        firstLevelaAnim1.jumpTo(Duration.ZERO);
        firstLevelaAnim1.stop();

        firstLevelaAnim2.jumpTo(Duration.ZERO);
        firstLevelaAnim2.stop();

        firstLevelAnim3.jumpTo(Duration.ZERO);
        firstLevelAnim3.stop();
    }

    @FXML
    void onFinish(ActionEvent actionEvent) {
        if(!toggleStart.isSelected())
        {
            return;
        }
        System.out.println("You Win");
    }

    @FXML
    void onStart(ActionEvent actionEvent) {
        if(toggleStart.isSelected())
        {
            startgame();

        }else
            {
                stopGame();
        }

    }

    void startgame() {
        toggleStart.setText("Stop");
        System.out.println("Game Started");


        //Line Moving Animatiion 1
        double middleXAnim1 = (rectLevel1A.getX() + rectLevel1A.getWidth())/2d;
        double middleYAnim1 = (rectLevel1A.getY() + rectLevel1A.getHeight())/2d;
        firstLevelaAnim1.setNode(rectLevel1A);
        Path p1 = new Path(new MoveTo(middleXAnim1 , middleYAnim1));
        p1.getElements().add(new HLineTo(150d));
        firstLevelaAnim1.setPath(p1);
        firstLevelaAnim1.setDuration(Duration.seconds(2));
        firstLevelaAnim1.setCycleCount(Timeline.INDEFINITE);
        firstLevelaAnim1.setAutoReverse(true);
        firstLevelaAnim1.play();




        //Line Moving Animatiion 2
        double middleXAnim2 = (rectLevel1B.getX() + rectLevel1B.getWidth())/2d;
        double middleYAnim2 = (rectLevel1B.getY() + rectLevel1B.getHeight())/2d;
        firstLevelaAnim2.setNode(rectLevel1B);
        Path p2 = new Path(new MoveTo(middleXAnim2 , middleYAnim2));
        p2.getElements().add(new HLineTo(150d));
        firstLevelaAnim2.setPath(p2);
        firstLevelaAnim2.setDuration(Duration.seconds(2));
        firstLevelaAnim2.setCycleCount(Timeline.INDEFINITE);
        firstLevelaAnim2.setAutoReverse(true);
        firstLevelaAnim2.play();



        //Arc Cycling Animation 3
        firstLevelAnim3.setNode(levelOneArc);
        firstLevelAnim3.setToAngle(180);
        firstLevelAnim3.setDuration(Duration.seconds(1d));
        firstLevelAnim3.setCycleCount(Timeline.INDEFINITE);
        firstLevelAnim3.setAutoReverse(true);
        firstLevelAnim3.play();

    }
}
