package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class CurrentOrderController {

    private final double taxRate = 0.06625;
    private final double totalWithTax = 1.06625;

    private MainMenuController mainController;
    private Stage stage;

    /**
     * A method to connect this controller with MainMenuController
     *
     * @param controller controller being connected
     */
    public void setMainController(MainMenuController controller) {
        this.mainController = controller;
    }

    @FXML
    private Button addOrder;

    @FXML
    private TextField number;

    @FXML
    private TextField orderTotal;

    @FXML
    private ListView<Pizza> ordersList;

    @FXML
    private Button removePizza;

    @FXML
    private TextField salesTax;

    @FXML
    private TextField subtotal;

    /**
     * A setter for the phone number text field
     *
     * @param text text being appended
     */
    public void setNumber(String text) {
        number.appendText(text);
    }

    /**
     * A setter for the pizza list
     *
     * @param pizzaList list of pizzas being set for the order
     */
    public void setOrdersList(ObservableList<Pizza> pizzaList) {
        ordersList.setItems(pizzaList);
    }

    /**
     * A method to update the price of the current order
     *
     * @param stage stage being updated
     */
    void updatePrices(Stage stage) {
        this.stage = stage;
        DecimalFormat dec = new DecimalFormat("#0.00");
        dec.setGroupingUsed(true);
        dec.setGroupingSize(3);
        double subTotal = mainController.calculateSubTotal();
        salesTax.clear();
        salesTax.appendText("" + dec.format(subTotal * taxRate));
        subtotal.clear();
        subtotal.appendText("" + dec.format(subTotal));
        orderTotal.clear();
        orderTotal.appendText("" + dec.format(subTotal * totalWithTax));
    }

    /**
     * A method to add an order to the store orders list
     *
     * @param event event where add order button is clicked
     */
    @FXML
    void addOrderClick(ActionEvent event) {
        if (ordersList.getItems().size() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Adding Pizza");
            alert.setContentText("Add a pizza to this order first.");
            alert.showAndWait();
        }
        Order temp = new Order();
        temp.phoneNumber = number.getText();
        temp.pizzas = FXCollections.observableArrayList(mainController.getCurrentOrderPizzas());
        temp.orderTotal = Double.parseDouble(orderTotal.getText());
        mainController.addOrderMain(temp);
        mainController.clearOrder();
        stage.close();
    }

    /**
     * A method to remove a pizza from an order
     *
     * @param event event where remove pizza button is clicked
     */
    @FXML
    void removePizzaClick(ActionEvent event) {
        Pizza temp = ordersList.getSelectionModel().getSelectedItem();
        if (temp == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Remove Pizza");
            alert.setContentText("Select a pizza from the cart to remove.");
            alert.showAndWait();
            return;
        }
        mainController.removePizzaMain(temp);
        ordersList.getItems().remove(temp);
        this.updatePrices(this.stage);
    }
}
