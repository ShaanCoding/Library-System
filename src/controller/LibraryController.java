package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Library;

import javax.swing.*;

public class LibraryController extends Controller<Library> {

    @FXML
    public void initialize() {

    }

    public final Library getLibrary() {
        return model;
    }

    @FXML private void exploreCatalogue(ActionEvent event) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/catalogue.fxml", "Catalogue", stage);
        }
        catch(Exception ex) {

        }
    }

    @FXML private void patronRecord(ActionEvent event) {

    }

    @FXML private void favouriteBooks(ActionEvent event) {

    }

    @FXML private void administrationMode(ActionEvent event) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/admin.fxml", "Administration Menu", stage);
        }
        catch(Exception ex) {

        }
    }

    @FXML private void exit(ActionEvent event) {
        //Exits the application
        stage.close();
    }
}
