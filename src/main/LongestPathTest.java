import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class LongestPathTest {

    private static class TestCase {
        List<List<Integer>> graph;
        int start;
        int expectedOutput;
    }
    public static void main(String[] args) throws IOException { 
        String[] inputFiles = {"input.txt"};
        String[] outputFiles = {"output.txt"};

        List<TestCase> testCases = readTestCases(inputFiles, outputFiles);

        for (TestCase testCase : testCases) {
            int V = testCase.graph.size();
            int actualOutput = LongestPathInDAG.findLongestPath(testCase.graph, V, testCase.start);
            //assertEquals(testCase.expectedOutput, actualOutput);
            System.out.println("Actual Ouput is: "+ actualOutput +"\nexpected output is: "+ testCase.expectedOutput);
            if(actualOutput != testCase.expectedOutput) {
                throw new RuntimeException("Actual output doesn't match with the expected output");
            }
        }
    }

    private static List<TestCase> readTestCases(String[] inputFiles, String[] outputFiles) throws IOException {
        List<TestCase> testCases = new ArrayList<>();
        
        for (int i = 0; i < inputFiles.length; i++) {
            BufferedReader reader = new BufferedReader(new FileReader(inputFiles[i]));
            TestCase testCase = new TestCase();

            int V = Integer.parseInt(reader.readLine().trim());
            testCase.graph = new ArrayList<>(V);
            for (int j = 0; j < V; j++) {
                testCase.graph.add(new ArrayList<>());
            }

            int E = Integer.parseInt(reader.readLine().trim());
            for (int j = 0; j < E; j++) {
                String[] parts = reader.readLine().trim().split(",");
                int u = Integer.parseInt(parts[0].trim());
                int v = Integer.parseInt(parts[1].trim());
                LongestPathInDAG.addEdge(testCase.graph, u, v);
            }

            testCase.start = Integer.parseInt(reader.readLine().trim());
            reader.close();

            BufferedReader outputReader = new BufferedReader(new FileReader(outputFiles[i]));
            testCase.expectedOutput = Integer.parseInt(outputReader.readLine().trim());
            outputReader.close();

            testCases.add(testCase);
        }
        
        return testCases;
    }
}
