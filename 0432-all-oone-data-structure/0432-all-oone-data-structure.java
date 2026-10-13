class AllOne {
    Map<String , Integer> map;
    TreeMap<Integer , Set<String>> tMap;

    public AllOne() {
        map = new HashMap<>();
        tMap = new TreeMap<>();
    }
    
    public void inc(String key) {
        int oldF = map.getOrDefault(key , -1);
        if(oldF == -1) _add(key , 1);
        else{
            _remove(key , oldF);
            _add(key , oldF + 1);
        }
    }

    private void _add(String key , int f){
        if(!tMap.containsKey(f)) tMap.put(f , new HashSet<>());
        tMap.get(f).add(key);
        map.put(key , f);
    }

    private void _remove(String key , int f){
        tMap.get(f).remove(key);
        if(tMap.get(f).size() == 0) tMap.remove(f);
    }
    
    public void dec(String key) {
        int oldF = map.get(key);
        _remove(key , oldF);
        if(oldF == 1) map.remove(key);
        else{
            _add(key , oldF - 1);
        }
    }
    
    public String getMaxKey() {
        var last = tMap.lastEntry();
        Set<String> set = null ;
        if(last != null) set = last.getValue();
        if(set != null) for(String s : set) return s;
        return "";
    }
    
    public String getMinKey() {
        var first = tMap.firstEntry();
        Set<String> set = null ;
        if(first != null) set = first.getValue();
        if(set != null) for(String s : set) return s;
        return "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */