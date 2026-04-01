package org.knp.dsa.heaps;

import java.util.PriorityQueue;

class KthLargest {

    // here K is constant
    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        // this is the constructor
        this.k = k;
        minHeap = new PriorityQueue<>(k);

        for (Integer num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.offer(num);
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        if(minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.offer(val);
            minHeap.poll();
        }

        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
