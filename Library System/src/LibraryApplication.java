import dev.shaankhan.javafx.ViewLoader;
import javafx.stage.*;
import javafx.application.Application;
import model.Library;

public class LibraryApplication extends Application {
    
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ViewLoader.showStage(new Library(), "/view/library.fxml", "Main Menu", stage);
    }
}
