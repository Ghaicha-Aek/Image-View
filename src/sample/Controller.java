package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Controller {


      @FXML
     private  FileChooser filesaver;
    @FXML
    private ColorAdjust colorAdjust;

    @FXML
    private ImageView view;
    @FXML
    private Image image;

    @FXML
    private File file1;

    private String filepath;
    @FXML
    private Button filechooser;

    @FXML
    private Button zoomp;

    @FXML
    private Button delete;

    @FXML
    private Button rotationd;
    @FXML
    private Button rotationg;

    @FXML
    private Button save;

    @FXML
    private Button zoomm;

    @FXML
    private Button normal;


    @FXML
    private Button filtre;

    @FXML
    void deleteview() {
        file1.delete();
        view.setImage(null);


    }


    @FXML
    void filechooserview() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("select a file ", "*png", "*jpg", "*jpeg");//exetension de image
        fileChooser.getExtensionFilters().add(filter);
        File file = fileChooser.showOpenDialog(null);//boite de dialogue avec la machine
        filepath = file.toURI().toString();

        if (filepath != null) {
            image = new Image(filepath);
            view.setImage(image);
            file1 = file;
            DoubleProperty width = view.fitWidthProperty();
            DoubleProperty height = view.fitHeightProperty();
            view.setVisible(true);
            delete.setDisable(false);
            zoomp.setDisable(false);
            rotationd.setDisable(false);
            rotationg.setDisable(false);
            save.setDisable(false);
            zoomp.setDisable(false);
            zoomm.setDisable(false);
            filtre.setDisable(false);
            normal.setDisable(false);

        }


    }

    @FXML
    void rotationgauche(ActionEvent event) {
        view.setRotate(view.getRotate() - 90);//on a ajouter -90 a ration de image

    }


    @FXML
    void rotationdroite(ActionEvent event) {
        view.setRotate(view.getRotate() + 90);//on a ajouter +90 a ration de image

    }

    @FXML
    void saveview()



            throws IOException  {

            WritableImage imageSnapshot = view.snapshot(new SnapshotParameters(),null);
            BufferedImage imageSnapshotBuffered= SwingFXUtils.fromFXImage(imageSnapshot,null);

                    filesaver.getExtensionFilters().add(
                             new FileChooser.ExtensionFilter("select a file ", "*.png", "*.jpg", "*.jpeg")
                    );

            File file = filesaver.showOpenDialog(null);
            ImageIO.write(imageSnapshotBuffered,".png",file);


    }


    @FXML
    void zoomplus() {

        if ((view.getFitWidth() < view.getImage().getWidth() * 2) && (view.getFitHeight() < view.getImage().getHeight() * 2)) {

            if (view.getFitWidth() < 4000) view.setFitWidth(view.getFitWidth() * 2);
            if (view.getFitHeight() < 4000) view.setFitHeight(view.getFitHeight() * 2);
            if (view.getFitHeight() == 4000) zoomp.setDisable(true);

            System.out.println(view.getFitHeight() + "x" + view.getFitHeight());


        }
              }


        @FXML
        void zoommoins()
        {

            if ((view.getFitWidth() > view.getImage().getWidth() * 1 / 2) && (view.getFitHeight() > view.getImage().getHeight() * 1 / 2)) {
                if (view.getFitWidth() < 4000) view.setFitWidth(view.getFitWidth() * 1 / 2);
                if (view.getFitHeight() < 4000) view.setFitHeight(view.getFitHeight() * 1 / 2);
                // if(view.getFitHeight()==4000)zoomp.setDisable(true);

                System.out.println(view.getFitHeight() + "x" + view.getFitHeight());


            }


        }
        @FXML
        private void initialiser()
        {
            view.setFitHeight(500);
            view.setFitWidth(500);
        }
        @FXML
        void filtre() {
            ColorAdjust colorAdjust = new ColorAdjust();
              colorAdjust.setSaturation(-1);
              view.setEffect(colorAdjust);


    }





    @FXML
    void desfiltre() {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setSaturation(0);
        view.setEffect(colorAdjust);


    }










}



