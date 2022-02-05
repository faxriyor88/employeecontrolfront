package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;


import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.connect.ConnectEmployeeController;
import sample.dto.*;
import sample.model.Company;
import sample.model.District;
import sample.model.Employee;
import sample.model.Region;
import sample.service.Result;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class AddEmpController implements Initializable {
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
    private Button saqlash;

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


    public static Stage addEmpStage;
    public static File imageTrans = null;
    public List<TextArea> areaList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        areaList.add(new TextArea());
        final int[] regionId = new int[1];
        final int[] districtId = new int[1];
        final int[] companyId = new int[1];

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

        saqlash.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (imageTrans != null) {
                    System.out.println("ishlayapti");
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
                    EmployeeDto employeeDto = new EmployeeDto((familyasi.getText() + "," + ismi.getText() + "," + sharifi.getText()), regionId[0], districtId[0],
                            companyId[0], lavozimi.getText(), informationAboutRelativeDTOS, birthday.getEditor().getText(), millati.getText(), malumoti.getText(),
                            malboymutaxasisligi.getText(), ilmiydaraja.getText(), ilmiyunvoni.getText(), qaysichettili.getText(),
                            davlatmukofoti.getText(), saylovorganiazosi.getText(), partiyaviyligi.getText(), tamomlaganjoyi.getText(),
                            harbiyunvoni.getText(), me);
                    try {
                        ApiResponse apiResponse = ConnectEmployeeController.addEmployee(imageTrans, employeeDto);
                       if (apiResponse.isSuccess()){
                           imageTrans=null;
                        addEmpStage.close();
                       Result.executed(apiResponse.getMessage());
                       }
                        else {
                            Result.failWindow(apiResponse.getMessage());
                        }
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
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
                //              new FileChooser.ExtensionFilter("All Files", "*.*"));
                imageTrans = fileChooser.showOpenDialog(null);
                if (imageTrans!=null) {
                    imageName.setText(imageTrans.getName());
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

//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.image.Image;
//import javafx.scene.input.MouseButton;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.stage.FileChooser;
//import javafx.scene.image.ImageView;
//import javafx.stage.Stage;
//import sample.connect.ConnectEmployeeController;
//import sample.dto.EmployeeDto;
//import sample.dto.InformationAboutRelativeDTO;
//
//
//import java.io.File;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.ResourceBundle;
//
//
//public class AddEmpController implements Initializable {
//
//    @FXML
//    private AnchorPane anchorpane;
//
//    @FXML
//    private TextField tamomlaganjoyi;
//
//    @FXML
//    private TextField ismi;
//
//    @FXML
//    private TextField familiyasi;
//
//    @FXML
//    private TextField sharifi;
//
//    @FXML
//    private DatePicker tugilgansana;
//
//    @FXML
//    private MenuItem mirobod;
//
//    @FXML
//    private MenuItem sergeli;
//
//    @FXML
//    private MenuItem forish;
//
//    @FXML
//    private MenuItem zafarobod;
//
//    @FXML
//    private MenuItem zomin;
//
//    @FXML
//    private Menu toshfilial;
//
//    @FXML
//    private Menu jizfilial;
//
//    @FXML
//    private TextField lavozimi;
//
//    @FXML
//    private TextField millati;
//
//    @FXML
//    private TextField malumotiboyichamutaxasisligi;
//
//    @FXML
//    private TextField ilmiydarajasi;
//
//    @FXML
//    private TextField chettili;
//
//    @FXML
//    private TextField malumoti;
//
//    @FXML
//    private TextField saylovorgan;
//
//    @FXML
//    private TextField partiyaviyligi;
//
//    @FXML
//    private TextField ilmiyunvon;
//
//    @FXML
//    private TextField harbiyunvon;
//
//    @FXML
//    private TextField davlatmukofot;
//
//    @FXML
//    private TextArea mehnatfaoliyat;
//
//    @FXML
//    private Button qoshish;
//
//    @FXML
//    private VBox vbox;
//
//    @FXML
//    private ImageView imageView;
//
//    @FXML
//    private Button selectr;
//
//    @FXML
//    private Button plus;
//
//    public EmployeeDto employeeDto;
//
//    public List<InformationAboutRelativeDTO> informationAboutRelativeDTOS = new ArrayList<>();
//
//    public File imageFile;
//
//
//    private short n = 0;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//        selectr.setOnMouseClicked(event -> {
//            if (event.getButton().equals(MouseButton.PRIMARY)) {
//                FileChooser fileChooser = new FileChooser();
//                fileChooser.getExtensionFilters().addAll(
////                           new FileChooser.ExtensionFilter("Text Files", "*.txt"),
////                           new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
////                           new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
//                        new FileChooser.ExtensionFilter("All Files", "*.*"));
//                File selectedFile = fileChooser.showOpenDialog(null);
//                imageFile = new File(selectedFile.getAbsolutePath());
//                Image image = new Image(selectedFile.toURI().toString());
//                imageView.setImage(image);
//            }
//        });
//
//        plus.setOnMouseClicked(event -> {
//            if (event.getButton().equals(MouseButton.PRIMARY)) {
//                if (n == 14) {
//                    failWindow();
//                }else {
//                    n++;
//                    Label label = new Label();
//                    label.setText("" + n + ".");
//                    label.setPrefHeight(55);
//                    label.setPrefWidth(26);
//                    TextArea textField1 = new TextArea();
//                    TextArea textField2 = new TextArea();
//                    TextArea textField3 = new TextArea();
//                    TextArea textField4 = new TextArea();
//                    TextArea textField5 = new TextArea();
//                    areas[n] = textField1;
//                    textField1.setPrefHeight(55);
//                    textField1.setPrefWidth(100);
//                    areas[n + 1] = textField2;
//                    textField2.setPrefHeight(55);
//                    textField2.setPrefWidth(146);
//                    areas[n + 2] = textField3;
//                    textField3.setPrefHeight(55);
//                    textField3.setPrefWidth(147);
//                    areas[n + 3] = textField4;
//                    textField4.setPrefHeight(55);
//                    textField4.setPrefWidth(157);
//                    areas[n + 4] = textField5;
//                    textField5.setPrefHeight(55);
//                    textField5.setPrefWidth(166);
//                    HBox hBox = new HBox();
//                    hBox.setPrefWidth(719);
//                    hBox.setPrefHeight(55);
//                    hBox.getChildren().setAll(label, areas[n], areas[n + 1], areas[n + 2], areas[n + 3], areas[n + 4]);
//                    hBox.setStyle("-fx-border-color: black");
//                    vbox.getChildren().add(hBox);
//                }
//            }
//        });
//
//        qoshish.setOnMouseClicked(event -> {
//            if (event.getButton().equals(MouseButton.PRIMARY)) {
//                for (int i = 1; i <= n; i++) {
//                    InformationAboutRelativeDTO in = new InformationAboutRelativeDTO(areas[i + 0].getText(), areas[i + 1].getText(), areas[i + 2].getText(), areas[i + 3].getText(), areas[i + 4].getText());
//                    informationAboutRelativeDTOS.add(in);
//                }
////                employeeDto = new EmployeeDto((familiyasi.getText() + " " + ismi.getText() + " " + sharifi.getText()), 1, 20,
////                        3, lavozimi.getText(), informationAboutRelativeDTOS, tugilgansana.getEditor().getText(), millati.getText(), malumoti.getText(),
////                        malumotiboyichamutaxasisligi.getText(), ilmiydarajasi.getText(), ilmiyunvon.getText(), chettili.getText(),
////                        davlatmukofot.getText(), saylovorgan.getText(), partiyaviyligi.getText(), tamomlaganjoyi.getText(),
////                        harbiyunvon.getText(), mehnatfaoliyat.getText());
////                employeeDto.setAboutRelative(informationAboutRelativeDTOS);
//                try {
//                    System.out.println(imageFile.getAbsolutePath());
//                    ConnectEmployeeController.addEmployee(imageFile, employeeDto);
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//
//    public void failWindow() {
//        Label label = new Label("Boshqa qo'shaolmaysiz !!!");
//        Button button = new Button("Yopish");
//        VBox vBox=new VBox(label,button);
//        vBox.setAlignment(Pos.CENTER);
//        Scene scene = new Scene(vBox,200,150);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.setTitle("Fail");
//        stage.show();
//
//        button.setOnMouseClicked(event -> {
//            if (event.getButton().equals(MouseButton.PRIMARY)){
//                stage.close();
//            }
//        });
//    }
//}
////1:57
//2:47