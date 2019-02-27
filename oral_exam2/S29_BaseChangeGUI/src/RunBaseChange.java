import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main class to run the BaseChange javaFX
 */
public class RunBaseChange extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root =
                FXMLLoader.load(getClass().getResource("BaseChangeGUI.fxml"));

        Scene scene = new Scene(root); // attach scene graph to scene
        primaryStage.setTitle("BaseChange"); // displayed in window's title bar
        primaryStage.setScene(scene); // attach scene to stage
        primaryStage.show(); // display the stage
    }
}
