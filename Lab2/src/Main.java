

public class Main {
	
	public static void main(String[] args) {
		
		long startTime = 0;
		String time = "";

		//grille de test
		
//		 int grille[][] = { 
//				   { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
//				   { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
//				   { 0, 8, 7, 0, 0, 0, 0, 3, 1 }, 
//				   { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
//				   { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
//				   { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, 
//				   { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
//				   { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
//				   { 0, 0, 5, 2, 0, 6, 3, 0, 0 } 
//				   };
				   
		int grille[][] = null;		   
		
		Sudoku sudo = new Sudoku();
		
		grille = sudo.getSudoku();
		Validateur bob = new Validateur(grille);
		Solveur tada = new Solveur(bob);
		sudo.affichageGrille(grille);
		
		try {
			
			startTime = System.nanoTime();
			tada.solve(0, 0);
			
		} catch (Exception e) {
			
			  time = String.valueOf( (System.nanoTime() - startTime) );			
			  
	    	  System.out.println("=== Done ===");	    	  
	    	  tada.getValid().affichageGrille();
	    	  
	    	  System.out.println("temps1= "+ time + "ns" );
		}
		//TODO est-ce que le thread est utile. Tester une version purement recursive pour comparer les vitesses.
		//TODO throw les exceptions jusquau main
			//TODO afficher la grille une fois que le run est fini (sans passer par le solveur)
		//sudo.affichageGrille(bob.getModel());

	}
	
}
