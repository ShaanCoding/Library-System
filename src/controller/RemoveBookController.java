package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.Book;
import model.Library;

public class RemoveBookController extends Controller<Library>
{
    @FXML
    ListView booksLv;

    public ObservableList<Book> getBooks() {
        return getLibrary().getCatalogue().getAllBooks();
    }

    private Book getSelectedBooks() {
        return (Book) booksLv.getSelectionModel().getSelectedItem();
    }

    @FXML
    public void initialize() {

    }

    public final Library getLibrary() {
        return model;
    }

    @FXML private void removeBook(ActionEvent actionEvent) {
        if(getSelectedBooks() != null) {
            getBooks().remove(getSelectedBooks());
        }
    }

    @FXML private void close(ActionEvent actionEvent) {
        stage.close();
    }}
