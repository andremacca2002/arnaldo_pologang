package it.unibs.fp.TamaGolem;

public class ScortaPietre {
	private static boolean [][] scorta = new boolean[5][3];
	
	public static boolean [][] inizializzazioneScorta() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 3; j++) {
				scorta[i][j] = true;
			}
		}
		return scorta;
	}

	public static boolean[][] getScorta() {
		return scorta;
	}

	public static void setScorta(boolean[][] scorta) {
		ScortaPietre.scorta = scorta;
	}
	
}
