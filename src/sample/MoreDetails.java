package sample;


import carParts.*;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.Map;

public class MoreDetails {


    private Parts part;
    private Pane secondPane;
    private Pane pane;
    private CheckBox scretchCheckBox, brokenCheckBox, deformetCheckBox, lessThanTwoHand, moreThanTwoHands, moreThanThreeHands;
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
        moreThanThreeHands.setLayoutY(160);
        moreThanThreeHands.setLayoutX(150);
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
            deformetCheckBox.setDisable(false);
            brokenCheckBox.setDisable(false);
            scretchCheckBox.setDisable(true);
        });
        brokenCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            scretchCheckBox.setSelected(false);
            deformetCheckBox.setSelected(false);
            brokenCheckBox.setSelected(newValue);
            brokenCheckBox.setDisable(true);
            deformetCheckBox.setDisable(false);
            scretchCheckBox.setDisable(false);
        });
        deformetCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            scretchCheckBox.setSelected(false);
            brokenCheckBox.setSelected(false);
            deformetCheckBox.setSelected(newValue);
            deformetCheckBox.setDisable(true);
            brokenCheckBox.setDisable(false);
            scretchCheckBox.setDisable(false);
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

    private void checkBoxSelect(CheckBox first, CheckBox second, CheckBox third) {
        first.selectedProperty().addListener((observable, oldValue, newValue) -> {
            second.setSelected(false);
            third.setSelected(false);
            first.setSelected(newValue);
            first.setDisable(true);
            second.setDisable(false);
            third.setDisable(false);
            okButton.setDisable(false);
        });

        second.selectedProperty().addListener((observable, oldValue, newValue) -> {
            first.setSelected(false);
            third.setSelected(false);
            second.setSelected(newValue);
            first.setDisable(false);
            second.setDisable(true);
            third.setDisable(false);
            okButton.setDisable(false);
        });

        third.selectedProperty().addListener((observable, oldValue, newValue) -> {
            first.setSelected(false);
            second.setSelected(false);
            third.setSelected(newValue);
            first.setDisable(false);
            second.setDisable(false);
            third.setDisable(true);
            okButton.setDisable(false);
        });
    }

    private void checkBoxSelectAndMore() {
        scretchCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            brokenCheckBox.setSelected(false);
            deformetCheckBox.setSelected(false);
            scretchCheckBox.setSelected(newValue);
            lessThanTwoHand.setSelected(false);
            moreThanThreeHands.setSelected(false);
            moreThanTwoHands.setSelected(false);
            deformetCheckBox.setDisable(false);
            brokenCheckBox.setDisable(false);
            scretchCheckBox.setDisable(true);
            secondPane.getChildren().removeAll(lessThanTwoHand, moreThanTwoHands);
            okButton.setDisable(false);
        });
        brokenCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            scretchCheckBox.setSelected(false);
            deformetCheckBox.setSelected(false);
            brokenCheckBox.setSelected(newValue);
            lessThanTwoHand.setSelected(false);
            moreThanThreeHands.setSelected(false);
            moreThanTwoHands.setSelected(false);
            brokenCheckBox.setDisable(true);
            deformetCheckBox.setDisable(false);
            scretchCheckBox.setDisable(false);
            secondPane.getChildren().removeAll(lessThanTwoHand, moreThanTwoHands);
            okButton.setDisable(false);
        });
        deformetCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            scretchCheckBox.setSelected(false);
            brokenCheckBox.setSelected(false);
            deformetCheckBox.setSelected(newValue);
            deformetCheckBox.setDisable(true);
            brokenCheckBox.setDisable(false);
            scretchCheckBox.setDisable(false);
            secondPane.getChildren().addAll(lessThanTwoHand, moreThanTwoHands);
            checkBoxSelect(lessThanTwoHand, moreThanTwoHands);
        });
    }

    private void disableDetailsDeformet(boolean value) {
        lessThanTwoHand.setDisable(value);
        moreThanTwoHands.setDisable(value);
        moreThanThreeHands.setDisable(value);
    }

    private void checkBoxSelectAndAddThree() {
        scretchCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            brokenCheckBox.setSelected(false);
            deformetCheckBox.setSelected(false);
            scretchCheckBox.setSelected(newValue);
            lessThanTwoHand.setSelected(false);
            moreThanThreeHands.setSelected(false);
            moreThanTwoHands.setSelected(false);
            deformetCheckBox.setDisable(false);
            brokenCheckBox.setDisable(false);
            scretchCheckBox.setDisable(true);
            secondPane.getChildren().removeAll(lessThanTwoHand, moreThanTwoHands, moreThanThreeHands);
            okButton.setDisable(false);
        });
        brokenCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            scretchCheckBox.setSelected(false);
            deformetCheckBox.setSelected(false);
            brokenCheckBox.setSelected(newValue);
            lessThanTwoHand.setSelected(false);
            moreThanThreeHands.setSelected(false);
            moreThanTwoHands.setSelected(false);
            brokenCheckBox.setDisable(true);
            deformetCheckBox.setDisable(false);
            scretchCheckBox.setDisable(false);
            secondPane.getChildren().removeAll(lessThanTwoHand, moreThanTwoHands, moreThanThreeHands);
            okButton.setDisable(false);
        });
        deformetCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            secondPane.getChildren().removeAll(lessThanTwoHand, moreThanTwoHands, moreThanThreeHands);
            scretchCheckBox.setSelected(false);
            brokenCheckBox.setSelected(false);


            deformetCheckBox.setSelected(newValue);
            deformetCheckBox.setDisable(true);
            brokenCheckBox.setDisable(false);
            scretchCheckBox.setDisable(false);
            okButton.setDisable(true);

            secondPane.getChildren().addAll(lessThanTwoHand, moreThanTwoHands, moreThanThreeHands);
            checkBoxSelect(lessThanTwoHand, moreThanTwoHands, moreThanThreeHands);
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
            part.setMoreThanThreeHands(moreThanThreeHands.isSelected());
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
                pane.getChildren().add(secondPane);
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
            case "drzwi przednie prawe":
                part = new FrontDoor();
                part.setIsRight(true);
                pane.getChildren().remove(secondPane);
                scretchCheckBox.setText("porysowane");
                deformetCheckBox.setText("wgniecione");
                lessThanTwoHand.setText("mniejsze niż 1 dłoń");
                moreThanTwoHands.setText("miedzy 1-3 dłonie");
                moreThanThreeHands.setText("Więcej niż 3 dłonie");
                closeDetails();
                checkBoxSelectAndAddThree();
                secondPane.getChildren().addAll(scretchCheckBox, deformetCheckBox, closeButton, okButton);
                pane.getChildren().add(secondPane);
                getMoreDetails();
                break;
            case "drzwi przednie lewe":
                part = new FrontDoor();
                part.setIsRight(false);
                pane.getChildren().remove(secondPane);
                scretchCheckBox.setText("porysowane");
                deformetCheckBox.setText("wgniecione");
                lessThanTwoHand.setText("mniejsze niż 1 dłoń");
                moreThanTwoHands.setText("miedzy 1-3 dłonie");
                moreThanThreeHands.setText("Więcej niż 3 dłonie");
                closeDetails();
                checkBoxSelectAndAddThree();
                secondPane.getChildren().addAll(scretchCheckBox, deformetCheckBox, closeButton, okButton);
                pane.getChildren().add(secondPane);
                getMoreDetails();
                break;
            case "drzwi tylne lewe":
                part = new FrontDoor();
                part.setIsRight(false);
                pane.getChildren().remove(secondPane);
                scretchCheckBox.setText("porysowane");
                deformetCheckBox.setText("wgniecione");
                lessThanTwoHand.setText("mniejsze niż 1 dłoń");
                moreThanTwoHands.setText("miedzy 1-3 dłonie");
                moreThanThreeHands.setText("Więcej niż 3 dłonie");
                closeDetails();
                checkBoxSelectAndAddThree();
                secondPane.getChildren().addAll(scretchCheckBox, deformetCheckBox, closeButton, okButton);
                pane.getChildren().add(secondPane);
                getMoreDetails();
                break;

            case "drzwi tylne prawe":
                part = new FrontDoor();
                part.setIsRight(true);
                part.setBack(true);
                pane.getChildren().remove(secondPane);
                scretchCheckBox.setText("porysowane");
                deformetCheckBox.setText("wgniecione");
                lessThanTwoHand.setText("mniejsze niż 1 dłoń");
                moreThanTwoHands.setText("miedzy 1-3 dłonie");
                moreThanThreeHands.setText("Więcej niż 3 dłonie");
                closeDetails();
                checkBoxSelectAndAddThree();
                secondPane.getChildren().addAll(scretchCheckBox, deformetCheckBox, closeButton, okButton);
                pane.getChildren().add(secondPane);
                getMoreDetails();
                break;

            case "błotnik tylny lewy":
                part = new RearFender();
                part.setIsRight(false);
                part.setBack(true);
                pane.getChildren().remove(secondPane);
                scretchCheckBox.setText("porysowane");
                deformetCheckBox.setText("wgniecione");
                brokenCheckBox.setText("rozerwany");
                lessThanTwoHand.setText("mniejsze niż 1 dłoń");
                moreThanTwoHands.setText("miedzy 1-3 dłonie");
                moreThanThreeHands.setText("Więcej niż 3 dłonie");
                closeDetails();
                checkBoxSelectAndAddThree();
                secondPane.getChildren().addAll(scretchCheckBox, deformetCheckBox,brokenCheckBox, closeButton, okButton);
                pane.getChildren().add(secondPane);
                getMoreDetails();
                break;
            case "błotnik tylny prawy":
                part = new RearFender();
                part.setIsRight(true);
                part.setBack(true);
                pane.getChildren().remove(secondPane);
                scretchCheckBox.setText("porysowane");
                deformetCheckBox.setText("wgniecione");
                brokenCheckBox.setText("rozerwany");
                lessThanTwoHand.setText("mniejsze niż 1 dłoń");
                moreThanTwoHands.setText("miedzy 1-3 dłonie");
                moreThanThreeHands.setText("Więcej niż 3 dłonie");
                closeDetails();
                checkBoxSelectAndAddThree();
                secondPane.getChildren().addAll(scretchCheckBox, deformetCheckBox,brokenCheckBox, closeButton, okButton);
                pane.getChildren().add(secondPane);
                getMoreDetails();
                break;
            case "maska":
                part = new Hood();
                pane.getChildren().remove(secondPane);
                scretchCheckBox.setText("porysowane");
                deformetCheckBox.setText("wgniecione");
                lessThanTwoHand.setText("mniejsze niż 1 dłoń");
                moreThanTwoHands.setText("miedzy 1-3 dłonie");
                moreThanThreeHands.setText("Więcej niż 3 dłonie");
                closeDetails();
                checkBoxSelectAndAddThree();
                secondPane.getChildren().addAll(scretchCheckBox, deformetCheckBox, closeButton, okButton);
                pane.getChildren().add(secondPane);
                getMoreDetails();
                break;
            case "dach":
                part = new Roof();
                pane.getChildren().remove(secondPane);
                scretchCheckBox.setText("porysowane");
                deformetCheckBox.setText("wgniecione");
                lessThanTwoHand.setText("mniejsze niż 1 dłoń");
                moreThanTwoHands.setText("miedzy 1-3 dłonie");
                moreThanThreeHands.setText("Więcej niż 3 dłonie");
                closeDetails();
                checkBoxSelectAndAddThree();
                secondPane.getChildren().addAll(scretchCheckBox, deformetCheckBox, closeButton, okButton);
                pane.getChildren().add(secondPane);
                getMoreDetails();
                break;
            case "klapa bagażnika":
                part = new TailGate();
                pane.getChildren().remove(secondPane);
                scretchCheckBox.setText("porysowane");
                deformetCheckBox.setText("wgniecione");
                lessThanTwoHand.setText("mniejsze niż 1 dłoń");
                moreThanTwoHands.setText("miedzy 1-3 dłonie");
                moreThanThreeHands.setText("Więcej niż 3 dłonie");
                closeDetails();
                checkBoxSelectAndAddThree();
                secondPane.getChildren().addAll(scretchCheckBox, deformetCheckBox, closeButton, okButton);
                pane.getChildren().add(secondPane);
                getMoreDetails();
                break;
            case "lusterko prawe":
                part = new Mirror();
                part.setIsRight(true);
                pane.getChildren().remove(secondPane);
                scretchCheckBox.setText("porysowane");
                brokenCheckBox.setText("Urwane/uszkodzona obudowa");
                closeDetails();
                checkBoxSelect();
                secondPane.getChildren().addAll(scretchCheckBox, brokenCheckBox, closeButton, okButton);
                pane.getChildren().add(secondPane);
                getMoreDetails();
                break;
            case "lusterko lewe":
                part = new Mirror();
                pane.getChildren().remove(secondPane);
                scretchCheckBox.setText("porysowane");
                brokenCheckBox.setText("Urwane/uszkodzona obudowa");
                closeDetails();
                checkBoxSelect();
                secondPane.getChildren().addAll(scretchCheckBox, brokenCheckBox, closeButton, okButton);
                pane.getChildren().add(secondPane);
                getMoreDetails();
                break;
            case "lampa przednia prawa":
                part = new HeadLight();
                part.setIsRight(true);
                pane.getChildren().remove(secondPane);
                scretchCheckBox.setText("porysowane");
                brokenCheckBox.setText("Urwane/uszkodzona obudowa");
                deformetCheckBox.setText("Pęknięte szkło");
                closeDetails();
                checkBoxSelect();
                secondPane.getChildren().addAll(scretchCheckBox, deformetCheckBox,brokenCheckBox, closeButton, okButton);
                pane.getChildren().add(secondPane);
                getMoreDetails();
                break;
            case "lampa przednia lewa":
                part = new HeadLight();
                pane.getChildren().remove(secondPane);
                scretchCheckBox.setText("porysowane");
                brokenCheckBox.setText("Urwane/uszkodzona obudowa");
                deformetCheckBox.setText("Pęknięte szkło");
                closeDetails();
                checkBoxSelect();
                secondPane.getChildren().addAll(scretchCheckBox, deformetCheckBox,brokenCheckBox, closeButton, okButton);
                pane.getChildren().add(secondPane);
                getMoreDetails();
                break;
            case "lampa tylna prawa":
                part = new HeadLight();
                part.setIsRight(true);
                part.setBack(true);
                pane.getChildren().remove(secondPane);
                scretchCheckBox.setText("porysowane");
                brokenCheckBox.setText("Urwane/uszkodzona obudowa");
                deformetCheckBox.setText("Pęknięte szkło");
                closeDetails();
                checkBoxSelect();
                secondPane.getChildren().addAll(scretchCheckBox, deformetCheckBox,brokenCheckBox, closeButton, okButton);
                pane.getChildren().add(secondPane);
                getMoreDetails();
                break;
            case "lampa tylna lewa":
                part = new HeadLight();
                part.setBack(true);
                pane.getChildren().remove(secondPane);
                scretchCheckBox.setText("porysowane");
                brokenCheckBox.setText("Urwane/uszkodzona obudowa");
                deformetCheckBox.setText("Pęknięte szkło");
                closeDetails();
                checkBoxSelect();
                secondPane.getChildren().addAll(scretchCheckBox, deformetCheckBox,brokenCheckBox, closeButton, okButton);
                pane.getChildren().add(secondPane);
                getMoreDetails();
                break;
            case "próg prawy":
                part = new Sill();
                part.setIsRight(true);
                pane.getChildren().remove(secondPane);
                scretchCheckBox.setText("porysowane");
                deformetCheckBox.setText("wgniecione");
                lessThanTwoHand.setText("mniejsze niż 1 dłoń");
                moreThanTwoHands.setText("miedzy 1-3 dłonie");
                moreThanThreeHands.setText("Więcej niż 3 dłonie");
                closeDetails();
                checkBoxSelectAndAddThree();
                secondPane.getChildren().addAll(scretchCheckBox, deformetCheckBox, closeButton, okButton);
                pane.getChildren().add(secondPane);
                getMoreDetails();
                break;
            case "próg lewy":
                part = new Sill();
                pane.getChildren().remove(secondPane);
                scretchCheckBox.setText("porysowane");
                deformetCheckBox.setText("wgniecione");
                lessThanTwoHand.setText("mniejsze niż 1 dłoń");
                moreThanTwoHands.setText("miedzy 1-3 dłonie");
                moreThanThreeHands.setText("Więcej niż 3 dłonie");
                closeDetails();
                checkBoxSelectAndAddThree();
                secondPane.getChildren().addAll(scretchCheckBox, deformetCheckBox, closeButton, okButton);
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

        this.brokenCheckBox = new CheckBox();
        this.deformetCheckBox = new CheckBox();
        this.scretchCheckBox = new CheckBox();
        this.lessThanTwoHand = new CheckBox();
        this.moreThanTwoHands = new CheckBox();
        this.moreThanThreeHands = new CheckBox();

        initialize();

    }

    public Parts getPart() {
        return part;
    }
}
