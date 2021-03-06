// 
// Decompiled by Procyon v0.5.36
// 

 package snake;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import java.util.Random;
import javafx.scene.paint.Paint;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.application.Application;

public class SnakeGUI extends Application
{
    private static final int GUI_HEIGHT = 550;
    private static final int GUI_WIDTH = 500;
    private static final int PIXELS_PER_SQUARE = 10;
    private Level theLevel;
    private Circle itemView;
    private Rectangle[][] mapView;
    
    public void start(final Stage theStage) throws Exception {
        final Pane theCanvas = new Pane();
        theCanvas.setStyle("-fx-background-color: white;");
        final Scene scene = new Scene((Parent)theCanvas, 500.0, 550.0, (Paint)Color.WHITE);
        this.theLevel = new Level(50, 55, new Random());
        final int[][] map = this.theLevel.getMap();
        if (map != null) {
            this.mapView = new Rectangle[map.length][map[0].length];
            for (int i = 0; i < map.length; ++i) {
                for (int j = 0; j < map[i].length; ++j) {
                    this.mapView[i][j] = new Rectangle((double)(j * 10), (double)(i * 10), 10.0, 10.0);
                    if (j == this.theLevel.getSnake().getHeadX() && i == this.theLevel.getSnake().getHeadY()) {
                        this.mapView[i][j].setFill((Paint)Color.GREEN);
                    }
                    else {
                        final int[][] theSnake = this.theLevel.getSnake().getSnake();
                        boolean partSnake = false;
                        for (int s = 1; s < this.theLevel.getSnake().getLength(); ++s) {
                            if (theSnake[s][0] == j && theSnake[s][1] == i) {
                                this.mapView[i][j].setFill((Paint)Color.LAWNGREEN);
                                partSnake = true;
                                break;
                            }
                        }
                        if (!partSnake) {
                            this.mapView[i][j].setFill((Paint)Color.WHITE);
                        }
                    }
                    theCanvas.getChildren().add(this.mapView[i][j]);
                }
            }
        }
        final Item theItem = this.theLevel.getItem();
        if (theItem != null) {
            this.itemView = new Circle((double)(theItem.getX() * 10 + 5), (double)(theItem.getY() * 10 + 5), 5.0);
            theCanvas.getChildren().add(this.itemView);
        }
        theStage.setTitle("CS2 Snake!");
        theStage.setScene(scene);
        theStage.show();
        final EventHandler<KeyEvent> handler = (EventHandler<KeyEvent>)new EventHandler<KeyEvent>() {
            public void handle(final KeyEvent event) {
                System.out.println("Event happened, event is: " + event.getText());
                if (event.getCode() == KeyCode.UP || event.getCharacter().equals("W")) {
                    SnakeGUI.this.theLevel.getSnake().changeDir(Direction.UP);
                }
                else if (event.getCode() == KeyCode.DOWN || event.getCharacter().equals("S")) {
                    SnakeGUI.this.theLevel.getSnake().changeDir(Direction.DOWN);
                }
                else if (event.getCode() == KeyCode.RIGHT || event.getCharacter().equals("D")) {
                    SnakeGUI.this.theLevel.getSnake().changeDir(Direction.RIGHT);
                }
                else if (event.getCode() == KeyCode.LEFT || event.getCharacter().equals("A")) {
                    SnakeGUI.this.theLevel.getSnake().changeDir(Direction.LEFT);
                }
            }
        };
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (EventHandler)handler);
        final AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate = 0L;
            
            public void handle(final long arg) {
                if (arg - this.lastUpdate >= 100000000L) {
                    this.lastUpdate = arg;
                    SnakeGUI.this.theLevel.updateOneStep();
                    final Item theItem = SnakeGUI.this.theLevel.getItem();
                    if (theItem != null) {
                        SnakeGUI.this.itemView.setCenterX((double)(theItem.getX() * 10 + 5));
                        SnakeGUI.this.itemView.setCenterY((double)(theItem.getY() * 10 + 5));
                    }
                    final int[][] newMap = SnakeGUI.this.theLevel.getMap();
                    if (newMap != null) {
                        for (int i = 0; i < newMap.length; ++i) {
                            for (int j = 0; j < newMap[i].length; ++j) {
                                if (j == SnakeGUI.this.theLevel.getSnake().getHeadX() && i == SnakeGUI.this.theLevel.getSnake().getHeadY()) {
                                    SnakeGUI.this.mapView[i][j].setFill((Paint)Color.GREEN);
                                }
                                else {
                                    final int[][] theSnake = SnakeGUI.this.theLevel.getSnake().getSnake();
                                    boolean partSnake = false;
                                    for (int s = 1; s < SnakeGUI.this.theLevel.getSnake().getLength(); ++s) {
                                        if (theSnake[s][0] == j && theSnake[s][1] == i) {
                                            SnakeGUI.this.mapView[i][j].setFill((Paint)Color.LAWNGREEN);
                                            partSnake = true;
                                            break;
                                        }
                                    }
                                    if (!partSnake) {
                                        SnakeGUI.this.mapView[i][j].setFill((Paint)Color.WHITE);
                                    }
                                }
                            }
                        }
                    }
                    final int MESSAGE_X = 50;
                    final int MESSAGE_Y = 300;
                    final int MESSAGE_FONT_SIZE = 50;
                    final GameState stat = SnakeGUI.this.theLevel.getGameState();
                    if (stat == GameState.LOST) {
                        final Text t = new Text(50.0, 300.0, "GAME OVER!\nFinal length: " + SnakeGUI.this.theLevel.getSnake().getLength());
                        t.setFont(Font.font("Verdana", 50.0));
                        t.setFill((Paint)Color.RED);
                        theCanvas.getChildren().add(t);
                        this.stop();
                    }
                }
            }
        };
        timer.start();
    }
    
    public static void main(final String[] args) {
        launch(args);
    }
}