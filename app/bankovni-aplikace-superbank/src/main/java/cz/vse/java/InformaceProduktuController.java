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
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;


public class InformaceProduktuController {

    public App app;
    public Produkt produkt;
    public String nazev;
    public Label typProduktu;
    public Label majitel;
    public Label cisloUctu;
    public Button kartaHistorie;
    public Button kartaInformace;
    public Button zpet;

    public void updateScreen() {

    }

    /**
     * Metoda init
     *
     * V metodě se nastavují eventy na kliknutí na každé z tlačítek ve formuláři informaceProduktu.fxml
     */
    public void init(App app, Produkt produkt, String nazev) {
        this.app = app;
        this.produkt = produkt;
        this.nazev = nazev;
        updateLabels();

        kartaHistorie.setOnMouseClicked((event) -> {

            try {
                FXMLLoader loader = new FXMLLoader();
                InputStream stream = getClass().getClassLoader().getResourceAsStream("historieProduktu.fxml");
                Parent root = loader.load(stream);

                Stage stage = new Stage();
                stage.setTitle(nazev.toString() + " historie");
                stage.setScene(new Scene(root, 410, 480));
                stage.show();

                HistorieProduktuController controller = loader.getController();
                controller.init(app, produkt, nazev.toString());
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
     * Metoda updateLabels
     *
     * nastavuje text Labelů typProduktu,majitel,cisloUctu na hodnoty které v sobě má daný produkt/uživatel
     */
    public void updateLabels()
    {
        this.typProduktu.setText(produkt.getTypProduktu());
        this.majitel.setText(app.getUzivatel().getJmeno());
        this.cisloUctu.setText(produkt.getCislo());

    }
}
