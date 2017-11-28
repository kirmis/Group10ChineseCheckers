

public class Board extends Marbles implements java.io.Serializable
{
	Marbles board[][] = new Marbles [13][17];
	
	public Board()
	{
		for (int x = 0; x < 13; x++)
		{
			for (int y = 0; y < 17; y++)
			{
				board[x][y]= new Marbles();
			}
		}
		//sets player 1 as green
		board[6][0].setColor('g');
		board[5][1].setColor('g');
		board[6][1].setColor('g');
		board[5][2].setColor('g');
		board[6][2].setColor('g');
		board[7][2].setColor('g');
		board[4][3].setColor('g');
		board[5][3].setColor('g');
		board[6][3].setColor('g');
		board[7][3].setColor('g');	
		
		//sets player 3 as yellow
		board[0][4].setColor('y');
		board[1][4].setColor('y');
		board[2][4].setColor('y');
		board[3][4].setColor('y');
		board[0][5].setColor('y');
		board[1][5].setColor('y');
		board[2][5].setColor('y');
		board[1][6].setColor('y');
		board[2][6].setColor('y');
		board[1][7].setColor('y');
		
		//sets player 5 as pink
		board[10][7].setColor('p');
		board[10][6].setColor('p');
		board[11][6].setColor('p');
		board[9][5].setColor('p');
		board[10][5].setColor('p');
		board[11][5].setColor('p');
		board[9][4].setColor('p');
		board[10][4].setColor('p');
		board[11][4].setColor('p');
		board[12][4].setColor('p');

		//sets payer 6 as white
		board[0][12].setColor('w');
		board[1][12].setColor('w');
		board[2][12].setColor('w');
		board[3][12].setColor('w');
		board[0][11].setColor('w');
		board[1][11].setColor('w');
		board[2][11].setColor('w');
		board[1][10].setColor('w');
		board[2][10].setColor('w');
		board[1][9].setColor('w');
		
		//sets player 4 as blue
		board[10][9].setColor('b');
		board[10][10].setColor('b');
		board[11][10].setColor('b');
		board[9][11].setColor('b');
		board[10][11].setColor('b');
		board[11][11].setColor('b');
		board[9][12].setColor('b');
		board[10][12].setColor('b');
		board[11][12].setColor('b');
		board[12][12].setColor('b');

		//sets player 2 as red
		board[4][13].setColor('r');
		board[5][13].setColor('r');
		board[6][13].setColor('r');
		board[7][13].setColor('r');
		board[7][14].setColor('r');
		board[5][14].setColor('r');
		board[6][14].setColor('r');
		board[5][15].setColor('r');
		board[6][15].setColor('r');
		board[6][16].setColor('r');
	
		//sets the playable area to a
		board[4][4].setColor('a');
		board[5][4].setColor('a');
		board[6][4].setColor('a');
		board[7][4].setColor('a');
		board[8][4].setColor('a');
		board[3][5].setColor('a');
		board[4][5].setColor('a');
		board[5][5].setColor('a');
		board[6][5].setColor('a');
		board[7][5].setColor('a');
		board[8][5].setColor('a');
		board[3][6].setColor('a');
		board[4][6].setColor('a');
		board[5][6].setColor('a');
		board[6][6].setColor('a');
		board[7][6].setColor('a');
		board[8][6].setColor('a');
		board[9][6].setColor('a');
		board[2][7].setColor('a');
		board[3][7].setColor('a');
		board[4][7].setColor('a');
		board[5][7].setColor('a');
		board[6][7].setColor('a');
		board[7][7].setColor('a');
		board[8][7].setColor('a');
		board[9][7].setColor('a');
		board[2][8].setColor('a');
		board[3][8].setColor('a');
		board[4][8].setColor('a');
		board[5][8].setColor('a');
		board[6][8].setColor('a');
		board[7][8].setColor('a');
		board[8][8].setColor('a');
		board[9][8].setColor('a');
		board[10][8].setColor('a');
		board[2][9].setColor('a');	
		board[3][9].setColor('a');
		board[4][9].setColor('a');
		board[5][9].setColor('a');
		board[6][9].setColor('a');
		board[7][9].setColor('a');
		board[8][9].setColor('a');
		board[9][9].setColor('a');
		board[3][10].setColor('a');
		board[4][10].setColor('a');
		board[5][10].setColor('a');	
		board[6][10].setColor('a');	
		board[7][10].setColor('a');	
		board[8][10].setColor('a');
		board[9][10].setColor('a');	
		board[3][11].setColor('a');
		board[4][11].setColor('a');	
		board[5][11].setColor('a');	
		board[6][11].setColor('a');	
		board[7][11].setColor('a');	
		board[8][11].setColor('a');
		board[4][12].setColor('a');	
		board[5][12].setColor('a');	
		board[6][12].setColor('a');	
		board[7][12].setColor('a');	
		board[8][12].setColor('a');			
	}
	
