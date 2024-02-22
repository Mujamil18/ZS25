package special.programs;

import java.util.Scanner;

public class BallPosition
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int r,c, ball, pos;
        System.out.println("Enter the size of the grid");
        r=sc.nextInt();
        c= sc.nextInt();
        int[][] grid= new int[r][c];
        ball=1;
        System.out.print("Enter the ball's intital position: ");
        pos= sc.nextInt();
        BallPosition obj= new BallPosition();
        obj.printGrid(r, c, pos, ball, grid);

        int choice;
        do {
            System.out.println("1. Move Ball 7. Print Grid 0. Terminate");
            choice= sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.print("Enter the ball's new position: ");
                    pos= sc.nextInt();
                    obj.moveBall(pos, ball, r, c, grid);
                    System.out.println("Completed!");
                    break;

                case 7:
                    obj.printGrid(r, c, pos, ball, grid);
                    break;

                case 0:
                    System.out.println("Terminated");

            }
        }while(choice != 0);

    }
    void moveBall(int pos, int ball, int r, int c, int[][] grid)
    {
        if(pos < c)
        {
            grid[r-1][pos] = ball;
        }

    }
    void printGrid(int r, int c, int pos, int ball,  int[][] grid)
    {
        BallPosition obj= new BallPosition();
        System.out.println("Ball Position [" + (r-1) + ", " + pos + "]");
        System.out.println("Grid: ");
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                grid[i][j] =0;
                obj.moveBall(pos, ball, r, c, grid);
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}