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
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Set;


public class NovaPlatbaController {

    public App app;
    public Produkt produkt;
    public ComboBox vyberProduktu;
    public TextField cisloUctu;
    public TextField castka;
    public Button novaPlatba;
    public Button hlavniStranka;
    public Button osobniUdaje;
    public Button potvrditPlatbu;

    JsonFileManager jsonFileManager;

    public void updateScreen() {

    }

    /**
     * Metoda init po kliknutí na tlačítko potvrdit platbu ve formuláři novaPlatba.fxml nejprve validuje pomoc metody Validate() zda jsou vstupní hodnoty v pořádku a poté provede transakci a zaznamená do JSONu/XML
     *
     * V metodě se nastavují eventy na kliknutí na každé z tlačítek ve formuláři novaPlatba.fxml
     */
    public void init(App app) {
        this.app = app;
        jsonFileManager = new JsonFileManager();

        // Combobox vyber produktu
        Set<String> products = app.getUzivatel().getProdukty().keySet();
        vyberProduktu.setEditable(false);
        vyberProduktu.getItems().addAll(products);

        potvrditPlatbu.setOnMouseClicked((event) -> {
            String nazevVybranehoProduktu = (String) vyberProduktu.getValue();
            Produkt vybranyProdukt = app.getUzivatel().getProdukt(nazevVybranehoProduktu);

            if(Validate() == false){

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Špatně zadané parametry nové platby");
                alert.setHeaderText("čáska i čislo učtu musí být zadány jako číslo, učet musí mít 9 číslic a musí být vybrán produkt");
                alert.setContentText("Platba nebyla provedena");

                alert.showAndWait();
            }

            else if (app.novaPlatba(vybranyProdukt, cisloUctu.getText(), Integer.parseInt(castka.getText())) == true)
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Potvrzení platby");
                alert.setHeaderText("Opravdu chcete provést zadanou platbu?");
                alert.setContentText("Zvolte OK pro potvrzení, Cancel pro zrušení");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    vybranyProdukt.pridatTransakci("Převod na účet " + cisloUctu.getText(), Integer.parseInt(castka.getText()));
                    cisloUctu.setText("");
                    castka.setText("");
                } else {
                    vybranyProdukt.setZustatek(Integer.parseInt(castka.getText()));
                }
                try {
                    jsonFileManager.save(app.getUzivatel());
                    //XmlFileManager xmlFileManager = new XmlFileManager();
                    //xmlFileManager.save(app.getUzivatel());
                    //pokud chceme uložit do XML
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Nedostatečný zůstatek");
                alert.setHeaderText("Na zvoleném produktu nemáte dostatečné prostředky");
                alert.setContentText("Platba nebyla provedena");

                alert.showAndWait();
            }
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

    /**
     * Metoda Validate
     *
     *obsahuje regex na castku(musí obsahovat čísla) regex na cisloUctu(musí být devítimístné) a combobox vyberProduktu nesmí být prázdný aby byla metoda validní jinak vrací false
     */
    public boolean Validate()
    {
        if(this.castka.getText().matches("[0-9]*") && this.cisloUctu.getText().matches("[0-9]{9}") && this.vyberProduktu.getValue() != null){
            return true;
        }
        return false;
    }
}
