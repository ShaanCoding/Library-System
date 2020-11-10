package controller;

import dev.shaankhan.javafx.Controller;
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

    @FXML private void close(ActionEvent actionEvent)
    {
        stage.close();
    }

    public final Library getLibrary() {
        return model;
    }
}
