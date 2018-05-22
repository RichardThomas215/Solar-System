

package Gravity;


import edu.princeton.cs.introcs.StdDraw;

import java.util.ArrayList;

public class SolarSystem {

	// Initialize variables
	public static int WINDOW_WIDTH = 400;
	public static int WINDOW_HEIGHT = 400;
	public static double GRAVITATIONAL_CONSTANT = 6.67384e-11;
	public static double TIMESTEP = (5000000/50);
	public static double AU = 1.49598e11;
	public static double EM = 5.9736e24;
	
	public static void main(String[] args) {

		// new bodies to new Array List
		ArrayList<Body> solarsystemBodies = new ArrayList<Body>(); 
		
	    Body Sun = new Body( 0, 0, 0, 0, 10, 1.98892e30, 255, 255, 0);

		Body Mercury = new Body(0.3871*AU, 0, 0, 48000, 3,0.055 * EM, 0, 255, 0);

		Body Venus = new Body(0.7233*AU, 0, 0, 35000, 5,0.81 * EM , 255, 255, 255);

		Body earth = new Body(AU, 0, 0, 29790, 5,EM , 0, 0, 255);
		
		Body mars = new Body(1.524*AU, 0, 0, 24140, 4,.108*EM , 255, 0, 0);

		solarsystemBodies.add(Sun);
		solarsystemBodies.add(Mercury);
		solarsystemBodies.add(Venus);
		solarsystemBodies.add(earth);
		solarsystemBodies.add(mars);

		// set canvas
		StdDraw.setXscale(0, WINDOW_WIDTH);
		StdDraw.setYscale(0, WINDOW_HEIGHT);

		system SolarSystem = new system(solarsystemBodies); // new system object instance
															 
		while (true) { // forever running
			SolarSystem.update(TIMESTEP);
			SolarSystem.draw2(200, 200, 5/1e10);
		}

	}
}
