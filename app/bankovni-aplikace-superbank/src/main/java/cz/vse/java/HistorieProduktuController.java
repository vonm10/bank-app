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


public class HistorieProduktuController {

    public App app;
    public Produkt produkt;
    public VBox historie;
    public Label zustatek;
    public Label nazevHistorie;
    public String nazev;
    public Button kartaHistorie;
    public Button kartaInformace;
    public Button zpet;

    public void updateScreen() {

    }

    /**
     * Metoda init
     *
     * V metodě se nastavují eventy na kliknutí na každé z tlačítek ve formuláři historieProduktu.fxml
     */
    public void init(App app, Produkt produkt, String nazev) {
        this.app = app;
        this.produkt = produkt;
        this.nazev = nazev;
        updateHistorie();

        kartaInformace.setOnMouseClicked((event) -> {

            try {
                FXMLLoader loader = new FXMLLoader();
                InputStream stream = getClass().getClassLoader().getResourceAsStream("informaceProduktu.fxml");
                Parent root = loader.load(stream);

                Stage stage = new Stage();
                stage.setTitle("Informace produktu");
                stage.setScene(new Scene(root, 410, 480));
                stage.show();

                InformaceProduktuController controller = loader.getController();
                controller.init(app, produkt, nazev);
                // Hide this current window (if this is what you want)
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        zpet.setOnMouseClicked(event -> {
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
    }
    /**
     * Metoda ...
     * @return Vrací
     * @param
     *
     */

    public void updateHistorie()
    {
        nazevHistorie.setText(nazev);
        zustatek.setText("Zůstatek: " + String.valueOf(produkt.getZustatek()));


        produkt.getHistorie().forEach((operace,castka) -> {


            VBox hisorieView = new VBox();
            Label operaceView = new Label(operace.toString());
            Label castkaView = new Label(String.valueOf(castka) + " Kč");

            hisorieView.getChildren().add(operaceView);
            hisorieView.getChildren().add(castkaView);

            historie.getChildren().add(hisorieView);
            //dsfsd???? co to - k smazani?

        });
    }
    /**
     * Metoda updateHistorie
     *
     *
     *
     */



}
