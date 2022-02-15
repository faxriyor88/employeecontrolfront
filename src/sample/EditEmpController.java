package sample;

import com.sun.glass.ui.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.connect.ConnectEmployeeController;
import sample.dto.*;
import sample.model.District;
import sample.model.Employee;
import sample.model.Region;
import sample.service.Result;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EditEmpController /*extends DashboardController*/ implements Initializable  {

    public TextField m1 = new TextField();
    public TextField m2 = new TextField();
    public TextField m3 = new TextField();
    public TextField m44 = new TextField();
    public TextField m5 = new TextField();
    public TextField m6 = new TextField();
    public TextField m7 = new TextField();
    public TextField m8 = new TextField();
    public TextField m9 = new TextField();
    public TextField m10 = new TextField();
    public TextField m11 = new TextField();
    public TextField m12 = new TextField();
    public TextField m13 = new TextField();
    public TextField m14 = new TextField();
    public TextField mo;

    public TextField[] areasLabor = {mo, m1, m2, m3, m44, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14};

    @FXML
    private ScrollPane scrrollPane;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private VBox vboxMain;

    @FXML
    private TextField ismi;

    @FXML
    private TextField familyasi;

    @FXML
    private TextField sharifi;

    @FXML
    private DatePicker birthday;

    @FXML
    private MenuButton birthdayplace;

    @FXML
    private MenuButton ishjoyi;


    @FXML
    private TextField lavozimi;

    @FXML
    private TextField millati;

    @FXML
    private TextField malboymutaxasisligi;

    @FXML
    private TextField ilmiydaraja;

    @FXML
    private TextField qaysichettili;

    @FXML
    private TextField malumoti;

    @FXML
    private TextField saylovorganiazosi;

    @FXML
    private TextField partiyaviyligi;

    @FXML
    private TextField ilmiyunvoni;

    @FXML
    private TextField harbiyunvoni;

    @FXML
    private TextField davlatmukofoti;

    @FXML
    private TextField tamomlaganjoyi;

    @FXML
    private Label imageName;

    @FXML
    private Button uploadImage;

    @FXML
    private VBox VboxRelative;

    @FXML
    private VBox VboxCarOfLabor;

    @FXML
    private Button back;

    @FXML
    public  Button saqlash;

    @FXML
    private Button plusRel;

    @FXML
    private Button plusLab;

    @FXML
    private Button minRel;

    @FXML
    private Button minLab;


    private short n = 0;
    private short k = 0;


    public static Stage stage;
    public static File imageTransEdit = null;
    public List<TextArea> areaList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final int[] regionId = new int[1];
        final int[] districtId = new int[1];
        final int[] companyId = new int[1];
        areaList.add(new TextArea());
        if (ViewEmpController.permission) {
            ViewEmpController.permission = false;
            areaList.clear();
            areaList.add(new TextArea());
            Employee e = ViewEmpController.employeeTrans;
            EmployeeAdditonalDTO extra = ViewEmpController.additonalTrans;
            String[] split = e.getFullname().split(" ");
           // ishjoyi.setPrefHeight(100);
            ismi.setText(split[1]);
            familyasi.setText(split[0]);
            sharifi.setText(split[2]);
            DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date = LocalDate.from(europeanDateFormatter.parse(e.getBirthday()));
            birthday.setValue(date);
            ishjoyi.setText(e.getCompany().getCompanyname());
            birthdayplace.setText(e.getDistrict().getRegion().getName() + "," + e.getDistrict().getDistrictname());
            regionId[0] = e.getDistrict().getRegion().getId();
            districtId[0] = e.getDistrict().getId();
            companyId[0] = e.getCompany().getId();
            for (Region r : LoginController.regions) {
                Menu menu = new Menu(r.getName());
                for (District d : LoginController.getAllDistricts(r.getId())) {
                    MenuItem menuItem = new MenuItem(d.getDistrictname());
                    menu.getItems().add(menuItem);
                    menuItem.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            birthdayplace.setText(d.getRegion().getName() + "," + d.getDistrictname());
                            regionId[0] = d.getRegion().getId();
                            districtId[0] = d.getId();
                        }
                    });
                }
                birthdayplace.getItems().add(menu);
            }
            for (CompanyDTO c : LoginController.companyDTOS) {
                MenuItem menuItem = new MenuItem(c.getCompanyname());
                ishjoyi.getItems().add(menuItem);
                menuItem.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        ishjoyi.setText(c.getCompanyname());
                        companyId[0] = c.getCompanyId();

                    }
                });
            }
            //            birthday.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                    DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//                    LocalDate date = LocalDate.from(europeanDateFormatter.parse(birthday.getEditor().getText()));
