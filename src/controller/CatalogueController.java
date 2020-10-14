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
        try {
            ViewLoader.showStage(getLibrary(), "/view/showAllBooks.fxml", "Complete Catalogue", stage);
        }
        catch(Exception ex) {

        }
    }

    @FXML private void availableBooks(ActionEvent actionEvent) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/showAvailableBooks.fxml", "Available Books", stage);
        }
        catch(Exception ex) {

        }
    }

    @FXML private void booksByGenre(ActionEvent actionEvent) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/showBooksByGenre.fxml", "Browse by Genre", stage);
        }
        catch(Exception ex) {

        }
    }

    @FXML private void booksByAuthor(ActionEvent actionEvent) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/showBooksByAuthor.fxml", "Browse by Author", stage);
        }
        catch(Exception ex) {

        }
    }

    @FXML private void borrowBooks(ActionEvent actionEvent) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/borrow.fxml", "Borrow a Book", stage);
        }
        catch(Exception ex) {

        }
    }

    @FXML private void returnBooks(ActionEvent actionEvent) {
        try {
            ViewLoader.showStage(getLibrary(), "/view/return.fxml", "Return a Book", stage);
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
        try {
            ViewLoader.showStage(getLibrary(), "/view/library.fxml", "Main menu", stage);
        }
        catch(Exception ex) {

        }
    }
}
