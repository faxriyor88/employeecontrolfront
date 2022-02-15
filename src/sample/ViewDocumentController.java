package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ViewDocumentController implements Initializable {

    @FXML
    private AnchorPane anchormuddatikelgan;


    @FXML
    private AnchorPane anchormuddatibor;

    @FXML
    private AnchorPane anchormuddatiotgan;

    @FXML
    private Tab muddatiotgan;

    @FXML
    private Tab muddatikelgan;

    @FXML
    private Tab muddatibor;

    @FXML
    private Button plus;
    @FXML
    private Button left;

    @FXML
    private Label labelotgan;

    @FXML
    private Label labelkelgan;

    @FXML
    private Label labelbor;

    @FXML
    private Text textotgan;

    @FXML
    private Text textkelgan;

    @FXML
    private Text textbor;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Parent bor = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("front/tabbortableview.fxml")));
            Parent otgan = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("front/tabotgantableview.fxml")));
            Parent kelgan = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("front/tabkelgantableview.fxml")));

            anchormuddatibor.getChildren().removeAll();
            anchormuddatibor.getChildren().setAll(bor);

            anchormuddatikelgan.getChildren().removeAll();
            anchormuddatikelgan.getChildren().setAll(kelgan);

            anchormuddatiotgan.getChildren().removeAll();
            anchormuddatiotgan.getChildren().setAll(otgan);
            textotgan.setText(TabOtganTableViewController.otgan);
            textkelgan.setText(TabKelganTableViewController.kelgan);
            textbor.setText(TabBorTableViewController.bor);


        } catch (IOException e) {
            e.printStackTrace();
        }


        left.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                try {
                    MainController mainController = new MainController();
                    mainController.loginPage(new Stage());
                    MainController.changeviewdocpage.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        labelbor.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                try {
                    Parent bor = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("front/tabbortableview.fxml")));
                    anchormuddatibor.getChildren().removeAll();
                    anchormuddatibor.getChildren().setAll(bor);
                    textbor.setText(TabBorTableViewController.bor);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        labelotgan.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                try {
                    Parent otgan = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("front/tabotgantableview.fxml")));
                    anchormuddatiotgan.getChildren().removeAll();
                    anchormuddatiotgan.getChildren().setAll(otgan);
                    textotgan.setText(TabOtganTableViewController.otgan);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        labelkelgan.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                try {
                    Parent kelgan = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("front/tabkelgantableview.fxml")));
                    anchormuddatikelgan.getChildren().removeAll();
                    anchormuddatikelgan.getChildren().setAll(kelgan);
                    textkelgan.setText(TabKelganTableViewController.kelgan);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
