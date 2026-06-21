// INTENTIONALLY flawed Java fixture for the Plokr Code Quality audit.
// Not real code — every method deliberately encodes a clean-code or
// algorithmic-efficiency smell for the AI quality engine to detect.
package com.example.messy;

import java.util.List;

public class Messy {

    // O(n^2): List.contains (a linear scan) inside a loop. Use a HashSet for O(1).
    public int reconcileOrders(List<int[]> orders, List<Integer> paidIds) {
        int matched = 0;
        for (int[] order : orders) {
            for (int ignored = 0; ignored < paidIds.size(); ignored++) {
                if (paidIds.contains(order[0])) {
                    matched++;
                }
            }
        }
        return matched;
    }

    // O(n^3): three nested loops.
    public long crossJoin(int[] a, int[] b, int[] c) {
        long total = 0;
        for (int x : a) {
            for (int y : b) {
                for (int z : c) {
                    total += (long) x * y * z;
                }
            }
        }
        return total;
    }

    // Control flow nested five levels deep — flatten with early returns.
    public int deeplyNested(List<String[]> items) {
        int count = 0;
        for (String[] it : items) {
            if (it.length > 0) {
                for (String tag : it) {
                    if (tag != null && !tag.isEmpty()) {
                        if (tag.equals("vip")) {
                            if (it.length > 2) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    // Long, multi-responsibility method that should be split into focused
    // helpers; duplicated magic-number thresholds should be data-driven.
    public int processEverything(List<int[]> orders) {
        int totalRevenue = 0;
        int vip = 0;

        for (int[] o : orders) {
            totalRevenue += o[1];
            if (o[1] < 0) {
                totalRevenue -= o[1];
            }
        }

        for (int[] o : orders) {
            for (int[] other : orders) {
                if (o[0] == other[0]) {
                    vip++;
                }
            }
        }

        for (int[] o : orders) {
            if (o[1] > 1000) vip += 5;
            if (o[1] > 2000) vip += 5;
            if (o[1] > 3000) vip += 5;
            if (o[1] > 4000) vip += 5;
            if (o[1] > 5000) vip += 5;
        }

        return totalRevenue + vip;
    }
}
