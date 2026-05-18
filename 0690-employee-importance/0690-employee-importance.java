/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    record empInfo(int importance , List<Integer> subOrd){}
    //int imp = 0;
    Map<Integer , empInfo> emp;
    public int getImportance(List<Employee> employees, int id) {
        emp = new HashMap<>();
        for(Employee e : employees) emp.put(e.id , new empInfo(e.importance , e.subordinates));
        //for(Employee e : employees) if(e.id == id) 
        
        return dfs(id , id);
    }
    private int dfs(int id , int findId){
        int importance_id = emp.get(id).importance;
        for(int subs : emp.get(id).subOrd) importance_id += dfs( subs , findId);
        // if(id == findId) imp = importance_id;
        return importance_id;
    }
}