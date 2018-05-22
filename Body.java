package Gravity;

import edu.princeton.cs.introcs.StdDraw;

public class Body {

	// Initialize Variables
	public double planet_x;
	public double planet_y;
	public double planet_vx;
	public double planet_vy;
	public double planet_radius;
	public double mass;

	public int R;
	public int G;
	public int B;

	public Body(double x, double y, double vx, double vy, double radius,double m, int r, int g, int b) { // build constructor
		 planet_x = x;
		 planet_y = y;
		 planet_vx = vx;
		 planet_vy = vy;
		 planet_radius = radius;
		 mass = m;
		 
		 R = r;
		 G = g;
		 B = b;																						 

	}

	public double setMass() { // m equals mass
		double m;
		m = mass;
		return mass;
	}

	public void draw(double cx, double cy, double PIXEL_PER_METER) { // draw utilizing PIXEL_PER_METER
		StdDraw.setPenColor(R, G, B);
		StdDraw.filledCircle(cx +( planet_x * PIXEL_PER_METER), cy +(planet_y *PIXEL_PER_METER), planet_radius);

	}

	public void updatePosition(double timestep) { // update positions of earth
													// and moon
		planet_x = planet_x + planet_vx * timestep;
		planet_y = planet_y + planet_vy * timestep;
		
	}

	public void updateVelocity(double ax, double ay, double timestep) { // update
																		// velocity
		planet_vx = planet_vx + ax * timestep;
		planet_vy = planet_vy + ay * timestep;
	}
}