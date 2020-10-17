package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.Author;
import model.Book;
import model.Genre;
import model.Library;

public class ShowBooksByAuthorController extends Controller<Library>
{
    @FXML
    private ListView authorsLv;
    @FXML private ListView booksInAuthorLv;

    public ObservableList<Author> getAllAuthors() {
        return getLibrary().getCatalogue().getAuthors();
    }

    private Author getSelectedAuthor() {
        return (Author) authorsLv.getSelectionModel().getSelectedItem();
    }

    @FXML
    public void initialize() {

    }

    public final Library getLibrary() {
        return model;
    }

    @FXML private void displayAuthors(ActionEvent actionEvent) {
        if(getSelectedAuthor() != null) {
            Author author = getSelectedAuthor();
            ObservableList<Book> booksInAuthor = getLibrary().getCatalogue().getBooksByAuthor(author);
            booksInAuthorLv.setItems(booksInAuthor);
        }
    }

    @FXML private void close(ActionEvent actionEvent) {
        stage.close();
    }
}
