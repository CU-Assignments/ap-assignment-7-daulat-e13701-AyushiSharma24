import java.util.Arrays;

public class MaxUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int units = 0;
        for (int[] box : boxTypes) {
            int count = Math.min(truckSize, box[0]);
            units += count * box[1];
            truckSize -= count;
            if (truckSize == 0) break;
        }
        return units;
    }
}