package Lab1;

import java.util.*;
import java.io.File;
import java.io.FileOutputStream;

public class randomWalk  
{  
	List<DirectedEdge>[] adj; 
	List<DirectedEdge> path = new ArrayList<>();  
	String vertex = "";

	public String RandomWalk() throws Exception
	{
		int v = new Random().nextInt(Main.aq.size());
		r(v);
		DirectedEdge e = path.get(path.size()-1);
		vertex += e.getTarget();
		//System.out.println(vertex);
		File f = new File("C:\\Users\\zipeng\\mygit\\Lab1\\src\\textnew.txt");
    	FileOutputStream fos=new FileOutputStream(f);
    	fos.write(vertex.getBytes());
    	fos.close();
    	System.out.println("文本写入成功");
		return vertex;
	}

	public void r(int v) 
	{  
		List<DirectedEdge> edges= new ArrayList<>(); 
		edges = EdgeWeightDiGraph.adj[v];
		if(!edges.isEmpty())
		{
			int n = new Random().nextInt(edges.size());
			DirectedEdge e = edges.get(n);
			vertex = vertex + Main.aq.get(v) + " ";
			int t = Main.aq.indexOf(e.getTarget());
			
			if(!path.contains(e))
			{
				path.add(e);
				r(t);
			}
			else
			{
				path.add(e);
			}
		}
    }  
}
