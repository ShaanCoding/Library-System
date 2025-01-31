package controller;

import dev.shaankhan.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Library;


public class AddBookController  extends Controller<Library>
{
    @FXML private TextField titleTf;
    @FXML private TextField authorTf;
    @FXML private TextField genreTf;
    @FXML private Text feedbackTxt;

    public String getTitle() {
        return titleTf.getText();
    }

    public String getAuthor() {
        return authorTf.getText();
    }

    public String getGenre() {
        return genreTf.getText();
    }

    @FXML private void addBook(ActionEvent actionEvent) {
        //Adds book to library - contains error handling if book with same data exists

        if(!getLibrary().getCatalogue().hasBook(getTitle(), getAuthor())) {
            getLibrary().getCatalogue().addBook(getTitle(), getAuthor(), getGenre());
            feedbackTxt.setText("Book added to Catalogue.");
        }
        else {
            feedbackTxt.setText("That book is already in the Catalogue.");
        }
    }

    @FXML private void close(ActionEvent actionEvent) {
        stage.close();
    }

    public final Library getLibrary() {
        return model;
    }
}
