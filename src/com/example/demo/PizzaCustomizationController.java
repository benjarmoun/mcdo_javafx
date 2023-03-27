package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PizzaCustomizationController {

    private final int maxToppings = 7;

    private MainMenuController mainController;

    /**
     * A method to connect this controller with MainMenuController
     * @param controller controller being connected
     */
    public void setMainController(MainMenuController controller){
        this.mainController = controller;
    }

    private Pizza pizza;
    private ObservableList<Topping> initialToppings = FXCollections.observableArrayList();

    @FXML
    private Button addButton;

    @FXML
    private ListView<Topping> addList;

    @FXML
    private Button addToOrderButton;

    @FXML
    private ImageView deluxePic;

    @FXML
    private ImageView hawaiianPic;

    @FXML
    private ImageView pepperoniPic;

    @FXML
    private TextField pizzaPrice;

    @FXML
    private Button removeButton;

    @FXML
    private ListView<Topping> selectedList;

    @FXML
    private ComboBox<Size> sizeMenu;

    /**
     * A method to initialize the pizza customization stage
     */
    @FXML
    public void initialize() {
        ObservableList<Topping> toppingsList = FXCollections.observableArrayList(Topping.values());
        ObservableList<Size> sizeList = FXCollections.observableArrayList(Size.values());
        addList.setItems(toppingsList);
        sizeMenu.setItems(sizeList);
        pizza = PizzaMaker.createPizza("Pepperoni");
    }

    /**
     * A method to set the initial values to a pizza
     * @param pizzaFlavor flavor of the specific pizza
     * @param toppings the initial toppings of the specific pizza
     */
    public void setDefaultValues(String pizzaFlavor, ObservableList<Topping> toppings) {
        initialToppings = toppings;
        addList.getItems().removeAll(initialToppings);
        selectedList.getItems().addAll(initialToppings);
        pizza = PizzaMaker.createPizza(pizzaFlavor);
        pizza.toppings = new ArrayList(selectedList.getItems());
        pizza.size = Size.Small;
        sizeMenu.getSelectionModel().selectFirst();
        pizzaPrice.clear();
        if (pizzaFlavor.equals("Deluxe")) {
            deluxePic.setVisible(true);
            pepperoniPic.setVisible(false);
            hawaiianPic.setVisible(false);
        }
        if (pizzaFlavor.equals("Hawaiian")) {
            hawaiianPic.setVisible(true);
            pepperoniPic.setVisible(false);
            deluxePic.setVisible(false);
        }
        if (pizzaFlavor.equals("Pepperoni")) {
            pepperoniPic.setVisible(true);
            hawaiianPic.setVisible(false);
            deluxePic.setVisible(false);
        }
        DecimalFormat dec = new DecimalFormat("#0.00");
        dec.setGroupingUsed(true);
        dec.setGroupingSize(3);
        pizzaPrice.appendText(dec.format(pizza.price()));
    }

    /**
     * A method to add a topping to the pizza
     * @param event event where add topping button is clicked
     */
    @FXML
    void addButtonClick(ActionEvent event) {
        if(selectedList.getItems().size() == maxToppings){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Maximum number of toppings is 7!");
            alert.showAndWait();
            return;
        }
        Topping selectedTopping = addList.getSelectionModel().getSelectedItem();
        if(selectedTopping == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No topping chosen to add!");
            alert.showAndWait();
            return;
        }
        addList.getItems().remove(selectedTopping);
        selectedList.getItems().add(selectedTopping);
        pizza.toppings = new ArrayList(selectedList.getItems());
        pizzaPrice.clear();
        DecimalFormat dec = new DecimalFormat("#0.00");
        dec.setGroupingUsed(true);
        dec.setGroupingSize(3);
        pizzaPrice.appendText("" + dec.format(pizza.price()));
    }

    /**
     * A method to remove a topping from the pizza
     * @param event event where remove topping button is clicked
     */
    @FXML
    void removeButtonClick(ActionEvent event) {
        Topping selectedTopping = selectedList.getSelectionModel().getSelectedItem();
        if(selectedTopping == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No topping chosen to remove!");
            alert.showAndWait();
            return;
        }
        selectedList.getItems().remove(selectedTopping);
        addList.getItems().add(selectedTopping);
        pizza.toppings = new ArrayList(selectedList.getItems());
        pizzaPrice.clear();
        DecimalFormat dec = new DecimalFormat("#0.00");
        dec.setGroupingUsed(true);
        dec.setGroupingSize(3);
        pizzaPrice.appendText("" + dec.format(pizza.price()));
    }

    /**
     * A method to add this pizza to the order
     * @param event event where add to order button is clicked
     */
    @FXML
    void addToOrderButtonClick(ActionEvent event) {
        Pizza temp = pizza.copy();
        mainController.addPizzaMain(temp);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Pizza added to the order!");
        alert.showAndWait();
    }

    /**
     * A method to change the size of the pizza
     * @param event event where pizza size menu is changed
     */
    @FXML
    void changePizzaSizeMenu(ActionEvent event) {
        pizza.size = sizeMenu.getValue();
        pizzaPrice.clear();
        DecimalFormat dec = new DecimalFormat("#0.00");
        dec.setGroupingUsed(true);
        dec.setGroupingSize(3);
        pizzaPrice.appendText(dec.format(pizza.price()));
    }
}
