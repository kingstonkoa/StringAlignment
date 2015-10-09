package controller;

import view.IStringAlignerView;
import view.StringAlignerView;

    public class StringAlignerController {

            /** Panel */
            private IStringAlignerView stringAlignerView;

            private String firstWord;
            private String secondWord;
            private Object [][] grid;
            private int rowLength;
            private int colLength;

            public StringAlignerController(StringAlignerView stringAlignerView) 
            {
                    this.stringAlignerView = stringAlignerView;
            }

            public void storeUserInputs(String firstWord, String secondWord) 
            {
                    this.firstWord = firstWord;
                    this.secondWord = secondWord;
            }

            public void buildAndInitializeTable()
            {
                this.rowLength = firstWord.length()+2;
                this.colLength = secondWord.length()+2;

                //* build the grid*/
                grid = new Object[rowLength][colLength];
                String reversedFirstWord = new StringBuffer(firstWord).reverse().toString();

                //* initialize the grid*/
                for(int i = 0; i < rowLength; i++)
                {
                        if(i == rowLength -2)
                        grid[i][0] = "#";
                            else if( i == rowLength -1)
                        grid[i][0] = " ";    
                        if(i < firstWord.length())
                            grid[i][0] = reversedFirstWord.charAt(i);

                        if(i != rowLength -1)
                            grid[i][1] = rowLength -(2+i);


                }

                for(int j = 1; j < colLength; j++)
                {
                    if(j == 1)
                    grid[rowLength - 1][j] = "#";   
                    else 
                    grid[rowLength - 1][j] = secondWord.charAt(j-2);

                   if(j > 1)
                   grid[rowLength - 2][j] = j-1;

                }

            }

            public void PrintTableContents()
            {

            for(int i = 0; i < grid.length; i++)
                {
                    for(int j = 0; j < grid[i].length; j++)
                       {
                        System.out.print(grid[i][j]);
                        if(j < grid[i].length - 1) System.out.print(" ");
                        }
                System.out.println();
    }
            }

        public void computeTableContents()
        {
            int x, y, z;
        for(int i = rowLength - 3; i > -1; i--)
        {
            for(int j = 2; j < colLength; j++)
            {
                x = (int) grid[i][j-1] + 1;
                y = (int) grid[i+1][j] + 1;
                z = (int)grid[i+1][j-1];
                if(grid[i][0].equals(grid[rowLength-1][j]))
                z += 0;
                else
                    z += 2;


            grid[i][j] = pickLeast(x,y,z);
            }
        }
        }

        public int pickLeast(int x, int y, int z)
        {
            int smallest = x;
            if (smallest > y) smallest = y;
            if (smallest > z) smallest = z;
            return smallest;
        }

        public Object[][] getGrid()
        {
            return grid;
        }

    }
