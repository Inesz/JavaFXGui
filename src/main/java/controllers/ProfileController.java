package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.LanguageModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProfileController {

    @FXML
    Button btn1;

    @FXML
    ChoiceBox language;

    Pane mainPane;
    Text joke = new Text();
    List<String> jokes = new ArrayList() {{
        add("Hear about the new restaurant called Karma? There is no menu: You get what you deserve.");
        add("Did you hear about the claustrophobic astronaut? He just needed a little space.");
        add("Where are average things manufactured? The satisfactory.");
    }};

    public void changeColor(ActionEvent actionEvent) {
        btn1.setDefaultButton(!btn1.isDefaultButton());
    }

    public void showJoke(ActionEvent actionEvent) {
        setMainPane(actionEvent);
        mainPane.getChildren().clear();
        mainPane.getChildren().add(joke);
        joke.setText(getJoke());
    }

    void setMainPane(ActionEvent actionEvent) {
        AnchorPane pane = (AnchorPane) ((Button) actionEvent.getSource()).getParent().getParent().getParent();
        mainPane = (Pane) pane.getChildren().get(1);
    }

    String getJoke() {
        int randomInt = ThreadLocalRandom.current().nextInt(0, jokes.size());
        return jokes.get(randomInt);
    }

    @FXML
    void initialize() {
        initLang();
    }

    void initLang() {
        ObservableList lang = FXCollections.observableArrayList(
                new LanguageModel("EN_GB", "English United Kingdom", 1),
                new LanguageModel("EN_US", "English United States", 2));
        language.setItems(lang);

        language.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                String langDesc = ((LanguageModel) language.getItems().get((Integer) newValue)).getLangDescription();
                System.out.println(langDesc);
            }
        });
    }

}
