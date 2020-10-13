package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Library;

import javax.swing.*;

public class LibraryController extends Controller<Library> {

    @FXML
    public void initialize() {

    }

    @FXML private void exploreCatalogue(ActionEvent event) {

    }

    @FXML private void patronRecord(ActionEvent event) {

    }

    @FXML private void favouriteBooks(ActionEvent event) {

    }

    @FXML private void administrationMode(ActionEvent event) {

    }

    @FXML private void exit(ActionEvent event) {
        //Exits the application
        stage.close();
    }

    public final Library getLibrary() {
        return model;
    }
}
