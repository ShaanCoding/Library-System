package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Library;

public class AddPatronController extends Controller<Library>
{
    @FXML private TextField patronIDTf;
    @FXML private TextField patronNameTf;

    public int getPatronID() {
        return Integer.parseInt(patronIDTf.getText());
    }

    public String getPatronName() {
        return patronNameTf.getText();
    }

    @FXML private void addPatron(ActionEvent actionEvent) {
        //Adds patron to the list

        /*
            Todo: Add text "Patron added." if new patron is added else "Patron already exists!" if patron exists
         */
        getLibrary().addPatron(getPatronID(), getPatronName());
    }

    @FXML private void close(ActionEvent actionEvent) {
        stage.close();
    }

    @FXML
    public void initialize() {

    }

    public final Library getLibrary() {
        return model;
    }
}
