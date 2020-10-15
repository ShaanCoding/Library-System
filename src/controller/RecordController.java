package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Book;
import model.Library;
import model.Patron;

public class RecordController  extends Controller<Library>
{
    @FXML private TextField patronIDTf;
    @FXML private Text patronText;
    @FXML private ListView<Book> currentlyBorrowedLv;
    @FXML private ListView<Book> borrwedHistoryLv;

    private int getPatronID() {
        return Integer.parseInt(patronIDTf.getText());
    }

    private void setBorrowedBooks(Patron patron) {
        currentlyBorrowedLv.setItems(patron.currentlyBorrowed());
    }

    private void setBorrwingHistoryBooks(Patron patron) {
        borrwedHistoryLv.setItems(patron.borrowingHistory());
    }

    @FXML private void showRecord(ActionEvent actionEvent) {
        if(!patronIDTf.getText().isEmpty()) {
            Patron patron = getLibrary().getPatron(getPatronID());

            //Set patron text
            patronText.setText(patron.toString());
            setBorrowedBooks(patron);
            setBorrwingHistoryBooks(patron);
        }
    }

    @FXML
    public void initialize()
    {

    }

    public final Library getLibrary() {
        return model;
    }

    @FXML private void close(ActionEvent actionEvent) {
        stage.close();
    }
}
