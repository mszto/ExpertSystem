package sample;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoreDetails {


    private Parts part;
    private Pane secondPane;
    private Pane pane;
    private CheckBox scretchCheckBox, brokenCheckBox, deformetCheckBox, lessThanTwoHand, moreThanTwoHands;
    private Button closeButton, okButton;
    private Car car;
    private String element;
    private List<String> selectedParts;
    private CheckBox sedan, hatchback, kombi;
    private Map<String, Parts> listPart;

    public MoreDetails() {

    }

    private void initialize() {
        lessThanTwoHand.setLayoutY(80);
        lessThanTwoHand.setLayoutX(150);
        moreThanTwoHands.setLayoutX(150);
        moreThanTwoHands.setLayoutY(120);
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
    }

    private void disabeldType() {
        sedan.setDisable(true);
        hatchback.setDisable(true);
        kombi.setDisable(true);
    }

    private void closeDetails() {
        closeButton.setOnAction(event -> {
            secondPane.getChildren().clear();
            pane.getChildren().remove(secondPane);
            pane.getChildren().forEach(node -> {
                node.setDisable(false);
            });
            disabeldType();
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

    private void checkBoxSelect(CheckBox first, CheckBox second) {
        first.selectedProperty().addListener((observable, oldValue, newValue) -> {
            second.setSelected(false);
            first.setSelected(newValue);
            okButton.setDisable(false);
        });

        second.selectedProperty().addListener((observable, oldValue, newValue) -> {
            first.setSelected(false);
            second.setSelected(newValue);
            okButton.setDisable(false);
        });
    }

    private void checkBoxSelectAndMore() {
        scretchCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            brokenCheckBox.setSelected(false);
            deformetCheckBox.setSelected(false);
            scretchCheckBox.setSelected(newValue);
            secondPane.getChildren().removeAll(lessThanTwoHand, moreThanTwoHands);
            okButton.setDisable(false);
        });
        brokenCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            scretchCheckBox.setSelected(false);
            deformetCheckBox.setSelected(false);
            brokenCheckBox.setSelected(newValue);
            secondPane.getChildren().removeAll(lessThanTwoHand, moreThanTwoHands);
            okButton.setDisable(false);
        });
        deformetCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            scretchCheckBox.setSelected(false);
            brokenCheckBox.setSelected(false);
            deformetCheckBox.setSelected(newValue);
            secondPane.getChildren().addAll(lessThanTwoHand, moreThanTwoHands);
            checkBoxSelect(lessThanTwoHand, moreThanTwoHands);
        });
    }


    private void bumperDetail(Pane pane) {
        pane.getChildren().remove(secondPane);
        scretchCheckBox.setText("prysowony");
        brokenCheckBox.setText("urwany/rozcięty");
        deformetCheckBox.setText("odkształcony");
        checkBoxSelect();
        closeDetails();
        secondPane.getChildren().addAll(scretchCheckBox, brokenCheckBox, deformetCheckBox, closeButton, okButton);

        okButton.setOnAction(event -> {
            part.setBroken(brokenCheckBox.isSelected());
            part.setScratched(scretchCheckBox.isSelected());
            part.setDented(deformetCheckBox.isSelected());
            secondPane.getChildren().clear();
            pane.getChildren().remove(secondPane);
            pane.getChildren().forEach(node -> {
                node.setDisable(false);
            });
            disabeldType();
            part.doValuation(car);
            listPart.put(element, part);
            selectedParts.add(element);

        });
    }

    private void frontFenderDetail() {
        okButton.setDisable(true);
        pane.getChildren().remove(secondPane);
        scretchCheckBox.setText("prysowony");
        brokenCheckBox.setText("urwany/rozcięty");
        deformetCheckBox.setText("wgnieciony");
        lessThanTwoHand.setText("mniejsze niż 2 dłonie");
        moreThanTwoHands.setText("większe niż 2 dłonie");
        initialize();
        checkBoxSelectAndMore();
        closeDetails();
        secondPane.getChildren().addAll(scretchCheckBox, brokenCheckBox, deformetCheckBox, closeButton, okButton);

        okButton.setOnAction(event -> {
            part.setScratch(scretchCheckBox.isSelected());
            part.setDented(deformetCheckBox.isSelected());
            part.setBroken(brokenCheckBox.isSelected());
            part.setScratch(scretchCheckBox.isSelected());
            part.setLessThaTwoHeands(lessThanTwoHand.isSelected());
            part.setMoreThanTwoHeands(moreThanTwoHands.isSelected());
            secondPane.getChildren().clear();
            pane.getChildren().remove(secondPane);
            pane.getChildren().forEach(node -> {
                node.setDisable(false);
            });
            disabeldType();
            part.doValuation(car);
            listPart.put(element, part);
            selectedParts.add(element);

        });
    }

    private void getMoreDetails() {

        okButton.setOnAction(event -> {
            part.setScratch(scretchCheckBox.isSelected());
            part.setDented(deformetCheckBox.isSelected());
            part.setBroken(brokenCheckBox.isSelected());
            part.setScratch(scretchCheckBox.isSelected());
            part.setLessThaTwoHeands(lessThanTwoHand.isSelected());
            part.setMoreThanTwoHeands(moreThanTwoHands.isSelected());
            secondPane.getChildren().clear();
            pane.getChildren().remove(secondPane);
            pane.getChildren().forEach(node -> {
                node.setDisable(false);
            });
            disabeldType();
            part.doValuation(car);
            listPart.put(element, part);
            selectedParts.add(element);

        });
    }

    public void ChoiseWindow() {
        switch (element) {
            case "zderzak przedni":
                pane.getChildren().remove(secondPane);
                part = new Bumper();
                part.setFront(true);
                scretchCheckBox.setText("prysowony");
                brokenCheckBox.setText("urwany/rozcięty");
                deformetCheckBox.setText("odkształcony");
                checkBoxSelect();
                closeDetails();
                secondPane.getChildren().addAll(scretchCheckBox, brokenCheckBox, deformetCheckBox, closeButton, okButton);
                pane.getChildren().add(secondPane);
                getMoreDetails();
                break;
            case "zderzak tylny":
                part = new Bumper();
                part.setBack(true);
                pane.getChildren().remove(secondPane);
                scretchCheckBox.setText("prysowony");
                brokenCheckBox.setText("urwany/rozcięty");
                deformetCheckBox.setText("odkształcony");
                checkBoxSelect();
                closeDetails();
                secondPane.getChildren().addAll(scretchCheckBox, brokenCheckBox, deformetCheckBox, closeButton, okButton);
                getMoreDetails();
                break;
            case "błotnik przedni prawy":
                part = new FrondFender();
                part.setIsRight(true);
                okButton.setDisable(true);
                pane.getChildren().remove(secondPane);
                scretchCheckBox.setText("prysowony");
                brokenCheckBox.setText("urwany/rozcięty");
                deformetCheckBox.setText("wgnieciony");
                lessThanTwoHand.setText("mniejsze niż 2 dłonie");
                moreThanTwoHands.setText("większe niż 2 dłonie");
                checkBoxSelectAndMore();
                closeDetails();
                secondPane.getChildren().addAll(scretchCheckBox, brokenCheckBox, deformetCheckBox, closeButton, okButton);
                pane.getChildren().add(secondPane);
                getMoreDetails();
                break;
            case "błotnik przedni lewy":
                part = new FrondFender();
                part.setLeft(true);
                pane.getChildren().remove(secondPane);
                scretchCheckBox.setText("prysowony");
                brokenCheckBox.setText("urwany/rozcięty");
                deformetCheckBox.setText("wgnieciony");
                lessThanTwoHand.setText("mniejsze niż 2 dłonie");
                moreThanTwoHands.setText("większe niż 2 dłonie");
                checkBoxSelectAndMore();
                closeDetails();
                secondPane.getChildren().addAll(scretchCheckBox, brokenCheckBox, deformetCheckBox, closeButton, okButton);
                pane.getChildren().add(secondPane);
                getMoreDetails();
                break;

        }
    }

    public MoreDetails(String element, Pane pane, Car car, List<String> select, CheckBox sedan, CheckBox hatchback, CheckBox kombi, Map<String, Parts> listP) {
        this.pane = pane;
        this.secondPane = new Pane();
        this.closeButton = new Button("X");
        this.okButton = new Button("ok");
        okButton.setLayoutY(180);
        closeButton.setLayoutX(480);
        this.car = car;
        this.element = element;
        this.selectedParts = select;
        this.sedan = sedan;
        this.hatchback = hatchback;
        this.kombi = kombi;
        this.listPart = listP;

        this.brokenCheckBox= new CheckBox();
        this.deformetCheckBox= new CheckBox();
        this.scretchCheckBox = new CheckBox();
        this.lessThanTwoHand= new CheckBox();
        this.moreThanTwoHands= new CheckBox();

        initialize();

    }

    public Parts getPart() {
        return part;
    }
}
