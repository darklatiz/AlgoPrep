package mx.com.geekflu.algo.prep.bfs;

import mx.com.geekflu.algo.prep.data.structures.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS<T> {

  public int baseTemplateBFS(Node root, Node target){
    Queue<Node<T>> queue = new LinkedList<>(); // this is to store all the node waiting to be processed
    Set<Node<T>> visited = new HashSet<>(); // store all the nodes that we have visited
    int step = 0; //  Number of steps needed from root to current node

    //initialize
    queue.add(root);
    visited.add(root);

    while(queue.size() > 0){
      step += 1;
      for(int i = 0; i < queue.size(); ++i){
        Node current = queue.peek();
        if(current.getData().equals(target.getData())){
          return step;
        }
        //we should iterate over the neighbors of current node
          //if the neighbor is not visited
            //add neighbor to the queue
            //add neighbor to the visited
          queue.remove();
      }
    }
    return 0;
  }




}
