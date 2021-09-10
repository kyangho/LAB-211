/**
 **  Java Program to Implement Graph Coloring Algorithm
 **/
 
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
 
/** Class GraphColoring **/
class GraphColoring
{    
    private int V, numOfColors;
    private int[] color; 
    private int[][] graph;
 
    /** Function to assign color **/
    public void graphColor(int[][] g)
    {
        int noc = 1;
        V = g.length;
        color = new int[V];
        graph = g;
        for (; noc <= g.length; noc++){
            numOfColors = noc;
            try
            {
                solve(0);
                if (noc == g.length)
                System.out.println("No solution");
            }
            catch (Exception e)
            {
                System.out.println("\nSolution exists with number of color is: " + noc);
                display();
                break;
            }
        }
    }
    /** function to assign colors recursively **/
    public void solve(int v) throws Exception
    {
        /** base case - solution found **/
        if (v == V)
            throw new Exception("Solution found");
        /** try all colours **/
        for (int c = 1; c <= numOfColors; c++)
        {
            if (isPossible(v, c))
            {
                /** assign and proceed with next vertex **/
                color[v] = c;
                solve(v + 1);
                /** wrong assignement **/
                color[v] = 0;
            }
        }    
    }
    /** function to check if it is valid to allot that color to vertex **/
    public boolean isPossible(int v, int c)
    {
        for (int i = 0; i < V; i++)
            if (graph[v][i] == 1 && c == color[i])
                return false;
        return true;    
    }
    /** display solution **/
    public void display()
    {
        System.out.println("\nColors : ");
        for (int i = 0; i < V; i++)
            System.out.println("Vertex " + (i + 1) + ": " + color[i]);
        System.out.println();
    }    
    
    public static int[][] inputGraphFromFile(String file){
        int[][] graph = null;
        try{
            Scanner sc = new Scanner(new File(file));
            int row = 0;
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                int vertex = line.split(" ").length;
                String numString[] = line.split(" ");
                int numLine[] = new int[vertex];
                for (int i = 0; i < vertex; i++){
                    numLine[i] = Integer.parseInt(numString[i]);
                }
                if (graph == null){
                    graph = new int[vertex][vertex];
                }
                graph[row] = numLine;
                row++;
            }
        }catch(Exception e){
            return null;
        }
        return graph;
    }
                
    public static void displayMatrix(int[][] graph){
        for(int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println("");
        }
    }
    /** Main function **/
    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Graph Coloring Algorithm");
        /** Make an object of GraphColoring class **/
        GraphColoring gc = new GraphColoring();
        /** get graph **/
        int graph[][] = inputGraphFromFile("C:\\Users\\Duc Ky\\Desktop\\graph1.txt");
        displayMatrix(graph);
        
//        int[][] graph ={{0,1,1,1,1,0,1,0,0,0},
//                        {1,0,0,1,1,0,0,0,0,0},
//                        {1,0,0,1,0,0,0,0,0,1},
//                        {1,1,1,0,0,0,0,0,1,0},
//                        {1,1,0,0,0,1,0,0,1,0},
//                        {0,0,0,0,1,0,0,1,1,0},
//                        {1,0,0,0,0,0,0,1,0,1},
//                        {0,0,0,0,0,1,1,0,0,1},
//                        {0,0,0,1,1,1,0,0,0,0},
//                        {0,0,1,0,0,0,1,1,0,0}};
//        int [][]graph =
//                {{0,1,1,1,1,1,1,1,1,1},
//                {1,0,1,1,1,1,1,1,1,1},
//                {1,1,0,1,1,1,1,1,1,1},
//                {1,1,1,0,1,1,1,1,1,1},
//                {1,1,1,1,0,1,1,1,1,1},
//                {1,1,1,1,1,0,1,1,1,1},
//                {1,1,1,1,1,1,0,1,1,1},
//                {1,1,1,1,1,1,1,0,1,1},
//                {1,1,1,1,1,1,1,1,0,1},
//                {1,1,1,1,1,1,1,1,1,0}};
        gc.graphColor(graph);
    }
}