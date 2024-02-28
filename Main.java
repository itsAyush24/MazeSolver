class MazeData {
    boolean left;
    boolean top;
    boolean right;
    boolean bottom;

    boolean isDeadEnd;
}
public class Main{
    public static void main(String[] args) {
        String[][] mazeStr = {    // Simple one way
                {"0010", "1001", "0001"},
                {"0011", "1110", "1100"},
                {"0110", "1010", "1000"}};
        String[][] mazeStr12 = { // 5x5 with island
                {"0010", "1010", "1010", "1010", "1001"},
                {"0011", "1011", "1011", "1011", "1101"},
                {"0101", "0110", "1100", "0101", "0101"},
                {"0111", "1010", "1010", "1100", "0101"},
                {"0100", "0010", "1010", "1010", "1100"}};
        String[][] mazeStr9= { //8x8 maze with T-junction
                {"0010", "1010", "1001", "0011", "1010", "1000", "0011", "1001"},
                {"0011", "1001", "0101", "0101", "0010", "1010", "1100", "0101"},
                {"0101", "0100", "0101", "0111", "1010", "1001", "0010", "1101"},
                {"0111", "1010", "1101", "0101", "0001", "0110", "1010", "1101"},
                {"0101", "0010", "1100", "0101", "0110", "1011", "1010", "1100"},
                {"0111", "1011", "1010", "1101", "0011", "1110", "1010", "1001"},
                {"0101", "0100", "0001", "0101", "0101", "0010", "1001", "0101"},
                {"0110", "1010", "1100", "0100", "0110", "1010", "1100", "0100"}
        };

        Util obj = new Util();
        //Solver sol = new Solver();
        SolveRecursive sol = new SolveRecursive();
        VisualMaze visual = new VisualMaze();

        MazeData[][] maze = obj.convert(mazeStr);
        int[] start = {0,0};
        int[] end = {mazeStr.length-1,mazeStr[0].length-1};
        sol.solve(maze,start, end);
        //visual.visualize(maze);
        
        //obj.display(maze);

        //testAllCases();

        PathVisualizer.driver(maze, sol.path);
    }

    public static void testAllCases(){
        String[][][] mazeAll = {
                {    // Simple one way
                        {"0001", "0011", "1001"},
                        {"0101", "0101", "0101"},
                        {"0110", "1100", "0100"}},
                { //simple one way
                        {"0010", "1010", "1001"},
                        {"0011", "1010", "1100"},
                        {"0110", "1010", "1000"}},
                { // 3x3 with a two-way
                        {"0010", "1001", "0001"},
                        {"0011", "1110", "1100"},
                        {"0110", "1010", "1000"}},
                { // 4x4 maze
                        {"0001", "0000", "0011", "1001"},
                        {"0110", "1001", "0101", "0101"},
                        {"0000", "0101", "0101", "0101"},
                        {"0000", "0110", "1100", "0100"}},
                { // 4x4 maze with a two-way
                        {"0010", "1001", "0000", "0001"},
                        {"0000", "0111", "1010", "1100"},
                        {"0000", "0110", "1010", "1001"},
                        {"0000", "0000", "0000", "0100"}},
                { //
                        {"0010", "1001", "0010", "1001"},
                        {"0000", "0111", "1010", "1100"},
                        {"0000", "0110", "1010", "1001"},
                        {"0000", "0010", "1000", "0100"}},

                { //
                        {"0010", "1001", "0010", "1001"},
                        {"0010", "1111", "1010", "1100"},
                        {"0001", "0111", "1010", "1001"},
                        {"0100", "0110", "1000", "0100"}},
                { // 4x4 maze with T junction
                        {"0001", "0000", "0011", "1001"},
                        {"0101", "0000", "0101", "0101"},
                        {"0111", "1010", "1101", "0101"},
                        {"0110", "1000", "0100", "0100"}},

                { //8x8 maze
                        {"0010", "1010", "1001", "0011", "1010", "1000", "0011", "1001"},
                        {"0011", "1001", "0101", "0101", "0010", "1010", "1100", "0101"},
                        {"0101", "0100", "0101", "0111", "1010", "1001", "0010", "1101"},
                        {"0111", "1010", "1101", "0101", "0001", "0110", "1010", "1101"},
                        {"0101", "0010", "1100", "0101", "0110", "1011", "1010", "1100"},
                        {"0111", "1011", "1010", "1100", "0011", "1110", "1010", "1001"},
                        {"0101", "0100", "0001", "0001", "0101", "0010", "1001", "0101"},
                        {"0110", "1010", "1100", "0100", "0110", "1010", "1100", "0100"}
                },
                { // 5x5 with island
                        {"0010", "1010", "1010", "1010", "1001"},
                        {"0011", "1011", "1011", "1011", "1101"},
                        {"0101", "0110", "1100", "0101", "0101"},
                        {"0111", "1010", "1010", "1100", "0101"},
                        {"0100", "0010", "1010", "1010", "1100"}}
        };

        for(int i = 0; i<mazeAll.length; i++){

            String[][] mazeStr = mazeAll[i];

            Util obj = new Util();
            //Solver sol = new Solver();
            SolveRecursive sol = new SolveRecursive();
            Visualizer draw = new Visualizer();

            MazeData[][] maze = obj.convert(mazeStr);
            int[] start = {0,0};
            int[] end = {mazeStr.length-1,mazeStr[0].length-1};
            //draw.createArray(maze);
            sol.solve(maze,start, end);
            PathVisualizer.driver(maze, sol.path);
        }
    }
}
