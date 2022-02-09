import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
    private Stage stage;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.stage = stage;
        stage.setTitle("Disk analyzer");
    }
}