//                    birthday.setValue(date);
//                }
//            });
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
                areaList.add(textArea);
                areaList.add(textArea1);
                areaList.add(textArea2);
                areaList.add(textArea3);
                areaList.add(textArea4);
                HBox hBox = new HBox();
                hBox.setPrefWidth(719);
                hBox.setPrefHeight(55);
                hBox.getChildren().setAll(label, textArea, textArea1, textArea2, textArea3, textArea4);
                VboxRelative.setPrefHeight(VboxRelative.getPrefHeight() + 55);
                plusLab.setLayoutY(plusLab.getLayoutY() + 55);
                minLab.setLayoutY(minLab.getLayoutY() + 55);
                back.setLayoutY(back.getLayoutY() + 55);
                saqlash.setLayoutY(saqlash.getLayoutY() + 55);
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
                areasLabor[k] = labor;
                HBox hBox = new HBox();
                hBox.setPrefHeight(100);
                hBox.setPrefWidth(200);
                hBox.getChildren().addAll(label, areasLabor[k]);
                VboxCarOfLabor.setPrefHeight(VboxCarOfLabor.getPrefHeight() + 67);
                back.setLayoutY(back.getLayoutY() + 67);
                saqlash.setLayoutY(saqlash.getLayoutY() + 67);
                scrrollPane.setPrefHeight(scrrollPane.getPrefHeight() - 67);
                vboxMain.setPrefHeight(vboxMain.getPrefHeight() + 67);
                VboxCarOfLabor.getChildren().add(hBox);
            }
       }
