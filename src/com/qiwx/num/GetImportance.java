package com.qiwx.num;

import com.qiwx.model.Employee;

import java.util.*;

//690. 员工的重要性
public class GetImportance {
    public static void main(String[] args) {

    }
    public int getImportance(List<Employee> employees, int id) {
        Stack<Employee> stack=new Stack<>();
        Map<Integer,Employee> map=new HashMap<>();
        int count=0;
        for(Employee employee:employees){
            map.put(employee.id,employee);
        }
        stack.push(map.get(id));
        Employee e=null;
        while(!stack.empty()){
            e=stack.pop();
            count+=e.importance;
            for(int i:e.subordinates){//依次取出下属实体信息
                stack.push(map.get(i));
            }
        }
        return count;
    }

}
