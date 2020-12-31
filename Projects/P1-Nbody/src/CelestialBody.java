

/**
 * Celestial Body class for NBody
 * @author Ayush Garg
 *
 */
public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;

	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		// TODO: complete constructor
		this.myXPos = xp;
		this.myYPos = yp;
		this.myXVel = xv;
		this.myYVel = yv;
		this.myMass = mass;
		this.myFileName = filename;
	}

	/**
	 * Copy constructor: copy instance variables from one
	 * body to this body
	 * @param b used to initialize this body
	 */
	public CelestialBody(CelestialBody b){
		// TODO: complete constructor
		this.myXPos = b.getX();
		this.myYPos = b.getY();
		this.myXVel = b.getXVel();
		this.myYVel = b.getYVel();
		this.myMass = b.getMass();
		this.myFileName = b.getName();
	}

	/**
	 * Return x-position of this Body.
	 * @return value of x-position.
	 */
	public double getX() {
		// TODO: complete method
		return myXPos;
	}

	/**
	 * Return y-position of this Body.
	 * @return value of y-position.
	 */
	public double getY() {
		// TODO: complete method
		return myYPos;
	}

	/**
	 * Return x-velocity of this Body.
	 * @return value of x-velocity.
	 */
	public double getXVel() {
		// TODO: complete method
		return myXVel;
	}
	/**
	 * Return y-velocity of this Body.
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		// TODO: complete method
		return myYVel;
	}

	/**
	 * Return mass of this Body.
	 * @return value of mass.
	 */
	public double getMass() {
		// TODO: complete method
		return myMass;
	}

	/**
	 * Return file name associated with this Body.
	 * @return value of file name.
	 */
	public String getName() {
		// TODO: complete method
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		// TODO: complete method
		double xDist = Math.pow(myXPos - b.getX(), 2);
		double yDist = Math.pow(myYPos - b.getY(), 2);
		return Math.sqrt(xDist + yDist);
	}

	/**
	 * Return the force exerted on this body by another
	 * @param b the other body to which force is calculated
	 * @return force exerted by b on this body
	 */
	public double calcForceExertedBy(CelestialBody b) {
		// TODO: complete method
		double g = 6.67 * Math.pow(10,-11);
		return (g * myMass * b.getMass()) / Math.pow(calcDistance(b), 2);
	}

	/**
	 * Return the force exerted on this body by another in the x-direction
	 * @param b the other body to which force is calculated
	 * @return force exerted by b on this body in the x-direction
	 */
	public double calcForceExertedByX(CelestialBody b) {
		// TODO: complete method
		return calcForceExertedBy(b) * (b.getX() - myXPos) / (calcDistance(b));
	}

	/**
	 * Return the force exerted on this body by another in the y-direction
	 * @param b the other body to which force is calculated
	 * @return force exerted by b on this body in the y-direction
	 */
	public double calcForceExertedByY(CelestialBody b) {
		// TODO: complete method
		return calcForceExertedBy(b) * (b.getY() - myYPos) / (calcDistance(b));
	}

	/**
	 * Return the total net force exerted on this body in the x-direction by an array of other bodies
	 * @param bodies the other bodies that apply forces on this body
	 * @return total net force exerted by bodies on this body in the x-direction
	 */
	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		// TODO: complete method
		double sum = 0.0;
		for (CelestialBody body: bodies) {
			if (!body.equals(this)) {
				sum += calcForceExertedByX(body);
			}
		}
		return sum;
	}

	/**
	 * Return the total net force exerted on this body in the y-direction by an array of other bodies
	 * @param bodies the other bodies that apply forces on this body
	 * @return total net force exerted by bodies on this body in the y-direction
	 */
	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		double sum = 0.0;
		for (CelestialBody body: bodies) {
			if (!body.equals(this)) {
				sum += calcForceExertedByY(body);
			}
		}
		return sum;
	}

	/**
	 * Update the body's position and velocity with small time steps
	 * @param deltaT the small time steps
	 * @param xforce net force exerted on this body by all other bodies in the x-direction
	 * @param yforce net force exerted on this body by all other bodies in the y-direction
	 */
	public void update(double deltaT, 
			           double xforce, double yforce) {
		// TODO: complete method
		// Calculating acceleration
		double ax = xforce / myMass;
		double ay = yforce / myMass;

		// Calculating new X and Y velocities
		double nvx = myXVel + deltaT*ax;
		double nvy = myYVel + deltaT*ay;

		// Calculation new X and Y positions
		double nx = myXPos + deltaT*nvx;
		double ny = myYPos + deltaT*nvy;

		// Updating instance variables for position and velocity
		myXPos = nx;
		myYPos = ny;
		myXVel = nvx;
		myYVel = nvy;
	}

	/**
	 * Draws this planet's image at its current position
	 */
	public void draw() {
		StdDraw.picture(myXPos,myYPos,"images/"+myFileName);
	}
}
