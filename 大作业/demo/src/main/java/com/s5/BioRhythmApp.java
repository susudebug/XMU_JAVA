package com.s5;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class BioRhythmApp extends Application {
    private Map<String, LocalDate> birthdays;  // 用于保存用户的生日信息
    private LineChart<Number, Number> chart;   // 生物节律曲线图

    public BioRhythmApp() {
        birthdays = new HashMap<>();  // 初始化生日信息的Map
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("生物节律App");

        // 创建生日输入界面
        GridPane inputPane = createInputPane();

        // 创建曲线绘制界面
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("生物节律曲线");

        // 创建切换用户按钮
        Button switchUserButton = new Button("切换用户");
        switchUserButton.setOnAction(e -> switchUser(primaryStage));

        // 布局界面
        GridPane mainPane = new GridPane();
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setHgap(10);
        mainPane.setVgap(10);
        mainPane.setPadding(new Insets(10));
        mainPane.add(inputPane, 0, 0);
        mainPane.add(chart, 0, 1);
        mainPane.add(switchUserButton, 0, 2);

        // 显示界面
        Scene scene = new Scene(mainPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    // 创建生日输入界面
    private GridPane createInputPane() {
        GridPane inputPane = new GridPane();
        inputPane.setAlignment(Pos.CENTER);
        inputPane.setHgap(10);
        inputPane.setVgap(10);

        Label nameLabel = new Label("姓名:");
        TextField nameField = new TextField();

        Label birthdayLabel = new Label("生日:(年-月-日)");
        TextField birthdayField = new TextField();

        Button submitButton = new Button("提交");
        submitButton.setStyle("-fx-background-color: lightblue; -fx-text-fill: black; -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0, 0, 1);");

        submitButton.setOnAction(e -> {
            String name = nameField.getText();
            String birthdayStr = birthdayField.getText();

            if (!name.isEmpty() && !birthdayStr.isEmpty()) {
                LocalDate birthday = LocalDate.parse(birthdayStr);
                birthdays.put(name, birthday);
                drawBioRhythm(name, birthday);
            }
        });

        inputPane.add(nameLabel, 0, 0);
        inputPane.add(nameField, 1, 0);
        inputPane.add(birthdayLabel, 0, 1);
        inputPane.add(birthdayField, 1, 1);
        inputPane.add(submitButton, 0, 2, 2, 1);

        return inputPane;
    }

    // 绘制生物节律曲线
    private void drawBioRhythm(String name, LocalDate birthday) {
        // 创建一个 XYChart.Series 对象，用于表示生物节律曲线的数据系列
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(name); // 设置数据系列的名称为姓名

        LocalDate currentDate = LocalDate.now(); // 获取当前日期
        long daysSinceBirth = ChronoUnit.DAYS.between(birthday, currentDate); // 计算从生日到当前日期的天数

        // 循环绘制30个数据点，表示30天的生物节律
        for (int i = 0; i <= 30; i++) {
            double x = i; // x轴坐标为循环变量i的值
            double y = Math.sin(2 * Math.PI * (daysSinceBirth + i) / 23); // 使用生物节律的示例计算公式计算y轴坐标，可以根据需要进行修改
            series.getData().add(new XYChart.Data<>(x, y)); // 将数据点添加到数据系列中
        }

        chart.getData().add(series); // 将数据系列添加到图表中显示
    }


    // 切换用户
    private void switchUser(Stage primaryStage) {
        // 创建切换用户界面
        GridPane switchUserPane = new GridPane();
        switchUserPane.setAlignment(Pos.CENTER);
        switchUserPane.setHgap(10);
        switchUserPane.setVgap(10);
        // 创建生日输入界面
        GridPane inputPane = createInputPane();

        // 创建曲线绘制界面
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("节律曲线图");

        // 创建切换用户按钮
        Button switchUserButton = new Button("切换用户");
        switchUserButton.setStyle("-fx-background-color: lightblue; -fx-text-fill: black; -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 5px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0, 0, 1);");

        switchUserButton.setOnAction(e -> switchUser(primaryStage));

        // 创建主要布局容器
        GridPane mainPane = new GridPane();
        mainPane.setAlignment(Pos.CENTER);//设置中央对齐
        mainPane.setHgap(10);//水平间距
        mainPane.setVgap(10);//垂直间距
        mainPane.setPadding(new Insets(10));//内边距
        mainPane.add(inputPane, 0, 0);//在第一行第一列添加inputPane
        mainPane.add(chart, 0, 1);
        mainPane.add(switchUserButton, 0, 2);//第三行--切换用户按钮


        AtomicReference<String> selectedUser = new AtomicReference<>("");

        int row = 1;
        for (String user : birthdays.keySet()) {
            Button userButton = new Button(user);
            GridPane.setConstraints(userButton, 0, row);
            switchUserPane.getChildren().add(userButton);
            userButton.setOnAction(e -> {
                selectedUser.set(userButton.getText());
            });
            row++;
        }

        Button switchButton = new Button("切换");
        switchButton.setOnAction(e -> {
            String user = selectedUser.get();
            if (!user.isEmpty()) {
                LocalDate birthday = birthdays.get(user);
                chart.getData().clear();
                drawBioRhythm(user, birthday);
            }

            primaryStage.getScene().setRoot(mainPane);
        });





        switchUserPane.getChildren().add(switchButton);
        Scene switchUserScene = new Scene(switchUserPane, 300, 200);
        primaryStage.setScene(switchUserScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
