package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Book;
import model.Library;
import model.Patron;

public class ReturnController extends Controller<Library>
{
    @FXML private TextField patronIDTf;
    @FXML private ListView<Book> borrowedBooksLv;
    @FXML private Button returnSelectedBookBtn;

    private Patron getPatron() {
        int patronID = Integer.parseInt(patronIDTf.getText());
        return getLibrary().getPatron(patronID);
    }

    private Book getBook() {
        return (Book) borrowedBooksLv.getSelectionModel().getSelectedItem();
    }

    @FXML
    public void initialize() {
        borrowedBooksLv.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldBook, newBook) ->
                        returnSelectedBookBtn.setDisable(newBook == null)
        );
    }

    public final Library getLibrary() {
        return model;
    }

    @FXML private void selectPatron(ActionEvent actionEvent) {
        //Checks if empty
        if(!patronIDTf.getText().isEmpty()) {
            Patron patron = getPatron();
            borrowedBooksLv.setItems(patron.currentlyBorrowed());
        }
    }

    @FXML private void returnSelectedBook(ActionEvent actionEvent) {
        //If return is selected we change from currently borrowing to borred and add it back to availablity
        Patron patron = getPatron();
        Book returnedBook = getBook();

        patron.returnBook(returnedBook);
    }

    @FXML private void close(ActionEvent actionEvent) {
        stage.close();
    }
}
