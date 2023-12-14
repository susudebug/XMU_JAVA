package com.s4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");

        // 创建一个 GridPane 用于放置按钮
        GridPane buttonGrid = createButtonGrid();

        // 创建一个 TextField 用于显示结果
        TextField displayField = createDisplayField();

        // 创建一个 VBox 用于放置显示结果和按钮
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(displayField, buttonGrid);

        // 创建一个场景并将其设置在舞台上
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private GridPane createButtonGrid() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        // 创建数字按钮
        for (int i = 0; i < 9; i++) {
            Button numberButton = createNumberButton(String.valueOf(i + 1));
            gridPane.add(numberButton, i % 3, i / 3);
        }

        // 创建运算符按钮
        Button addButton = createOperatorButton("+");
        Button subtractButton = createOperatorButton("-");
        Button multiplyButton = createOperatorButton("*");
        Button divideButton = createOperatorButton("/");

        gridPane.add(addButton, 3, 0);
        gridPane.add(subtractButton, 3, 1);
        gridPane.add(multiplyButton, 3, 2);
        gridPane.add(divideButton, 3, 3);

        return gridPane;
    }

    private Button createNumberButton(String number) {
        Button button = new Button(number);
        button.setPrefWidth(60);
        button.setPrefHeight(40);
        button.setStyle("-fx-background-color: #EFEFEF;");
        return button;
    }

    private Button createOperatorButton(String operator) {
        Button button = new Button(operator);
        button.setPrefWidth(60);
        button.setPrefHeight(40);
        button.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
        return button;
    }

    private TextField createDisplayField() {
        TextField textField = new TextField();
        textField.setEditable(false);
        textField.setAlignment(Pos.CENTER_RIGHT);
        textField.setStyle("-fx-font-size: 18;");
        return textField;
    }

    public static void main(String[] args) {
        launch();
    }
}
