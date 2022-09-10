class MedianFinder {
    
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
        
    public MedianFinder() {
        //contains left half, i.e smaller elements
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        //contains right half, i.e larger elements
        minHeap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        
        if(maxHeap.isEmpty() || maxHeap.peek() >= num){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        
        // maintain size
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        }
        else if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){ // even no. of elements
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        else{
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */