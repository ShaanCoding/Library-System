package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.Book;
import model.Genre;
import model.Library;
import model.Patron;

public class ShowBooksByGenreController extends Controller<Library>
{
    @FXML private ListView genresLv;
    @FXML private ListView booksInGenreLv;

    public ObservableList<Genre> getAllGenres() {
        return getLibrary().getCatalogue().getGenres();
    }

    private Genre getSelectedGenre() {
        return (Genre) genresLv.getSelectionModel().getSelectedItem();
    }

    @FXML private void displayGenres(ActionEvent actionEvent) {
        if(getSelectedGenre() != null) {
            Genre genre = getSelectedGenre();
            ObservableList<Book> booksInGenre = getLibrary().getCatalogue().getBooksInGenre(genre);
            booksInGenreLv.setItems(booksInGenre);
        }
    }

    @FXML private void close(ActionEvent actionEvent) {
        stage.close();
    }

    public final Library getLibrary() {
        return model;
    }
}
