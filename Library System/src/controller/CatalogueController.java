package controller;

import dev.shaankhan.javafx.Controller;
import dev.shaankhan.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Library;

public class CatalogueController extends Controller<Library>
{
    @FXML private void allBooks(ActionEvent actionEvent) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/showAllBooks.fxml", "Complete Catalogue", new Stage());
    }

    @FXML private void availableBooks(ActionEvent actionEvent) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/showAvailableBooks.fxml", "Available Books", new Stage());
    }

    @FXML private void booksByGenre(ActionEvent actionEvent) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/showBooksByGenre.fxml", "Browse by Genre", new Stage());
    }

    @FXML private void booksByAuthor(ActionEvent actionEvent) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/showBooksByAuthor.fxml", "Browse by Author", new Stage());
    }

    @FXML private void borrowBooks(ActionEvent actionEvent) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/borrow.fxml", "Borrow a Book", new Stage());
    }

    @FXML private void returnBooks(ActionEvent actionEvent) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/return.fxml", "Return a Book", new Stage());
    }

    @FXML private void placeHold(ActionEvent actionEvent) throws Exception {
            ViewLoader.showStage(getLibrary(), "/view/placeHold.fxml", "Place a Hold", new Stage());
    }

    @FXML private void exitCatalogue(ActionEvent actionEvent) {
        stage.close();
    }

    private final Library getLibrary() {
        return model;
    }
}
