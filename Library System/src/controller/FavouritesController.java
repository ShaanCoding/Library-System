package controller;

import dev.shaankhan.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Book;
import model.Library;
import model.Patron;

public class FavouritesController extends Controller<Library>
{
    @FXML private TextField patronIDTf;
    @FXML private Button showRecordBtn;
    @FXML private Text feedbackTxt;
    @FXML private ListView<Book> favouriteBooksLv;

    @FXML
    public void initialize()
    {
        patronIDTf.textProperty().addListener(
                (observable, oldText, newText) ->
                        showRecordBtn.setDisable(patronIDTf.getText().isEmpty())
        );
    }

    private int getPatronID() {
        return Integer.parseInt(patronIDTf.getText());
    }

    @FXML private void showFavourites(ActionEvent actionEvent) {
        Patron patron = getLibrary().getPatron(getPatronID());

        if(patron != null) {
            favouriteBooksLv.setItems(patron.favourites());
            feedbackTxt.setText(patron.getName() + "'s favourite books:");
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
