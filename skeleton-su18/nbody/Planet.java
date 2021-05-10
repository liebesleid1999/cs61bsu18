public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;	

	public Planet(double xP,double yP,double xV,double yV,double m,String img){
			xxPos = xP;
			yyPos = yP;
			xxVel = xV;
			yyVel = yV;
			mass = m;
			imgFileName = img;
    }

    public void change (double xP,double yP,double xV,double yV,double m,String img){
			xxPos = xP;
			yyPos = yP;
			xxVel = xV;
			yyVel = yV;
			mass = m;
			imgFileName = img;
    }

    public Planet(Planet b){
			xxPos = b.xxPos;
			yyPos = b.yyPos;
			xxVel = b.xxVel;
			yyVel = b.yyVel;
			mass = b.mass;
			imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet b){
    	double dis;
    	dis = Math.sqrt(Math.pow(b.xxPos - this.xxPos,2) + Math.pow(b.yyPos - this.yyPos,2));
  
    	return dis;
    }

    public double calcForceExertedBy(Planet b){
    	double force;
 
    	force = 6.67e-11 * b.mass * mass / Math.pow(calcDistance(b),2);
    	return force;
    }

    public double calcForceExertedByX(Planet b){
    	double force;
 
    	force = calcForceExertedBy(b) * (b.xxPos - this.xxPos) / calcDistance(b);

    	return force;
    }
    
    public double calcForceExertedByY(Planet b){
    	double force;
 
    	force = calcForceExertedBy(b) * (b.yyPos-this.yyPos) / calcDistance(b);
    	
    	return force;
    }
    public boolean equals(Planet b){
    	return b.imgFileName == imgFileName;
    }

    public double calcNetForceExertedByX(Planet[] b){
    	double force = 0;
 		for(int i = 1;i < b.length;i ++){
 			if (equals(b[i])){
 				continue;
 			}
    		force += calcForceExertedByX(b[i]);
 		}
    	
    	return force;
    }

    public double calcNetForceExertedByY(Planet[] b){
    	double force = 0;
 		for(int i = 0;i<b.length;i++){
 			if (equals(b[i])){
 				continue;    		
 			}
 			force += calcForceExertedByY(b[i]);
 		}
    	
    	return force;
    }  

    public void update(double dt,double fx,double fy){
			xxVel += dt * fx / mass;
			yyVel += dt * fy / mass;
			xxPos += dt * xxVel;
			yyPos += dt * yyVel;
    }

    public void draw(){
    	StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    //	System.out.println(xxPos+yyPos);
    }

    
}



