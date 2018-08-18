package rizzutih.Exercises;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by h.rizzuti on 14/08/2018.
 */
public class RotateMatrixTest {

    private RotateMatrix rotateMatrix;

    @Before
    public void setUp() {
        rotateMatrix = new RotateMatrix();
    }

    @Test
    public void shouldRotateOneRow() {
        //Given
        final int[][] image = new int[][]{
                {1,2,3},

        };

        final int[][] expectedImage = new int[][]{
                {1},
                {2},
                {3}
        };
        //When
        assertArrayEquals(expectedImage, rotateMatrix.rotate(image));
        //Then
    }

    @Test
    public void shouldRotateTwo() {
        //Given
        final int[][] image = new int[][]{
                {1,2,3},
                {4,5,6},

        };

        final int[][] expectedImage = new int[][]{
                {4,1},
                {5,2},
                {6,3}
        };
        //When
        assertArrayEquals(expectedImage, rotateMatrix.rotate(image));
        //Then
    }

    @Test
    public void shouldRotateMany() {
        //Given
        final int[][] image = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9},

        };

        final int[][] expectedImage = new int[][]{
                {7,4,1},
                {8,5,2},
                {9,6,3}
        };

        //When
        assertArrayEquals(expectedImage, rotateMatrix.rotate(image));
        //Then
    }

}