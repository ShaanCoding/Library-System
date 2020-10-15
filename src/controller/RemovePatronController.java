package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.Library;
import model.Patron;

public class RemovePatronController extends Controller<Library>
{
    @FXML ListView patronsLv;

    public ObservableList<Patron> getPatrons() {
        return getLibrary().getPatrons();
    }

    private Patron getSelectedPatron() {
        return (Patron) patronsLv.getSelectionModel().getSelectedItem();
    }

    @FXML
    public void initialize() {

    }

    public final Library getLibrary() {
        return model;
    }

    @FXML private void removePatron(ActionEvent actionEvent) {
        if(getSelectedPatron() != null) {
            getPatrons().remove((getSelectedPatron()));
            //System.out.println(getSelectedPatron().getName());
        }
    }

    @FXML private void close(ActionEvent actionEvent) {
        stage.close();
    }
}
