package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.DecimalFormat;

public class StoreOrdersController {

    private MainMenuController mainController;

    /**
     * A method to connect this controller with MainMenuController
     * @param controller controller being connected
     */
    public void setMainController(MainMenuController controller){
        this.mainController = controller;
    }

    /**
     * A method to add a phone number being worked on in the main menu to this list
     * @param number the phone number being added
     */
    public void addPhoneNumberToList(String number){
        phoneMenu.getItems().add(number);
    }


    @FXML
    private Button cancelOrderButton;

    @FXML
    private Button exportOrders;

    @FXML
    private TextField orderTotal;

    @FXML
    private ComboBox<String> phoneMenu;

    @FXML
    private ListView<Pizza> storeOrdersList;

    @FXML
    void cancelOrderButtonClick(ActionEvent event) {
        int orderIndex = phoneMenu.getSelectionModel().getSelectedIndex();
        if(orderIndex == -1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No order to be cancelled");
            alert.showAndWait();
            return;
        }
        storeOrdersList.getItems().clear();
        orderTotal.clear();
        phoneMenu.getItems().remove(orderIndex);
        mainController.getStoreOrder().orders.remove(orderIndex);
    }

    @FXML
    void exportOrdersClick(ActionEvent event) {
        mainController.getStoreOrder().export();
    }

    /**
     * A method to handle the event where a phone number is selected
     * @param event event where phone number is selected
     */
    @FXML
    void selectPhoneNumber(ActionEvent event) {
        int orderIndex = phoneMenu.getSelectionModel().getSelectedIndex();
        storeOrdersList.getItems().clear();
        storeOrdersList.getItems().addAll(mainController.getStoreOrder().orders.get(orderIndex).pizzas);
        orderTotal.clear();
        DecimalFormat dec = new DecimalFormat("#0.00");
        dec.setGroupingUsed(true);
        dec.setGroupingSize(3);
        orderTotal.appendText(dec.format(mainController.getStoreOrder().orders.get(orderIndex).orderTotal));
    }

}
