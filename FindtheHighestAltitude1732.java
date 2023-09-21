public class FindtheHighestAltitude1732 {
    public int largestAltitude(int[] gain) {
        int maxAl = 0, altitude = 0;
        //using for each has better memory use in leetcode submission than for i
        for (int g : gain) {
            altitude += g;
            //using this has better memory use than Math.max
            maxAl = altitude > maxAl? altitude: maxAl;
        }
/*        for (int i = 0; i < gain.length; i++) {
            altitude += gain[i];
            maxAl = Math.max(altitude, maxAl);
        }*/
        return maxAl;
    }
}
