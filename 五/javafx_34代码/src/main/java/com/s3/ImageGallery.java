package com.s3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ImageGallery extends Application {

    private static final int WINDOW_WIDTH = 1080;
    private static final int WINDOW_HEIGHT = 720;
    private static final int MAX_IMAGES = 4;
    private static final String IMAGE_DIRECTORY = "E:\\桌面\\java实验";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Image Gallery");

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        GridPane imageGrid = createImageGrid();
        root.setCenter(imageGrid);

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createImageGrid() {
        GridPane imageGrid = new GridPane();
//        imageGrid.setHgap(10);
//        imageGrid.setVgap(10);

        List<File> imageFiles = getImageFiles();
        int numImages = Math.min(imageFiles.size(), 4);
        int[] col = {0,1,1,2};
        int[] row = {0,0,1,1};

        //占几列、几行
        int[] columnSpan={1,2,1,1};
        int[] rowSpan={2,1,1,1};

        // 自定义图片布局的坐标和尺寸
        //3x2的列表
        double[] columnWidths = { 540,270,270 };
        double[] rowHeights = { 360,360};

        for (int i = 0; i < numImages; i++) {
            File file = imageFiles.get(i);
            ImageView imageView = createImageView(file);
            GridPane.setConstraints(imageView, col[i], row[i], columnSpan[i], rowSpan[i]);

            // 设置网格列宽和行高
            ColumnConstraints colConstraints = new ColumnConstraints(columnWidths[col[i]]);
            imageGrid.getColumnConstraints().add(colConstraints);

            RowConstraints rowConstraints = new RowConstraints(rowHeights[row[i]]);
            imageGrid.getRowConstraints().add(rowConstraints);
            // 将ImageView添加到网格布局中
            imageGrid.getChildren().add(imageView);
        }

        return imageGrid;
    }


    private List<File> getImageFiles() {
        File directory = new File(IMAGE_DIRECTORY);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".jpg") || name.endsWith(".png"));
        if (files != null) {
            return Arrays.asList(files).subList(0, Math.min(MAX_IMAGES, files.length));
        }
        return List.of();
    }

    private ImageView createImageView(File file) {
        Image image = new Image(file.toURI().toString());
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);

        // 计算适应宽度和适应高度
        double windowWidth = WINDOW_WIDTH - 20; // 减去边距的宽度
        double windowHeight = WINDOW_HEIGHT - 20; // 减去边距的高度
        double fitWidth = windowWidth / 2 - 15;
        double fitHeight = windowHeight / 2 - 15;

        imageView.setFitWidth(fitWidth);
        imageView.setFitHeight(fitHeight);

        return imageView;
    }

}
