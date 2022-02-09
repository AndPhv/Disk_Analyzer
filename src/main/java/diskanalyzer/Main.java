package diskanalyzer;

import diskanalyzer.Analyzer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Paths;
import java.util.Map;

public class Main extends Application
{
    private Stage stage;
    private Map<String, Long> sizes;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.stage = stage;
        stage.setTitle("Disk analyzer");

        Button button = new Button("Choose directory");
        button.setOnAction(event -> {
            File file = new DirectoryChooser().showDialog(stage);
            String path = file.getAbsolutePath();
            sizes = new Analyzer().calculateDirectorySize(Paths.get(path));
        });
        StackPane pane = new StackPane();
        pane.getChildren().add(button);
        stage.setScene(new Scene(pane, 300, 250));
        stage.show();
    }
}
