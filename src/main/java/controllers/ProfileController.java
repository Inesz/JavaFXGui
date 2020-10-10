package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProfileController {

    @FXML
    Button btn1;

    Pane mainPane;
    Text joke = new Text();

    public void changeColor(ActionEvent actionEvent) {
        btn1.setDefaultButton(!btn1.isDefaultButton());
    }

    public void showJoke(ActionEvent actionEvent) {
        setMainPane(actionEvent);
        mainPane.getChildren().clear();
        mainPane.getChildren().add(joke);
        joke.setText(getJoke());
    }

    void setMainPane(ActionEvent actionEvent){
        AnchorPane pane = (AnchorPane) ((Button)actionEvent.getSource()).getParent().getParent().getParent();
        mainPane = (Pane) pane.getChildren().get(1);
    }

    List<String> jokes = new ArrayList() {{
        add("Hear about the new restaurant called Karma? There is no menu: You get what you deserve.");
        add("Did you hear about the claustrophobic astronaut? He just needed a little space.");
        add("Where are average things manufactured? The satisfactory.");
    }};

    String getJoke(){
        int randomInt = ThreadLocalRandom.current().nextInt(0, jokes.size());
        return jokes.get(randomInt);
    }
}
