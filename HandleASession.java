import java.net.*;
import java.io.*;

public class HandleASession implements Runnable
{
	private Socket player1;
	private Socket player2;
	private Socket player3;
	private Socket player4;
	private Socket player5;
	private Socket player6;
	private Board board;
	private ObjectOutputStream toP1;
	private ObjectOutputStream toP2;
	private ObjectOutputStream toP3;
	private ObjectOutputStream toP4;
	private ObjectOutputStream toP5;
	private ObjectOutputStream toP6;
	private ObjectInputStream fromP1;
	private ObjectInputStream fromP2;
	private ObjectInputStream fromP3;
	private ObjectInputStream fromP4;
	private ObjectInputStream fromP5;
	private ObjectInputStream fromP6;

	HandleASession(Socket player1, ObjectOutputStream toP1, ObjectInputStream fromP1, Socket player2, ObjectOutputStream toP2, ObjectInputStream fromP2, Socket player3, ObjectOutputStream toP3, ObjectInputStream fromP3, Socket player4, ObjectOutputStream toP4, ObjectInputStream fromP4,Socket player5, ObjectOutputStream toP5, ObjectInputStream fromP5, Socket player6, ObjectOutputStream toP6, ObjectInputStream fromP6) throws IOException
	{
		this.player1 = player1;
		this.player2 = player2;
		this.player3 = player3;
		this.player4 = player4;
		this.player5 = player5;
		this.player6 = player6;
		this.toP1 = toP1;
		this.fromP1 = fromP1;
		this.toP2 = toP2;
		this.fromP2 = fromP2;
		this.toP3 = toP3;
		this.fromP3 = fromP3;
		this.toP4 = toP4;
		this.fromP4 = fromP4;
		this.toP5 = toP5;
		this.fromP5 = fromP5;
		this.toP6 = toP6;
		this.fromP6 = fromP6;
	}
	
	@Override
	public void run()
	{
		try
		{
			board = new Board();
			toP1.writeInt(1);
			toP2.writeInt(2);
			toP3.writeInt(3);
			toP4.writeInt(4);
			toP5.writeInt(5);
			toP6.writeInt(6);
			
			boolean playAgain = true;
			int turn = 1;
			
			while(playAgain == true)
			{
				int playerWon = 0;
				toP1.writeInt(turn);
				toP1.flush();
				toP2.writeInt(turn);
				toP2.flush();
				toP3.writeInt(turn);
				toP3.flush();
				toP4.writeInt(turn);
				toP4.flush();
				toP5.writeInt(turn);
				toP5.flush();
				toP6.writeInt(turn);
				toP6.flush();
				
				switch(turn)
				{
					case 1:
					{
						board = (Board) fromP1.readObject();
						break;
					}
					case 2:
					{
						board = (Board) fromP2.readObject();
						break;
					}
					case 3:
					{
						board = (Board) fromP3.readObject();
						break;
					}
					case 4:
					{
						board = (Board) fromP4.readObject();
						break;
					}
					case 5:
					{
						board = (Board) fromP5.readObject();
						break;
					}
					case 6:
					{
						board = (Board) fromP6.readObject();
						break;
					}
				}

				playerWon = board.checkIfWon();
				
				toP1.writeInt(playerWon);
				toP1.flush();
				toP2.writeInt(playerWon);
				toP2.flush();
				toP3.writeInt(playerWon);
				toP3.flush();
				toP4.writeInt(playerWon);
				toP4.flush();
				toP5.writeInt(playerWon);
				toP5.flush();
				toP6.writeInt(playerWon);
				toP6.flush();
					
				toP1.writeObject(board);
				toP1.flush();
				toP2.writeObject(board);
				toP2.flush();
				toP3.writeObject(board);
				toP3.flush();
				toP4.writeObject(board);
				toP4.flush();
				toP5.writeObject(board);
				toP5.flush();
				toP6.writeObject(board);
				toP6.flush();
				
				if(playerWon > 0)
				{
					if(fromP1.readBoolean() == false || fromP2.readBoolean() == false || fromP3.readBoolean() == false || fromP4.readBoolean() == false || fromP5.readBoolean() == false || fromP6.readBoolean() == false)
					{
						playAgain = false;
					}
				}
				else
				{
					turn++;
					if(turn > 6)
						turn = 1;
				}
			}
		}
		catch(IOException ex)
		{
			System.err.println(ex);
		} 
		catch (ClassNotFoundException ex) 
		{
			System.out.println("ERROR: Class not found.");
			ex.printStackTrace();
		} 
	}
}
