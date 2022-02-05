package sample;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    @FXML
    private Circle c1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       setRotate(c1,true,360,30);
//       setRotate(c2,true,180,25);
//       setRotate(c3,true,145,25);
    }
    public void setRotate(Circle c,boolean reverse,int angle,int duration){
        RotateTransition rotateTransition=new RotateTransition(Duration.seconds(duration),c);
        rotateTransition.setAutoReverse(reverse);
        rotateTransition.setByAngle(angle);
        rotateTransition.setRate(10);
        rotateTransition.setCycleCount(50);
        rotateTransition.play();
    }
}
