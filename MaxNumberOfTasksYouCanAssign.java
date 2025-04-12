import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxNumberOfTasksYouCanAssign {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int left = 0, right = tasks.length;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (canAssign(tasks, workers, pills, strength, mid)) left = mid;
            else right = mid - 1;
        }
        return left;
    }

    private boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = workers.length - k; i < workers.length; i++) dq.add(workers[i]);
        int i = k - 1;
        while (i >= 0) {
            if (dq.peekLast() >= tasks[i]) {
                dq.pollLast();
                i--;
            } else if (pills > 0 && dq.peekFirst() + strength >= tasks[i]) {
                dq.pollFirst();
                pills--;
                i--;
            } else return false;
        }
        return true;
    }
}
