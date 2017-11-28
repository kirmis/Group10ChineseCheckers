/*
 * SER215 Group Project: Chinese Checkers
 * Group 10: Ryan Kirmis, Manolito Ramirez, Hadeel Aldosary, and Jessica Gilbert
 * Date of submission: December 1, 2017
 * 
 * Server class to Chinese Checkers game.
 */

import java.net.*;
import java.util.Date;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

import java.io.*;

public class Server extends Application implements Runnable
{
	// initializing server, sockets, and server log UI
	private ServerSocket server;
	private Socket player1;
	private Socket player2;
	private Socket player3;
	private Socket player4;
	private Socket player5;
	private Socket player6;
	private TextArea log;
	private int sessionNum;
	
	// server port number
	private int port;
	
	/**
	 * Overridden start method that sets up the server log and starts a separate thread to accept clients.
	 * @param primaryStage
	 */
	
	@Override
	public void start(Stage primaryStage)
	{
		log = new TextArea();
		log.setEditable(false);
		log.setMaxSize(450, 200);
		primaryStage.setTitle("Server log");
		Scene logScene = new Scene(new ScrollPane(log), 450, 200);
		primaryStage.setScene(logScene);
		primaryStage.show();
		
		primaryStage.setOnCloseRequest(e -> primaryStage.close());
		
		new Thread(this).start();
	}
	
	/**
	 * Overridden run() method to continuously accept clients into sessions.
	 */
	
	@Override
	public void run()
	{
		try
		{
			// creating server at port number
			port = 8000;
			server = new ServerSocket(port);
			log.appendText(new Date() + ": Server created at port " + Integer.toString(port) + ".\n");
			
			// initializing session number to 0
			sessionNum = 0;
			
			while(true) // loop continuously 
			{
				sessionNum++; // increment session number
				
				// accepting players into server and initializing object input/output streams
				player1 = server.accept();
				ObjectOutputStream toP1 = new ObjectOutputStream(player1.getOutputStream());
				ObjectInputStream fromP1 = new ObjectInputStream(player1.getInputStream());
				// updating server log
				log.appendText(new Date() + ": Player 1 accepted into Session " + sessionNum + ".\n");
				player2 = server.accept();
				ObjectOutputStream toP2 = new ObjectOutputStream(player2.getOutputStream());
				ObjectInputStream fromP2 = new ObjectInputStream(player2.getInputStream());
				log.appendText(new Date() + ": Player 2 accepted into Session " + sessionNum + ".\n");
				player3 = server.accept();
				ObjectOutputStream toP3 = new ObjectOutputStream(player3.getOutputStream());
				ObjectInputStream fromP3 = new ObjectInputStream(player3.getInputStream());
				log.appendText(new Date() + ": Player 3 accepted into Session " + sessionNum + ".\n");
				player4 = server.accept();
				ObjectOutputStream toP4 = new ObjectOutputStream(player4.getOutputStream());
				ObjectInputStream fromP4 = new ObjectInputStream(player4.getInputStream());
				log.appendText(new Date() + ": Player 4 accepted into Session " + sessionNum + ".\n");
				player5 = server.accept();
				ObjectOutputStream toP5 = new ObjectOutputStream(player5.getOutputStream());
				ObjectInputStream fromP5 = new ObjectInputStream(player5.getInputStream());
				log.appendText(new Date() + ": Player 5 accepted into Session " + sessionNum + ".\n");
				player6 = server.accept();
				ObjectOutputStream toP6 = new ObjectOutputStream(player6.getOutputStream());
				ObjectInputStream fromP6 = new ObjectInputStream(player6.getInputStream());
				log.appendText(new Date() + ": Player 6 accepted into Session " + sessionNum + ".\n");
			
				log.appendText(new Date() + ": Starting Session " + sessionNum + ".\n");
				
				// create a session thread using class HandleASession
				Thread handle = new Thread(new HandleASession(player1, toP1, fromP1, player2, toP2, fromP2, player3, toP3, fromP3, player4, toP4, fromP4, player5, toP5, fromP5, player6, toP6, fromP6));
				handle.start();
			}	
		}
		catch(IOException ex)
		{
			// printing IOExceptions
			System.err.println(ex);
		}
	}
	
	/**
	 * Main method that launches UI.
	 * @param args
	 */
	
	public static void main(String [] args)
	{
		launch(args);
	}
}
