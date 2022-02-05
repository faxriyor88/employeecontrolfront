package sample;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.connect.ConnectEmployeeController;
import sample.dto.ApiResponse;
import sample.dto.EmployeeAdditonalDTO;
import sample.dto.ShowEmployee;
import sample.model.Employee;
import sample.service.Result;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ViewEmpController implements Initializable {

    public static boolean permission;
    public static Employee employeeTrans;
    public static EmployeeAdditonalDTO additonalTrans;


    @FXML
    private AnchorPane anchorpane;

    @FXML
    private TableColumn<ShowEmployee, String> birthday;

    @FXML
    private TableColumn<ShowEmployee, String> fullname;

    @FXML
    private TableColumn<ShowEmployee, String> lavozim;

    @FXML
    private TableColumn<ShowEmployee, Integer> num;

    @FXML
    private TableColumn<ShowEmployee, ShowEmployee> qoshimcha;

    @FXML
    private TableView<ShowEmployee> tableview;

    @FXML
    private TableColumn<ShowEmployee, String> tashkilot;

    @FXML
    private TableColumn<ShowEmployee, String> viloyattuman;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            shower();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void shower() throws IOException, InterruptedException {
        final int[] employeeId = new int[1];
        List<Employee> employees = ConnectEmployeeController.getAllEmployee();
        List<ShowEmployee> list = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);

            ShowEmployee showEmployee = new ShowEmployee(i + 1, e.getFullname(), e.getDistrict().getRegion().getName() + "," + e.getDistrict().getDistrictname(), e.getCompany().getCompanyname(), e.getBirthday(), e.getLavozimivaQachondan());
            list.add(showEmployee);
        }

        num.setCellValueFactory(new PropertyValueFactory<>("id"));
        fullname.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        viloyattuman.setCellValueFactory(new PropertyValueFactory<>("district"));
        tashkilot.setCellValueFactory(new PropertyValueFactory<>("company"));
        lavozim.setCellValueFactory(new PropertyValueFactory<>("lavozimivaQachondan"));
        birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        qoshimcha.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        qoshimcha.setCellFactory(param -> new TableCell<ShowEmployee, ShowEmployee>() {
            @Override
            protected void updateItem(ShowEmployee item, boolean empty) {
                if (!empty) {


                    File download = new File("src\\sample\\image\\microsoft-word-xxl.png");
                    File editing = new File("src\\sample\\image\\edit-12-xl.png");
                    File plus = new File("src\\sample\\image\\plus-4-xl.png");
                    File delete = new File("src\\sample\\image\\delete-xl.png");

                    Image del = new Image(delete.toURI().toString());
                    ImageView imageView = new ImageView(del);
                    imageView.setFitWidth(25);
                    imageView.setFitHeight(25);
                    Button b = new Button();
                    b.setGraphic(imageView);
                    b.setStyle("-fx-background-color: #2562EAFF;");
                    b.getStyleClass().add("pressedser");
                    b.setFont(new Font(1));

                    Image edit = new Image(editing.toURI().toString());
                    ImageView imageView1 = new ImageView(edit);
                    imageView1.setFitWidth(25);
                    imageView1.setFitHeight(25);
                    Button b1 = new Button();
                    b1.setGraphic(imageView1);
                    b1.setStyle("-fx-background-color:#2562EAFF;");
                    b1.getStyleClass().add("pressedser");
                    b1.setFont(new Font(1));

                    Image plu = new Image(plus.toURI().toString());
                    ImageView imageView2 = new ImageView(plu);
                    imageView2.setFitWidth(25);
                    imageView2.setFitHeight(25);
                    Button b2 = new Button();
                    b2.setGraphic(imageView2);
                    b2.setStyle("-fx-background-color:#2562EAFF;");
                    b2.getStyleClass().add("pressedser");
                    b2.setFont(new Font(1));

                    Image down = new Image(download.toURI().toString());
                    ImageView imageView3 = new ImageView(down);
                    imageView3.setFitWidth(25);
                    imageView3.setFitHeight(25);
                    Button b3 = new Button();
                    b3.setGraphic(imageView3);
                    b3.setStyle("-fx-background-color: #2562EAFF;");
                    b3.getStyleClass().add("pressedser");
                    b3.getStyleClass().add("hoverser");
                    b3.setFont(new Font(1));


                    HBox hBox = new HBox(6, b, b1, b2, b3);
                    hBox.setStyle("-fx-background-color: white;");

//                    tableview.setOnMouseClicked(new EventHandler<MouseEvent>() {
//                        @Override
//                        public void handle(MouseEvent event) {
//
//                          employeeId[0] =tableview.getSelectionModel().getSelectedItem().getId();
//                            System.out.println("tableview"+employeeId[0]);
//                        }
//                    });

                    // DELETE


                    b.setOnMouseClicked(event -> {
                        if (event.getButton().equals(MouseButton.PRIMARY)) {
                            hBox.setStyle("-fx-background-color: white;");
                            employeeId[0] = item.getId();
                            UUID uuid = employees.get(employeeId[0] - 1).getId();
                            //Label label = new Label(text);
                            Result.deleteAsk(uuid);
                        }
                    });

                    b1.setOnMouseClicked(event -> {
                        if (event.getButton().equals(MouseButton.PRIMARY)) {
                            try {
                                hBox.setStyle("-fx-background-color: white;");
                                //employeeId[0] = tableview.getSelectionModel().getSelectedItem().getId();
                                employeeId[0] = item.getId();
                                UUID id = employees.get(employeeId[0] - 1).getId();
                                EmployeeAdditonalDTO employeeAdditonalDTO = ConnectEmployeeController.getExtractInformation(id);
                                Employee employee = employees.get(employeeId[0] - 1);
                                permission = true;
                                employeeTrans = employee;
                                additonalTrans = employeeAdditonalDTO;
                                Stage stage = new Stage();
                                EditEmpController.stage = stage;
                                MainController.editPage(stage);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    //Extra
//                    imageView2.setOnMouseClicked(event -> {
//                        if (event.getButton().equals(MouseButton.PRIMARY)) {
//                            hBox.setStyle("-fx-background-color: white;");
//                          //  employeeId[0] = tableview.getSelectionModel().getSelectedItem().getId();
//                            employeeId[0] =item.getId();
//                            UUID id = employees.get(employeeId[0] - 1).getId();
//                            EmployeeAdditonalDTO employeeAdditonalDTO = null;
//                            try {
//                                employeeAdditonalDTO = ConnectEmployeeController.getExtractInformation(id);
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                            Employee employee = employees.get(employeeId[0] - 1);
//                            permission = true;
//                            employeeTrans = employee;
//                            additonalTrans = employeeAdditonalDTO;
//                            MainController.extraPage(new Stage());
//                        }
//                    });

                    b2.setOnMouseClicked(event -> {
                        if (event.getButton().equals(MouseButton.PRIMARY)) {
                            hBox.setStyle("-fx-background-color: white;");
                            //  employeeId[0] = tableview.getSelectionModel().getSelectedItem().getId();
                            employeeId[0] = item.getId();
                            UUID id = employees.get(employeeId[0] - 1).getId();
                            EmployeeAdditonalDTO employeeAdditonalDTO = null;
                            try {
                                employeeAdditonalDTO = ConnectEmployeeController.getExtractInformation(id);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Employee employee = employees.get(employeeId[0] - 1);
                            permission = true;
                            employeeTrans = employee;
                            additonalTrans = employeeAdditonalDTO;
                            MainController.extraPage(new Stage());
                        }
                    });

                    b3.setOnMouseClicked(event -> {
                        System.out.println("sdf");
                        if (event.getButton().equals(MouseButton.PRIMARY)) {

                            hBox.setStyle("-fx-background-color: white;");
                            employeeId[0] = item.getId();
                            System.out.println(employeeId[0]);
                            UUID id = employees.get(employeeId[0] - 1).getId();

                            try {
                                ConnectEmployeeController.downloader(id);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
//                    imageView3.setOnMouseClicked(event -> {
//                        if (event.getButton().equals(MouseButton.PRIMARY)) {
//                            hBox.setStyle("-fx-background-color: white;");
//                            employeeId[0] = tableview.getSelectionModel().getSelectedItem().getId();
//                            UUID id = employees.get(employeeId[0] - 1).getId();
//
//                            try {
//                                ConnectEmployeeController.downloader(id);
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    });


                    hBox.setAlignment(Pos.CENTER);
                    this.setGraphic(hBox);
                }
            }
        });
        tableview.getItems().clear();
        tableview.getItems().addAll(list);

    }


}
// Qaysi ustun bosilganligini bilish System.out.println("Clicked on " + (tableview.getSelectionModel().getSelectedCells().get(0)).getColumn());