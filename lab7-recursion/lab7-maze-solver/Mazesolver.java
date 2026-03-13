package com.mycompany.mazesolver;

public class Mazesolver {

    private char[][] maze;

    public Mazesolver(char[][] maze) {
        this.maze = maze;
    }

    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    // locate start position
    public boolean solve() {

        int startRow = -1;
        int startCol = -1;

        // find starting position 'S'
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }

        if (startRow != -1) {
            return solve(startRow, startCol);
        }

        return false;
    }

    private boolean solve(int row, int col) {

        // out of bounds check
        if (row < 0 || col < 0 || row >= maze.length || col >= maze[row].length)
            return false;

        // stops if a wall or already visited
        if (maze[row][col] == '#' || maze[row][col] == '.')
            return false;

        // finish found
        if (maze[row][col] == 'F')
            return true;

        // marks current path
        if (maze[row][col] != 'S')
            maze[row][col] = '.';

        // try moving North, East, South, West
        if (solve(row - 1, col)) return true;
        if (solve(row, col + 1)) return true;
        if (solve(row + 1, col)) return true;
        if (solve(row, col - 1)) return true;

        // turn back if dead end
        if (maze[row][col] != 'S')
            maze[row][col] = ' ';

        return false;
    }

    public static void main(String[] args) {

        char[][] mazeToSolve = {
            {'#','#','#','#','#','#','#'},
            {'#','S',' ','#',' ',' ','#'},
            {'#',' ',' ','#',' ','#','#'},
            {'#',' ','#',' ',' ',' ','#'},
            {'#',' ',' ',' ','#','F','#'},
            {'#','#','#','#','#','#','#'}
        };

        Mazesolver solver = new Mazesolver(mazeToSolve);

        System.out.println("Original Maze:");
        solver.printMaze();

        if (solver.solve()) {
            System.out.println("Solution Found:");
        } else {
            System.out.println("No Solution Found:");
        }

        solver.printMaze();

        // second maze with no solution
        char[][] mazeNoSolution = {
            {'#','#','#','#','#'},
            {'#','S','#','F','#'},
            {'#','#','#','#','#'}
        };

        Mazesolver solver2 = new Mazesolver(mazeNoSolution);

        System.out.println("Second Maze:");
        solver2.printMaze();

        if (solver2.solve()) {
            System.out.println("Solution Found:");
        } else {
            System.out.println("No Solution Found:");
        }

        solver2.printMaze();
    }
}