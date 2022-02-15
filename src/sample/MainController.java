package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class MainController extends Application {
    public static Stage loginpage;
    public static Stage dashboardpage;
    public static Stage changeloginpage;
    public static Stage changeDashboardpage;
    public static Stage changeviewdocpage;
    public static Stage changeviewandAdddocpage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        loginPage(primaryStage);
        loginpage = primaryStage;


    }


    public void loginPage(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("front/login.fxml")));
        // primaryStage.setMaximized(true);
        primaryStage.getIcons().add(new Image("sample/image/kasaba.png"));

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        changeloginpage = primaryStage;

    }

    public static Stage dashBoardPage(Stage stage) {
        Parent root = null;
        try {
            //loginpage.close();
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("front/dashboard.fxml"));
            DashboardController dashboardController = new DashboardController();
            loader.setControllerFactory(param -> dashboardController);
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Dashboard");
            stage.getIcons().add(new Image("sample/image/kasaba.png"));
            stage.setScene(scene);
            stage.show();
            stage.setMaximized(true);
            changeDashboardpage = stage;
            dashboardpage = stage;
            return loginpage;
        } catch (IOException e) {
            return null;
        }
    }

    public static Stage editPage(Stage stage) {
        Parent root = null;
        try {
            // dashboardpage.close();
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("front/editemp.fxml"));
            EditEmpController editEmpController = new EditEmpController();
            loader.setControllerFactory(param -> editEmpController);
            root = loader.load();
            stage.setTitle("Edit");
            stage.getIcons().add(new Image("sample/image/kasaba.png"));
            stage.setResizable(false);
            stage.setScene(new Scene(root, 860, 855));
            stage.show();
            return dashboardpage;
        } catch (IOException e) {
            return null;
        }
    }


    public static Stage addPage(Stage stage) {
        Parent root = null;
        try {

            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("front/addempp.fxml"));
            AddEmpController addEmpController = new AddEmpController();
            loader.setControllerFactory(param -> addEmpController);
            root = loader.load();
            stage.setTitle("Insert");
            stage.getIcons().add(new Image("sample/image/kasaba.png"));
            stage.setResizable(false);
            stage.setScene(new Scene(root, 860, 855));
            stage.show();
            return dashboardpage;
        } catch (IOException e) {
            return null;
        }
    }

    public static Stage extraPage(Stage stage) {
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("front/extraemp.fxml"));
            ExtraEmpController extraEmpController = new ExtraEmpController();
            loader.setControllerFactory(param -> extraEmpController);
            root = loader.load();
            stage.setTitle("Extra");
            stage.getIcons().add(new Image("sample/image/kasaba.png"));
            stage.setResizable(false);
            stage.setScene(new Scene(root, 860, 855));
            stage.show();
            return dashboardpage;
        } catch (IOException e) {
            return null;
        }
    }

    public static void viewDocumentPage(Stage stage) {
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("front/viewdocument.fxml"));
            ViewDocumentController documentController = new ViewDocumentController();
            loader.setControllerFactory(param -> documentController);
            root = loader.load();
            stage.setTitle("DOC");
            stage.getIcons().add(new Image("sample/image/kasaba.png"));
            //   stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
            changeviewdocpage = stage;
        } catch (IOException ignored) {
        }
    }

    public static void viewAndAddDocumentPage(Stage stage) {
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("front/viewandaddDocument.fxml"));
            ViewAndAddDocumentController viewAndAddDocumentController = new ViewAndAddDocumentController();
            loader.setControllerFactory(param -> viewAndAddDocumentController);
            root = loader.load();
            stage.setTitle("DOC");
            stage.getIcons().add(new Image("sample/image/kasaba.png"));
            //   stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
            changeviewandAdddocpage=stage;
        } catch (IOException ignored) {
        }
    }

    public static Stage addDocumentPage(Stage stage) {
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("front/addDocument.fxml"));
            AddDocumentController addDocumentController = new AddDocumentController();
            loader.setControllerFactory(param -> addDocumentController);
            root = loader.load();
            stage.setTitle("DOC");
            stage.getIcons().add(new Image("sample/image/kasaba.png"));
            //   stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
            changeDashboardpage = stage;
            return dashboardpage;
        } catch (IOException e) {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        MainController.launch(args);
    }


}