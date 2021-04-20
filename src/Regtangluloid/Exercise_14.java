/*
  CSC 164-6C1
  Assignment 8
  Chapter 14 Exercise 14:
   date :04/19/2021
  (Display a Rectanguloid)
  This   program  displays a Rectanguloid
  as shown in Figure 14.47a. The cube should grow
  and shrink as the window grows or shrinks.

  Created by Noel Martial nguemechieu
 */
package Regtangluloid;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.*;


//Main class
public class Exercise_14 extends Application {

    @Override
    // Start Method
    public void start(Stage primaryStage) {
        ArrayList <Shape>shapeArrayList=new ArrayList<>(); //Create a shapes Array to store all rectangles shapes
        AnchorPane anchorPane=new AnchorPane();//Create AnCharPane to display rectanguloid
        anchorPane.setPrefWidth(600);// Setting anchorPane width
        anchorPane.setPrefHeight(600);//Setting anchorPane Height

        Rectangle rectangle1 = new Rectangle(0,0, Color.TRANSPARENT);//Create rectangle1
        rectangle1.setStroke(Color.BLACK);
        rectangle1.xProperty().bind(anchorPane.widthProperty().divide(4).subtract(25));//setting xProperty
        rectangle1.yProperty().bind(anchorPane.heightProperty().divide(4).add(25));//setting y
        rectangle1.widthProperty().bind(anchorPane.widthProperty().divide(2));//Setting width
        rectangle1.heightProperty().bind(anchorPane.widthProperty().divide(2));//setting rectangle Height
        shapeArrayList.add(rectangle1);// adding Rectangle1  to Shape array
        Rectangle rectangle2 = new Rectangle(0,0, Color.TRANSPARENT);
        rectangle2.setStroke(Color.BLACK);
        rectangle2.xProperty().bind(anchorPane.widthProperty().divide(4).add(25));
        rectangle2.yProperty().bind(anchorPane.heightProperty().divide(4).subtract(25));
        rectangle2.widthProperty().bind(anchorPane.widthProperty().divide(2));
        rectangle2.heightProperty().bind(anchorPane.widthProperty().divide(2));
        shapeArrayList.add(rectangle2);//adding Rectangle 2
        Line line1 = new Line();//Create new line
        line1.startXProperty().bind(rectangle1.xProperty());
        line1.startYProperty().bind(rectangle1.yProperty());
        line1.endXProperty().bind(rectangle2.xProperty());
        line1.endYProperty().bind(rectangle2.yProperty());
        shapeArrayList.add(line1);
        Line line2 = new Line();//Create line 2
        line2.startXProperty().bind(rectangle1.xProperty());
        line2.startYProperty().bind(rectangle1.yProperty().add(rectangle1.heightProperty()));
        line2.endXProperty().bind(rectangle2.xProperty());
        line2.endYProperty().bind(rectangle2.yProperty().add(rectangle1.heightProperty()));
        shapeArrayList.add(line2);
        Line line3 = new Line();//Create line 3
        line3.startXProperty().bind(rectangle1.xProperty().add(rectangle1.widthProperty()));
        line3.startYProperty().bind(rectangle1.yProperty().add(rectangle1.heightProperty()));
        line3.endXProperty().bind(rectangle2.xProperty().add(rectangle1.widthProperty()));
        line3.endYProperty().bind(rectangle2.yProperty().add(rectangle1.heightProperty()));
        shapeArrayList.add(line3);
        Line line4 = new Line();
        line4.startXProperty().bind(rectangle1.xProperty().add(rectangle1.widthProperty()));
        line4.startYProperty().bind(rectangle1.yProperty());
        line4.endXProperty().bind(rectangle2.xProperty().add(rectangle1.widthProperty()));
        line4.endYProperty().bind(rectangle2.yProperty());
        shapeArrayList.add(line4);

        primaryStage.setScene(new Scene(anchorPane));//setting scene with anchorPane
        anchorPane.getChildren().addAll(shapeArrayList);//shapeArraylist to anchorPane
        primaryStage.setTitle(getClass().getSimpleName());//display class title
        primaryStage.show();//show Rectanguloid
    }


    //  main method
    public static void main(String[] args) {
        Application.launch(args);
    }


}

