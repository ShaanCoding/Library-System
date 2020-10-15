package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Library;

public class AdminController extends Controller<Library>
{
    @FXML
    public void initialize() {

    }

    @FXML
    private void addPatron(ActionEvent actionEvent) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/addPatron.fxml", "Add Patron", new Stage());
        }
        catch(Exception ex) {

        }
    }

    @FXML private void removePatron(ActionEvent actionEvent) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/removePatron.fxml", "Remove Patron", new Stage());
        }
        catch(Exception ex) {

        }
    }

    @FXML private void addBook(ActionEvent actionEvent) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/addBook.fxml", "Add Book", new Stage());
        }
        catch(Exception ex) {

        }
    }

    @FXML private void removeBook(ActionEvent actionEvent) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/removeBook.fxml", "Remove Book", new Stage());
        }
        catch(Exception ex) {

        }
    }

    @FXML private void exitAdministration(ActionEvent actionEvent) {
        stage.close();
    }

    public final Library getLibrary() {
        return model;
    }
}
