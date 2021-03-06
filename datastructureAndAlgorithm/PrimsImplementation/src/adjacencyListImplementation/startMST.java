package adjacencyListImplementation;
import java.io.IOException;


import java.util.*;
import randomGen.*;

/**
 * @author SRoy
 * Takes user input to run prim's algorithnm in desired paradigm
 */
public class startMST {
	
	private static Scanner in;

	public static void main(String args[]) throws IOException{
		in = new Scanner(System.in);
	    String s;
	    String scheme;
	    String runMode;
	    int v = 0;
	    int d = 10;
	    String fileNameAndPath;
	    long startTime = 0;
	    long endTime = 0;
	    long timeTaken = 0;
	    
	    System.out.println("Enter : file name along with full path");
	    fileNameAndPath = in.nextLine();
	      System.out.println("For Random, check input file in location : "+fileNameAndPath);
	      System.out.println("For File input, place file in location : "+fileNameAndPath);
		
		System.out.println("Enter : 'r' for Random Mode; 'f' for file input");
	      s = in.nextLine();
	      System.out.println("You entered "+s);
	      if(s.equals("r")){
	    	  runMode = "'random'";
	      }
	      else{
	    	  runMode = "'file read'";
	      }	      
	      
	      if(s.equals("r")){
	    	  System.out.println("Enter : 's' for Simple Scheme; 'f' for Fibonacci scheme");
		      s = in.nextLine();
		      System.out.println("You entered "+s);

		      if(s.equals("s")){
		    	  scheme = "'simple scheme'";
		    	  System.out.println("Enter : number of nodes");
			      s = in.nextLine();
			      v = Integer.parseInt(s);
			      System.out.println("Enter : density");
			      s = in.nextLine();
			      d = Integer.parseInt(s);
			      RandomMatrixGen.getRandom(v, d, fileNameAndPath);
			      startTime = System.currentTimeMillis();
			      GraphReprAndRunPrim.getGraphAndPrim(fileNameAndPath);
			      endTime = System.currentTimeMillis();
			      timeTaken = endTime - startTime;
			      System.out.println("Total Time Taken for "+scheme+ " in "+runMode+" is "+timeTaken+ "ms.");
			      System.out.println("-------- Thank You --------");
		      }
		      else if(s.equals("f")){
		    	  scheme = "'fibonacci heap scheme'";
		    	  System.out.println("Code for fibonacci heap scheme is not updated");
		    	  
			      /*s = in.nextLine();
			      v = Integer.parseInt(s);
			      System.out.println("Enter : density");
			      s = in.nextLine();
			      d = Integer.parseInt(s);
			      RandomMatrixGen.getRandom(v, d, fileNameAndPath);
			      startTime = System.currentTimeMillis();
			      FibHeapMeth hm=new FibHeapMeth();
			      hm.startHeap(fileNameAndPath);
			      endTime = System.currentTimeMillis();
			      timeTaken = endTime - startTime;
			      System.out.println("Total Time Taken for "+scheme+ " in "+runMode+" is "+timeTaken+ "ms.");*/
			      
		    	  System.out.println("-------- Thank You --------");
		      }
		      else {
		    	  System.out.println("check the input. It should be 'r' or 'f'");
		      }
	      }
	      else if(s.equals("f")){
	    	  System.out.println("Enter : 's' for Simple Scheme; 'f' for Fibonacci scheme");
		      s = in.nextLine();
		      System.out.println("You entered "+s);
		      if(s.equals("s")){
		    	  scheme = "'simple scheme'";
		    	  System.out.println("file should be present in folder "+fileNameAndPath);
		    	  startTime = System.currentTimeMillis();
		    	  GraphReprAndRunPrim.getGraphAndPrim(fileNameAndPath);
		    	  endTime = System.currentTimeMillis();
			      timeTaken = endTime - startTime;
			      System.out.println("Total Time Taken for "+scheme+ " in "+runMode+" is "+timeTaken+ "ms.");
			      System.out.println("-------- Thank You --------");
		      }
		      else if(s.equals("f")){
		    	  scheme = "'fibonacci heap scheme'";
		    	  System.out.println("Code for fibonacci scheme is not updated");
		    	  
		    	  /*System.out.println("file should be present in folder "+fileNameAndPath);
		    	  startTime = System.currentTimeMillis();
		    	  FibHeapMeth hm=new FibHeapMeth();
			      hm.startHeap(fileNameAndPath);
			      endTime = System.currentTimeMillis();
			      timeTaken = endTime - startTime;
			      System.out.println("Total Time Taken for "+scheme+ " in "+runMode+" is "+timeTaken+ "ms.");*/
			      
		    	  System.out.println("-------- Thank You --------");
		      }
		      else {
		    	  System.out.println("check the input. It should be 'r' or 'f'");
		      }
	      }
	      else{
	    	  System.out.println("check the input. It should be 'r' or 'f'");
	      }
	}

}
