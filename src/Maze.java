import helpers.Point;

import java.util.Random;

public class Maze {
    private final char[][] maze;

    private static final double percentage = 0.3;
    private static final int rows = 60;

    private static final int cols = 80;

    protected Point initial;
    protected Point goal;

    public Maze() {
        this.maze = new char[Maze.rows][Maze.cols];
        this.createMaze();
    }

    private void createMaze() {
        for (int i = 0; i < Maze.rows; i++) {
            for (int j = 0; j < Maze.cols; j++) {
                double rand = Math.random();
                if (rand <= Maze.percentage) {
                    this.maze[i][j] = '*';
                } else {
                    this.maze[i][j] = ' ';
                }
            }
        }

        Random r = new Random();

        this.initial = new Point(r.nextInt(Maze.rows), r.nextInt(Maze.cols));
        this.goal = new Point(r.nextInt(Maze.rows), r.nextInt(Maze.cols));

        if (this.maze[this.initial.getX()][this.initial.getY()] == '*') {
            throw new RuntimeException("Initial collides with obstacle");
        }

        this.maze[this.initial.getX()][this.initial.getY()] = 'I';

        if (this.maze[this.goal.getX()][this.goal.getY()] == '*') {
            throw new RuntimeException("Goal collides with obstacle");
        }

        this.maze[this.goal.getX()][this.goal.getY()] = 'G';
    }

    @Override
    public String toString() {
        int numRows = this.maze.length;
        int numCols = this.maze[0].length;
        String out = "";

        for (int i = 0; i < numCols + 2; i++) {
            out += "#";
        }

        out += "\n";

        for (int i = 0; i < numRows; i++) {
            out += "#";
            for (int j = 0; j < numCols; j++) {
                out += this.maze[i][j];
            }
            out += "#\n";
        }

        for (int i = 0; i < numCols + 2; i++) {
            out += "#";
        }

        return out;
    }
}
