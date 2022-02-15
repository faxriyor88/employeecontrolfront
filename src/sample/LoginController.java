package sample;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.connect.ConnectEmployeeController;
import sample.dto.ApiResponse;
import sample.dto.CompanyDTO;
import sample.dto.ManagerDtoOfDocumentEffector;
import sample.model.District;
import sample.model.Region;
import sample.service.Result;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Button salom;
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

   /* @FXML
    private StackPane stackpane;

    @FXML
    private Circle c1;*/

    public static List<Region> regions;
    public static List<District> districts;
    public static List<CompanyDTO> companyDTOS;
    public static List<ManagerDtoOfDocumentEffector> managerDtoOfDocumentEffectors;

    @Override

    public void initialize(URL location, ResourceBundle resources) {


        salom.setOnMouseClicked(event -> {

            if (event.getButton().equals(MouseButton.PRIMARY)) {

                ApiResponse login = null;
                try {
                    if (ConnectEmployeeController.netChecker()) {
                        login = ConnectEmployeeController.login(username.getText(), password.getText());
                        if (login.isSuccess()) {
                            if (login.getMessage().equals("DIRECTOR") || login.getMessage().equals("REGION")) {
                                MainController.dashBoardPage(new Stage());
                                MainController.changeloginpage.close();
                                regions = ConnectEmployeeController.sugRegion();
                                companyDTOS = ConnectEmployeeController.sugCompany();
                                districts = ConnectEmployeeController.sugAllDistrict();
                            }
                            if (login.getMessage().equals("PERFORM")){
                                MainController.viewDocumentPage(new Stage());
                                MainController.changeloginpage.close();
                            }
                            if (login.getMessage().equals("ADDDOCUMENT")){
                                MainController.viewAndAddDocumentPage(new Stage());
                                MainController.changeloginpage.close();
                                managerDtoOfDocumentEffectors=ConnectEmployeeController.sugManagerOfDocumentEffector();
                            }

                        } else {
                            password.setStyle("-fx-border-color: red");
                            username.setStyle("-fx-border-color: red");
                            //  Result.failWindow(login.getMessage());
                        }
                    } else {
                        Result.netResult("Internet ulanishingizni tekshiring va qayta ulanib ko'ring");
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        username.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                username.setStyle("-fx-border-color: white");
            }
        });
        password.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                password.setStyle("-fx-border-color: white;");
            }
        });

    }

//    public RotateTransition setRotate(Circle c, boolean reverse, int angle, int duration) {
//        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration), c);
//        //rotateTransition.setAutoReverse(reverse);
//        rotateTransition.setByAngle(angle);
//        rotateTransition.setRate(10);
//        rotateTransition.setCycleCount(50);
//        rotateTransition.play();
//
//        return rotateTransition;
//    }

    public static List<District> getAllDistricts(int regionId) {
        List<District> list = new ArrayList<>();
        for (District d : districts) {
            if (d.getRegion().getId() == regionId) {
                list.add(d);
            }
        }
        return list;
    }


}