package com.example.hellicoptergame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;




public class HelloApplication extends Application {


    VBox labelview = new VBox();

    Label GainedScore;
    Label instructions;
    int score;


    Duration durA1 = Duration.millis(4050);
    Duration durB2 = Duration.millis(6050);
    Duration durC3 = Duration.millis(7050);
    Duration durD4 = Duration.millis(9050);
    Duration durE5 = Duration.millis(11050);


    Duration durA = Duration.millis(14000);
    Duration durB = Duration.millis(16000);
    Duration durC = Duration.millis(11000);
    Duration durD = Duration.millis(19500);



    TranslateTransition pointW = new TranslateTransition(durA);
    TranslateTransition pointX = new TranslateTransition(durB);
    TranslateTransition pointY = new TranslateTransition(durC);
    TranslateTransition pointZ = new TranslateTransition(durD);



    TranslateTransition translate1 = new TranslateTransition(durA1);
    TranslateTransition translate2 = new TranslateTransition(durB2);
    TranslateTransition translate3 = new TranslateTransition(durC3);
    TranslateTransition translate4 = new TranslateTransition(durD4);
    TranslateTransition translate5 = new TranslateTransition(durE5);


    SequentialTransition seqA;
    SequentialTransition seqB;
    SequentialTransition seqC;
    SequentialTransition seqD;


    SequentialTransition seqT1;
    SequentialTransition seqT2;
    SequentialTransition seqT3;
    SequentialTransition seqT4;
    SequentialTransition seqT5;

    //Desplying helicopter image and set it on screen
    Rectangle shape1 = new Rectangle(180,100);
    String source = getClass().getResource("/elecopter.png").toExternalForm();
    Image image = new Image(source);
    ImageView imageView = new ImageView(image);

    //desplaying bonus money to be colected by the helicopter on screen
    Rectangle shape2 = new Rectangle(35,20);
    String source1 = getClass().getResource("/moneybag.png").toExternalForm();
    Image point1 = new Image(source1);
    Rectangle shape3 = new Rectangle(35,20);
    String source2 = getClass().getResource("/moneybag.png").toExternalForm();
    Image point2 = new Image(source2);
    Rectangle shape4 = new Rectangle(35,20);
    String source3 = getClass().getResource("/moneybag.png").toExternalForm();
    Image point3 = new Image(source3);
    Rectangle shape5 = new Rectangle(35,20);
    String source4 = getClass().getResource("/moneybag.png").toExternalForm();
    Image point4 = new Image(source4);


    //desplaying clouds images on screen and resize the images
    Rectangle shape1k = new Rectangle(180,100);
    String source_1 = getClass().getResource("/cloud5.png").toExternalForm();
    Image image1 = new Image(source_1);
    Rectangle shape2l = new Rectangle(180,100);
    String source_2 = getClass().getResource("/cloud.png").toExternalForm();
    Image image2 = new Image(source_2);
    Rectangle shape3m = new Rectangle(480,230);
    String source_3 = getClass().getResource("/cloud3.png").toExternalForm();
    Image image3 = new Image(source_3);
    Rectangle shape4n = new Rectangle(480,230);
    String source_4 = getClass().getResource("/cloud5.png").toExternalForm();
    Image image4 = new Image(source_4);
    Rectangle shape5o = new Rectangle(180,100);
    String source_5 = getClass().getResource("/cloud.png").toExternalForm();
    Image image5 = new Image(source_5);


