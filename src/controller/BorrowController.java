package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Author;
import model.Book;
import model.Library;
import model.Patron;

public class BorrowController extends Controller<Library>
{
    @FXML private TextField patronTf;
    @FXML private ListView availableBooksLv;

    /*
    Todo: replace with observable and update when user presses button
     */

    private int getPatronID() {
        return Integer.parseInt(patronTf.getText());
    }

    private Book getSelectedBook() {
        return (Book) availableBooksLv.getSelectionModel().getSelectedItem();
    }

    @FXML
    public void initialize() {

    }

    public final Library getLibrary() {
        return model;
    }

    @FXML private void selectPatron(ActionEvent actionEvent) {
        //Checks if empty before casting
        if(!patronTf.getText().isEmpty()) {
            Patron patron = getLibrary().getPatron(getPatronID());
            ObservableList<Book> bookObservableList = getLibrary().getCatalogue().getBorrowableBooks(patron);
            availableBooksLv.setItems(bookObservableList);
        }
    }

    @FXML private void borrowSelectedBook(ActionEvent actionEvent) {
        if(getSelectedBook() != null) {
            Book borrowedBook = getSelectedBook();
            Patron patron = getLibrary().getPatron(getPatronID());

            patron.borrowBook(borrowedBook);
        }
    }

    @FXML private void close(ActionEvent actionEvent) {
        stage.close();
    }
}
