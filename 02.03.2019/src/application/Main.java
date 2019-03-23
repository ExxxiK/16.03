package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {		
			primaryStage.setTitle("Animation example");
			Group root = new Group();
			Scene myScene = new Scene(root);		
			primaryStage.setScene(myScene);
			
			Canvas canvas = new Canvas(512,512);
			root.getChildren().add(canvas);
			
			GraphicsContext gc =canvas.getGraphicsContext2D();
			Image sun =  new Image("sun.png");
			Image space =  new Image("space.png");
			Image earth =  new Image("earth.png");
			Image barans =  new Image("barans.png");
			Image fox =  new Image("fox.png");
			
			final long startTime = System.nanoTime();
			
			
			new AnimationTimer(){
	/////			double bx = 10;
////	/			double by = 10;


				@Override
				public void handle(long now) {
					double dd = (now-startTime)/1000000000.0;
		////			double x = 232 + 100*Math.cos(dd); 
	////				double y = 232 + 128*Math.sin(dd);
					double x = 101;
					double y = 101;

					gc.drawImage(space, 0, 0);
					gc.drawImage(earth, x, y);
					gc.drawImage(sun, 196, 196);
		////			gc.drawImage(fox, -50 + 100*Math.cos(dd), 20 + 150*Math.sin(dd));
					if(x==400.0 && y<400.0) 
					{ 
					y=y+1.0; 
					gc.drawImage(earth, x, y); 

					} 
					if(y==400.0 && x>100.0) 
					{ 
					x=x-1.0; 
					gc.drawImage(earth, x, y); 
					} 
					if(x==100.0 && y>100.0) 
					{ 
					y = y - 1.0; 
					gc.drawImage(earth, x, y); 
					} 
					if(x<400.0 && y==100.0) 
					{ 
					x=x+1.0; 
					gc.drawImage(earth, x, y); 
					}
				}
				
			}.start();
			
			
			gc.drawImage(sun, 200, 200);
			primaryStage.show();		
			
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
