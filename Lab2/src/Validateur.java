
public class Validateur {

	private int[][] model = new int[9][9] ;
	public Validateur(int[][] m) {
		this.model = m;
	}

	protected int[][] getModel(){
		return model;
	}
	protected int getValue(int row, int col){
		return model[row][col];
	}
	protected void setValue(int row, int col, int val){
		model[row][col] = val;
	}
	protected boolean isValid(int row, int col, int val){
		//validons la row en premier
		for(int coli = 0; coli < 9 ; coli++){
			//pour la row donnee on verifie tout les cols pour un doublon de la val
			if(model[row][coli] == val){
				//on peut pas ajouter la valeur ell est deja dans la row
				return false;
			}
		}
		//validons la col maintenant
		for(int rowi = 0; rowi<9; rowi++){
			//pour la col donee on verifie qu<aucune de ses row n'a la valeur
			if(model[rowi][col] == val){
				//valeur non valide pour la col
				return false;
			}
		}
		//finalement validons la boite 3x3
		//pour nos cel/row donnee trouver le début de leurs boites
		row = (row/3)*3;
		col = (col/3)*3;
		for(int r=0; r<3;r++){
			for(int c=0;c<3;c++){
				//on passe toute les cell de toute les row dans la boite 3x3 de notre validation
				if(model[row+r][col+c] == val){
					//la valeur existe deja dans notre boite donc pas valide
					return false;
				}
			}
		}
		//la valeur est valide
		return true;
	}
	
	 
	/**
	 * Parceque lazyness voici un merveilleu doublon
	 * affiche la grille de sudoku
	 * @param grille
	 */
	public void affichageGrille(){
		
		for (int row = 0; row < 9; row++) 
		{
			if(row%3 == 0)
				System.out.println("-------------");
			
			for (int col = 0; col < 9; col++){
				if(col%3 == 0)
					System.out.print("|");
				System.out.print(model[row][col]);
			}
			System.out.print("|");	
			System.out.println();
		}
		System.out.println("-------------");
	}
	   
	
}
