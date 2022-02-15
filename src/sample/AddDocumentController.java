package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.connect.ConnectEmployeeController;
import sample.dto.ApiResponse;
import sample.dto.DocumentEffectorDto;
import sample.dto.ManagerDtoOfDocumentEffector;
import sample.service.Result;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AddDocumentController implements Initializable {
    @FXML
    private ScrollPane scrrollPane;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private VBox vboxMain;

    @FXML
    private TextField taskSection;

    @FXML
    private TextField documentType;

    @FXML
    private DatePicker documentDate;

    @FXML
    private TextField documentNumber;

    @FXML
    private DatePicker registrDay;

    @FXML
    private TextField registrNumber;

    @FXML
    private TextArea documentNameOrContent;

    @FXML
    private TextArea organizationName;

    @FXML
    private TextArea directorResolution;

    @FXML
    private MenuButton effectorname;

    @FXML
    private TextArea effectorSection;

    @FXML
    private DatePicker executionDeadline;

    @FXML
    private Label originalFileName;

    @FXML
    private Button uploadImage;

    @FXML
    private Button back;

    @FXML
    private Button save;

    public static File fileTrans = null;
    public static Stage addDocStage = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final int[] managerId = {7};
        for (ManagerDtoOfDocumentEffector m : LoginController.managerDtoOfDocumentEffectors) {
            MenuItem menuItem = new MenuItem(m.getManagerName());
            effectorname.getItems().add(menuItem);
            menuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    effectorname.setText(m.getManagerName());
                    managerId[0] =m.getManagerId();

                }
            });
        }

        save.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                if (fileTrans != null) {
                    DocumentEffectorDto documentEffectorDto = new DocumentEffectorDto(
                            taskSection.getText(), documentType.getText(), documentNumber.getText(), documentDate.getValue(),
                            registrDay.getValue(), registrNumber.getText(), documentNameOrContent.getText(),
                            organizationName.getText(), directorResolution.getText(), managerId[0], effectorSection.getText(), executionDeadline.getValue());
                    ApiResponse apiResponse = ConnectEmployeeController.addDocument(fileTrans, documentEffectorDto);
                    if (apiResponse.isSuccess()) {
                        try {
                            System.out.println("Okkkkk");
                            fileTrans = null;
                            addDocStage.close();
                            Result.executed(apiResponse.getMessage());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        try {
                            Result.failWindow(apiResponse.getMessage());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    try {
                        Result.failWindow("Fayl tanlanmagan");
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
                        //   new FileChooser.ExtensionFilter("Text Files", "*.txt"));
                        //  new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
//                          new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                        new FileChooser.ExtensionFilter("All Files", "*.*"));
                fileTrans = fileChooser.showOpenDialog(null);
                if (fileTrans != null) {
                    originalFileName.setText(fileTrans.getName());
                }
            }
        });
    }


    private void shower() {

    }
}
