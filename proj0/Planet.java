public class Planet {
	double xxPos, yyPos;
	double xxVel, yyVel;
	double mass;
	String imgFileName;
	static final double g = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
		double dx = p.xxPos - this.xxPos;
		double dy = p.yyPos - this.yyPos;
		return Math.pow(dx * dx + dy * dy, 0.5);
	}

	public double calcForceExertedBy(Planet p) {
		double r = calcDistance(p);
		return (g * this.mass * p.mass) / (r * r);
	}

	public double calcForceExertedByX(Planet p) {
		double f = calcForceExertedBy(p);
		double r = calcDistance(p);
		return (f * (p.xxPos - this.xxPos)) / r;
	}

	public double calcForceExertedByY(Planet p) {
		double f = calcForceExertedBy(p);
		double r = calcDistance(p);
		return (f * (p.yyPos - this.yyPos)) / r;
	}

	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double f = 0;
		for(Planet p : allPlanets) {
			if (p.equals(this) == false)
				f += calcForceExertedByX(p);
		}
		return f;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets) {
		double f = 0;
		for(Planet p : allPlanets) {
			if (p.equals(this) == false)
				f +=  calcForceExertedByY(p);
		}
		return f;
	}

	public void update(double dt, double xxForce, double yyForce) {
		double xxAcce = xxForce / mass;
		double yyAcce = yyForce / mass;
		xxVel += dt * xxAcce;
		yyVel += dt * yyAcce;
		xxPos += dt * xxVel;
		yyPos += dt * yyVel;
	}

	public void draw() {
		StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
	} 
 }