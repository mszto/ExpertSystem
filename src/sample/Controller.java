package sample;


import carParts.Car;
import carParts.Parts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Controller {

    private IntegerTextField year = new IntegerTextField();
    public Pane pane;
    public Button okButton;
    public Label textLabel;
    private Label labelCar;
    private TextField carMakeTextField;
    private DatebaseConnection datebaseConnection;
    private ResultSet rs;
    private List<Button> buttonsCar;
    private List<Button> carModelsList;
    private Button backButton, addElementButton,convert,deleteElementButton;
    private ComboBox carElementList;
    private ListView<String> partsSelectedComboBox;
    private CheckBox sedanCheckBox, kombiCheckBox, hatchbackCheckBox;
    private Car car;
    private ObservableList<String> selectedParts = FXCollections.observableArrayList();
    private Map<String, Parts> listPart=new HashMap<>();

    public void initialize() {
        year.setLayoutX(300);
        year.setLayoutY(200);
        pane.getChildren().addAll(year);
    }

    public Controller() {
        addElementButton = new Button("Dodaj");
        addElementButton.setLayoutY(170);

    }

    private void ConvertListener(){
        convert.setOnAction(event -> {
            float cout= (float) 0.0;
            Sumary sumary=new Sumary();
            sumary.setLayoutY(300);
            pane.getChildren().add(sumary);
            for (String part:selectedParts) {
                Parts parts=listPart.get(part);
                cout+=parts.getPainting()+parts.getWorkPrice()+parts.getPartPrice();
                sumary.addPart(parts,part);
                sumary.setY(sumary.getY()+50);
            }

            if(sumary.getHeight()+sumary.getLayoutY()>pane.getHeight()){
                pane.setMinHeight(sumary.getHeight()+sumary.getLayoutY());
            }
            convert.setText(String.format("%.2f",cout)+" zł");
        });
    }

    private boolean checkSelectedItems(String element) {
        for (int i = 0; i < selectedParts.size(); i++) {
            if (selectedParts.get(i).equals(element))
                return true;
        }
        return false;
    }

    private void addElementListener() {
        if (addElementButton != null) {

            addElementButton.setOnAction(event -> {
                String element;
                System.out.println(carElementList.getSelectionModel().getSelectedItem());
                element = String.valueOf(carElementList.getSelectionModel().getSelectedItem());
                element = element.toLowerCase();
                if (checkSelectedItems(element)) {
                    System.out.println(element + " został już wybrany");
                } else {

                    if (sedanCheckBox.isSelected()) {
                        car.setType(sedanCheckBox.getText().toLowerCase());
                    } else if (hatchbackCheckBox.isSelected()) {
                        car.setType(hatchbackCheckBox.getText().toLowerCase());
                    } else {
                        car.setType(kombiCheckBox.getText().toLowerCase());
                    }
                    MoreDetails moreDetails = new MoreDetails(element, pane, car, selectedParts, sedanCheckBox, hatchbackCheckBox, kombiCheckBox,listPart);
                    moreDetails.ChoiseWindow();
                    deleteElementButton.setDisable(true);
                }
            });
        }
    }

    private void bodyTypeCheckBox() {
        sedanCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            hatchbackCheckBox.setSelected(false);
            kombiCheckBox.setSelected(false);
            sedanCheckBox.setSelected(newValue);
            hatchbackCheckBox.setDisable(false);
            kombiCheckBox.setDisable(false);
            sedanCheckBox.setDisable(true);
        });
        hatchbackCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            sedanCheckBox.setSelected(false);
            kombiCheckBox.setSelected(false);
            hatchbackCheckBox.setSelected(newValue);
            hatchbackCheckBox.setDisable(true);
            kombiCheckBox.setDisable(false);
            sedanCheckBox.setDisable(false);
        });
        kombiCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            sedanCheckBox.setSelected(false);
            hatchbackCheckBox.setSelected(false);
            kombiCheckBox.setSelected(newValue);
            hatchbackCheckBox.setDisable(false);
            kombiCheckBox.setDisable(true);
            sedanCheckBox.setDisable(false);
        });
    }

    private void addButtonsToScene(String columnLabel, List<Button> listButtons) {
        listButtons.clear();
        if (rs != null) {
            try {
                int x = 10;
                int y = 100;
                int i = 0;
                int prefsize = 200;

                while (rs.next()) {
                    i += 1;
                    Button button = new Button(rs.getString(columnLabel));
                    button.setMinSize(200, 70);
                    button.setLayoutX(x);
                    button.setLayoutY(y);
                    x += 200;
                    if (i == 4) {
                        i = 0;
                        y += 100;
                        x = 10;
                        prefsize += 100;
                    }
                    listButtons.add(button);

                    pane.getChildren().add(button);
                    pane.setMinHeight(prefsize);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Label label = new Label("Brak Wyników");
            pane.getChildren().add(label);
        }
    }

    private void carMakeScene() {
        for (Button but : buttonsCar
                ) {
            but.setOnAction(event1 -> {
                pane.getChildren().clear();
                labelCar.setText("Wybierz model pojazdu");
                pane.getChildren().addAll(backButton,labelCar);
                rs = datebaseConnection.getData("Select car_model from cars where car_make='" + but.getText() + "' and car_model_year=" + year.getText());

                carModelsList = new ArrayList<>();

                addButtonsToScene("car_model", carModelsList);
                carModelListener(but.getText().toLowerCase());
            });
        }
    }

    private void carMakeFilter(String carMakeTextField) {
        String car = carMakeTextField.toLowerCase();
        String car2;
        Button lastButton = null;
        int i = 0;
        for (Button button : buttonsCar
                ) {
            car2 = button.getText().toLowerCase();
            pane.getChildren().remove(button);

            if (car2.contains(car)) {

                if (lastButton != null) {
                    if (i == 4) {
                        button.setLayoutX(10);
                        button.setLayoutY(lastButton.getLayoutY() + 100);
                        i = 0;
                    } else {
                        button.setLayoutX(lastButton.getLayoutX() + 200);
                        button.setLayoutY(lastButton.getLayoutY());
                    }
                    pane.getChildren().add(button);
                } else {
                    button.setLayoutY(100);
                    button.setLayoutX(10);
                    pane.getChildren().add(button);
                }
                lastButton = button;
                i += 1;
            }
        }
    }

    private void carModelListener(String carMake) {
        for (Button button : carModelsList
                ) {
            button.setOnAction(event -> {
                Button back = new Button("Nowy pojazd");
                deleteElementButton=new Button("Usuń element");
                Label labelCar = new Label(carMake.toUpperCase() + " " + button.getText().toUpperCase());
                Label label1=new Label("Wybrane części: ");
                Label label2=new Label("Wybierz częścii z listy poniżej:");
                sedanCheckBox = new CheckBox("sedan");
                hatchbackCheckBox = new CheckBox("hatchback");
                kombiCheckBox = new CheckBox("kombi");
                convert=new Button("Przelicz");
                car = new Car(carMake, button.getText().toLowerCase(), year.getText());
                partsSelectedComboBox=new ListView<>();
                carElementList = new ComboBox();
                ObservableList<String> elementsList = FXCollections.observableArrayList();

                label2.setLayoutY(90);
                label1.setLayoutX(350);
                label1.setLayoutY(90);
                labelCar.setFont(new Font("Cambria", 24));
                labelCar.setLayoutX(150);

                convert.setLayoutY(250);
                convert.setLayoutX(550);
                convert.setPrefSize(200,100);

                sedanCheckBox.setSelected(true);
                sedanCheckBox.setDisable(true);
                sedanCheckBox.setLayoutY(50);

                hatchbackCheckBox.setLayoutX(150);
                hatchbackCheckBox.setLayoutY(50);
                kombiCheckBox.setLayoutX(300);
                kombiCheckBox.setLayoutY(50);


                partsSelectedComboBox.setLayoutY(120);
                partsSelectedComboBox.setLayoutX(350);
                partsSelectedComboBox.setMaxHeight(50);
                carElementList.setLayoutY(120);
                partsSelectedComboBox.setOnMouseClicked(event1 -> {deleteElementButton.setDisable(false);});

                deleteElementButton.setLayoutY(120);
                deleteElementButton.setLayoutX(600);
                deleteElementButton.setDisable(true);

                pane.getChildren().clear();

                partsSelectedComboBox.setItems(selectedParts);
                elementsList.addAll("Błotnik Przedni Prawy", "Błotnik Przedni Lewy", "Zderzak Przedni", "Maska", "Lampa Przednia Lewa", "Lampa Przednia Prawa");
                elementsList.addAll("Lusterko Lewe", "Lusterko Prawe", "Drzwi Przednie Prawe", "Drzwi Przednie Lewe", "Drzwi tylne Prawe", "Drzwi Tylne Lewe");
                elementsList.addAll("Próg Prawy", "Próg Lewy", "Listwa Ozdobna Na Drzwiach Lewych", "Listwa Ozdobna na drzwiach Prawych", "Błotnik tylny lewy", "Błotnik tylny prawy");
                elementsList.addAll("Lampa tylna lewa", "Lampa tylna Prawa", "Zderzak Tylny", "Klapa Bagażnika", "Dach");
                carElementList.setItems(elementsList);

                pane.getChildren().addAll(carElementList, addElementButton, kombiCheckBox, hatchbackCheckBox, sedanCheckBox, labelCar, back,convert,partsSelectedComboBox,label2,label1,deleteElementButton);
                bodyTypeCheckBox();
                addElementListener();
                back.setOnAction(event1 -> {
                    pane.getChildren().clear();
                    pane.getChildren().addAll(year, okButton, textLabel);
                    listPart.clear();
                    selectedParts.clear();
                    pane.setMinHeight(600);
                });
                ConvertListener();
            });
        }
    }

    public void ActionOkYearCar(ActionEvent event) {
        carMakeTextField = new TextField();
        datebaseConnection = DatebaseConnection.getInstance();
        buttonsCar = new ArrayList<>();
        labelCar=new Label("Wynierz markę samochodu:");
        Label label2=new Label("Wybierz model pojazdu");
        carMakeTextField.setPromptText("Wyszukaj");
        pane.getChildren().clear();
        Button back=new Button("Wróć");
        back.setLayoutX(250);
        labelCar.setLayoutY(50);
        labelCar.setLayoutX(300);
        back.setOnAction(event1 -> {
            pane.getChildren().clear();
            pane.getChildren().addAll(year, okButton, textLabel);
        });
        pane.getChildren().addAll(carMakeTextField,back,labelCar);
        rs = datebaseConnection.getData("Select car_make from cars where car_model_year=" + year.getText() + " group by car_make");


        addButtonsToScene("car_make", buttonsCar);

        carMakeTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            carMakeFilter(carMakeTextField.getText());
        });

        backButton = new Button("Wróć");
        carMakeScene();

        backButton.setOnAction(event2 -> {
            pane.getChildren().clear();
            labelCar.setText("Wynierz markę samochodu:");
            rs = datebaseConnection.getData("Select car_make from cars where car_model_year=" + year.getText() + " group by car_make");

            pane.getChildren().addAll(carMakeTextField,back,labelCar);
            addButtonsToScene("car_make", buttonsCar);
            carMakeScene();

        });

    }

}
