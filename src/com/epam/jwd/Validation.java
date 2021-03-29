package com.epam.jwd;

import com.epam.jwd.bean.Point;
import static java.lang.Math.*;

public class Validation {

	public static boolean ifSquare(Point A, Point B, Point C, Point D) {
		
		int AB;
		int BC;
		int CD;
		int DA;
		int AC;
		int BD;
		
		AB = (int) sqrt(pow( A.getX() - B.getX(),2) + pow(A.getY() - B.getY(),2) );
		BC = (int) sqrt(pow( B.getX() - C.getX(),2) + pow(B.getY() - C.getY(),2) );
		CD = (int) sqrt(pow( C.getX() - D.getX(),2) + pow(C.getY() - D.getY(),2) );
		DA = (int) sqrt(pow( D.getX() - A.getX(),2) + pow(D.getY() - A.getY(),2) );
		
		if ( AB != BC || AB != CD || AB != DA || AB == 0 ) {
			return false;
		}
		
		AC = (int) sqrt(pow( A.getX() - C.getX(),2) + pow(A.getY() - C.getY(),2) );
		BD = (int) sqrt(pow( B.getX() - D.getX(),2) + pow(B.getY() - D.getY(),2) );
		if ( AC != BD ) {
			return false;
		}
		
		return true;
		
	}
	
}
