package sample;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    private IntegerTextField year = new IntegerTextField();
    public Pane pane;
    public Button okButton;
    public Label textLabel;
    private TextField carMakeTextField;
    private DatebaseConnection datebaseConnection;
    private ResultSet rs;
    private List<Button> buttonsCar;
    private List<Button> carModelsList;
    private Button backButton, addElementButton;
    private ComboBox carElementList;
    private CheckBox sedanCheckBox, kombiCheckBox, hatchbackCheckBox;
    private List<String> brokenElemnts;
    private Pane secondPane;
    private List<Parts> listParts = new ArrayList<>();
    private Car car;
    private List<String> selectedParts=new ArrayList<>();

    public void initialize() {
        year.setLayoutX(300);
        year.setLayoutY(200);
        pane.getChildren().addAll(year);
    }

    public Controller() {
        addElementButton = new Button("Dodaj");
        addElementButton.setLayoutY(150);
    }
    private boolean eqal(String x,String y){
        return x.equals(y);
    }
    private boolean checkSelectedItems(String element){
        for(int i=0;i<selectedParts.size();i++){
            if(selectedParts.get(i).equals(element))
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
                if(checkSelectedItems(element)){
                    System.out.println(element+" został już wybrany");
                }else {

                    if (sedanCheckBox.isSelected()) {
                        car.setType(sedanCheckBox.getText().toLowerCase());
                    } else if (hatchbackCheckBox.isSelected()) {
                        car.setType(hatchbackCheckBox.getText().toLowerCase());
                    } else {
                        car.setType(kombiCheckBox.getText().toLowerCase());
                    }
                    MoreDetails moreDetails = new MoreDetails(element, pane, car,selectedParts);
                    moreDetails.ChoiseWindow();
                }
            });
        }
    }

    private void bodyTypeCheckBox() {
        sedanCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            hatchbackCheckBox.setSelected(false);
            kombiCheckBox.setSelected(false);
            sedanCheckBox.setSelected(newValue);
        });
        hatchbackCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            sedanCheckBox.setSelected(false);
            kombiCheckBox.setSelected(false);
            hatchbackCheckBox.setSelected(newValue);
        });
        kombiCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            sedanCheckBox.setSelected(false);
            hatchbackCheckBox.setSelected(false);
            kombiCheckBox.setSelected(newValue);
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

                pane.getChildren().add(backButton);
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

                System.out.println(button.getText());
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
                Button back=new Button("Nowy pojazd");

                Label labelCar=new Label(carMake.toUpperCase()+" "+button.getText().toUpperCase());
                labelCar.setFont(new Font("Cambria",24));
                labelCar.setLayoutX(150);
                 car = new Car(carMake, button.getText().toLowerCase(), year.getText());

                sedanCheckBox = new CheckBox("sedan");
                hatchbackCheckBox = new CheckBox("hatchback");
                kombiCheckBox = new CheckBox("kombi");

                sedanCheckBox.setSelected(true);
                sedanCheckBox.setLayoutY(50);
                hatchbackCheckBox.setLayoutX(150);
                hatchbackCheckBox.setLayoutY(50);
                kombiCheckBox.setLayoutX(300);
                kombiCheckBox.setLayoutY(50);

                carElementList = new ComboBox();
                carElementList.setLayoutY(100);
                ObservableList<String> elementsList = FXCollections.observableArrayList();
                pane.getChildren().clear();

                elementsList.addAll("Błotnik Przedni Prawy", "Błotnik Przedni Lewy", "Zderzak Przedni", "Maska", "Lampa Przednia Lewa", "Lampa Przedmia Prawa");
                elementsList.addAll("Lusterko Lewe", "Lusterko Prawe", "Drzwi Przednie Prawe", "Drzwi Przednie Lewe", "Drzwi tylne Prawe", "Drzwi Tylne Lewe");
                elementsList.addAll("Próg Prawy", "Próg Lewy", "Listwa Ozdobna Na Drzwiach Lewych", "Listwa Ozdobna na drzwiach Prawych", "Błotnik tylny lewy", "Błotnik tylny prawy");
                elementsList.addAll("Lamapa tylna lewa", "Lampa tylna Prawa", "Zderzak Tylny", "Klapa Bagażnika", "Dach");
                carElementList.setItems(elementsList);

                pane.getChildren().addAll(carElementList, addElementButton, kombiCheckBox, hatchbackCheckBox, sedanCheckBox,labelCar,back);
                bodyTypeCheckBox();
                addElementListener();
                back.setOnAction(event1 -> {
                    pane.getChildren().clear();
                    pane.getChildren().addAll(year, okButton,textLabel);
                });
            });
        }
    }

    public void ActionOkYearCar(ActionEvent event) {
        carMakeTextField = new TextField();
        datebaseConnection = DatebaseConnection.getInstance();
        buttonsCar = new ArrayList<>();
        carMakeTextField.setStyle("-fx-background-image: url('/icons/search.png')");
        carMakeTextField.setStyle("-fx-background-repeat: no-repeat");
        carMakeTextField.setStyle("-fx-background-position: right 10 center");
        pane.getChildren().clear();
        pane.getChildren().addAll(carMakeTextField);
        rs = datebaseConnection.getData("Select car_make from cars where car_model_year=" + year.getText() + " group by car_make");


        addButtonsToScene("car_make", buttonsCar);

        carMakeTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            carMakeFilter(carMakeTextField.getText());
        });

        backButton = new Button("Wróć");
        carMakeScene();

        backButton.setOnAction(event2 -> {
            pane.getChildren().clear();
            pane.getChildren().add(carMakeTextField);
            rs = datebaseConnection.getData("Select car_make from cars where car_model_year=" + year.getText() + " group by car_make");
            addButtonsToScene("car_make", buttonsCar);
            carMakeScene();

        });

    }
}
