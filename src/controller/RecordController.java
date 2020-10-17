package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Book;
import model.Library;
import model.Patron;

public class RecordController  extends Controller<Library>
{
    @FXML private TextField patronIDTf;
    @FXML private Button showRecordBtn;
    @FXML private Text feedbackTxt;
    @FXML private ListView<Book> currentlyBorrowedLv;
    @FXML private ListView<Book> borrowedHistoryLv;

    @FXML
    public void initialize() {
        patronIDTf.textProperty().addListener(
                (observable, oldText, newText) ->
                        showRecordBtn.setDisable(patronIDTf.getText().isEmpty())
        );
    }

    private int getPatronID() {
        return Integer.parseInt(patronIDTf.getText());
    }

    private void setBorrowedBooks(Patron patron) {
        currentlyBorrowedLv.setItems(patron.currentlyBorrowed());
    }

    private void setBorrwingHistoryBooks(Patron patron) {
        borrowedHistoryLv.setItems(patron.borrowingHistory());
    }

    @FXML private void showRecord(ActionEvent actionEvent) {
        Patron patron = getLibrary().getPatron(getPatronID());

        //Checks if patron exists
        if(patron != null) {
            //Set patron text
            feedbackTxt.setText(patron.toString());
            setBorrowedBooks(patron);
            setBorrwingHistoryBooks(patron);
        }
        else {
            feedbackTxt.setText("No Patron selected");
        }
    }

    @FXML private void close(ActionEvent actionEvent) {
        stage.close();
    }

    public final Library getLibrary() {
        return model;
    }
}
