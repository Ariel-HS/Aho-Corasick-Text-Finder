/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arsonhs.src;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.view.mxGraph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ariel
 */
public class AhoCorasick {
    // Max number of states, equal to the sum of the length of patterns. 
    static Integer MAXS = 0; 

    // Maximum number of characters ASCII
    static Integer MAXC = 256; 

    // output function out[i][j]
    // stores all patterns that ends in state/node [i]
    // patterns are stored as pattern at index [j]
    static Integer [][]out; 

    // failure function f[i]
    // stores all stores all edges that are
    // followed when current character doesn't
    // have edge
    static Integer []f; 

    // goto function/TrieTree g[i][j]
    // where [i] = state/node
    // [j] = states/nodes where state [i] can go to
    // g[i][j] = edge
    static Integer [][]g; 
    
    // stores the corresponding vertex Object (for mxGraph)
    // for state [i] in g
    static Object []gObj; 
    
    // stores the corresponding string
    // for state [i] in g
    static String []gString; 
    
    // stores the char
    // for edge between g[i] and g[j]
    static Character [][]gChar; 
    
    // stores the amount of nodes
    // at depth i
    static Integer []depthNumNode; 

    // Builds the String matching machine. 
    // patterns - array of patterns that is being matched
    // Returns the number of states that the machine has
    // States are numbered 0 up to the return value - 1
    private static void buildMachine(ArrayList<String> patterns, mxGraph graph) 
    { 
        // initialize variables
        Integer k = patterns.size();
        MAXS = 0;
        for (String pattern : patterns) {
            MAXS += pattern.length();
        }
        out = new Integer[MAXS][k]; 
        f = new Integer[MAXS]; 
        g = new Integer[MAXS][MAXC];
        gObj = new Object[MAXS];
        gString = new String[MAXS];
        gChar = new Character[MAXS][MAXC];
        depthNumNode = new Integer[MAXS];
        
        // Initialize all values in arrays
        for(int i = 0; i < MAXS; i++)
            Arrays.fill(out[i], -1); 
        
        for(int i = 0; i < MAXS; i++) 
            Arrays.fill(g[i], -1); 

        Arrays.fill(depthNumNode, 0);
        
        // Initialize the number of states
        int numStates = 1;
        
        // Build the Trie Tree
        for(int i = 0; i < k; ++i) 
        { 
            String word = patterns.get(i); 
            
            // start from the root node
            int currentStateIdx = 0;
            gString[0] = "";

            // Insert all characters of current word
            for(int j = 0; j < word.length(); ++j) 
            {
                int ch = word.charAt(j); 

                // Allocate a new node (create a new edge) if a node for ch doesn't exist. 
                if (g[currentStateIdx][ch] == -1) {
                    g[currentStateIdx][ch] = numStates++; 
                    
                    Integer stateIdx = g[currentStateIdx][ch];
                    
                    // Set string and char for new node for later
                    char chChar = (char) ch;
                    gChar[currentStateIdx][ch] = chChar;
                    String newString = gString[currentStateIdx] + chChar;   
                    gString[stateIdx] = newString;
                }

                currentStateIdx = g[currentStateIdx][ch]; 
            } 

            // Add current word (patterns[i]) in output function 
            out[currentStateIdx][i] = 1; 
        } 
        
        // create first node for display
        Object parent = graph.getDefaultParent();
        Object vertex = graph.insertVertex(parent, null, "", 0, 0, 100, 50);
        gObj[0] = vertex;
        
        // drawGraph and set layout before connecting failure nodes for formatting purposes
        drawGraph(graph, 0, 1);
        mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
        layout.setParallelEdgeSpacing(10);
        layout.execute(graph.getDefaultParent());

        // For all characters which don't have an edge from root in Trie, 
        // add a goto edge to state 0 itself 
        for(int ch = 0; ch < MAXC; ++ch) 
            if (g[0][ch] == -1) 
                g[0][ch] = 0; 

        // Build the failure function 
        // Initialize values in fail function 
        Arrays.fill(f, -1); 

        // Computed in breadth first order using queue 
        Queue<Integer> q = new LinkedList<>(); 

        // Iterate over every possible input 
        for(int ch = 0; ch < MAXC; ++ch) 
        {
            if (g[0][ch] != 0)  
            { 
                f[g[0][ch]] = 0; 
                q.add(g[0][ch]); 
                
                // connect node to failure node for display
                Object source = gObj[g[0][ch]];
                Object target = gObj[0];
                graph.insertEdge(parent, null, null, source, target);
            } 
        } 

        while (!q.isEmpty()) 
        { 
            // Remove the front state from queue 
            int state = q.peek(); 
            q.remove(); 

            // For the removed state, find failure  
            // function for all those characters 
            // for which goto function is 
            // not defined. 
            for(int ch = 0; ch < MAXC; ++ch) 
            { 
                // If goto function is defined for character 'ch' and state 'state' 
                if (g[state][ch] != -1) 
                { 
                    // Find failure state of removed state 
                    int failure = f[state]; 

                    // Find the deepest node labeled by proper 
                    // suffix of String from root to current 
                    // state. 
                    while (g[failure][ch] == -1) {
                        failure = f[failure];
                    } 

                    failure = g[failure][ch]; 
                    f[g[state][ch]] = failure; 
                    
                    // connect node to failure node for display
                    Object source = gObj[g[state][ch]];
                    Object target = gObj[failure];
                    graph.insertEdge(parent, null, null, source, target);

                    // Add output of failure node to output of state
                    for (int i=0; i < k; i++) {
                        if (out[failure][i] == 1) {
                            out[g[state][ch]][i] = 1;
                        }
                    }

                    // Insert the next level node (of Trie) in Queue 
                    q.add(g[state][ch]); 
                } 
            } 
        }

//        layout.run(parent); // repaint the graph, avoid overlaps but unclear depth between nodes
//        return numStates; 
    }
    
