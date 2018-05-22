package Gravity;

import edu.princeton.cs.introcs.StdDraw;
import java.util.ArrayList;

public class system {

	// Intialize variables
	public static int WINDOW_WIDTH = 200;
	public static int WINDOW_HEIGHT = 200;

	public double GRAVITATIONAL_CONSTANT = 6.67384e-11;
	public double PIXEL_PER_METER = 3 / 1e7;

	public ArrayList<Body> bodies; // Array List declared

	public system(ArrayList<Body> solarsystemBodies) { // system constructor 
		bodies = solarsystemBodies;
	}

	public void draw2(double cx, double cy, double PIXELS_PER_METER) { // get planets and draw

		StdDraw.clear(StdDraw.BLACK);
		for (int i = 0; i < bodies.size(); i++) {
			bodies.get(i).draw(cx, cy, PIXELS_PER_METER);
		}
		StdDraw.show(20);
	}

	public double[] computeAccleration(int bodyIndex) { // calculate acceleration
														
		double[] retArray = new double[2];
		double a;
		double ax = 0;
		double ay = 0;

		for (int index = 0; index < bodies.size(); index++) {
			if (index != bodyIndex) {

				double changeX = (bodies.get(index).planet_x - bodies.get(bodyIndex).planet_x);
				double changeY = (bodies.get(index).planet_y - bodies.get(bodyIndex).planet_y);

				double r = Math.sqrt((changeX * changeX) + (changeY * changeY));

				a = GRAVITATIONAL_CONSTANT * bodies.get(index).mass / (r * r);
				ax += a * changeX / r;

				ay += a * changeY / r;

			}
		}
		retArray[0] = ax;
		retArray[1] = ay;

		return retArray;

	}

	public void update(double timestep) { // Update positions and velocity and calculate acceleration
											
		double[] acceleration = new double[2];
		for (int index = 0; index < bodies.size(); index++) {
			acceleration = computeAccleration(index);
			bodies.get(index).updateVelocity(acceleration[0], acceleration[1], timestep);
			bodies.get(index).updatePosition(timestep);
		}
	}
}
