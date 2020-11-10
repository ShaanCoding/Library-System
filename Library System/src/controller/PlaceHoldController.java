package controller;

import dev.shaankhan.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Book;
import model.Library;
import model.Patron;

public class PlaceHoldController extends Controller<Library>
{
    @FXML private TextField patronIDTf;
    @FXML private Button selectPatronIDBtn;
    @FXML private Button holdBookBtn;
    @FXML private ListView<Book> availableBooksLv;
    @FXML private Text feedbackTxt;

    private Patron getPatron() {
        int patronID = Integer.parseInt(patronIDTf.getText());
        return getLibrary().getPatron(patronID);
    }

    private Book getSelectedBook() {
        return (Book) availableBooksLv.getSelectionModel().getSelectedItem();
    }

    public ObservableList<Book> getAvailableBooks() {
        return getLibrary().getCatalogue().getBooksOnShelf();
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

    @FXML private void selectPatron(ActionEvent actionEvent) {
            Patron patron = getPatron();
            if(patron == null) {
                feedbackTxt.setText("No Patron selected");
            }
    }

    @FXML private void holdSelectedBook(ActionEvent actionEvent) {
        //We need to remove book from observable list and then redefine source for listview, also update text

        Patron patron = getPatron();
        if(patron != null) {
            Book borrowedBook = getSelectedBook();

            //If the book is unheld we then can do it, otherwise we can't process it
            if(borrowedBook.patronWithFirstHold() == null) {
                borrowedBook.addHold(patron);
                //availableBooksLv.setItems(getLibrary().getCatalogue().getBorrowableBooks(patron)); DON'T THINK WE NEED TO UPDATE
                feedbackTxt.setText("Hold placed on " + borrowedBook.getTitle() + " for " + patron.getName());
            }
            else {
                Patron bookHolder = borrowedBook.patronWithFirstHold();
                feedbackTxt.setText(bookHolder.getName() + " has already placed a hold on " + borrowedBook.getTitle());
            }
        }
        else {
            feedbackTxt.setText("No Patron selected");
        }
    }

    @FXML private void close(ActionEvent actionEvent) { stage.close(); }

    public final Library getLibrary() {
        return model;
    }
}
