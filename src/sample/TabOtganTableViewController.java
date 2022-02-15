package sample;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Callback;
import sample.connect.ConnectEmployeeController;
import sample.dto.DocumentEffectorDtoResponse;
import sample.dto.ShowDocument;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

public class TabOtganTableViewController implements Initializable {
    @FXML
    private TableView<ShowDocument> tableview;

    @FXML
    private TableColumn<ShowDocument, Integer> n;

    @FXML
    private TableColumn<ShowDocument, String> tasksection;

    @FXML
    private TableColumn<ShowDocument, String> doctypenumdate;

    @FXML
    private TableColumn<ShowDocument, String> registrday;

    @FXML
    private TableColumn<ShowDocument, String> docnameorcontent;

    @FXML
    private TableColumn<ShowDocument, String> organization;

    @FXML
    private TableColumn<ShowDocument, String> directorresolution;

    @FXML
    private TableColumn<ShowDocument, String> effectorname;

    @FXML
    private TableColumn<ShowDocument, String> effectorsection;

    @FXML
    private TableColumn<ShowDocument, String> executiondeadline;

    @FXML
    private TableColumn<ShowDocument, Integer> leftday;

    @FXML
    private TableColumn<ShowDocument, ShowDocument> originalfilename;

    public static String otgan = "0";


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        showMuddatiOtgan();

    }

    public void showMuddatiOtgan() {
        try {
            String rangi = "RED";
            List<DocumentEffectorDtoResponse> dtoResponses = ConnectEmployeeController.getAllDocumentEffector(rangi);
            otgan = dtoResponses.size() + "";
            if (dtoResponses.size() != 0) {

//                File red = new File("src/sample/image/red.png");
//                Image redcolor = new Image(red.toURI().toString());
//                ImageView redview = new ImageView();
//                redview.setFitWidth(25);
//                redview.setFitHeight(25);
//                redview.setImage(redcolor);
                List<ShowDocument> list = new ArrayList<>();
                for (int i = 0; i < dtoResponses.size(); i++) {
                    DocumentEffectorDtoResponse e = dtoResponses.get(i);
                    ShowDocument showDocument = new ShowDocument(i + 1, e.getTaskSection(), (e.getDocumentType() + " " + e.getDocumentDate() + " " + e.getDocumentNumber()), (e.getRegistrDay() + " " + e.getRegistrNumber()), e.getDocumentNameOrContent(), e.getOrganizationName(), e.getDirectorResolution(), e.getEffectorName(), e.getEffectorSection(), e.getExecutionDeadline() + "", e.getDeadLineDay(), e.getOriginalFileName());
                    list.add(showDocument);
                }

                n.setCellValueFactory(new PropertyValueFactory<>("id"));
                tasksection.setCellValueFactory(new PropertyValueFactory<>("taskSection"));

                doctypenumdate.setCellValueFactory(new PropertyValueFactory<>("documentTypeNumberDate"));
                doctypenumdate.setCellFactory(new Callback<TableColumn<ShowDocument, String>, TableCell<ShowDocument, String>>() {
                    @Override
                    public TableCell<ShowDocument, String> call(TableColumn<ShowDocument, String> arg0) {
                        return new TableCell<ShowDocument, String>() {
                            private Text text;

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (!isEmpty()) {
                                    text = new Text(item);
                                    text.setWrappingWidth(docnameorcontent.getWidth());
                                    this.setWrapText(true);

                                    setGraphic(text);
                                }
                            }
                        };
                    }
                });

                registrday.setCellValueFactory(new PropertyValueFactory<>("registrDayNumber"));
                registrday.setCellFactory(new Callback<TableColumn<ShowDocument, String>, TableCell<ShowDocument, String>>() {
                    @Override
                    public TableCell<ShowDocument, String> call(TableColumn<ShowDocument, String> arg0) {
                        return new TableCell<ShowDocument, String>() {
                            private Text text;

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (!isEmpty()) {
                                    text = new Text(item);
                                    text.setWrappingWidth(docnameorcontent.getWidth());
                                    this.setWrapText(true);

                                    setGraphic(text);
                                }
                            }
                        };
                    }
                });


                docnameorcontent.setCellValueFactory(new PropertyValueFactory<>("documentNameOrContent"));
                docnameorcontent.setCellFactory(new Callback<TableColumn<ShowDocument, String>, TableCell<ShowDocument, String>>() {
                    @Override
                    public TableCell<ShowDocument, String> call(TableColumn<ShowDocument, String> arg0) {
                        return new TableCell<ShowDocument, String>() {
                            private Text text;

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (!isEmpty()) {
                                    text = new Text(item);
                                    text.setWrappingWidth(docnameorcontent.getWidth());
                                    this.setWrapText(true);

                                    setGraphic(text);
                                }
                            }
                        };
                    }
                });

                directorresolution.setCellValueFactory(new PropertyValueFactory<>("directorResolution"));
                directorresolution.setCellFactory(new Callback<TableColumn<ShowDocument, String>, TableCell<ShowDocument, String>>() {
                    @Override
                    public TableCell<ShowDocument, String> call(TableColumn<ShowDocument, String> arg0) {
                        return new TableCell<ShowDocument, String>() {
                            private Text text;

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (!isEmpty()) {
                                    text = new Text(item);
                                    text.setWrappingWidth(docnameorcontent.getWidth());
                                    this.setWrapText(true);

                                    setGraphic(text);
                                }
                            }
                        };
                    }
                });

                organization.setCellValueFactory(new PropertyValueFactory<>("organizationName"));
                organization.setCellFactory(new Callback<TableColumn<ShowDocument, String>, TableCell<ShowDocument, String>>() {
                    @Override
                    public TableCell<ShowDocument, String> call(TableColumn<ShowDocument, String> arg0) {
                        return new TableCell<ShowDocument, String>() {
                            private Text text;

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (!isEmpty()) {
                                    text = new Text(item);
                                    text.setWrappingWidth(docnameorcontent.getWidth());
                                    this.setWrapText(true);

                                    setGraphic(text);
                                }
                            }
                        };
                    }
                });

                effectorname.setCellValueFactory(new PropertyValueFactory<>("effectorName"));
                effectorname.setCellFactory(new Callback<TableColumn<ShowDocument, String>, TableCell<ShowDocument, String>>() {
                    @Override
                    public TableCell<ShowDocument, String> call(TableColumn<ShowDocument, String> arg0) {
                        return new TableCell<ShowDocument, String>() {
                            private Text text;

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (!isEmpty()) {
                                    text = new Text(item);
                                    text.setWrappingWidth(docnameorcontent.getWidth());
                                    this.setWrapText(true);

                                    setGraphic(text);
                                }
                            }
                        };
                    }
                });

                effectorsection.setCellValueFactory(new PropertyValueFactory<>("effectorSection"));
                effectorsection.setCellFactory(new Callback<TableColumn<ShowDocument, String>, TableCell<ShowDocument, String>>() {
                    @Override
                    public TableCell<ShowDocument, String> call(TableColumn<ShowDocument, String> arg0) {
                        return new TableCell<ShowDocument, String>() {
                            private Text text;

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (!isEmpty()) {
                                    text = new Text(item);
                                    text.setWrappingWidth(docnameorcontent.getWidth());
                                    this.setWrapText(true);

                                    setGraphic(text);
                                }
                            }
                        };
                    }
                });

                executiondeadline.setCellValueFactory(new PropertyValueFactory<>("executionDeadline"));
                leftday.setCellValueFactory(new PropertyValueFactory<>("deadLineDay"));
                originalfilename.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));




                originalfilename.setCellFactory(param -> new TableCell<ShowDocument, ShowDocument>() {
                    @Override
                    protected void updateItem(ShowDocument item, boolean empty) {
                        if (!empty) {

                            File delete = new File("src/sample/image/download-2-xl.png");
                            Label label = new Label(item.getOriginalFileName());
                            Image del = new Image(delete.toURI().toString());
                            ImageView imageView = new ImageView(del);
                            imageView.setFitWidth(25);
                            imageView.setFitHeight(25);
                            Button downloadButton = new Button();
                            downloadButton.setGraphic(imageView);
                            downloadButton.setStyle("-fx-background-color: #2562EAFF;");
                            downloadButton.getStyleClass().add("pressedser");
                            downloadButton.setFont(new Font(1));


                            VBox vBox = new VBox(6, label, downloadButton);
                            //    hBox.setStyle("-fx-background-color: white;");

//                    tableview.setOnMouseClicked(new EventHandler<MouseEvent>() {
//                        @Override
//                        public void handle(MouseEvent event) {
//
//                          employeeId[0] =tableview.getSelectionModel().getSelectedItem().getId();
//                            System.out.println("tableview"+employeeId[0]);
//                        }
//                    });
                            downloadButton.setOnMouseClicked(event -> {
                                if (event.getButton().equals(MouseButton.PRIMARY)) {
                                    UUID id = dtoResponses.get(item.getId() - 1).getId();
                                    try {
                                        ConnectEmployeeController.documentDownloader(id);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            vBox.setAlignment(Pos.CENTER);
                            this.setGraphic(vBox);

                        }
                    }
                });


                tableview.getItems().clear();
                tableview.getItems().addAll(list);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
