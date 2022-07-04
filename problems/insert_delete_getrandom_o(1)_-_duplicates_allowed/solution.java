class RandomizedCollection {
    HashMap<Integer,HashSet<Integer>> map;
    List<Integer> list;
    Random r; 

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        HashSet<Integer> set;
        boolean flag;
        
        //if val present in map then get corresponding set
        if(map.containsKey(val) == true){
            set = map.get(val); 
            flag = false;
        }
        //else create new set
        else{
            set = new HashSet<>();
            flag = true;
        }
        
        set.add(list.size()); //add last+1 index as it will be the index for new val
        list.add(val); //add val to list
        map.put(val,set); //put val and set in map
        
        return flag;
    }
    
    public boolean remove(int val) {
        HashSet<Integer> set;
        
        if(map.containsKey(val) == true){
            set = map.get(val);
            
        }else return false;
        
        int removeIndex = -1;
        for(int i: set){
            removeIndex = i;
            break;
        }
        //Remove index of val from set corresponding to val key in Map.
        set.remove(removeIndex);
        map.put(val,set);
        
        //val corresponding set size becomes zero then remove val from set
        if(map.get(val).size() == 0)
            map.remove(val);
        
        
        //Remove val from list as well
        //If val is present at last of list then remove directly
        if(removeIndex == list.size()-1)
            list.remove(removeIndex);
        
        //else swap val with lastIndex then remove last index.
        else{
            //set(int index(index of the element to replace), E element(element to be stored at the specified position))
            list.set(removeIndex, list.get(list.size()-1)); 
            list.remove(list.size()-1);   
        
        
        int newVal = list.get(removeIndex);
        
        HashSet<Integer> temp = map.get(newVal);
        temp.remove(list.size()); //remove the last+1 index as it was the position which was swapped/set for removed val 
        temp.add(removeIndex); //Add the new index for the value that was present at last index before swapping/Set.
        map.put(newVal,temp); //Update this last index swap in the map
        }
        return true;
    }
    
    public int getRandom() {
        int randomIndex = r.nextInt(list.size());
        return list.get(randomIndex);
        
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */