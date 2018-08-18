package rizzutih.Exercises;

/**
 * Created by h.rizzuti on 14/08/2018.
 */
public class RotateMatrix {

    public int[][] rotate(final int[][] image) {

        int[][] rotatedImage = new int[image[0].length][image.length];
        int count = 0;

        for(int i=image.length-1; i >=0; i--) {
            for (int j=0; j < image[i].length; j++) {

                rotatedImage[j][count] = image[i][j];
            }
            count++;
        }

        return rotatedImage;
    }
}