	public int checkIfWon()
	{
	    //if player 2 wins
	    if(board[6][0].getColor() == 'r' && board[5][1].getColor() == 'r' && board[6][1].getColor() == 'r' && board[5][2].getColor() == 'r' && board[6][2].getColor() == 'r' && board[7][2].getColor() == 'r' &&  board[4][3].getColor() == 'r' && board[5][3].getColor() == 'r' && board[6][3].getColor() == 'r' && board[7][3].getColor() == 'r')
	      return 2;
	    
	    //if player 1 wins
	    if(board[4][13].getColor() == 'g' && board[5][13].getColor() == 'g' && board[6][13].getColor() == 'g' && board[7][13].getColor() == 'g' && board[4][14].getColor() == 'g' && board[5][14].getColor() == 'g' && board[6][14].getColor() == 'g' && board[5][15].getColor() == 'g' && board[6][15].getColor() == 'g' && board[6][16].getColor() == 'g')
	      return 1;

	    // if player 3 wins
	    if(board[10][9].getColor() == 'y' && board[10][10].getColor() == 'y' && board[11][10].getColor() == 'y' && board[9][11].getColor() == 'y' && board[10][11].getColor() == 'y' && board[11][11].getColor() == 'y' && board[9][12].getColor() == 'y' && board[10][12].getColor() == 'y' && board[11][12].getColor() == 'y' && board[12][12].getColor() == 'y')
	      return 3;

	    //if player 4 wins
	    if(board[0][4].getColor() == 'b' && board[1][4].getColor() == 'b' && board[2][4].getColor() == 'b' && board[3][4].getColor() == 'b' && board[0][5].getColor() == 'b' && board[1][5].getColor() == 'b' && board[2][5].getColor() == 'b' && board[1][6].getColor() == 'b' && board[2][6].getColor() == 'b' && board[1][7].getColor() == 'b')
	      return 4;

	    //if player 5 wins
	    if(board[0][12].getColor() == 'p' && board[1][12].getColor() == 'p' && board[2][12].getColor() == 'p' && board[3][12].getColor() == 'p' && board[0][11].getColor() == 'p' && board[1][11].getColor() == 'p' && board[2][11].getColor() == 'p' && board[1][10].getColor() == 'p' && board[2][10].getColor() == 'p' && board[1][9].getColor() == 'p')
	      return 5;

	    //if player 6 wins
	    if(board[10][7].getColor() == 'w' && board[10][6].getColor() == 'w' && board[11][6].getColor() == 'w' && board[9][5].getColor() == 'w' && board[10][5].getColor() == 'w' && board[11][5].getColor() == 'w' && board[9][4].getColor() == 'w' && board[10][4].getColor() == 'w' && board[11][4].getColor() == 'w' && board[12][4].getColor() == 'w')
	      return 6;
	    
	    // else return 0
	    return 0;
	}

	public void move(int startX, int startY, int endX, int endY)
	{
	    Marbles temp = board[endX][endY];
	    board[endX][endY] = board[startX][startY];
	    board[startX][startY] = temp;
	}
	  
	public boolean checkMove(int x, int y)
	{
		boolean isValid = true;
		
		if(board[x][y].getColor() == 'r' || board[x][y].getColor() == 'b' || board[x][y].getColor() == 'p' || board[x][y].getColor() == 'g' || board[x][y].getColor() == 'y' || board[x][y].getColor()== 'w' || board[x][y].getColor()== 'z')
		{
			isValid = false;
		}
		
		return isValid;
    }
	
	public Marbles getMarble(int x, int y)
	{
		return board[x][y];
	}
}




