package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Author;
import model.Book;
import model.Library;
import model.Patron;

public class BorrowController extends Controller<Library>
{
    @FXML private TextField patronTf;
    @FXML private Button patronIDBtn;
    @FXML private ListView availableBooksLv;
    @FXML private Button borrowSelectedBookBtn;

    private int getPatronID() {
        return Integer.parseInt(patronTf.getText());
    }

    private Book getSelectedBook() {
        return (Book) availableBooksLv.getSelectionModel().getSelectedItem();
    }

    @FXML
    public void initialize() {
        patronTf.textProperty().addListener(
                (observer, oldText, newText) ->
                        patronIDBtn.setDisable(patronTf.getText().isEmpty())
        );

        availableBooksLv.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldBook, newBook) ->
                        borrowSelectedBookBtn.setDisable(newBook == null)
        );
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

            //Borrows the book
            getLibrary().getCatalogue().loanBookToPatron(borrowedBook, patron);
        }
    }

    @FXML private void close(ActionEvent actionEvent) {
        stage.close();
    }
}