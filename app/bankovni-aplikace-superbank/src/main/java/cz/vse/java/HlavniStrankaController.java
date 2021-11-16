package cz.vse.java;

/**
 * Třída ...
 *
 * Během chodu aplikace třída vypisuje...
 *
 * @author Matyáš Vondra
 * @author Jaroslava Ludrinská
 * @author Patrik Novák
 * @version 25-01-2021
 */

import cz.vse.java.model.App;
import cz.vse.java.model.Produkt;
import cz.vse.java.model.Uzivatel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;


public class HlavniStrankaController {

    public Uzivatel uzivatel;
    public VBox produkty;
    public VBox historie;
    public App app;
    public Button novaPlatba;
    public Button hlavniStranka;
    public Button osobniUdaje;

    public void updateScreen() {

    }

    /**
     * Metoda init spravuje načítání Uživatele buď z JSONu pomocí třídy JsonFileManager nebo z XML pomocí třídy XmlFileManager
     */
    public void init(App app) {
        this.app = app;
        try {
            uzivatel = (new XmlFileManager()).load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        updateProducts();
    }

    /**
     * Metoda updateProducts nejprve vyčistí VBox produkty a historie a poté nahrává do VBoxu produkty a historie mapu produktů (string nazevproduktu, class produkt)
     *
     * V metodě se nastavují eventy na kliknutí na každé z tlačítek ve formuláři hlavniStranka.fxml
     */
    private void updateProducts() {
        produkty.getChildren().clear();
        historie.getChildren().clear();

        uzivatel.getProdukty().forEach((nazev, produkt) -> {

            Produkt prdkt = (Produkt) produkt;

            VBox produktView = new VBox();
            VBox historieView =new VBox();
            Label nazevProduktu = new Label(nazev.toString());
            Label zustatekProduktu = new Label(String.valueOf(prdkt.getZustatek()) + " Kč");

            produktView.getChildren().add(nazevProduktu);
            historieView.getChildren().add(zustatekProduktu);


            produktView.setOnMouseClicked((event) -> {


                try {
                    FXMLLoader loader = new FXMLLoader();
                    InputStream stream = getClass().getClassLoader().getResourceAsStream("historieProduktu.fxml");
                    Parent root = loader.load(stream);

                    Stage stage = new Stage();
                    stage.setTitle(nazev.toString() + " historie");
                    stage.setScene(new Scene(root, 410, 480));
                    stage.show();

                    HistorieProduktuController controller = loader.getController();
                    controller.init(app, prdkt, nazev.toString());
                    // Hide this current window (if this is what you want)
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            });
            produkty.getChildren().add(produktView);
            historie.getChildren().add(historieView);


        });

        novaPlatba.setOnMouseClicked((event) -> {

            try {
                FXMLLoader loader = new FXMLLoader();
                InputStream stream = getClass().getClassLoader().getResourceAsStream("novaPlatba.fxml");
                Parent root = loader.load(stream);

                Stage stage = new Stage();
                stage.setTitle("Nová Platba");
                stage.setScene(new Scene(root, 410, 480));
                stage.show();

                NovaPlatbaController controller = loader.getController();
                controller.init(app);
                // Hide this current window (if this is what you want)
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        hlavniStranka.setOnMouseClicked((event) -> {

            try {
                FXMLLoader loader = new FXMLLoader();
                InputStream stream = getClass().getClassLoader().getResourceAsStream("hlavniStranka.fxml");
                Parent root = loader.load(stream);

                Stage stage = new Stage();
                stage.setTitle("Superbank");
                stage.setScene(new Scene(root, 410, 480));
                stage.show();

                HlavniStrankaController controller = loader.getController();
                controller.init(app);
                // Hide this current window (if this is what you want)
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });


        osobniUdaje.setOnMouseClicked((event) -> {

            try {
                FXMLLoader loader = new FXMLLoader();
                InputStream stream = getClass().getClassLoader().getResourceAsStream("osobniUdaje.fxml");
                Parent root = loader.load(stream);

                Stage stage = new Stage();
                stage.setTitle("Osobní údaje");
                stage.setScene(new Scene(root, 410, 480));
                stage.show();

                OsobniUdajeController controller = loader.getController();
                controller.init(app);
                // Hide this current window (if this is what you want)
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
