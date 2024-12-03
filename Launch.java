package ticTacToe;

import java.util.Random;
import java.util.Scanner;

class TicTacToe{
	static char[][] board;
	public TicTacToe() {
		board=new char[3][3];
		initializeBoard();
		
	}
	void initializeBoard() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j]=' ';
			}
		}
	}
	static void displayBoard() {
		System.out.println("-------------");
		for(int i=0;i<board.length;i++) {
			System.out.print("| ");
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j]+" | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
	static void placeMark(int row,int col,char mark) {
		if((row>=0 && row<=2) && (col>=0 && col<=2) && (mark=='O'|| mark=='X')) {
			board[row][col]=mark;
		}
		else {
			System.out.println("Invalid value");
		}
	}
	
	static boolean rowWin() {
		for (int i = 0; i < board.length; i++) {
			if(board[i][0]!=' ' && (board[i][0]==board[i][1]) &&(board[i][1]==board[i][2])) {
				return true;
			}
		}
		return false;
	}
	static boolean colWin() {
		for (int j = 0; j < board.length; j++) {
			if(board[0][j]!=' ' && (board[0][j]==board[1][j]) && (board[1][j]==board[2][j])) {
				return true;
			}
		}
		return false;
	}
	static boolean diagonalWin() {
		if((board[0][0]!=' '&&(board[0][0]==board[1][1] && board[1][1]==board[2][2]))||(board[0][2]!=' ' &&(board[0][2]==board[1][1] && board[1][1]==board[2][0]))) {
			return true;
		}
		return false;
	}
	static boolean drawCond() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j]==' ') {
					return false;
				}
			}
		}
		return true;
	}
}
abstract class Player{
	String name;
	char mark;
	abstract void makeMove();
	
	boolean isValidMove(int row,int col) {
		if((row>=0 && row<=2)&& (col>=0 && col<=2) ) {
			if(TicTacToe.board[row][col]==' ') {
				return true;
			}
		}
		return false;
	}
	
}
class HumanPlayer extends Player{
	public HumanPlayer(String name,char mark){
		this.name=name;
		this.mark=mark;
	}
	@Override
	void makeMove() {
		Scanner sc=new Scanner(System.in);
		int row,col;
		do {
			System.out.println("Enter row and col");
			row=sc.nextInt();
			col=sc.nextInt();
		}while(!isValidMove(row,col));
		TicTacToe.placeMark(row, col, mark);
		
	}
}
class AiPlayer extends Player{
	public AiPlayer(String name,char mark){
		this.name=name;
		this.mark=mark;
	}
	@Override
	void makeMove() {
		Scanner sc=new Scanner(System.in);
		int row,col;
		do {
			Random r=new Random();
			row=r.nextInt(3);
			col=r.nextInt(3);
		}while(!isValidMove(row,col));
		TicTacToe.placeMark(row, col, mark);
		
	}
}
public class Launch {
	
	public static void main(String[] args) {
		
		TicTacToe t = new TicTacToe();
		
		HumanPlayer p1=new HumanPlayer("Meghana", 'X');
		AiPlayer p2=new AiPlayer("Ai", 'O');
		
		Player p;
		
		p=p1;
		while(true) {
			System.out.println(p.name+" turn");
			p.makeMove();
			TicTacToe.displayBoard();
			if(TicTacToe.rowWin() || TicTacToe.colWin() || TicTacToe.diagonalWin())
			{
				System.out.println(p.name+" Won");
				break;
			}
			else if(TicTacToe.drawCond()) {
				System.out.println("The game was draw");
				break;
			}
			else {
				if(p==p1) {
					p=p2;
				}
				else {
					p=p1;
				}
			}
		}
	}

}
