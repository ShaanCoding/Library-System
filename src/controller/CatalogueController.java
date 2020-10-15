package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
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
        try {
            ViewLoader.showStage(getLibrary(), "/view/showAllBooks.fxml", "Complete Catalogue", new Stage());
        }
        catch(Exception ex) {

        }
    }

    @FXML private void availableBooks(ActionEvent actionEvent) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/showAvailableBooks.fxml", "Available Books", new Stage();
        }
        catch(Exception ex) {

        }
    }

    @FXML private void booksByGenre(ActionEvent actionEvent) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/showBooksByGenre.fxml", "Browse by Genre", new Stage();
        }
        catch(Exception ex) {

        }
    }

    @FXML private void booksByAuthor(ActionEvent actionEvent) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/showBooksByAuthor.fxml", "Browse by Author", new Stage();
        }
        catch(Exception ex) {

        }
    }

    @FXML private void borrowBooks(ActionEvent actionEvent) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/borrow.fxml", "Borrow a Book", new Stage();
        }
        catch(Exception ex) {

        }
    }

    @FXML private void returnBooks(ActionEvent actionEvent) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/return.fxml", "Return a Book", new Stage();
        }
        catch(Exception ex) {

        }
    }

    @FXML private void placeHold(ActionEvent actionEvent) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/placeHold.fxml", "Place a Hold", stage);
        }
        catch(Exception ex) {

        }
    }

    @FXML private void exitCatalogue(ActionEvent actionEvent) {
        stage.close();
    }
}
