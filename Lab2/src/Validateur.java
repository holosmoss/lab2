
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

	/** Checks if num is an acceptable value for the given row */
	protected boolean checkRow( int row, int num ){
	  for( int col = 0; col < 9; col++ )
	     if( model[row][col] == num )
	        return false ;
	
	  return true ;
	}
   
	/** Checks if num is an acceptable value for the given column */
	protected boolean checkCol( int col, int num ){
	  for( int row = 0; row < 9; row++ )
	     if( model[row][col] == num )
	        return false ;
	
	  return true ;
	}
   
	/** Checks if num is an acceptable value for the box around row and col */
	protected boolean checkBox( int row, int col, int num ){
		
		//pour notre cellule trouver le début de son block
		row = (row / 3) * 3 ;
		col = (col / 3) * 3 ;
		//Verifier que le block ne contient pas notre num
		for( int r = 0; r < 3; r++ )
			for( int c = 0; c < 3; c++ )
				if( model[row+r][col+c] == num )
					return false ;
		
		return true ;
	}
	   
	   
	
}
