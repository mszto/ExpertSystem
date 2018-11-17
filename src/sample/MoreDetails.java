package sample;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class MoreDetails {


    Parts part;
    Pane secondPane;
    Pane pane;
    CheckBox scretchCheckBox, brokenCheckBox, deformetCheckBox;
    Button closeButton, okButton;
    Car car;
    public MoreDetails() {

    }

    private void closeDetails() {
        closeButton.setOnAction(event -> {
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
        part = new Bumper();
        ((Bumper) part).setFront(true);
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
            pane.getChildren().remove(secondPane);
            pane.getChildren().forEach(node -> {
                node.setDisable(false);
            });
            part.doValuation();
            System.out.println(part.painting+part.workPrice+part.partPrice+" cały koszt");
            System.out.println(part.painting+" materiał lakierniczy");
        });
    }

    public MoreDetails(String element, Pane pane,Car car) {
        this.pane = pane;
        this.secondPane = new Pane();
        this.closeButton = new Button("X");
        this.okButton = new Button("ok");
        okButton.setLayoutY(180);
        closeButton.setLayoutX(480);
        this.car=car;
        switch (element) {
            case "zderzak przedni":
                bumperDetail(pane);

        }
    }

    public Parts getPart() {
        return part;
    }
}
