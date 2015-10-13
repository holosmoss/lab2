
public class Solveur implements Runnable {

	private Validateur valid;
	public Solveur(Validateur v) {
		//
		this.valid = v;
	}
	//http://www.heimetli.ch/ffh/simplifiedsudoku.html
	
	/** This method is called by the browser to start the applet */
	   public void start() 
	   {
//		   TODO throw les exceptions jusquau main
	      // This statement will start the method 'run' to in a new thread
	      (new Thread(this)).start() ;
	   }

	   /** The active part begins here */

	   public void run()
	   {
	      try
	      {
	         // Let the observers see the initial position
	         //Thread.sleep( 1000 ) ;
	    	 
	         // Start to solve the puzzle in the left upper corner
	         solve( 0, 0 ) ;
	      }
	      catch( Exception e )
	      {
	    	  System.out.println("WUZZAH");
	    	  valid.affichageGrille();
	      }
	   }

	   /** Recursive function to find a valid number for one single cell */
	   public void solve( int row, int col ) throws Exception
	   {
	      // Throw an exception to stop the process if the puzzle is solved
	      if( row > 8 )
	         throw new Exception( "Solution found" ) ;

	      // If the cell is not empty, continue with the next cell
	      if( valid.getValue(row,col) != 0 ){
	         next( row, col );
	      }else{
	         // Find a valid number for the empty cell
	         for( int num = 1; num < 10; num++ )
	         {
		    	//System.out.println("num:"+num+" row:"+row+" col:"+col);
		    	//System.out.println("checkRow: "+valid.checkRow(row,num)+" checkCol: "+valid.checkCol(col,num)+" checkBox: "+valid.checkBox(row,col,num));
	            if( valid.checkRow(row,num) && valid.checkCol(col,num) && valid.checkBox(row,col,num) )
	            {
	            	valid.setValue(row,col,num);
	               //updateView() ;

	               // Let the observer see it
	               //Thread.sleep( 1000 ) ;

	               // Delegate work on the next cell to a recursive call
	               next( row, col ) ;
	            }
	         }

	         // No valid number was found, clean up and return to caller
	         valid.setValue(row,col,0);
	         //updateView() ;
	      }
	   }

	   /** Calls solve for the next cell */
	   public void next( int row, int col ) throws Exception
	   {
	      if( col < 8 )
	         solve( row, col + 1 ) ;
	      else
	         solve( row + 1, 0 ) ;
	   }
}
