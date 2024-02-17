package tictactoe;

import java.util.Random;
import java.util.Scanner;

class Tictactoe{
	 static char[][] board;
	
	public Tictactoe()
	{
		  board=new char[3][3];
		initBoard();
	}
    void initBoard()
    {
    	for(int i=0;i<board.length;i++) {
    		for(int j=0;j<board[i].length;j++)
    		{
    			board[i][j]= ' ';
    		}
    	}
    }
   static  void displayBoard()
    {
    	System.out.println("--------------");
    	for(int i=0;i<board.length;i++) {
    		System.out.print(" | ");
    		for(int j=0;j<board[i].length;j++)
    		{
    			System.out.print(board[i][j]+ " | ");
    		}
    		System.out.println();
    		System.out.println("--------------");
    	}
    }
    
   static  void placemark(int row ,int col , char mark)
    {
    	if(row>=0 && row<=2 && col>=0 && col<=2)
    	{
    	board[row][col]=mark;
    	}
    	else
    	{
    		System.out.println("Invalid position");
    	}
    }
     static boolean checkcolwin()
    {
    	for(int j=0;j<=2;j++)
    	{
    		if( board[0][j]!=' ' && board[0][j]==board[1][j] && board[1][j]==board[2][j]) 
    		{
    			return true;
    		}
    				
    	}
    	return false;
    }
     static boolean checkrowwin()
    {
    	for(int i=0;i<=2;i++)
    	{
    		if( board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2]) 
    		{
    			return true;
    		}
    				
    	}
    	return false;
    }
    static boolean checkdiagonalwin()
    {
    	
    		if( board[0][0]!=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2] ||
    				board[0][2]!=' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0]) 
    		{
    			return true;
    		}
    				
    	
    	return false;
    }    
    static boolean checkDraw()
    {
    	for(int i=0;i<=2;i++)
    	{
    		for(int j=0;j<=2;j++)
    		{
    			if(board[i][j]==' ')
    			{
    				return false;
    			}
    		}
    	}
    	return true;
    }
}

 abstract class Player
{
	String name;
	char mark;
	abstract void makemove();
	
		boolean isvalid(int row,int col)
		{
			if(row>=0 && row<=2 && col>=0 && col<=2)
			{
				if(Tictactoe.board[row][col]==' ')
				{
					return true;
				}
				
			}
			return false;
		}
	}
	

class Humanplayer extends Player
{
	
	
	
	Humanplayer(String name, char mark){
		this.name=name;
		this.mark=mark;
		
	}
	void makemove()
	{
		Scanner sc= new Scanner(System.in);
		int row;
		int col;
		do {
			System.out.println("enter the row and col");
			 row=sc.nextInt();
			 col=sc.nextInt();
			
		}
		while(!isvalid(row,col));
		Tictactoe.placemark(row, col, mark);
	
		
	}
	
}


class Aiplayer extends Player
{
	
	
Aiplayer(String name, char mark){
		this.name=name;
		this.mark=mark;
		
	}
	void makemove()
	{
		Scanner sc= new Scanner(System.in);
		int row;
		int col;
		do {
			 Random r=new Random();
			 row=r.nextInt(3);
			 col=r.nextInt(3);
			
		}
		while(!isvalid(row,col));
		Tictactoe.placemark(row, col, mark);
	
		
	}
	
}




public class Gamelaunch {

	public static void main(String[] args) {
		Tictactoe  t=new Tictactoe();
		Humanplayer p1=new Humanplayer("Bob",'x');
		Aiplayer p2=new Aiplayer("AI",'o');
		Player cp;
		cp=p1;
		while(true) {
		System.out.println(cp.name+ "turn");
		cp.makemove();
		Tictactoe.displayBoard();
		if(Tictactoe.checkcolwin() || Tictactoe.checkrowwin() || Tictactoe.checkdiagonalwin())
		{
			System.out.println(cp.name+ " "+"won");
			break;
		}
		else if(Tictactoe.checkDraw())
		{
			System.out.println("Game is Draw");
			break; 
		}
		else
		{
			if(cp==p1)
			{
				cp=p2;
			}
			else
			{
				cp=p1;
			}
		}
		
		
		}
	}

}