    @Override
    public void start(Stage stage) {
        Pane root = new Pane();



        //setting clouds images locations
        shape1k.setFill(new ImagePattern(image1));
        shape5o.setFill(new ImagePattern(image5));
        shape2l.setFill(new ImagePattern(image2));
        shape3m.setFill(new ImagePattern(image3));
        shape4n.setFill(new ImagePattern(image4));

        //setting points images locations
        shape2.setFill(new ImagePattern(point1));
        shape3.setFill(new ImagePattern(point2));
        shape4.setFill(new ImagePattern(point3));
        shape5.setFill(new ImagePattern(point4));


        //getting points
        pointW.setToY(-1950f);
        pointW.setCycleCount(200);
        pointW.setAutoReverse(false);
        seqA = new SequentialTransition (shape2, pointW);


        pointX.setToY(-1800f);
        pointX.setCycleCount(200);
        pointX.setAutoReverse(false);
        seqB = new SequentialTransition (shape3, pointX);


        pointY.setToY(1800f);
        pointY.setCycleCount(200);
        pointY.setAutoReverse(false);
        seqC = new SequentialTransition (shape4, pointY);


        pointZ.setToY(1800f);
        pointZ.setCycleCount(200);
        pointZ.setAutoReverse(false);
        seqD = new SequentialTransition (shape5, pointZ);


        translate1.setToX(-1800f);
        translate1.setCycleCount(200);
        translate1.setAutoReverse(false);
        seqT1 = new SequentialTransition (shape1k, translate1);



        translate2.setToX(-1800f);
        translate2.setCycleCount(200);
        translate2.setAutoReverse(false);
        seqT2 = new SequentialTransition (shape2l, translate2);

        translate3.setToX(-1800f);
        translate3.setCycleCount(200);
        translate3.setAutoReverse(false);
        seqT3 = new SequentialTransition (shape3m, translate3);

        translate4.setToX(-1800f);
        translate4.setCycleCount(200);
        translate4.setAutoReverse(false);
        seqT4 = new SequentialTransition (shape4n, translate4);

        translate5.setToX(-1800f);
        translate5.setCycleCount(200);
        translate5.setAutoReverse(false);
        seqT5 = new SequentialTransition (shape5o, translate5);
        final Group group = new Group(createInstructions(),createScore(),labelview,shape2l,shape3m,shape4n,shape2,shape3,shape4,shape5,root);


        shape1k.setX(1500);
        shape1k.setY(50);
        shape2l.setX(1400);
        shape2l.setY(400);
        shape3m.setX(1500);
        shape3m.setY(800);
        shape4n.setX(1500);
        shape4n.setY(500);
        shape5o.setX(1400);
        shape5o.setY(100);


        shape2.setX(500);
        shape2.setY(-50);
        shape3.setX(600);
        shape3.setY(-50);
        shape4.setX(700);
        shape4.setY(-50);
        shape5.setX(850);
        shape5.setY(-50);
        final Scene scene = new Scene(group,1350, 680);


        ImageView helicopter = createHelecopter(scene);
        root.getChildren().addAll(instructions,shape1,shape2,shape3,shape4,shape5,shape1k,shape2l,shape3m,shape4n,shape5o,GainedScore);


//setting controlls
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            double x = shape1.getX();
            double y = shape1.getY();

            if(event.getCode()==KeyCode.UP){
                shape1.setY(y-10);
            }
            else if(event.getCode()==KeyCode.DOWN){
                shape1.setY(y+10);
            }
            else if(event.getCode()==KeyCode.RIGHT){
                shape1.setX(x+10);
            }
            else if(event.getCode()==KeyCode.LEFT){
                shape1.setX(x-10);
            }
            else if(event.getCode()==KeyCode.ENTER){
                Play();
            }
            if(event.getCode() == KeyCode.SPACE){
                seqA.pause();
                seqB.pause();
                seqC.pause();
                seqD.pause();
                seqT1.pause();
                seqT2.pause();
                seqT2.pause();
                seqT3.pause();
                seqT4.pause();
                seqT5.pause();
            }
        });

        stage.setTitle("WELCCOME TO HELICOPTER GAME ENJOY!!!");
        stage.setScene(scene);
        root.setStyle("-fx-background-color:#87CEEB;");
        stage.show();
    }

    //play method
    public void Play(){
        seqA.play();
        seqB.play();
        seqC.play();
        seqD.play();
        seqT1.play();
        seqT2.play();
        seqT2.play();
        seqT3.play();
        seqT4.play();
        seqT5.play();

    }
    //pouse method
    public void Pause(){
        seqA.pause();
        seqB.pause();
        seqC.pause();
        seqD.pause();
        seqT1.pause();
        seqT2.pause();
        seqT2.pause();
        seqT3.pause();
        seqT4.pause();
        seqT5.pause();

    }

    //Helicopter method
    private ImageView createHelecopter(Scene scene) {

        shape1.setFill(new ImagePattern(image));
        shape1.setX(100);
        shape1.setY(200);
        imageView.setFitWidth(130);
        imageView.setFitHeight(80);
        imageView.setY(scene.getHeight() - imageView.getFitHeight());

        return imageView;
    }
    //intrustion to be followed to play a game
    private Label createInstructions() {
        instructions = new Label(
                "\n\tPRESS ENTER TO START!!!\n\tSCORE:"
        );


        instructions.setTextFill(Color.RED);
        instructions.setFont(Font.font("Tahoma", FontWeight.BOLD,20));
        return instructions;
    }
    //method of creating a score and setting helicopter diplay gameover and stop while interset with any cloud
    private Label createScore() {
        score=0;

        GainedScore = new Label();
        GainedScore.setText(score+"");
        GainedScore.setLayoutX(200);
        GainedScore.setLayoutY(47);
        labelview.getChildren().add(GainedScore);

        GainedScore.setTextFill(Color.FORESTGREEN);
        GainedScore.setFont(Font.font("Tahoma", FontWeight.BOLD,20));
        shape1.translateXProperty().addListener(observable -> {

        });
        shape1k.translateXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                if (shape1.getBoundsInParent().intersects(shape1k.getBoundsInParent())){
                    String icon= getClass().getResource("/boom.png").toExternalForm();
                    Image imageB= new Image(icon);
                    shape1.setFill(new ImagePattern(imageB));
                    Pause();
                    shape1k.setOpacity(0.1);
                } else if (shape1.getBoundsInParent().intersects(shape2l.getBoundsInParent())) {
                    String icon= getClass().getResource("/boom.png").toExternalForm();
                    Image imageJet= new Image(icon);
                    shape1.setFill(new ImagePattern(imageJet));
                    Pause();
                    shape2l.setOpacity(0.1);
                } else if (shape1.getBoundsInParent().intersects(shape3m.getBoundsInParent())) {
                    String icon= getClass().getResource("/boom.png").toExternalForm();
                    Image imageB= new Image(icon);
                    shape1.setFill(new ImagePattern(imageB));
                    Pause();
                    shape3m.setOpacity(0.1);
                } else if (shape1.getBoundsInParent().intersects(shape4n.getBoundsInParent())) {
                    String icon= getClass().getResource("/boom.png").toExternalForm();
                    Image imageB= new Image(icon);
                    shape1.setFill(new ImagePattern(imageB));
                    Pause();
                    shape4n.setOpacity(0.1);
                }
                else if (shape1.getBoundsInParent().intersects(shape5o.getBoundsInParent())) {
                    String icon= getClass().getResource("/boom.png").toExternalForm();
                    Image imageB= new Image(icon);
                    shape1.setFill(new ImagePattern(imageB));
                    Pause();
                    shape5o.setOpacity(0.1);
                }
                else if (shape1.getBoundsInParent().intersects(shape2.getBoundsInParent())) {
                    score+=10;
                    GainedScore.setText(score+" ");
                }
                else if (shape1.getBoundsInParent().intersects(shape3.getBoundsInParent())) {
                    score+=10;
                    GainedScore.setText(score+" ");
                }
                else if (shape1.getBoundsInParent().intersects(shape4.getBoundsInParent())) {
                    score+=10;
                    GainedScore.setText(score+" ");
                }
                else if (shape1.getBoundsInParent().intersects(shape5.getBoundsInParent())) {
                    score+=10;
                    GainedScore.setText(score+" ");
                }
            }
        });
        return GainedScore;
    }
    public static void main(String[] args) {
        launch();
    }



}



