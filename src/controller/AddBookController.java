package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Library;


public class AddBookController  extends Controller<Library>
{
    @FXML private TextField titleTf;
    @FXML private TextField authorTf;
    @FXML private TextField genreTf;

    public String getTitle() {
        return titleTf.getText();
    }

    public String getAuthor() {
        return authorTf.getText();
    }

    public String getGenre() {
        return genreTf.getText();
    }

    @FXML
    public void initialize() {

    }

    public final Library getLibrary() {
        return model;
    }

    @FXML private void addBook(ActionEvent actionEvent) {
        //Adds book to library
        getLibrary().getCatalogue().addBook(getTitle(), getAuthor(), getGenre());
        titleTf.setText("");
        authorTf.setText("");
        genreTf.setText("");
        //System.out.println(getLibrary().getCatalogue().getAllBooks().get(0).toString());
    }

    @FXML private void close(ActionEvent actionEvent) {
        stage.close();
    }
}
