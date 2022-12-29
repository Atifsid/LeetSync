class Solution {
    public int[] getOrder(int[][] tasks) {
        int size  = tasks.length;
        // indexedTasks stores tasks with there index, enqueueTime & processingTime
        Task[] indexedTasks = new Task[size];
        for(int i = 0; i< size; i++){
            indexedTasks[i] = new Task(i, tasks[i][0], tasks[i][1]);
        }
        
        // sort indexedTasks on the basis of enqueueTime
        Arrays.sort(indexedTasks, (a,b) -> {
                return Integer.compare(a.enqueueTime, b.enqueueTime);
            });

        // Priority queue which pops(completes) the tasks on the basis of shortest processing time
        // in case of same processing time, task with smallest index will be popped
        PriorityQueue<Task> pq = new PriorityQueue<>((a,b) -> {
            if (a.processingTime == b.processingTime){
                return Integer.compare(a.index, b.index);
            }
            return Integer.compare(a.processingTime, b.processingTime);
            
        });

        int res[] = new int[size];
        int resIndex = 0;
        int taskIndex = 0;
        int currTime = 0;

        while(resIndex < size){
            while(taskIndex < size && indexedTasks[taskIndex].enqueueTime <= currTime){
                pq.offer(indexedTasks[taskIndex++]);
            }

            if(pq.isEmpty()){
                currTime = indexedTasks[taskIndex].enqueueTime;
            }
            else{
                currTime += pq.peek().processingTime;
                res[resIndex++] = pq.poll().index;
            }
        }
        return res;
    }

    class Task{
        int index;
        int enqueueTime;
        int processingTime;

        Task(int indx, int enqT, int proT){
            this.index = indx;
            this.enqueueTime = enqT;
            this.processingTime = proT;
        }
    }
}