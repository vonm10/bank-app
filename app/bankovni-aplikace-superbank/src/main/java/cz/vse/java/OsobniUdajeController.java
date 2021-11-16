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


public class OsobniUdajeController {

    public App app;
    public Produkt produkt;
    public Label name;
    public Label email;
    public Label telefon;
    public Button novaPlatba;
    public Button hlavniStranka;
    public Button osobniUdaje;

    public void updateScreen() {

    }

    /**
     * Metoda init
     *
     * V metodě se nastavují eventy na kliknutí na každé z tlačítek ve formuláři osobniUdaje.fxml
     */
    public void init(App app) {
        this.app = app;
        updateLabels();

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

    /**
     * Metoda updateLabels
     *
     * nastavuje text Labelů email,name,telefon na hodnoty které v sobě má načtený uživatel
     */
    public void updateLabels()
    {
        this.email.setText(app.getUzivatel().getEmail());
        this.name.setText(app.getUzivatel().getJmeno());
        this.telefon.setText(app.getUzivatel().getTelefon());
    }
}
