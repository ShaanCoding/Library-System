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

    @FXML private void exploreCatalogue(ActionEvent event) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/catalogue.fxml", "Catalogue", new Stage());
        }
        catch(Exception ex) {

        }
    }

    @FXML private void patronRecord(ActionEvent event) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/record.fxml", "Patron Record", new Stage());
        }
        catch(Exception ex) {

        }
    }

    @FXML private void favouriteBooks(ActionEvent event) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/favourites.fxml", "Favourites", new Stage());
        }
        catch(Exception ex) {

        }
    }

    @FXML private void administrationMode(ActionEvent event) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/admin.fxml", "Administration Menu", new Stage());
        }
        catch(Exception ex) {

        }
    }

    @FXML private void exit(ActionEvent event) {
        //Exits the application
        stage.close();
    }
}
