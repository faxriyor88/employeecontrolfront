package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.commons.codec.binary.Base64;
import sample.connect.ConnectEmployeeController;

import javax.swing.text.View;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;


public class MainController extends Application {
    public static Stage loginpage;
    public static Stage dashboardpage;
    public static Stage changeloginpage;
    public static Stage changeDashboardpage;

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

//    public static void main(String[] args) throws Exception {
//
//        File f = new File("D:\\ZoomDarslar1\\EmployeeControl\\imagelocation\\2bb5cd8c-b182-4f8f-ac4d-153c4c666be0.png");
//        String encodstring = encodeFileToBase64Binary(f);
//        System.out.println(encodstring);
//    }

    private static String encodeFileToBase64Binary(File file) throws Exception {
        FileInputStream fileInputStreamReader = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        fileInputStreamReader.read(bytes);
        return new String(Base64.encodeBase64(bytes), "UTF-8");
    }


}