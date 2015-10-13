

public class Main {
	
	public static void main(String[] args) {

		//grille de test
		/*
		  int grille[][] = { 
				   { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
				   { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
				   { 0, 8, 7, 0, 0, 0, 0, 3, 1 }, 
				   { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
				   { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
				   { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, 
				   { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
				   { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
				   { 0, 0, 5, 2, 0, 6, 3, 0, 0 } 
				   };
		*/		   
		int grille[][] = null;		   
		
		Sudoku sudo = new Sudoku();
		
		grille = sudo.getSudoku();
		sudo.affichageGrille(grille);

	}
	
}
