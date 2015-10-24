
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Sudoku {
	
	private final int TAILLE_GRILLE = 9; //9x9
	
	/**
	 * Lit le fichier .sud ou .txt avec saut de ligne ou non
	 */
	public int[][] getSudoku(){
		
		int grilleTemp[][] = null;
		String filename = null;
		byte [] b = null;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Entrer le nom du fichier avec son extension : ");
		try {
			filename = br.readLine();
			File file = new File(filename);
		    Path path = file.toPath();
		    
		    b = Files.readAllBytes(path);
		    
		} catch (IOException e) {
			System.out.println("Ain't nobody got file named like that !");
			e.printStackTrace();
		}
		
		String grille = new String(b, StandardCharsets.UTF_8 );		
		
		//supprime les sauts de ligne de la string si jamais il y'en avait
		grille = grille.replaceAll("\\r\\n", "");
		
		grilleTemp = remplirGrille(grille);
		
		return grilleTemp;
	}
	
	/**
	 * Methode qui va remplir un tableau double d'entier représentant la 
	 * grille sudoku
	 * @param sudoku - String contenant la grille de sudoku
	 * @return int[][] - grille rempli
	 */
	public int[][] remplirGrille(String sudoku){
		
		int grille[][] = new int[TAILLE_GRILLE][TAILLE_GRILLE];
		int i = 0;
		for (int row = 0; row < TAILLE_GRILLE; row++) 
		{
			for (int col = 0; col < TAILLE_GRILLE; col++)
			{
				grille[row][col] = Character.getNumericValue(sudoku.charAt(i));				
				i++;	
			}	
		}
		
		
		return grille;
	}
	
	/**
	 * affiche la grille de sudoku
	 * @param grille
	 */
	public void affichageGrille(int[][] grille){
		
		for (int row = 0; row < TAILLE_GRILLE; row++) 
		{
			if(row%3 == 0)
				System.out.println("-------------");
			
			for (int col = 0; col < TAILLE_GRILLE; col++){
				if(col%3 == 0)
					System.out.print("|");
				System.out.print(grille[row][col]);
				
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.println("-------------");
	}
}