    private static Integer findNextState(Integer currentState, Character input) {
        Integer nextState = currentState;
        Integer ch = (int) input;
        
        // use failure function if goto is not defined
        while (g[nextState][ch] == -1) {
            nextState = f[nextState];
        }
        
        return g[nextState][ch];
    }
    
    // check if state doesn't have an output
    private static Boolean noMatch(Integer state) {
        for (Integer item : out[state]) {
            if (item == 1) {
                return false;
            }
        }
        
        return true;
    }
    
    // returns Pair Array of num-match, index-matches
    static Pair<Integer, ArrayList<Pair<Integer, Integer>>>[] searchWords(ArrayList<String> patterns, String text, mxGraph graph) {
        Integer k = patterns.size();
        
        // build machine
        buildMachine(patterns, graph);
        
        // initialize root
        Integer currentState = 0;
        
        // initialize result
        Pair<Integer, ArrayList<Pair<Integer, Integer>>> []result = new Pair[k];
        for(int i = 0; i < k; i++) {
            result[i] = new Pair(0, new ArrayList<>());
        }
        
        // traverse the text
        for(int i = 0; i < text.length(); i++) 
        { 
            currentState = findNextState(currentState, text.charAt(i)); 

            // If match not found, move to next state 
            if (noMatch(currentState)) 
                continue; 

            // Match found, append to result
            for(int j = 0; j < k; ++j) 
            { 
                if (out[currentState][j] == 1) 
                { 
                    // increment num of matches
                    result[j].setKey(result[j].getKey()+1);
                    
                    // append match index
                    Pair<Integer, Integer> range = new Pair(i - patterns.get(j).length() + 1, i);
                    ArrayList<Pair<Integer, Integer>> list = result[j].getValue();
                    list.add(range);
                    result[j].setValue(list);
                } 
            } 
        } 
        
        return result;
    }
    
    static void drawGraph(mxGraph graph, Integer stateIdx, Integer depth) {
        Object parent = graph.getDefaultParent();
        for(int i = 0; i < MAXC; i++) {
            //traverse through all child node
            if (g[stateIdx][i] > 0) {
                Integer childIdx = g[stateIdx][i];
                
                // Get string for new node and char for edge
                char chChar = gChar[stateIdx][i];
                String newString = gString[childIdx];
                
                // Create new node for child
                Object source = gObj[stateIdx];
                Integer x = 200*depth;
                Integer y = 75*(depthNumNode[depth]++); //increment num of notes at depth after assignment
//                Object newVertex = graph.insertVertex(parent, null, newString, 0, 0, 100, 50);
                Object newVertex = graph.insertVertex(parent, null, newString, x, y, 100, 50);
                graph.insertEdge(parent, null, chChar, source, newVertex);
                
                // Save object of current node
                gObj[childIdx] = newVertex;
                
                // Draw child of child
                drawGraph(graph, childIdx, depth+1);
            }
        }
    }
}
