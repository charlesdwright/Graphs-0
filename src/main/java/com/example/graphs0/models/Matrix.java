
package com.example.graphs0.models;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Matrix {
    private String[] rows;
    private String[] cols;
    private int[][] matrix;

    public Matrix(int rows, int cols) {
        this.matrix= new int [rows][cols];
    }

    public int[][] getMatrix() { return matrix; }
    public void setMatrix(int row, int col, int value) {

        this.matrix[row][col] = value;
        log.info("in setMatrix: " + row+", "+ col + ", "+ value);
    }

    public String[] getRows() { return rows; }
    public void setRows(String[] rows) { this.rows = rows; }

    public String[] getCols() { return cols; }
    public void setCols(String[] cols) { this.cols = cols; }

    private void setMatrix(){
/*
        for (int i = 0; i < this.cols.length; i++) {
            log.info("i: "+i);
            int row = (int)getKeyFromValue(parsedNodes,theEdges[i].split(",")[0].trim());
            int col = (int)getKeyFromValue(parsedNodes,theEdges[i].split(",")[1].trim());

            a[row][col]=1;
        }
*/

    }

}
