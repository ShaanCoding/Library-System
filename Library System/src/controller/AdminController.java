package controller;

import dev.shaankhan.javafx.Controller;
import dev.shaankhan.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Library;

public class AdminController extends Controller<Library>
{
    @FXML
    private void addPatron(ActionEvent actionEvent) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/addPatron.fxml", "Add Patron", new Stage());
    }

    @FXML private void removePatron(ActionEvent actionEvent) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/removePatron.fxml", "Remove Patron", new Stage());
    }

    @FXML private void addBook(ActionEvent actionEvent) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/addBook.fxml", "Add Book", new Stage());
    }

    @FXML private void removeBook(ActionEvent actionEvent) throws Exception {
        ViewLoader.showStage(getLibrary(), "/view/removeBook.fxml", "Remove Book", new Stage());
    }

    @FXML private void exitAdministration(ActionEvent actionEvent) {
        stage.close();
    }

    public final Library getLibrary() {
        return model;
    }
}
