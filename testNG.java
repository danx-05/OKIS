package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import static org.example.Main.*;
import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.fail;

public class MainTest {





    @Test (groups = {"fast"})
    public void testSquare(){
        final int [][] coords = {{2,1},{2,3},{6,3},{6,1}};
        final int expectedResult = 8;
        int actualResult;

        actualResult = square(coords);

        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test (groups = {"fast"})
    public void testMatrixPow(){
        final int [][] matrix = {{2,1},{2,3}};
        final int pow = 2;
        final int [][] expectedResult = {{6,5},{10,11}};
        final int [][] actualResult;
        actualResult = power(matrix, pow);
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"exceptions", "fast"})
    public void TestMatrixPowException() {
        int[][] nonSquareMatrix = {{1, 2, 3}, {4, 5, 6}}; // Не квадратная матрица
        Main.power(nonSquareMatrix, 2);
    }

    @DataProvider
    public Object[][] MultMatrix(){
        return new Object[][]{
                {new int[][]{{1, 2},{2,1}}, new int[][]{{1, 0},{0,1}}, new int[][]{{1, 2},{2,1}}},
                {new int[][]{{2,1,1},{2,3,4},{2,3,3}},new int[][]{{2,2,3},{3,11,2},{3,3,4}}, new int[][]{{10,18,12},{25,49,28},{22,46,24}}},
                {new int[][] {{1,2,3}}, new int[][]{{1}, {2}, {3}}, new int[][] {{14}}},

        };
    }
    @Test(dataProvider = "MultMatrix")
    public void testMultMatrix(int[][] matrix1, int [][] matrix2, int[][] expected){
        Assert.assertEquals(mult(matrix1, matrix2), expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"exceptions"})
    public void TestMultMatrixException() {
        int[][] matrix1 = {{1, 2, 3}, {4, 5}};
        int[][] matrix2 = {{1, 2, 5}, {4, 5}};
        Main.mult(matrix1, matrix2);
    }

    @Test (groups = {"fast"})
    public void testFibb(){
        final int a = 1;
        final int b = -1;
        final int c = -1;
        final int n = 4;
        final int expectedResult = 3;
        final int actualResult;
        actualResult = solveReccurence(a,b,c,n);
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test (groups = {"fast"})
    public void testReccurence(){
        final int a = 1;
        final int b = -4;
        final int c = 4;
        final int n = 3;
        final int expectedResult = 12;
        final int actualResult;
        actualResult = solveReccurence(a,b,c,n);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test (groups = {"fast"})
    public void testSubArray(){
        final int[] sp = {-1,-2, 2, 3,-4, 20};

        final int expectedResult = 21;
        final int actualResult;
        actualResult = maxSubArray(sp);
        Assert.assertEquals(actualResult, expectedResult);
    }









}
