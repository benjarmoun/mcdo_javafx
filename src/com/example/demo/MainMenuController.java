package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    private Order order = new Order();
    private StoreOrders storeOrders = new StoreOrders();

    /**
     * Getter for the current order's pizza list
     *
     * @return the current order pizzas
     */
    public ObservableList<Pizza> getCurrentOrderPizzas() {
        return order.pizzas;
    }

    /**
     * Getter for the store order list
     *
     * @return store order list
     */
    public StoreOrders getStoreOrder() {
        return storeOrders;
    }

    @FXML
    private Button checkCurrentOrder;

    @FXML
    private Button deluexButton;

    @FXML
    private ImageView deluxeButton;

    @FXML
    private VBox enterNumberText;

    @FXML
    private Button hawaiianButton;

    @FXML
    private AnchorPane mainChangeSize;

    @FXML
    private Button manageStoreOrders;

    @FXML
    private TextField numberEnter;

    @FXML
    private Button pepperoniButton;

    @FXML
    private VBox workingText;


    /**
     * A helper method to check if a phone number is valid or not
     *
     * @param phoneNumber phone number being checked
     * @return true if valid, false otherwise
     */
    public static boolean phoneNumberChecker(String phoneNumber) {
        try {
            Long.parseLong(phoneNumber);
            return phoneNumber.length() == 10; //phone numbers must be 10 digits long
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * A method to initialize the PizzaCustomization Controller for a pepperoni pizza
     *
     * @param event event where adding this pizza is clicked
     * @throws IOException can't load FXML loader
     */
    @FXML
    void addPepperoniButton(ActionEvent event) throws IOException {
        if (!phoneNumberChecker(numberEnter.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Phone number");
            alert.setContentText("Invalid phone number.");
            alert.showAndWait();
            return;
        }
        if (numberEnter.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Phone number");
            alert.setContentText("Please enter a phone number.");
            alert.showAndWait();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Pizza Maker");
        alert.setContentText("Ordering a Pepperoni Pizza");
        alert.showAndWait();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../resources/com/example/demo/PizzaCustomizationView.fxml"));
        Parent root = loader.load();
        PizzaCustomizationController pizzaCustomizer = loader.getController();
        pizzaCustomizer.setMainController(this);

        ObservableList<Topping> toppings = FXCollections.observableArrayList(Topping.Pepperoni);
        pizzaCustomizer.setDefaultValues("Pepperoni", toppings);
        Stage stage = new Stage();
        Scene scene = new Scene(root, 1280, 800);
        stage.setTitle("Creating Pepperoni Pizza");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    /**
     * A method to initialize the PizzaCustomization Controller for a hawaiian pizza
     *
     * @param event event where adding this pizza is clicked
     * @throws IOException can't load FXML loader
     */
    @FXML
    void addHawaiianButton(ActionEvent event) throws IOException {
        if (!phoneNumberChecker(numberEnter.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Phone number");
            alert.setContentText("Invalid phone number.");
            alert.showAndWait();
            return;
        }
        if (numberEnter.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Phone number");
            alert.setContentText("Please enter a phone number.");
            alert.showAndWait();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Pizza Maker");
        alert.setContentText("Ordering a Hawaiian Pizza");
        alert.showAndWait();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../resources/com/example/demo/PizzaCustomizationView.fxml"));
        Parent root = loader.load();
        PizzaCustomizationController pizzaCustomizer = loader.getController();
        pizzaCustomizer.setMainController(this);

        ObservableList<Topping> toppings = FXCollections.observableArrayList(Topping.Ham, Topping.Pineapple);
        pizzaCustomizer.setDefaultValues("Hawaiian", toppings);
        Stage stage = new Stage();
        Scene scene = new Scene(root, 1280, 800);
        stage.setTitle("Creating Hawaiian Pizza");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    /**
     * A method to initialize the PizzaCustomization Controller for a deluxe pizza
     *
     * @param event event where adding this pizza is clicked
     * @throws IOException can't load FXML loader
     */
    @FXML
    void addDeluxeButton(ActionEvent event) throws IOException {
        if (!phoneNumberChecker(numberEnter.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Phone number");
            alert.setContentText("Invalid phone number.");
            alert.showAndWait();
            return;
        }
        if (numberEnter.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Phone number");
            alert.setContentText("Please enter a phone number.");
            alert.showAndWait();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Pizza Maker");
        alert.setContentText("Ordering a Deluxe Pizza");
        alert.showAndWait();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../resources/com/example/demo/PizzaCustomizationView.fxml"));
        Parent root = loader.load();
        PizzaCustomizationController pizzaCustomizer = loader.getController();
        pizzaCustomizer.setMainController(this);

        ObservableList<Topping> toppings = FXCollections.observableArrayList(
                Topping.Sausage, Topping.Peppers, Topping.Onions, Topping.Mushrooms, Topping.Pepperoni);
        pizzaCustomizer.setDefaultValues("Deluxe", toppings);
        Stage stage = new Stage();
        Scene scene = new Scene(root, 1280, 800);
        stage.setTitle("Creating Deluxe Pizza");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    /**
     * A method to check the current order of a phone number
     *
     * @param event event where check order button is clicked
     * @throws IOException FXML loader does not work
     */
    @FXML
    void checkCurrentOrderClick(ActionEvent event) throws IOException {
        if (!phoneNumberChecker(numberEnter.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Phone number");
            alert.setContentText("Invalid phone number.");
            alert.showAndWait();
            return;
        }
        if (numberEnter.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Phone number");
            alert.setContentText("Please enter a phone number.");
            alert.showAndWait();
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../resources/com/example/demo/CurrentOrderView.fxml"));
        Parent root = loader.load();
        CurrentOrderController currentOrderView = loader.getController();
        currentOrderView.setMainController(this);

        currentOrderView.setNumber(numberEnter.getText());
        currentOrderView.setOrdersList(order.pizzas);
        Stage stage = new Stage();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Order Detail");
        stage.setScene(scene);
        currentOrderView.updatePrices(stage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    /**
     * A method to manage the store orders
     *
     * @param event event where manage store orders button is clicked
     * @throws IOException FXML loader doesn't work
     */
    @FXML
    void manageStoreOrdersClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../resources/com/example/demo/StoreOrdersView.fxml"));
        Parent root = loader.load();
        StoreOrdersController storeOrderView = loader.getController();
        storeOrderView.setMainController(this);

        for (Order order : storeOrders.orders) {
            storeOrderView.addPhoneNumberToList(order.phoneNumber);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root, 1280, 800);
        stage.setTitle("Store Orders");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    /**
     * A method to return the subtotal of all pizzas in an order
     *
     * @return order subtotal in double form
     */
    public double calculateSubTotal() {
        double total = 0;
        for (int i = 0; i < order.pizzas.size(); i++) {
            total += order.pizzas.get(i).price();
        }
        return total;
    }

    /**
     * A method to add the pizza to an order
     *
     * @param pizza pizza being added
     */
    public void addPizzaMain(Pizza pizza) {
        order.pizzas.add(pizza);
    }

    /**
     * A method to remove a pizza from an order
     *
     * @param pizza pizza being removed
     */
    public void removePizzaMain(Pizza pizza) {
        order.pizzas.remove(pizza);
    }

    /**
     * A method to add an order to the list of store orders
     *
     * @param order order being added to the list
     */
    public void addOrderMain(Order order) {
        storeOrders.orders.add(order);
    }

    /**
     * A method to clear the current order being worked on
     */
    public void clearOrder() {
        order.pizzas.removeAll(order.pizzas);
        numberEnter.clear();
    }
}
