package Homework1;
import java.util.*;
import com.interview.coding.course.Homework_Serializable.*;

public class Collection {

    //Using (Set) Find true friends: Given two arraylists containing friend names, find the true friends that appear in both list.
    
    public Set<String> trueFriends(List<String> friends1, List<String> friends2){
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();

        if(friends1 == null || friends2 == null){
            return null;
        }

        for(String f1: friends1){
            set.add(f1);
        }
        for(String f2: friends2){
            if(set.contains(f2)){
                res.add(f2);
            }
        }
        return res;
    }

    //Using (Map)Given a string, output duplicate characters and their counts
    
    public void duplicateCounts(String str){

        Map<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }

    }


    //create a new map to duplicate
    Map<Integer, String> employees = new HashMap<>();

    public void addEmployee(Employee employee){
        employees.put(employee.getId(), employee.getName());
    }
    public void deleteEmployee(Employee employee){
        for(Integer id: employees.keySet()){
            if(id == employee.getId()){
                employees.remove(id);
            }
        }

    }

    public void changeEmployee(Employee employee){
        if(employees.containsKey(employee.getId())){
            employees.put(employee.getId(), employee.getName());
        }
    }

    public Employee findEmployee(int employeeId){
        if(employees.containsKey(employeeId)){
            Employee e =  new Employee();
            e.setId(employeeId);
            e.setName(employees.get(employeeId));
            return e;
        }
        return null;
    }
}
