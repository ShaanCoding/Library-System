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

public class FavouritesController extends Controller<Library>
{
    @FXML private TextField patronIDTf;
    @FXML private Text feedbackTxt;
    @FXML private ListView<Book> favouriteBooksLv;

    @FXML
    public void initialize()
    {

    }

    public final Library getLibrary() {
        return model;
    }

    private int getPatronID() {
        return Integer.parseInt(patronIDTf.getText());
    }

    @FXML private void showFavourites(ActionEvent actionEvent) {
        if(!patronIDTf.getText().isEmpty()) {
            Patron patron = getLibrary().getPatron(getPatronID());
            favouriteBooksLv.setItems(patron.favourites());
        }
    }

    @FXML private void close(ActionEvent actionEvent) {
        stage.close();
    }
}
