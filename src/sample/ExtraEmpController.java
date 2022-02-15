package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.connect.ConnectEmployeeController;
import sample.dto.CompanyDTO;
import sample.dto.EmployeeAdditonalDTO;
import sample.dto.InformationAboutRelativeDTO;
import sample.dto.MehnatFaoliyatiDto;
import sample.model.District;
import sample.model.Employee;
import sample.model.Region;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ExtraEmpController implements Initializable {
    @FXML
    private ScrollPane scrrollPane;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private VBox vboxMain;

    @FXML
    private Label ismi;

    @FXML
    private Label familyasi;

    @FXML
    private Label sharifi;

    @FXML
    private Label birthday;

    @FXML
    private Label birthdayplace;

    @FXML
    private Label ishjoyi;

    @FXML
    private Label lavozimi;

    @FXML
    private Label millati;

    @FXML
    private Label malboymutaxasisligi;

    @FXML
    private Label ilmiydaraja;

    @FXML
    private Label qaysichettili;

    @FXML
    private Label malumoti;

    @FXML
    private Label saylovorganiazosi;

    @FXML
    private Label partiyaviyligi;

    @FXML
    private Label ilmiyunvoni;

    @FXML
    private Label harbiyunvoni;

    @FXML
    private Label davlatmukofoti;

    @FXML
    private Label tamomlaganjoyi;

    @FXML
    private Label imageName;

    @FXML
    private Button uploadImage;

    @FXML
    private VBox VboxRelative;

    @FXML
    private VBox VboxCarOfLabor;

    private short n = 0;
    private short k = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (ViewEmpController.permission) {
            ViewEmpController.permission = false;
            Employee e = ViewEmpController.employeeTrans;
            EmployeeAdditonalDTO extra = ViewEmpController.additonalTrans;
            String[] split = e.getFullname().split(" ");
            ishjoyi.setPrefHeight(100);

            ismi.setText(split[1]);
            familyasi.setText(split[0]);
            sharifi.setText(split[2]);
            birthday.setText(e.getBirthday());
            ishjoyi.setText(e.getCompany().getCompanyname());
            birthdayplace.setText(e.getDistrict().getRegion().getName() + "," + e.getDistrict().getDistrictname());
            lavozimi.setText(e.getLavozimivaQachondan());
            harbiyunvoni.setText(extra.getHarbiyunvoni());
            ilmiydaraja.setText(extra.getIlmiydarajasi());
            ilmiyunvoni.setText(extra.getIlmiyunvoni());
            malboymutaxasisligi.setText(extra.getMalumotiboyichamutaxasisligi());
            malumoti.setText(extra.getMalumoti());
            qaysichettili.setText(extra.getChettillari());
            davlatmukofoti.setText(extra.getDavlatmukofotibilantaqdirlanganligiqanaqa());
            millati.setText(extra.getNationality());
            partiyaviyligi.setText(extra.getPartiyaviyligi());
            saylovorganiazosi.setText(extra.getSaylovorganiazosi());
            tamomlaganjoyi.setText(extra.getTamomlaganjoyi());
            for (InformationAboutRelativeDTO i : extra.getAboutRelative()) {
                n++;
                Label label = new Label();
                label.setStyle("-fx-border-radius: 10px;-fx-background-color: white;-fx-background-radius: 10px;-fx-border-color: #828080;");
                label.setText("" + n + "");
                label.setPrefHeight(55);
                label.setPrefWidth(26);
                TextArea textArea = new TextArea();
                TextArea textArea1 = new TextArea();
                TextArea textArea2 = new TextArea();
                TextArea textArea3 = new TextArea();
                TextArea textArea4 = new TextArea();

                textArea.setStyle("-fx-border-radius: 10px;-fx-background-color: white;-fx-background-radius: 10px;-fx-border-color: #828080;");
                textArea1.setStyle("-fx-border-radius: 10px;-fx-background-color: white;-fx-background-radius: 10px;-fx-border-color: #828080;");
                textArea2.setStyle("-fx-border-radius: 10px;-fx-background-color: white;-fx-background-radius: 10px;-fx-border-color: #828080;");
                textArea3.setStyle("-fx-border-radius: 10px;-fx-background-color: white;-fx-background-radius: 10px;-fx-border-color: #828080;");
                textArea4.setStyle("-fx-border-radius: 10px;-fx-background-color: white;-fx-background-radius: 10px;-fx-border-color: #828080;");

                textArea.setPrefHeight(55);
                textArea.setPrefWidth(100);
                textArea1.setPrefHeight(55);
                textArea1.setPrefWidth(146);
                textArea2.setPrefHeight(55);
                textArea2.setPrefWidth(147);
                textArea3.setPrefHeight(55);
                textArea3.setPrefWidth(157);
                textArea4.setPrefHeight(55);
                textArea4.setPrefWidth(166);

                textArea.setText(i.getName());
                textArea1.setText(i.getRelativefullname());
                textArea2.setText(i.getBirthdayandbirthofplace());
                textArea3.setText(i.getIshjoyivalavozimi());
                textArea4.setText(i.getTurarjoyi());

                HBox hBox = new HBox();
                hBox.setPrefWidth(719);
                hBox.setPrefHeight(55);
                hBox.getChildren().setAll(label, textArea, textArea1, textArea2, textArea3, textArea4);
                VboxRelative.setPrefHeight(VboxRelative.getPrefHeight() + 55);

                scrrollPane.setPrefHeight(scrrollPane.getPrefHeight() - 55);
                vboxMain.setPrefHeight(vboxMain.getPrefHeight() + 55);
                VboxRelative.getChildren().add(hBox);
                VboxRelative.setSpacing(3);

            }
            for (MehnatFaoliyatiDto m : extra.getMehnatFaoliyati()) {
                k++;
                Label label = new Label();
                label.setPrefHeight(67);
                label.setPrefWidth(30);
                label.setStyle("-fx-border-radius: 10px;-fx-background-color: white;-fx-background-radius: 10px;-fx-border-color: #828080;-fx-font-size: 24px");
                label.setText("" + k + "");
                TextField labor = new TextField();
                labor.setText(m.getText());
                labor.setPrefHeight(67);
                labor.setPrefWidth(639);
                labor.setStyle("-fx-border-radius: 20px;-fx-background-color: white;-fx-background-radius: 20px;-fx-border-color: #828080;-fx-font-size: 30px");
                HBox hBox = new HBox();
                hBox.setPrefHeight(100);
                hBox.setPrefWidth(200);
                hBox.getChildren().addAll(label, labor);
                VboxCarOfLabor.setPrefHeight(VboxCarOfLabor.getPrefHeight() + 67);
                scrrollPane.setPrefHeight(scrrollPane.getPrefHeight() - 67);
                vboxMain.setPrefHeight(vboxMain.getPrefHeight() + 67);
                VboxCarOfLabor.getChildren().add(hBox);
            }
        }
    }
}
