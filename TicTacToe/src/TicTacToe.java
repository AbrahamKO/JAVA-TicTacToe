import java.util.Scanner;

public class TicTacToe {
	static Scanner input = new Scanner(System.in);
	
	static char[][] OX= new char [3][3];
	
	public static void main(String args[]){
		if (FirstQuestion() ==1)
		{	
			do{
				player1();
				if (win() == true)
				{	
					System.out.println("Player1 WIN!!!!");
					System.exit(0);
				}else if (tie())
				{
					System.out.println("It's a tie");
					System.exit(0);
				}
				computer();
				if (win() == true)
				{	
					System.out.println("Computer WIN!!!!");
					System.exit(0);
				}else if (tie())
				{
					System.out.println("It's a tie");
					System.exit(0);
				}
			}while(!win());
		}
		
		else if (FirstQuestion() ==2)
		{
			do{
				player1();
				if (win() == true)
				{	
					System.out.println("Player1 WIN!!!!");
					System.exit(0);
				}else if (tie())
				{
					System.out.println("It's a tie");
					System.exit(0);
				}
				player2();
				if (win() == true)
				{	
					System.out.println("Player2 WIN!!!!");
					System.exit(0);
				}else if (tie())
				{
					System.out.println("It's a tie");
					System.exit(0);
				}
			}while(!win());
		}
		map();
	}
	
	private static boolean win() {
	
		if (OX[0][0] == OX [0][1] && OX[0][0] == OX[0][2] && OX[0][0] != '\u0000')
			return true;
		else if (OX[1][0] == OX [1][1] && OX[1][0] == OX[1][2] && OX[1][0] != '\u0000')
			return true;
		else if (OX[2][0] == OX [2][1] && OX[2][0] == OX[2][2] && OX[2][0] != '\u0000')
			return true;
		else if (OX[0][0] == OX [1][1] && OX[0][0] == OX[2][2] && OX[0][0] != '\u0000')
			return true;
		else if (OX[0][2] == OX [1][1] && OX[0][2] == OX[2][0] && OX[0][2] != '\u0000')
			return true;
		else if (OX[0][0] == OX [1][0] && OX[0][0] == OX[2][0] && OX[0][0] != '\u0000')
			return true;
		else if (OX[0][1] == OX [1][1] && OX[1][1] == OX[2][1] && OX[0][1] != '\u0000')
			return true;
		else if (OX[0][2] == OX [1][2] && OX[1][2] == OX[2][2] && OX[0][2] != '\u0000')
			return true;
		
		return false;
	}

	public static void map(){
		System.out.println();
		System.out.println();
		System.out.println(OX[0][0]+"|"+ OX[0][1]+"|"+OX[0][2]);
		System.out.println("----");
		System.out.println(OX[1][0]+"|"+ OX[1][1]+"|"+OX[1][2]);
		System.out.println("----");
		System.out.println(OX[2][0]+"|"+ OX[2][1]+"|"+OX[2][2]);
		System.out.println();
		System.out.println();
		
	}
	
	public static int FirstQuestion(){
		
		int firstChoice;
		do {
			System.out.println("Whould you like to play with computer or another player?");
			System.out.println("1) Computer  2) Player");
			firstChoice = input.nextInt();
			if (firstChoice != 1 && firstChoice != 2)
				System.out.println("Please reenter the number");
		}while (firstChoice != 1 && firstChoice != 2);
		
		if (firstChoice == 1)
			return 1;
		else 
			return 2;
	}
		

	private static void player1(){
		int column, row;
		boolean pass = true;
		do {
			System.out.println("Please enter the column");
			column = input.nextInt();
			System.out.println("Please enter the row");
			row = input.nextInt();
			if (OX[row-1][column-1] != 'X'&&OX[row-1][column-1] != 'O')
			{
				OX[row-1][column-1]='O';
				pass = true;
			}
			else if (3<row || row <0 ||3<column || column <0 )
			{
				System.out.println("Invalid move. Please chose a new move");
				pass = false;
			}
			else {
				System.out.println("There's already a mark. Please chose a new move");
				pass = false;
			}
		}while (pass == false );
		map();
	}
	
	private static void player2() {
		int column, row;
		boolean pass = true;
		do {
			System.out.println("Please enter the column");
			column = input.nextInt();
			System.out.println("Please enter the row");
			row = input.nextInt();
			if (OX[row-1][column-1] != 'X'&&OX[row-1][column-1] != 'O') {
				OX[row-1][column-1]='X';
				pass = true;
			}
			else if (3<row || row <0 ||3<column || column <0 )
			{
				System.out.println("Invalid move. Please chose a new move");
				pass = false;
			}
			else {
				System.out.println("There's already a mark. Please chose a new move");
				pass = false;
			}
		}while (pass == false );
		map();
	}

	private static void computer() {
		int column, row;
		boolean pass = true;
		do {
			
			row = (int)(Math.random() * 3 + 1);
			column = (int)(Math.random() * 3 + 1);
			if (OX[row-1][column-1] != 'X'&&OX[row-1][column-1] != 'O') {
				OX[row-1][column-1]='X';
				pass = true;
			}
			else if (3<row || row <0 ||3<column || column <0 )
			{
				System.out.println("Invalid move. Please chose a new move");
				pass = false;
			}
			else {
				System.out.println("There's already a mark. Please chose a new move");
				pass = false;
			}
		}while (pass == false );
		map();
	}
	private static boolean tie(){
		boolean hello = true;
		int i;
		int j;
		for (i = 0; i <= 2; i++)
			for (j = 0;j <= 2;j++)
				if (OX[i][j] == '\u0000')
					hello =  false;
		if (hello == true)
			return true;
		
		return false;
	}
	
}