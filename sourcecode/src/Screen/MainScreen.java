package Screen;

import controller.MainScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainScreen extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Stage primaryStage;
    // Scene scene1, scene2, scene3;

    @Override
    public void start(Stage primaryStage) {

        try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/MainScreen.fxml"));
            MainScreenController controller = new MainScreenController();
            fxmlloader.setController(controller);
            Parent root = fxmlloader.load();
            Scene scene = new Scene(root);

            primaryStage.setTitle("VIRUS MAIN MENU");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
}