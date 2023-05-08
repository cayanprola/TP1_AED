public class Cosine extends Distancias {
    public static double cosineSimilarity(double[] vector1, double[] vector2) {
        if (vector1.length != vector2.length) {
            throw new IllegalArgumentException("Vectors must have the same length");
        }

        double dotProduct = 0;
        double norm1 = 0;
        double norm2 = 0;

        for (int i = 0; i < vector1.length; i++) {
            dotProduct += vector1[i] * vector2[i];
            norm1 += Math.pow(vector1[i], 2);
            norm2 += Math.pow(vector2[i], 2);
        }

        double denominator = Math.sqrt(norm1) * Math.sqrt(norm2);

        if (denominator == 0) {
            return 0;
        } else {
            return dotProduct / denominator;
        }
    }

    /*This method takes two arrays of double values as input and returns a double value between 0 and 1, which represents their cosine similarity.
     The method first checks if the two arrays have the same length, as the cosine similarity can only be calculated between vectors of equal length. If the lengths are different, an IllegalArgumentException is thrown.

The method then iterates over the elements in the two arrays and computes the dot product of the two vectors, as well as their individual norms.
 The dot product is the sum of the products of the corresponding elements in the two arrays, and the norm of a vector is the square root of the sum of the squares of its elements.

Finally, the method computes the denominator of the cosine similarity formula, which is the product of the norms of the two vectors.
 If the denominator is zero, the method returns 0, as the cosine similarity between two zero vectors is undefined.
 Otherwise, the method returns the dot product divided by the denominator, which gives a value between 0 and 1,
  where 1 represents two identical vectors and 0 represents two completely different vectors.*/
}
