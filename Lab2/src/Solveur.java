
public class Solveur {

	private Validateur valid;

	
	public Solveur(Validateur v) {
		//
		this.valid = v;
	}
	public Validateur getValid() {
		return valid;
	}
	/**
	 * --------------------Citation--------------------------
	 * La structure du solve est fortement inspiré du site web
	 * http://www.heimetli.ch/ffh/simplifiedsudoku.html
	 * surtout en ce qui concerne l'utilisation d'une exception pour déterminer
	 * que la récursion est terminé avec une solution
	 */
	
	/**
	 * Fonction recursive qui se termine soit par une exception 
	 * qui nous indique que tout les cellules sont remplie donc nous avons la solution
	 * Sinon les solves appeler recursivement vont se remettre a 0 pour le backtracking
	 * 		dautre solve continuer de tester dautre possibilites
	 * jusqua ce que finalement la cell 0,0 retourne a 0 et rien ne se passe : pas de solution
	 * 
	 * @param row
	 * @param col
	 * @throws Exception
	 */
	public void solve(int row, int col)throws Exception{
		if(row > 8){
			// avec ce test on s<assure que la récursion se termine
			throw new Exception("grille terminé");
		}
		//si la cell est déja remplie on passe à la prochaine
		if(valid.getValue(row, col)!=0){
			next(row,col);
		}else{
			//pour les cell vide tester les valeur de 1 à 9
			for(int val=1;val<10;val++){
				//le validateur va nous dire si la valeur testé est déja dans notre col ou row ou boite
				if(valid.isValid(row, col, val)){
					//on ajoute cette valeur au model
					valid.setValue(row,col,val);
					//récursion de notre solve
					next(row,col);
				}
			}
			// nous n'avons pas pu ajouter de valeur, reset a 0
			//apres avoir tester toute les options aucune n<est bonne pour la cell donc on remet a 0
			//tout les solves vont continuer de tester des valeurs jusqua ce que tous finissent et que 0-0 est décidé non valide
			//si il on se rend ici pour le premier solve il n<y a donc pas de solution (autrement l<exception sera lancé)
			valid.setValue(row,col,0);
		}
	}
	/**
	 * Fonction de controle pour la récurence du solve.
	 * part un solve pour la prochaine cell
	 * @param row
	 * @param col
	 * @throws Exception
	 */
	public void next( int row, int col ) throws Exception{ 
		//logique pour continuer col par col sur chaque row et sauté une row si on arrive au bout
		if(col<8){
			solve(row,col+1);
		}else{
			solve(row+1,0) ;
		}
	}

}
