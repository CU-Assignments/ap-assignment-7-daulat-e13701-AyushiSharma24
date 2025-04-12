import java.util.PriorityQueue;

public class RemoveStonesToMaximizeTotal {
    public int maxKelements(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int pile : piles) pq.add(pile);
        int total = 0;
        while (k-- > 0) {
            int max = pq.poll();
            total += max;
            pq.add((int)Math.ceil(max / 3.0));
        }
        return total;
    }
}
