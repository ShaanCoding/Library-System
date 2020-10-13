package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Library;

public class CatalogueController extends Controller<Library>
{
    @FXML
    public void initialize() {

    }

    @FXML private final Library getLibrary() {
        return model;
    }

    @FXML private void allBooks(ActionEvent actionEvent) {

    }

    @FXML private void availableBooks(ActionEvent actionEvent) {

    }

    @FXML private void booksByGenre(ActionEvent actionEvent) {

    }

    @FXML private void booksByAuthor(ActionEvent actionEvent) {

    }

    @FXML private void borrowBooks(ActionEvent actionEvent) {

    }

    @FXML private void returnBooks(ActionEvent actionEvent) {

    }

    @FXML private void placeHold(ActionEvent actionEvent) {

    }

    @FXML private void exitCatalogue(ActionEvent actionEvent) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/library.fxml", "Main menu", stage);
        }
        catch(Exception ex) {

        }
    }
}
