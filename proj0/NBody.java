
import java.util.Scanner;
public class NBody{
	

	static double readRadius(String s){


			/* Start reading in national_salt_production.txt */
			In in = new In(s);
			
			/* Keep looking until the file is empty. 
			while(!in.isEmpty())  String st)
			 Each line has the rank of a country, then its
			  name, then its production in metric tons, and
			 finally the fraction of world salt output it produces. */
			int n = in.readInt();
			double re = in.readDouble();

			return re;
	}

	static Body[] readBodies(String s){


			/* Start reading in national_salt_production.txt */
			In in = new In(s);
			int n = in.readInt();
			double radius = in.readDouble();
			int k = 0 ;
			Body[ ] b = new Body [n];
			while( k < n  ){

				double xP = in.readDouble();
				double yP = in.readDouble();
				double yV = in.readDouble();
				double xV = in.readDouble();
				double mass = in.readDouble();
				String img = in.readString();

				b[k] = new Body (xP,yP,yV,xV,mass,img);
			//    b[k].change(xP,yP,yV,xV,mass,img);
				k ++ ;
			}
			return b;
		
	}


    public static void main(String[] args){
/*
    	Scanner inp = new Scanner(System.in);
        String str = inp.next();

        
        
        double t = Double.parseDouble(str);


        
        str = inp.next();
        double dt = Double.parseDouble(str);
       

        
		str = inp.next();*/
//		if(args.length > 0 ) 

		double t = Double.parseDouble(args[0]);
		
		double dt = Double.parseDouble(args[1]);
		
		String filename = args[2];

        double r = NBody.readRadius ( filename );

        Body[] Body = NBody.readBodies ( filename );

        StdDraw.setScale(-r, r);
        
        String background = "images/starfield.jpg";
 	    
 	    StdDraw.picture(0, 0, background);

 	    for(int i = 0 ; i < Body.length; i++ ){

 	    	Body[i].draw();

 	    }

		StdDraw.enableDoubleBuffering();

 	    int time=0;

 	    while(time < t){
 	    	 	    

 	     
  	        StdDraw.clear(); 
 	    	double [] xForce = new double [Body.length];

 	    	double [] yForce = new double [Body.length];

 	    	for(int i = 0 ; i < Body.length; i++ ){
 	    		yForce[i] = Body[i].calcNetForceExertedByY(Body);
 	    		xForce[i] = Body[i].calcNetForceExertedByX(Body);
 	  		}

			for(int i = 0 ; i < Body.length; i++ ){
 	    		Body[i].update(dt,xForce[i],yForce[i]);
 	  		}

 	  	    StdDraw.picture(0, 0, background);

 	 	    for(int i = 0 ; i < Body.length; i++ ){

 	  		  	Body[i].draw();

 	 	    }


 	 	    t += dt;

 	  	    StdDraw.show();
 	 	    StdDraw.pause(23);
 	    }

 	    StdOut.printf("%d\n", Body.length);
		StdOut.printf("%.2e\n", r);
		for (int i=0; i < Body.length; i++) {
  		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  Body[i].xxPos, Body[i].yyPos, Body[i].xxVel,
                  Body[i].yyVel, Body[i].mass, Body[i].imgFileName);   
		}

    }
}
