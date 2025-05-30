/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package arsonhs.src;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author ariel
 */
public class TextFinder extends javax.swing.JFrame {
    private mxGraph graph;
    /**
     * Creates new form MainForm
     */
    public TextFinder() {
        initComponents();
        getContentPane().setBackground((new java.awt.Color(0, 71, 171)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPane = new javax.swing.JTextPane();
        textLabel = new javax.swing.JLabel();
        patternLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        patternPane = new javax.swing.JTextPane();
        importButton = new javax.swing.JButton();
        resultLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultPane = new javax.swing.JTextPane();
        graphPanel = new javax.swing.JPanel();
        placeholderPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 255));
        setResizable(false);

        titleLabel.setFont(new java.awt.Font("Bebas", 1, 36)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Aho Corasick Text Finder");
        titleLabel.setAlignmentX(0.5F);

        jScrollPane1.setFont(new java.awt.Font("Bebas", 0, 12)); // NOI18N

        textPane.setEditable(false);
        textPane.setText("Placeholder Text");
        textPane.setPreferredSize(new java.awt.Dimension(103, 40));
        jScrollPane1.setViewportView(textPane);

        textLabel.setFont(new java.awt.Font("Bebas", 1, 12)); // NOI18N
        textLabel.setForeground(new java.awt.Color(255, 255, 255));
        textLabel.setText("Text :");

        patternLabel.setFont(new java.awt.Font("Bebas", 1, 12)); // NOI18N
        patternLabel.setForeground(new java.awt.Color(255, 255, 255));
        patternLabel.setText("Pattern :");

        jScrollPane2.setFont(new java.awt.Font("Bebas", 0, 12)); // NOI18N

        patternPane.setEditable(false);
        patternPane.setText("Placeholder Text");
        patternPane.setPreferredSize(new java.awt.Dimension(103, 60));
        jScrollPane2.setViewportView(patternPane);

        importButton.setFont(new java.awt.Font("Bebas", 1, 12)); // NOI18N
        importButton.setText("import");
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });

        resultLabel.setFont(new java.awt.Font("Bebas", 1, 12)); // NOI18N
        resultLabel.setForeground(new java.awt.Color(255, 255, 255));
        resultLabel.setText("Result :");

        jScrollPane3.setFont(new java.awt.Font("Bebas", 0, 12)); // NOI18N

        resultPane.setEditable(false);
        resultPane.setPreferredSize(new java.awt.Dimension(13, 72));
        jScrollPane3.setViewportView(resultPane);

        graphPanel.setBackground(new java.awt.Color(0, 71, 171));
        graphPanel.setMinimumSize(new java.awt.Dimension(0, 324));

        placeholderPanel.setBackground(new java.awt.Color(0, 71, 171));

        javax.swing.GroupLayout placeholderPanelLayout = new javax.swing.GroupLayout(placeholderPanel);
        placeholderPanel.setLayout(placeholderPanelLayout);
        placeholderPanelLayout.setHorizontalGroup(
            placeholderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        placeholderPanelLayout.setVerticalGroup(
            placeholderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout graphPanelLayout = new javax.swing.GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(placeholderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        graphPanelLayout.setVerticalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(placeholderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(91, 91, 91))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(textLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(patternLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(importButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(graphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleLabel)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(importButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(patternLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resultLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(graphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("").getAbsoluteFile());
        int response = fileChooser.showOpenDialog(null); 
        if (response != JFileChooser.APPROVE_OPTION) {
            return;
        }
        
        String path = fileChooser.getSelectedFile().getAbsolutePath();
        try {
            // Read JSON File
            Pair<String, ArrayList<String>> resultJson = JsonReader.readJson(path);
            
            // Set text
            String text = resultJson.getKey();
            textPane.setText(text);
            
            // Set patterns
            StringBuilder patternsText = new StringBuilder();
            ArrayList<String> patterns = resultJson.getValue();
            for (String pattern : patterns) {
                patternsText.append(pattern).append("\n");
            }
            patternPane.setText(patternsText.toString());
            
            // create graph
            graph = new mxGraph();
            mxGraphComponent graphComponent = new mxGraphComponent(graph);
            graphComponent.setPreferredSize(new Dimension(520, 320));

            // Begin Updating Graph
            graph.getModel().beginUpdate();
            
            // Get Result
            Pair<Integer, ArrayList<Pair<Integer, Integer>>> []result = AhoCorasick.searchWords(patterns, text, graph);
            
            // Stop Updating Graph
            graph.getModel().endUpdate();
            graphComponent.setEnabled(false);
            
            // Display output
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < patterns.size(); i++) {
                String template = "Pola \"%s\" ditemukan %dx";
                Integer numMatch = result[i].getKey();
                output.append(String.format(template, patterns.get(i), result[i].getKey()));

                ArrayList<Pair<Integer, Integer>> arrayIndex = result[i].getValue();
                if (!arrayIndex.isEmpty()) {
                    output.append(", ditemukan pada indeks");
                    String templateIndex = " [(%d,%d)]";
                    for (int j = 0; j < numMatch; j++) {
                        Pair<Integer, Integer> idx = arrayIndex.get(j);
                        String outputIndex = String.format(templateIndex, idx.getKey(), idx.getValue());
                        output.append(outputIndex);
                    }
                }
                output.append("\n");
            }
            String outputResult = output.toString();
            System.out.println(outputResult);
            resultPane.setText(outputResult);
            
            //redisplay graph
            addGraph(graphComponent);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, ex.getMessage(), 
                                   "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_importButtonActionPerformed

    private void addGraph(Component graphComponent) {
        graphPanel.remove(placeholderPanel);

        placeholderPanel = new javax.swing.JPanel();
        placeholderPanel.setBackground(new java.awt.Color(0, 71, 171));

        javax.swing.GroupLayout placeholderPanelLayout = new javax.swing.GroupLayout(placeholderPanel);
        placeholderPanel.setLayout(placeholderPanelLayout);
        placeholderPanelLayout.setHorizontalGroup(
            placeholderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(graphComponent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        placeholderPanelLayout.setVerticalGroup(
            placeholderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(graphComponent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 324, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout graphPanelLayout = new javax.swing.GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(placeholderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        graphPanelLayout.setVerticalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(placeholderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TextFinder().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel graphPanel;
    private javax.swing.JButton importButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel patternLabel;
    private javax.swing.JTextPane patternPane;
    private javax.swing.JPanel placeholderPanel;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JTextPane resultPane;
    private javax.swing.JLabel textLabel;
    private javax.swing.JTextPane textPane;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
