import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinOperationsToMakeSubsequence {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) map.put(target[i], i);
        List<Integer> lis = new ArrayList<>();
        for (int val : arr) {
            if (!map.containsKey(val)) continue;
            int idx = map.get(val);
            int pos = Collections.binarySearch(lis, idx);
            if (pos < 0) pos = -pos - 1;
            if (pos == lis.size()) lis.add(idx);
            else lis.set(pos, idx);
        }
        return target.length - lis.size();
    }
}
