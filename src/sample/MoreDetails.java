package sample;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.util.List;

public class MoreDetails {


    private Parts part;
    private Pane secondPane;
    private Pane pane;
    private CheckBox scretchCheckBox, brokenCheckBox, deformetCheckBox;
    private Button closeButton, okButton;
    private Car car;
    private String element;
    private List<String> selectedParts;
    public MoreDetails() {

    }

    private void closeDetails() {
        closeButton.setOnAction(event -> {
            secondPane.getChildren().clear();
            pane.getChildren().remove(secondPane);
            pane.getChildren().forEach(node -> {
                node.setDisable(false);
            });
        });
    }

    private void checkBoxSelect() {
        scretchCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            brokenCheckBox.setSelected(false);
            deformetCheckBox.setSelected(false);
            scretchCheckBox.setSelected(newValue);
        });
        brokenCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            scretchCheckBox.setSelected(false);
            deformetCheckBox.setSelected(false);
            brokenCheckBox.setSelected(newValue);
        });
        deformetCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            scretchCheckBox.setSelected(false);
            brokenCheckBox.setSelected(false);
            deformetCheckBox.setSelected(newValue);
        });
    }

    private void bumperDetail(Pane pane) {
        pane.getChildren().remove(secondPane);
        scretchCheckBox = new CheckBox("prysowony");
        brokenCheckBox = new CheckBox("urwany/rozcięty");
        deformetCheckBox = new CheckBox("odkształcony");
        brokenCheckBox.setLayoutY(50);
        deformetCheckBox.setLayoutY(100);
        secondPane.setLayoutX(200);
        secondPane.setLayoutY(150);
        secondPane.setStyle("-fx-background-color: #4283f4");
        secondPane.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        secondPane.setMinSize(500, 200);
        pane.getChildren().forEach(node -> {
            node.setDisable(true);
        });
        secondPane.setDisable(false);
        pane.getChildren().add(secondPane);
        checkBoxSelect();
        closeDetails();
        secondPane.getChildren().addAll(scretchCheckBox, brokenCheckBox, deformetCheckBox, closeButton, okButton);

        okButton.setOnAction(event -> {
            ((Bumper) part).setBroken(brokenCheckBox.isSelected());
            ((Bumper) part).setScrachet(scretchCheckBox.isSelected());
            ((Bumper) part).setDented(deformetCheckBox.isSelected());
            secondPane.getChildren().clear();
            pane.getChildren().remove(secondPane);
            pane.getChildren().forEach(node -> {
                node.setDisable(false);
            });
            part.doValuation(car);
            selectedParts.add(element);

        });
    }

    public void ChoiseWindow() {
        switch (element) {
            case "zderzak przedni":
                part = new Bumper();
                ((Bumper) part).setFront(true);
                bumperDetail(pane);
                break;
            case "zderzak tylny":
                part = new Bumper();
                ((Bumper) part).setBack(true);
                bumperDetail(pane);
                break;
            case "błotnik przedni prawy":
                break;
            case "błotnik przedni lewy":
                break;

        }
    }

    public MoreDetails(String element, Pane pane, Car car,List<String> select) {
        this.pane = pane;
        this.secondPane = new Pane();
        this.closeButton = new Button("X");
        this.okButton = new Button("ok");
        okButton.setLayoutY(180);
        closeButton.setLayoutX(480);
        this.car = car;
        this.element = element;
        this.selectedParts=select;
    }

    public Parts getPart() {
        return part;
    }
}
