import java.awt.*;

public abstract class Vehicle {

	private Rectangle boundingBox;	//A teaser about using a Rectangle object as the container for any vehicle
									//object we draw. Research a Rectangle's methods, might be something handy to find
									//for determining collisions.

	private Color vehicleColor;
	
	private int height;		//Height of car body
	private int width;		//Width of car body
	
	private int xPosition;	//Current X position of top left of car
	private int yPosition;	//Current Y position of top left of car

	private int xSpeed = 10;	//Set default speeds for x & y
	private int ySpeed = 0;

	//Abstract method to draw a vehicle, pass graphics object for drawing
	public abstract void drawVehicle(Graphics g);

	//Abstract method to move a vehicle, pass panel so we can query its dimensions
	public abstract void moveVehicle(DrawingPanel dp);

	//Getters & Setters
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getxPosition() {
		return xPosition;
	}
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	public int getyPosition() {
		return yPosition;
	}
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	public Color getVehicleColor() {
		return vehicleColor;
	}
	public void setVehicleColor(Color vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	public int getxSpeed() {		return xSpeed;	}
	public void setxSpeed(int xSpeed) {		this.xSpeed = xSpeed;	}
	public int getySpeed() {		return ySpeed;	}
	public void setySpeed(int ySpeed) {		this.ySpeed = ySpeed;	}

//	public Rectangle getBoundingBox() {
//		return boundingBox;
//	}
//
//	public void setBoundingBox(Rectangle boundingBox) {
//		this.boundingBox = boundingBox;
//	}
}