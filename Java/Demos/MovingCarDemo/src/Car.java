import java.awt.*;

public class Car extends Vehicle {

	//Constructor
	public Car(Color color, int height, int width, int xPosition, int yPosition)
	{
		//Assign param values to properties of the object (calls super's get/set methods)
		this.setVehicleColor(color);
		this.setHeight(height);
		this.setWidth(width);
		this.setxPosition(xPosition);
		this.setyPosition(yPosition);
	}

	//Implement the inherited drawVehicle method
	@Override
	public void drawVehicle(Graphics g) {

		//This drawVehicle method uses graphics to draw a car.
		//The car is relatively-sized, meaning that all it's components sizes and x/y locations are derived from
		//only the car's x/y and l/w property values. Uses some basic math, but the payoff is that it can draw
		// any scale car from only a couple of values.

		//Example of downcasting Graphics to a Graphics2D object, to take advantage of 2D's more powerful
		//graphics capabilities. In this case, instead of using the simple .setColor() method, we're
		//creating a gradient paint object, then assigning it as the "paintbrush color" for our "canvas"
		Graphics2D g2d = (Graphics2D) g;

		GradientPaint gradient = new GradientPaint(this.getxPosition(), this.getyPosition(), this.getVehicleColor(),
				this.getxPosition() + this.getWidth(), this.getyPosition() + this.getHeight(), Color.YELLOW);

		g2d.setPaint(gradient);

		//Get the main car color from parent
		Color mainColor = this.getVehicleColor();

		//First draw the car body (rectangle)
		//g.setColor(mainColor);	//<-- original code, we changed so we could set the car's body color as a gradient
		g2d.fillRect(this.getxPosition(), this.getyPosition(), this.getWidth(), this.getHeight());
				
		//Figure out wheel size and position in relation to car body
		int wheelSize = this.getWidth()/4; 	//Wheel is quarter of width
		int leftWheelX = this.getxPosition() + (this.getWidth()/8); //Wheel starts at 1/8th of body length
		int wheelY = this.getyPosition() + (this.getHeight() - (wheelSize /2));
		
		//Draw first wheel, a filled circle (oval)
		g.setColor(Color.BLACK);	//Set wheel color to black
		g.fillOval(leftWheelX, wheelY, wheelSize, wheelSize);

		//Figure out position of right wheel - half the length of the car from the left wheel position
		int rightWheelX = leftWheelX + (this.getWidth()/2);
		
		//Draw second wheel
		g.fillOval(rightWheelX, wheelY, wheelSize, wheelSize);

		//Draw roof ( a non-filled rectangle)
		g.setColor(mainColor);
		//Half the total car width and height.
		//X position is centre of left wheel
		//Get Y position by subtracting half the height of the car body
		g.drawRect(leftWheelX + wheelSize / 2,this.getyPosition() - this.getHeight() /2, this.getWidth()/2, this.getHeight()/2);

		// Draw the "windows" separator
		g.setColor(Color.BLACK);
		//X1 and X2 are main car's X + half the width of car (to get centre)
		//Y1 is top of roof (main car Y subtract half height of car)
		//Y2 is top of main car
		g.drawLine(this.getxPosition() + this.getWidth()/2, this.getyPosition() - this.getHeight() / 2, this.getxPosition() + this.getWidth()/2, this.getyPosition());
	}

	//Implement the inherited moveVehicle() method
	@Override
	public void moveVehicle(DrawingPanel dp) {

		//To move vehicle, add "speed" to current position x/y coords

		//Either coord can be positive or negative
		//+x means move right, +y means down
		//-x means move left, -y ,means up
		this.setxPosition(this.getxPosition() + this.getxSpeed());
		this.setyPosition(this.getyPosition() + this.getySpeed());

		//What if it hits the edge of window?
		//Compare current position of car to current panel width (ie. the "furthest right" x position of window
		//Note that we add the car's width to get the car's right edge.
		if ((this.getxPosition() + this.getWidth()) >= dp.getWidth())
		{
			//Multiply by -1 to reverse the direction
			this.setxSpeed(this.getxSpeed() * -1);
		} else if (this.getxPosition() < 0)		//if the car hits the left edge (x position 0)
		{
			//Multiply by -1 to reverse the direction
			this.setxSpeed(this.getxSpeed() * -1);
		}
	}
}
