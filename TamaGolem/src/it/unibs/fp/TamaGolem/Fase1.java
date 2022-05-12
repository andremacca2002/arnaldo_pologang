package it.unibs.fp.TamaGolem;

public class Fase1 {

	    private static Elemento[] elementi = {Elemento.MAIONESE, Elemento.BARBECUE, Elemento.YOGURT, Elemento.KETCHUP, Elemento.TERIYAKI};

	    /**
	     * Questo metodo crea l'equilibrio tra i vari elementi esistenti
	     */
	    public static int[][] creaEquilibrio(){

	        int [][] M = new int[5][5];
	        for ( int i = 0; i < 5; i++)
	            for ( int j = 0; j < 5; j++)
	                M[i][j] = 0;

	        while ( M[0][1] == 0 || M[0][2] == 0 ) {
	            M[0][1] = (int) Math.floor(Math.random() * (9)-4);
	            M[0][2] = (int) Math.floor(Math.random() * (9)-4);
	            while ( (M[0][3] + M[0][4]) != (0 - M[0][1] - M[0][2]) || M[0][3] == 0 || M[0][4] == 0 ) {
	                M[0][3] = (int) Math.floor(Math.random() * (9)-4);
	                M[0][4] = (int) Math.floor(Math.random() * (9)-4);
	            }
	            M[1][0] = 0 - M[0][1];
	            M[2][0] = 0 - M[0][2];
	            M[3][0] = 0 - M[0][3];
	            M[4][0] = 0 - M[0][4];
	        }

	        while ( M[1][2] == 0 ) {
	            M[1][2] = (int) Math.floor(Math.random() * (9)-4);
	            while ( (M[1][3] + M[1][4]) != (0 - M[1][0] - M[1][2]) || M[1][3] == 0 || M[1][4] == 0 ) {
	                M[1][3] = (int) Math.floor(Math.random() * (9)-4);
	                M[1][4] = (int) Math.floor(Math.random() * (9)-4);
	            }
	            M[2][1] = 0 - M[1][2];
	            M[3][1] = 0 - M[1][3];
	            M[4][1] = 0 - M[1][4];
	        }

	        while ( (M[2][3] + M[2][4]) != (0 - M[2][0] - M[2][1]) || M[2][3] == 0 || M[2][4] == 0 || M[0][4] + M[1][4] + M[2][4] > 4 || M[0][4] + M[1][4] + M[2][4] < -4 || M[0][3] + M[1][3] + M[2][3] > 4 || M[0][3] + M[1][3] + M[2][3] < -4 || M[0][3] + M[1][3] + M[2][3] != M[4][0] + M[4][1] + M[4][2] || M[0][4] + M[1][4] + M[2][4] != M[3][0] + M[3][1] + M[3][2] ) {
	            M[2][3] = (int) Math.floor(Math.random() * (9)-4);
	            M[2][4] = (int) Math.floor(Math.random() * (9)-4);
	            M[3][2] = 0 - M[2][3];
	            M[4][2] = 0 - M[2][4];
	        }

	        M[3][4] = 0 - M[0][4] - M[1][4] - M[2][4];
	        M[4][3] = 0 - M[3][4];

	        return M;
	    }

	    public static Elemento[] getElementi() {
	        return elementi;
	    }
	}

