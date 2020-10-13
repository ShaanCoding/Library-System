package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Library;

public class AdminController extends Controller<Library>
{
    @FXML
    public void initialize() {

    }

    @FXML
    private void addPatron(ActionEvent actionEvent) {

    }

    @FXML private void removePatron(ActionEvent actionEvent) {

    }

    @FXML private void addBook(ActionEvent actionEvent) {

    }

    @FXML private void removeBook(ActionEvent actionEvent) {

    }

    @FXML private void exitAdministration(ActionEvent actionEvent) {
        try{
            ViewLoader.showStage(getLibrary(), "/view/library.fxml", "Main menu", stage);
        }
        catch(Exception ex) {

        }
    }

    public final Library getLibrary() {
        return model;
    }
}
