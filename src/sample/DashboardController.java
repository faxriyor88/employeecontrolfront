package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.model.Password;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private VBox VBoxButton;

    @FXML
    private Button viewButton;

    @FXML
    private Button addButton;

    @FXML
    private Button exitButton;

    @FXML
    private HBox HBoxbutton;

    @FXML
    private StackPane contentArea;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("front/viewemp.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);

        } catch (IOException e) {
            e.printStackTrace();
        }
        addButton.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                Stage stage = new Stage();
                AddEmpController.addEmpStage = stage;
                MainController.addPage(stage);
            }
        });

        viewButton.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                try {
                    Parent fxml = FXMLLoader.load(getClass().getResource("front/viewemp.fxml"));
                    contentArea.getChildren().removeAll();
                    contentArea.getChildren().setAll(fxml);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        exitButton.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
              MainController mainController=new MainController();
                try {
                    mainController.loginPage(new Stage());
                    MainController.changeDashboardpage.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

//        deleteButton.setOnMouseClicked(event -> {
//            if (event.getButton().equals(MouseButton.PRIMARY)) {
//                try {
//                    Parent fxml = FXMLLoader.load(getClass().getResource("front/deleteemp.fxml"));
//                    contentArea.getChildren().removeAll();
//                    contentArea.getChildren().setAll(fxml);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });


    }

    public void setAnchorpane(AnchorPane anchorpane) {
        this.anchorpane = anchorpane;
    }

    public StackPane getContentArea() {
        return contentArea;
    }


//    public void view() throws IOException {
//        Parent fxml = FXMLLoader.load(getClass().getResource("front/viewemp.fxml"));
//        this.contentArea.getChildren().removeAll();
//        this.contentArea.getChildren().setAll(fxml);
//    }
}
