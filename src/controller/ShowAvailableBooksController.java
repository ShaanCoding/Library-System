package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import model.Book;
import model.Library;

public class ShowAvailableBooksController extends Controller<Library>
{
    @FXML
    private TableView<Book> booksTv;

    public ObservableList<Book> getAvailableBooks() {
        return getLibrary().getCatalogue().getBooksOnShelf();
    }

    @FXML
    public void initialize() {

    }

    public final Library getLibrary() {
        return model;
    }

    @FXML private void close(ActionEvent actionEvent)
    {
        stage.close();
    }
}
