public class NBody {
	final static int pauseTime = 10;

	public static double readRadius(String fileLocation) {
		In in = new In(fileLocation);
		in.readDouble();// pass the num of planets 
		return in.readDouble();
	}

	public static Planet[] readPlanets(String fileLocation) {
		In in = new In(fileLocation);
		int PlanetNum = in.readInt();
		Planet[] planets = new Planet[PlanetNum];

		in.readDouble(); // /pass the radius 

		for(int i = 0; i < PlanetNum; i++) {			
			double xxPos = in.readDouble();
			double yyPos  = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}
		return planets;
	}

	public static void main(String[] args) {
		Double T = Double.parseDouble(args[0]);
		Double dt = Double.parseDouble(args[1]);
		String fileLocation = args[2];

		Double radius = NBody.readRadius(fileLocation);
		Planet[] planets = NBody.readPlanets(fileLocation);

		/*  initize the graph */
		StdDraw.setScale(-radius, radius);
		StdDraw.enableDoubleBuffering();
		StdDraw.picture(0, 0, "./images/starfield.jpg");
		for(Planet p : planets) {
			p.draw();
		}

		StdDraw.show();


		/* animation */
		int time = 0;
		while(time != T) {
			Double[] xForces = new Double[planets.length];
			Double[] yForces = new Double[planets.length];

			for(int i = 0; i < planets.length; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}

			for(int i = 0; i < planets.length; i++) {
				planets[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.picture(0, 0, "./images/starfield.jpg");
			for(Planet p : planets) {
				p.draw();
			}

			StdDraw.pause(pauseTime);
			StdDraw.show();

			time += dt;
		}

		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
		                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}		
	}

}