package controller;

import dev.shaankhan.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.Library;
import model.Patron;

public class RemovePatronController extends Controller<Library>
{
    @FXML private ListView patronsLv;

    public ObservableList<Patron> getPatrons() {
        return getLibrary().getPatrons();
    }

    private Patron getSelectedPatron() {
        return (Patron) patronsLv.getSelectionModel().getSelectedItem();
    }

    @FXML private void removePatron(ActionEvent actionEvent) {
        getPatrons().remove((getSelectedPatron()));
    }

    @FXML private void close(ActionEvent actionEvent) {
        stage.close();
    }

    public final Library getLibrary() {
        return model;
    }
}
