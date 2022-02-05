package sample;

import java.io.File;

public class Main {
    public static void main(String[] args) {

    }
}

//import javafx.application.Application;
//import javafx.application.Platform;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//
//public class Main extends Application {
//    private String text = "";
//
//    @Override // Override the start method in the Application class
//    public void start(Stage primaryStage) {
//        StackPane pane = new StackPane();
//        Label lblText = new Label("Programming is fun");
//        pane.getChildren().add(lblText);
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    while (true) {
//                        if (lblText.getText().trim().length() == 0)
//                            text = "Welcome";
//                        else
//                            text = "";
//
//                        Platform.runLater(new Runnable() { // Run from JavaFX GUI
//                            @Override
//                            public void run() {
//                                lblText.setText(text);
//                            }
//                        });
//
//                        Thread.sleep(200);
//                    }
//                } catch (InterruptedException ex) {
//                }
//            }
//        }).start();
//        Scene scene = new Scene(pane, 200, 50);
//        primaryStage.setTitle("FlashText"); // Set the stage title
//        primaryStage.setScene(scene); // Place the scene in the stage
//        primaryStage.show(); // Display the stage
//    }
//}
//package sample;
//
//
//import javafx.animation.Animation;
//import javafx.animation.Transition;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Pos;
//
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLConnection;
//
//
//public class Main {
//    public static void main(String[] args) throws Exception {
////        try {
////            URL url = new URL("http://www.google.com");
////            URLConnection connection = url.openConnection();
////            connection.connect();
////            System.out.println("Internet is connected");
////        } catch (MalformedURLException e) {
////            System.out.println("Internet is not connected");
////        } catch (IOException e) {
////            System.out.println("Internet is not connected");
////        }
//        String s=" md fj ";
//        boolean admit=true;
//        String[] bite=new String[3];
//        short a=0;
//        for (int i = 0; i < s.length(); i++) {
//            if (!String.valueOf(s.charAt(i)).equals(" ")){
//                if (admit){
//                    bite[a]=bite[a]+String.valueOf(s.charAt(i));
//                }else {
//                    admit=false;
//                    a++;
//                }
//
//            }
//        }
//        System.out.println(bite[0]);
//        System.out.println(bite[1]);
//        System.out.println(bite[2]);
//
//
//    }
//}