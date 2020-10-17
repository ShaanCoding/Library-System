package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Library;

public class LibraryController extends Controller<Library> {

    @FXML
    public void initialize() {

    }

    public final Library getLibrary() {
        return model;
    }

    @FXML private void exploreCatalogue(ActionEvent event) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/catalogue.fxml", "Catalogue", new Stage());
    }

    @FXML private void patronRecord(ActionEvent event) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/record.fxml", "Patron Record", new Stage());
    }

    @FXML private void favouriteBooks(ActionEvent event) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/favourites.fxml", "Favourites", new Stage());
    }

    @FXML private void administrationMode(ActionEvent event) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/admin.fxml", "Administration Menu", new Stage());
    }

    @FXML private void exit(ActionEvent event) {
        //Exits the application
        stage.close();
    }
}
