import pkg.*;

public class Car{
	private Rectangle body1;
	private Rectangle body2;
	private Ellipse w1;
	private Ellipse w2;
	private Ellipse front;
	private Color c1;
	private Color c2;
	private Color c3;
	private Text label;
	
	private Line l1;
	private Line l2;
	private Line l3;
	private Line l4;
	private Rectangle boundbox;
	
	private int stepX;
	private int stepY;
	
	private int sg; //stop and go variable
	
	private Line road;
	private Line space;
	private int roady;
	
	private double x;
	private double y;
	
	public Car(double x, double y, String text){
		body1 = new Rectangle(x,y,100,40);
		body2 = new Rectangle(x+25,y-20,50,20);
		w1 = new Ellipse(x,y+30,25,25);
		w2 = new Ellipse(x+75,y+30,25,25);
		front = new Ellipse(x+80,y,30,40);
		
		//c1 = new Color(255,0,0);
		//c2 = new Color(0,0,255);
		c3 = new Color(100,100,100);
		
		//body1.setColor(c1);
		//body2.setColor(c2);
		front.setColor(c3);
		
		l1 = new Line(x,y-20,x+110,y-20); //top
		l2 = new Line(x+110,y-20,x+110,y+55); //right
		l3 = new Line(x,y+55,x+110,y+55); // bottom
		l4 = new Line(x,y-20,x,y+55); //left
		
		boundbox = new Rectangle(x,y-20,110,75);
		
		stepX = Canvas.rand(6);
		stepY = Canvas.rand(6);
		
		label = new Text(x+35,y+10,text);
		
	}
	
	public Car(double x, double y, String text, Color c){
		this(x,y,text);//refers to all of the text in previous car constructor
		this.x = x;
		this.y = y;
		body1.setColor(c);
		body2.setColor(c);
	}
	
	public void translate(int x, int y){
		body1.translate(x,y);
		body2.translate(x,y);
		w1.translate(x,y);
		w2.translate(x,y);
		front.translate(x,y);
		l1.translate(x,y);
		l2.translate(x,y);
		l3.translate(x,y);
		l4.translate(x,y);
		boundbox.translate(x,y);
		label.translate(x,y);
	}
	
	//
	// public int getXLeft(){
		// return l1.getX();
	// }
	// public int getXRight(){
		// return l2.getX();
	// }
	// public int getYTop(){
		// return l1.getY();
	// }
	// public int getYBottom(){
		// return l3.getY();
	// }//hitbox of car
	
	public int getCX(){
		return boundbox.getX();
	}
	public int getCY(){
		return boundbox.getY();
	}
	
	//
	public void setStep(int stx, int sty){
		stepX = stx;
		stepY = sty;
	}
	//overrrides the random stepX,Y above
	
	public int getStepX(){
		return stepX;
	}
	public int getStepY(){
		return stepY;
		
	}
	
	
	public void Drive(int speed, int time){
		body1.translate(speed,0);
		body2.translate(speed,0);
		w1.translate(speed,0);
		w2.translate(speed,0);
		front.translate(speed,0);
		l1.translate(speed,0);
		l2.translate(speed,0);
		l3.translate(speed,0);
		l4.translate(speed,0);
		boundbox.translate(speed,0);
		label.translate(speed,0);
			
		Canvas.pause(time);
		
		int farthest = 725;
		int tx = 125;
		int ty = -625;
			
		if(l1.getX()>farthest-tx){
			body1.translate(-farthest,tx);
			body2.translate(-farthest,tx);
			w1.translate(-farthest,tx);
			w2.translate(-farthest,tx);
			front.translate(-farthest,tx);
			l1.translate(-farthest,tx);
			l2.translate(-farthest,tx);
			l3.translate(-farthest,tx);
			l4.translate(-farthest,tx);
			boundbox.translate(-farthest,tx);
			label.translate(-farthest,tx);
		}
		if(l1.getY()>519){
			body1.translate(0,ty);
			body2.translate(0,ty);
			w1.translate(0,ty);
			w2.translate(0,ty);
			front.translate(0,ty);
			l1.translate(0,ty);
			l2.translate(0,ty);
			l3.translate(0,ty);
			l4.translate(0,ty);
			boundbox.translate(0,ty);
			label.translate(0,ty);
		}
		
	}
	
	public void draw(){
		front.fill();
		body1.fill();
		body2.fill();
		w1.fill();
		w2.fill();
		// l1.draw();
		// l2.draw();
		// l3.draw();
		// l4.draw();
		boundbox.draw();
		label.draw();
		//draws car
		
		for(int n=0; n<6; n++){
			if(stepX == n){
				stepX = n*115 - 500;
			}
		}
		
		for(int n = 0; n<6; n++){
			if(stepY == n){
				stepY = n*125 + 22;
			}
		}
		
		body1.translate(stepX,stepY);
		body2.translate(stepX,stepY);
		w1.translate(stepX,stepY);
		w2.translate(stepX,stepY);
		front.translate(stepX,stepY);
		l1.translate(stepX,stepY);
		l2.translate(stepX,stepY);
		l3.translate(stepX,stepY);
		l4.translate(stepX,stepY);
		boundbox.translate(stepX,stepY);
		label.translate(stepX,stepY);
		//step function
		
		roady = 1;
		for(int z = 0; z<6; z++){
			road = new Line(0,roady,1000,roady);
			space = new Line(0,roady-45,1000,roady-45);
			space.setColor(Color.GREEN);
			road.draw();
			space.draw();
			roady = roady+125;
			//System.out.print(road.getY()+" ");
			//System.out.print(space.getY()+" ");
		}
		//draws roads
		
	}
	 
}