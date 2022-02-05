package sample.service;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.connect.ConnectEmployeeController;
import sample.dto.ApiResponse;

import java.io.IOException;
import java.util.UUID;

public class Result {
    public static void failWindow(String text) throws InterruptedException {
        Label label = new Label(text);
        Button button = new Button("Yopish");
        VBox vBox = new VBox(label, button);
        vBox.setSpacing(5);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 400, 300);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        stage.setTitle("Fail");
        stage.show();

        button.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                stage.close();
            }
        });
//        Thread.sleep(1_000);
//        stage.close();

    }

    public static void executed(String text) throws InterruptedException {
        Label label = new Label(text);
        Button button = new Button("Yopish");
        VBox vBox = new VBox(label, button);
        vBox.setSpacing(5);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 400, 300);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        stage.setTitle("OK");
        stage.show();


        button.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                stage.close();
            }
        });

    }

    public static void deleteAsk(UUID uuid){
        Button delete1 = new Button("DELETE");
        Button cancel = new Button("CANCEL");
        HBox hBox1 = new HBox(cancel, delete1);
        hBox1.setSpacing(20);
        hBox1.setAlignment(Pos.CENTER);
        Scene scene = new Scene(hBox1, 400, 300);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        stage.setTitle("OK");
        stage.show();
        delete1.setOnMouseClicked(event1 -> {
            if (event1.getButton().equals(MouseButton.PRIMARY)) {
                ApiResponse apiResponse = null;
                try {
                    apiResponse = ConnectEmployeeController.deleteEmployee(uuid);
                    if (apiResponse.isSuccess()) {
                        Result.executed(apiResponse.getMessage());
                    } else {
                        Result.failWindow(apiResponse.getMessage());
                    }
                    stage.close();
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        });
        cancel.setOnMouseClicked(event1 -> {
            if (event1.getButton().equals(MouseButton.PRIMARY)) {
                stage.close();
            }
        });
    }

    public static void netResult(String text) throws InterruptedException {
        Label label = new Label(text);
        Button button = new Button("Yopish");
        VBox vBox = new VBox(label, button);
        vBox.setSpacing(5);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 400, 300);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        stage.setTitle("OK");
        stage.show();


        button.setOnMouseClicked(event -> {
            if (event.getButton().equals(MouseButton.PRIMARY)) {
                stage.close();
            }
        });

    }

}
