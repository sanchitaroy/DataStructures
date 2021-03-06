package adjacencyListImplementation;

/**
 * @author SRoy
 * Generates Adjacency List and Runs the simple scheme for prims algorithm
 */
public class GraphReprAndRunPrim {

	static int[][] inputArr;
	static int nodes;	
	static int edge;
	static int [] vertList;

	static Graph graph;

	/*//For testing purpose
	 public static void main(String[] args) {
		 System.out.println("start");
		getGraphAndPrim("/home/sanchita/output.txt");

	}*/	
	
	/**
	 * @param fileNameAndPath
	 */
	public static void getGraphAndPrim(String fileNameAndPath){
		int num1 = 0, num2 = 0, len = 0;
		inputArr = InputAsArray.inputAr(fileNameAndPath);
		//inputArr = {{10, 9, 0}, {0, 1, 978}, {0, 4, 294}, {1, 3, 844}, {1, 5, 886}, {2, 9, 306}, {3, 6, 123}, {5, 7, 109}, {6, 0, 894}, {6, 2, 27}};
		nodes = inputArr[0][0];
		graph = new Graph(nodes);
		edge = inputArr[0][1];
		for(int row = 1; row<=edge; row++){
			num1 = inputArr[row][0];
			num2 = inputArr[row][1];
			len = inputArr[row][2];			

			if(len!=0){
				//generating UNDIRECTED adjacency list for the graph
				graph.insertEdge(num1, num2, len);
				graph.insertEdge(num2, num1, len);
			}				
			num1 = 0;
			num2 = 0; 
			len = 0;
		}

		System.out.println("-------- The given graph in adjacency matrix --------");
		graph.printGraph();
		prim();
		/*System.out.println("-------- After Prim --------");
		graph.printGraph();*/
		//graph.printGraph();	
	}

	/**
	 * Run Prim's Algorithm in adjacency list representation of graph
	 * to generate minimum spanning tree
	 */
	public static void prim(){
		int len;
		int overalLen = 0;
		int nxtNode = 0;
		int k = -1;
		int m=1;
		int p= nodes-1; 
		int c = -2;
		int counter = 0;
		int outCounter = 1;
		
		vertList = new int [nodes];		
		// Array of nodes visited
		int[] visArr = new int [nodes+1];
		int[] nxtN = new int[2];
		int[][] outputArr = new int[nodes+1][2];
		int min = Integer.MAX_VALUE;

		// vertList filled in dynamically to hold the node visited per run
		for (int d=0;d<nodes;d++)
			vertList[d]=-1;

		vertList[counter]=0;
		visArr[0] = 1;
		while(vertList[p]== -1 ){
			for(counter = 0; counter<m; ){
				nxtN = getMinFromNode(vertList[counter]);
				len = nxtN[1];
				nxtNode = nxtN[0];
				if(len < min && visArr[nxtNode] == 1){
					graph.removeEdge(nxtNode, vertList[counter]);
					graph.removeEdge(vertList[counter], nxtNode);
					nxtN = getMinFromNode(vertList[counter]);
					len = nxtN[1];
					nxtNode = nxtN[0];
				}
				if(len < min && visArr[nxtNode] != 1){
					min = len;
					k = nxtNode;
					c = vertList[counter];
				}
				counter++;
			}		
			vertList[counter] = k;
			visArr[k] = 1;
			outputArr[outCounter][0] = c;
			outputArr[outCounter][1] = k;
			graph.removeEdge(c, k);
			graph.removeEdge(k, c);
			m=m+1;
			if(min != Integer.MAX_VALUE){
				overalLen = overalLen+min;
			}
			min=Integer.MAX_VALUE;
			outCounter++;
			
			/*System.out.println("----------------");
			graph.printGraph();
			System.out.println("----------------");*/
		}
		outputArr[0][0] = overalLen;
		outputArr[0][1] = 0;
		
		for(int i = 0; i < outputArr.length-1; i++){
			if(i == 0){
				System.out.println("\n===========================\nTotalCost: "+ outputArr[i][0]);
				System.out.println(" ");
			}
			else{
				System.out.println(outputArr[i][0]+"->"+outputArr[i][1]);
			}			
		}
	}

	/**
	 * @param v : key vertex in adjacency list
	 * @return outNode : array containing the next node from key node that has least weigth/edge length
	 */
	public static int[] getMinFromNode(int v){
		int min = Integer.MAX_VALUE;
		//int minNode[] = new int[3];
		int outNode[] = new int[2];
		int edgLen = 0;
		int[] nodeList;
		outNode[0] = 0;		
		//int numNode = graph.getNumNodes(v);
		nodeList = graph.nodeList(v);
		for(int i = 0; i< nodeList.length; i++){
			if(nodeList[i] == v){
				continue; //removes self loop
			}
			edgLen = graph.edgeLength(v, nodeList[i]);
			//minNode = graph.getNode(nodeList[i]);
			if(edgLen < min && edgLen != 0){
				min = edgLen;
				outNode[1] = edgLen;
				outNode[0] = nodeList[i];
			}
		}
		return outNode;
	}

	/**
	 * gets the overall minimum of all edges in adjacency list
	 * @return minAr : array containing to node, from node and minimum weigth
	 * Note : This is not used here. Here, we consider the first node of the graph. However, it may 
	 * be used to randomize the first node to get the edge with minimum weigth
	 */
	public static int[] getMin(){
		int min = Integer.MAX_VALUE;
		int[] minAr = new int [3];
		int edgLen = 0;
		for(int i = 0; i<nodes; i++){
			for(int j = 0; j<nodes; j++){
				edgLen = graph.edgeLength(i, j);
				if(edgLen < min && edgLen != 0){
					min = edgLen;
					minAr[0]=i;
					minAr[1]=edgLen;
					minAr[2] = j;
				}
			}
		}
		return minAr;
	}
}