//
//        saqlash.setOnMouseClicked(event -> {
//            if (event.getButton().equals(MouseButton.PRIMARY)) {
//                if (imageTransEdit != null) {
//                    List<InformationAboutRelativeDTO> informationAboutRelativeDTOS = new ArrayList<>();
//                    int c = 1;
//                    for (int i = 1; i <= n; i++) {
//                        InformationAboutRelativeDTO in = new InformationAboutRelativeDTO(areaList.get(c++).getText(), areaList.get(c++).getText(), areaList.get(c++).getText(), areaList.get(c++).getText(), areaList.get(c++).getText());
//                        informationAboutRelativeDTOS.add(in);
//                    }
//                    List<MehnatFaoliyatiDto> me = new ArrayList<>();
//                    for (int i = 1; i <= k; i++) {
//                        me.add(new MehnatFaoliyatiDto(areasLabor[i].getText()));
//                    }
//                    EmployeeDto employeeDto = new EmployeeDto((familyasi.getText() + "," + ismi.getText() + "," + sharifi.getText()), regionId[0], districtId[0],
//                            companyId[0], lavozimi.getText(), informationAboutRelativeDTOS, birthday.getEditor().getText(), millati.getText(), malumoti.getText(),
//                            malboymutaxasisligi.getText(), ilmiydaraja.getText(), ilmiyunvoni.getText(), qaysichettili.getText(),
//                            davlatmukofoti.getText(), saylovorganiazosi.getText(), partiyaviyligi.getText(), tamomlaganjoyi.getText(),
//                            harbiyunvoni.getText(), me);
//
//                    try {
//                        ApiResponse apiResponse = ConnectEmployeeController.editEmployee(imageTransEdit, employeeDto, ViewEmpController.employeeTrans.getId());
//                        System.out.println(apiResponse.getMessage());
//                        System.out.println(imageTransEdit.getName());
//                        imageTransEdit = null;
//                        stage.close();
//                        if (!apiResponse.isSuccess()) {
//                            Result.failWindow(apiResponse.getMessage());
//                        }
//                    } catch (IOException | InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    try {
//                        Result.failWindow("Rasm tanlanmagan");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
        saqlash.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (imageTransEdit != null) {
                    List<InformationAboutRelativeDTO> informationAboutRelativeDTOS = new ArrayList<>();
                    int c = 1;
                    for (int i = 1; i <= n; i++) {
                        InformationAboutRelativeDTO in = new InformationAboutRelativeDTO(areaList.get(c++).getText(), areaList.get(c++).getText(), areaList.get(c++).getText(), areaList.get(c++).getText(), areaList.get(c++).getText());
                        informationAboutRelativeDTOS.add(in);
                    }
                    List<MehnatFaoliyatiDto> me = new ArrayList<>();
                    for (int i = 1; i <= k; i++) {
                        me.add(new MehnatFaoliyatiDto(areasLabor[i].getText()));
                    }
                    EmployeeDto employeeDto = new EmployeeDto((familyasi.getText() + " " + ismi.getText() + " " + sharifi.getText()), regionId[0], districtId[0],
                            companyId[0], lavozimi.getText(), informationAboutRelativeDTOS, birthday.getEditor().getText(), millati.getText(), malumoti.getText(),
                            malboymutaxasisligi.getText(), ilmiydaraja.getText(), ilmiyunvoni.getText(), qaysichettili.getText(),
                            davlatmukofoti.getText(), saylovorganiazosi.getText(), partiyaviyligi.getText(), tamomlaganjoyi.getText(),
                            harbiyunvoni.getText(), me);

                    try {
                        ApiResponse apiResponse = ConnectEmployeeController.editEmployee(imageTransEdit, employeeDto, ViewEmpController.employeeTrans.getId());
                        System.out.println(apiResponse.getMessage());
                        System.out.println(imageTransEdit.getName());
                        imageTransEdit = null;
                        stage.close();
                        if (!apiResponse.isSuccess()) {
                            Result.failWindow(apiResponse.getMessage());
                        }
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Result.failWindow("Rasm tanlanmagan");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        uploadImage.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.getExtensionFilters().addAll(
//                          new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
//                          new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                //         new FileChooser.ExtensionFilter("All Files", "*.*"));
                imageTransEdit = fileChooser.showOpenDialog(null);
                if (imageTransEdit != null) {
                    imageName.setText(imageTransEdit.getName());
                }
            }
        });

        plusRel.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (n == 14) {
                    try {
                        Result.failWindow("Boshqa qo'shaolmaysiz !!!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
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

                    areaList.add(textArea);
                    areaList.add(textArea1);
                    areaList.add(textArea2);
                    areaList.add(textArea3);
                    areaList.add(textArea4);
                    HBox hBox = new HBox();
                    hBox.setPrefWidth(719);
                    hBox.setPrefHeight(55);
                    hBox.getChildren().setAll(label, textArea, textArea1, textArea2, textArea3, textArea4);
                    VboxRelative.setPrefHeight(VboxRelative.getPrefHeight() + 55);
                    plusLab.setLayoutY(plusLab.getLayoutY() + 55);
                    minLab.setLayoutY(minLab.getLayoutY() + 55);
                    back.setLayoutY(back.getLayoutY() + 55);
                    saqlash.setLayoutY(saqlash.getLayoutY() + 55);
                    scrrollPane.setPrefHeight(scrrollPane.getPrefHeight() - 55);
                    vboxMain.setPrefHeight(vboxMain.getPrefHeight() + 55);
                    VboxRelative.getChildren().add(hBox);
                    VboxRelative.setSpacing(3);
                }
            }
        });

        plusLab.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (k == 14) {
                    try {
                        Result.failWindow("Boshqa qo'shaolmaysiz !!!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    k++;
                    Label label = new Label();
                    label.setPrefHeight(67);
                    label.setPrefWidth(30);
                    label.setStyle("-fx-border-radius: 10px;-fx-background-color: white;-fx-background-radius: 10px;-fx-border-color: #828080;-fx-font-size: 24px");
                    label.setText("" + k + "");
                    areasLabor[k].setPrefHeight(67);
                    areasLabor[k].setPrefWidth(639);
                    areasLabor[k].setStyle("-fx-border-radius: 20px;-fx-background-color: white;-fx-background-radius: 20px;-fx-border-color: #828080;-fx-font-size: 30px");
                    HBox hBox = new HBox();
                    hBox.setPrefHeight(100);
                    hBox.setPrefWidth(200);
                    hBox.getChildren().addAll(label, areasLabor[k]);
                    VboxCarOfLabor.setPrefHeight(VboxCarOfLabor.getPrefHeight() + 67);
                    back.setLayoutY(back.getLayoutY() + 67);
                    saqlash.setLayoutY(saqlash.getLayoutY() + 67);
                    scrrollPane.setPrefHeight(scrrollPane.getPrefHeight() - 67);
                    vboxMain.setPrefHeight(vboxMain.getPrefHeight() + 67);
                    VboxCarOfLabor.getChildren().add(hBox);
                    //   VboxCarOfLabor.setSpacing(3);

                }
            }
        });

        minRel.setOnMouseClicked(event -> {
            if (n != 0) {
                if (event.getButton().equals(MouseButton.PRIMARY)) {
                    areaList.remove(areaList.size() - 1);
                    areaList.remove(areaList.size() - 1);
                    areaList.remove(areaList.size() - 1);
                    areaList.remove(areaList.size() - 1);
                    areaList.remove(areaList.size() - 1);
                    VboxRelative.getChildren().remove(VboxRelative.getChildren().size() - 1);
                    VboxRelative.setPrefHeight(VboxRelative.getPrefHeight() - 55);
                    plusLab.setLayoutY(plusLab.getLayoutY() - 55);
                    minLab.setLayoutY(minLab.getLayoutY() - 55);
                    back.setLayoutY(back.getLayoutY() - 55);
                    saqlash.setLayoutY(saqlash.getLayoutY() - 55);
                    scrrollPane.setPrefHeight(scrrollPane.getPrefHeight() + 55);
                    vboxMain.setPrefHeight(vboxMain.getPrefHeight() - 55);
                    n--;
                }
            }
        });

        minLab.setOnMouseClicked(event -> {
            if (k != 0) {
                if (event.getButton().equals(MouseButton.PRIMARY)) {
                    VboxCarOfLabor.getChildren().remove(VboxCarOfLabor.getChildren().size() - 1);
                    VboxCarOfLabor.setPrefHeight(VboxCarOfLabor.getPrefHeight() - 67);
                    back.setLayoutY(back.getLayoutY() - 67);
                    saqlash.setLayoutY(saqlash.getLayoutY() - 67);
                    scrrollPane.setPrefHeight(scrrollPane.getPrefHeight() + 67);
                    vboxMain.setPrefHeight(vboxMain.getPrefHeight() - 67);
                    k--;
                }
            }
        });


    }
}
