/*
#########################################################
## File Name: SolvedSudokuValidator.java               ##
## Description: Validating Sudoku			 		   ##
##             										   ##
## Programmed By: FARHAN KHAN						   ##
#########################################################
*/
import java.util.*;

class SudokuValidator {

	//Taking Matrix Of 9*9 And Returning True Or False After Validation
	
	private static boolean validateSudoku(int[][] matrix) {
		
    for (int i = 0; i < 9; i++) {
		
        int[] row = new int[9];
        int[] block = new int[9];
        int[] col = matrix[i].clone(); 

        for (int j = 0; j < 9; j ++) {
			
            row[j] = matrix[j][i];
            block[j] = matrix[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
			
        }
		
        if (!(validate(col) && validate(row) && validate(block)))
            return false;
		}
    return true;
	}

	private static boolean validate(int[] verify) {
		int i = 1;
		Arrays.sort(verify);
		for (int number : verify) { //Checking Each Having Number 1-9 For Row, Column And Block
			if (number != i++)
				return false;
		}
		return true;
	}

	
	public static void main(String[] args)
	{
		boolean valid;
		int row,col;
		row = col = 9;
		
		// Solved Sudoku 
		int sudoku1[][] = {
					 {7, 9, 2, 1, 5, 4, 3, 8, 6}, 
					 {6, 4, 3, 8, 2, 7, 1, 5, 9},
					 {8, 5, 1, 3, 9, 6, 7, 2, 4},
					 {2, 6, 5, 9, 7, 3, 8, 4, 1},
					 {4, 8, 9, 5, 6, 1, 2, 7, 3},
					 {3, 1, 7, 4, 8, 2, 9, 6, 5},
					 {1, 3, 6, 7, 4, 8, 5, 9, 2},
					 {9, 7, 4, 2, 1, 5, 6, 3, 8},
					 {5, 2, 8, 6, 3, 9, 4, 1, 7}
					 };
					 
		//Unsolved Sudoku			 
		int sudoku2[][] = {
					 {7, 9, 2, 1, 5, 4, 3, 8, 6}, 
					 {6, 4, 3, 8, 2, 7, 1, 5, 9},
					 {8, 5, 1, 3, 9, 6, 7, 2, 4},
					 {2, 6, 5, 9, 7, 3, 8, 4, 1},
					 {4, 8, 9, 5, 6, 1, 2, 7, 3},
					 {3, 1, 7, 4, 8, 2, 9, 6, 5},
					 {1, 3, 6, 7, 4, 8, 5, 9, 2},
					 {9, 7, 4, 2, 1, 5, 6, 3, 8},
					 {5, 2, 8, 6, 5, 9, 4, 1, 7}
					 };
		
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				System.out.print(sudoku1[i][j]+"\t");   //Please Replace sudoku1 by sudoku2 to Check Functionality For Incorrect Sudoku
			}
			System.out.println();
		}
		
//Function Call To Check Sudoko Is Solved Or Not
		valid = validateSudoku(sudoku1);  	//Please Replace sudoku1 by sudoku2 to Check Functionality For Incorrect Sudoku
		
		if(valid)
			System.out.println("Above Sudoku Is Solved Correctly");
		else
			System.out.println("Above Sudoku Is Not Solved Correctly");
	}
}
