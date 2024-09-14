import java.util.*;
import java.lang.*;
import java.io.*;

class Reachable
{
    private static Map<Integer,List<Integer>> map=new HashMap<>();
    
    public static boolean Reachability(int index,int v,List<Integer> vis){
        if(index==v) return true;
        
        vis.add(index);
        for(int next:map.get(index)){
            if(!vis.contains(next)){
                if(Reachability(next,v,vis)) return true;
            }
        }
        
        return false;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		
		for(int i=0;i<n;i++){
		    map.put(in.nextInt(),new ArrayList<>());
		}
		
		int edges=in.nextInt();
		for(int i=0;i<edges;i++){
		    int u=in.nextInt();
		    int v=in.nextInt();
		    map.get(u).add(v);
		    map.get(v).add(u);
		}
		
		int u=in.nextInt();
		int v=in.nextInt();
		System.out.println(Reachability(u,v,new ArrayList<>()));
	}
}
