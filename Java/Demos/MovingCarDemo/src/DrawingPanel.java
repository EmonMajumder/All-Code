import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawingPanel extends JPanel {	//This JPanel will serve as our drawing board, our canvas.

	//Declare a timer, used to move the car
	//Set to fire every 1/10th of a second, since the delay parameter is in milliseconds
	private Timer timer = new Timer(100, new TimerAction());

	private ArrayList<Vehicle> vehicles;

	public DrawingPanel() {

		vehicles = new ArrayList<Vehicle>();

		//Make some car objects
		Car Car1 = new Car(Color.RED, 70, 200, 100, 80);
		Car Car2 = new Car(Color.BLUE, 20, 100, 10, 10);
		Car Car3 = new Car(Color.GREEN, 100, 50, 200, 180);
		Car Car4 = new Car(Color.MAGENTA, 120, 300, 20, 20);

		vehicles.add(Car1);
		vehicles.add(Car2);
		vehicles.add(Car3);
		vehicles.add(Car4);

		// Code to add a mouselistener, to capture mouse-related events
		// Uses a class called MouseAdapter, which simplifies accessing Mouse properties & events.
		// NOTE: The MouseEvent parameter (e) contains all mouse-related properties. Use intellisense to check
		// what it has available.
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//When mouse is clicked on panel, call our start/stop timer method
				startOrStopMoving();
			}
		});

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	//Tell the parent JPanel to repaint ie redraw
									//Avoids a couple of potential issues
		
		//Draw each vehicle from the array on panel
		for (Vehicle vehicle : vehicles) {
			vehicle.drawVehicle(g);
		}
		//myCar.drawVehicle(g);		//Original code, when we only had one car
		//timer.start();			//Original code, when we only had one car
	}

	//Method we use that's hooked up to the timer ticks.
	public void driveTheVehicle()
	{
		//Call the "move me" method for each car
		for (Vehicle vehicle : vehicles) {
			vehicle.moveVehicle(this);
		}

		//After the move, tell the panel to repaint (which re-calls
		//the paintComponent() method)
		DrawingPanel.this.repaint();
	}

	//Method to start or stop the timer - in effect, stopping the cars' movements
	private void startOrStopMoving() {

		if (timer.isRunning()) {
			timer.stop();
		}
		else {
			timer.start();
			}
	}

	//A private class we declared for use with the Timer object. A Timer's constructor needs an ActionListener, so
	//we made one for our own use. Since it implements ActionListener, it IS an ActionListener.
	private class TimerAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//Whenever the timer fires a tick event, this method is called, which in turn calls our "drive" method.
			driveTheVehicle();
		}
	}
}

