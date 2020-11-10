package controller;

import dev.shaankhan.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Library;

public class AddPatronController extends Controller<Library>
{
    @FXML private TextField patronIDTf;
    @FXML private TextField patronNameTf;
    @FXML private Text feedbackTxt;

    public int getPatronID() {
        return Integer.parseInt(patronIDTf.getText());
    }

    public String getPatronName() {
        return patronNameTf.getText();
    }

    @FXML private void addPatron(ActionEvent actionEvent) {
        //Adds patron to the list
        if(getLibrary().getPatron(getPatronID()) == null) {
            getLibrary().addPatron(getPatronID(), getPatronName());
            feedbackTxt.setText("Patron added.");
        }
        else {
            feedbackTxt.setText("Patron already exists!");
        }
    }

    @FXML private void close(ActionEvent actionEvent) {
        stage.close();
    }

    public final Library getLibrary() {
        return model;
    }
}
