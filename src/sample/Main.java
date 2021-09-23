package sample;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("image view");
        //primaryStage.getIcons().add(new Image("picture-frame.png"));
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
        primaryStage.getScene();





       root.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
           public void handle(MouseEvent doubleClicked) {
               if(doubleClicked.getClickCount()==2)
               {
                   primaryStage.setFullScreen(true);

               }
               else
               {
                   primaryStage.setFullScreen(false);
               }
           }
       });




    }


    public static void main(String[] args) {
        launch(args);
    }
}
