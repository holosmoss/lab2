

public class Main {
	
	public static void main(String[] args) {
		
		long startTime = 0;
		String time = "";
				   
		int grille[][] = null;		   
		
		//convertisseur d<input en model de sudoku
		Sudoku sudo = new Sudoku();
		grille = sudo.getSudoku();
		//validateur pour les ajouts dans la grille
		Validateur bob = new Validateur(grille);
		//solutioneur qui va tenter tout les possibilité
		Solveur tada = new Solveur(bob);
		sudo.affichageGrille(grille);
		
		try {
			//On essaie de resoudre la grille
			startTime = System.nanoTime();
			tada.solve(0, 0);
			//si rien ne se passe (pas d'exceptions) aucune solution nexiste
			System.out.println("Aucune solution possible");
			time = String.valueOf( (System.nanoTime() - startTime) );
			System.out.println("temps1= "+ time + "ns" );
			
		} catch (Exception e) {
			
			  //le model est maintenant la solution trouvé
			  time = String.valueOf( (System.nanoTime() - startTime) );			
	    	  System.out.println("=== Done ===");	    	  
	    	  tada.getValid().affichageGrille();	    	  
	    	  System.out.println("temps1= "+ time + "ns" );
		}
	}
	
}
