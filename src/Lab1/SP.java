package Lab1;

import java.util.ArrayList;

public class SP {
    public static String calcShortestPath(String word1, String word2)
    {
        String s = "";
        if(Main.aq.contains(word1) && Main.aq.contains(word2))
        {
            DijkstraSP p = new DijkstraSP(Main.g,word1);
            String ad = "";
            double sum = 0;
            ArrayList<String> ad2 = new ArrayList<String>();
            for(DirectedEdge e : p.pathTo(word2))
            {
                ad=ad + e.getSource()+"->";
                ad2.add(e.getTarget());
                sum+=e.weight();
            }
            ad += ad2.get(ad2.size()-1);
            s = ad+"\t"+sum;
        }
        else if(!Main.aq.contains(word1) && Main.aq.contains(word2))
        {
            s = "No ¡°" + word1 + "¡± in the graph!";
        }
        else if(Main.aq.contains(word1))
        {
            s = "No ¡°" + word2 + "¡± in the graph!";
        }
        else
        {
            s = "No ¡°" + word1 + "¡± and ¡°" + word2 + "¡± in the graph!";
        }
        
        return s;
    } 
}
