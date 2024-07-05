# Longest Path in a Directed Acyclic Graph (DAG)

This Java program calculates the longest directed path from a given starting vertex in a Directed Acyclic Graph (DAG). It takes input from the user for the number of vertices, the number of edges, the edges themselves, and the starting vertex. The program then outputs the length of the longest path starting from the given vertex.


## Files Description

- `LongestPathInDAG.java`: Contains the implementation for finding the longest path in a DAG.
- `LongestPathTest.java`: Java program to execute test cases using input (`input.txt`) and expected output (`output.txt`) files.
- `input.txt`: Input file containing graph definitions and starting vertices.
- `output.txt`: Output file containing the expected longest path length.


## Execution Steps

1. **Compile the Program:**
   ```sh
    javac LongestPathInDAG.java
2. **Run the Program:**
   ```sh
    java LongestPathInDAG
3. **Enter the Input:**
  </br>In the input we have to enter number of vertices and number edges followed by edges as coma separated values.

**Sample Input:**

    Enter the number of vertices:
    4
    Enter the number of edges:
    4
    Enter the edges (u,v):
    0,1
    0,2
    1,2
    2,3
    Enter the starting vertex:
    0
**Sample Output:**

    Longest path length from vertex 0: 2
  
</br>  

## Code Overview:

<br/>**Main Classes and Methods:**

**addEdge:** 
</br>Adds a directed edge to the graph, avoiding self-loops.
<br/>**findLongestPath:** 
</br>Finds the longest path in the DAG from the given starting vertex.
<br/>**topologicalSort:** 
</br>Performs topological sorting on the graph.
<br/>**PerformTopologicalSort:** 
</br>Utility function used by topologicalSort.
<br/>**main:** 
</br>The main method which handles input, constructs the graph, and prints the longest path length.


**Exception Handling:**
<br/>The program includes exception handling to manage invalid inputs and other unexpected errors:

**InputMismatchException:**
<br/>Caught when the user enters a non-integer value where an integer is expected.

**NumberFormatException:**
<br/>Caught when the edge input is not in the correct format (u,v).

**General Exception:**
<br/>Caught for any other unexpected errors.

</br>

## Questions


1. `Does the solution work for larger graphs?`: 
<br/>Yes, the solution works for larger graphs as it uses topological sorting which is efficient for DAGs. However, the memory and time complexity should be considered when dealing with very large graphs.

2. `Can you think of any optimizations?`:
<br/>Space Optimization: Use more space-efficient data structures if necessary.
<br/>Algorithmic Optimization: Implement more advanced algorithms if the graph has specific properties that can be exploited.

3. `What’s the computational complexity of your solution?`:
The computational complexity of the solution is:
Topological Sort:
<br/>O(V + E), where V is the number of vertices and E is the number of edges.
<br/>Longest Path Calculation: O(V + E), as it processes each vertex and edge once.
Thus, the overall complexity is O(V + E).
<br/>Space Complexity: 
O(V+E)
4. `Are there any unusual cases that aren't handled?`
<br/>Graph with Self-Loops: The program avoids self-loops, but if they are included in the input, they will be ignored.
<br/>Disconnected Graph: If the graph is disconnected, only the connected component containing the starting vertex will be considered.
<br/>Multiple Edges between Same Vertices: The program handles multiple edges by treating them as a single edge for the purpose of finding the longest path.


# Longest Path in Directed Acyclic Graph (DAG) - Test Suite (LongestPathTest.java)

This is a Java program to compute and validate the longest path in a Directed Acyclic Graph (DAG) using predefined input and output files. The program reads graph definitions and starting vertices from `input.txt`, computes the longest path using a custom algorithm implemented in `LongestPathInDAG.java`, and compares the computed result against expected output stored in `output.txt`.

## Execution Steps

1. **Compile the Program:**
   ```sh
    javac LongestPathTest.java
2. **Run the Program:**
   ```sh
    java LongestPathTest

## Input File Format

The `input.txt` file should have the following format:
</br><number_of_vertices>
</br><number_of_edges>
</br><edge1_start>,<edge1_end>
</br><edge2_start>,<edge2_end>
</br>...

</br><starting_vertex>


## Output File Format
The output.txt file contains a single integer, which is the expected length of the longest path from the starting vertex.
</br><expected_output>

## Adding More Test Cases: 
Currently I have added one test case scenario in input.txt and output.txt
</br>To add more additional test cases, We just have to add more input and output files and add those file names in the `LongestPathTest.java` file.