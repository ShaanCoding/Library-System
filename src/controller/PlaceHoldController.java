package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Author;
import model.Book;
import model.Library;
import model.Patron;

public class PlaceHoldController extends Controller<Library>
{
    @FXML private TextField patronIDTf;
    @FXML private Button selectPatronIDBtn;
    @FXML private Button holdBookBtn;
    @FXML private ListView<Book> availableBooksLv;
    @FXML private Text holdResponseText;

    private Patron getPatron() {
        int patronID = Integer.parseInt(patronIDTf.getText());
        return getLibrary().getPatron(patronID);
    }

    private Book getSelectedBook() {
        return (Book) availableBooksLv.getSelectionModel().getSelectedItem();
    }

    @FXML
    public void initialize() {
        patronIDTf.textProperty().addListener(
                (observable, oldTextField, newTextField) ->
                        selectPatronIDBtn.setDisable(patronIDTf.getText().isEmpty())
        );

        availableBooksLv.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldBook, newBook) ->
                        holdBookBtn.setDisable(newBook == null)
        );
    }

    public final Library getLibrary() {
        return model;
    }

    @FXML private void selectPatron(ActionEvent actionEvent) {
        if(!patronIDTf.getText().isEmpty()) {
            Patron patron = getPatron();
            availableBooksLv.setItems(getLibrary().getCatalogue().getBorrowableBooks(patron));
        }
    }

    @FXML private void holdSelectedBook(ActionEvent actionEvent) {
        //We need to remove book from observable list and then redefine source for listview
        //Also update text

        if(!patronIDTf.getText().isEmpty()) {
            Patron patron = getPatron();
            Book borrowedBook = getSelectedBook();
            patron.borrowBook(borrowedBook);
            //availableBooksLv.setItems(getLibrary().getCatalogue().getBorrowableBooks(patron)); DON'T THINK WE NEED TO UPDATE
            holdResponseText.setText("Hold placed on " + borrowedBook.getTitle() + " for " + patron.getName());
        }

    }

    @FXML private void close(ActionEvent actionEvent) {
        stage.close();
    }
}
