package cz.vse.java.main;
/**
 * Třída Start
 *
 * třída spouští hlavniStranka.fxml a k ní HlavniStrankaController jako úvodní stránku s předurčenou velikostí
 *
 * @author Matyáš Vondra
 * @author Jaroslava Ludrinská
 * @author Patrik Novák
 * @version 25-01-2021
 */


import cz.vse.java.HlavniStrankaController;
import cz.vse.java.model.App;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.InputStream;


public final class Start extends Application {

	public void main() {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		App app = new App();

		System.out.println("Startuji");

		primaryStage.setTitle("Superbank");

		primaryStage.show();

		FXMLLoader loader = new FXMLLoader();
		InputStream stream = getClass().getClassLoader().getResourceAsStream("hlavniStranka.fxml");
		Parent root = loader.load(stream);

		Scene scene = new Scene(root, 410, 480);
		primaryStage.setScene(scene);
		primaryStage.setFullScreen(false);

		HlavniStrankaController controller = loader.getController();
		controller.init(app);
	}

}
