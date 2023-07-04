import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
		public class MazeSolution {
			
            public static ArrayList<String> ans = new ArrayList<>();
		    public static void main(String[] args) throws Exception {
		    

		    	//--------------------------------------------------------
				// Summary: in this code , my aim is to get rid of an error and prevent errors from occurring 
				// so I use throws and try - catch method. We scan the file and examine it has error or not.
				// I use "Scanner" to call a maze .
				// Precondition: if we find an error in try part
				// Postcondition: in "catch" we print the errors .
				//-------------------------------------------------------  
		        char[][] maze = null;           //for holding maze data
		        boolean[][] visited = null;     //for keeping the trace of visited paths
		        int line_count = 0;
		        int char_count = 0;
		      		        System.out.println("Please enter the file name");
		        Scanner fn_scanner = new Scanner(System.in);
		        String file_name = fn_scanner.nextLine();
		        // maze reading done here
		        try {
		            File input_file = new File(file_name);// we scan the file which we determine before.
		            Scanner file_scanner = new Scanner(input_file);
		            while(file_scanner.hasNextLine()) {
		                String data = file_scanner.nextLine();
		                if(data.length() > 2){
		                    if(char_count == 0)
		                        char_count = data.length();
		                    line_count++;
		                }
		            }
		            maze = new char[line_count][char_count];
		            visited = new boolean[line_count][char_count];
		            file_scanner.close();
		            file_scanner = null;
		            file_scanner = new Scanner(input_file);
		            int line_num = 0;
		            while (file_scanner.hasNextLine()) {
		                String data = file_scanner.nextLine();
		                if(data.length() > 2){
		                    char[] data_array = data.toCharArray();
		                    for(int i = 0; i < char_count; i++){
		                        maze[line_num][i] = data_array[i];
		                        visited[line_num][i] = false;
		                    }
		                        
		                    line_num++;
		                }
		            }
		            file_scanner.close();
		          } catch (FileNotFoundException e) {
		            System.out.println("An error occurred.");
		            e.printStackTrace();
		        }
		        //if readed maze is successfull the finding section down here.
		        if(maze != null){
		            Stack control_stack = new Stack(line_count*char_count);
		            Node initialNode = new Node(0, 1);
		            visited[1][0] = true;
		            control_stack.push(initialNode);
		            String results[] = new String[line_count*char_count];
		            int found = 0;
		            while(!control_stack.is_empty()){
		                
		                int x = -1, y = -1;
		                initialNode = control_stack.pop();
		                x = initialNode.getX();
		                y = initialNode.getY();
		                control_stack.push(initialNode);
		                if(maze[y][x] == 'E'){
		                    results[found++] = control_stack.printstack(maze);
		                } 
		                //check up
		                if(y-1>0 && !visited[y-1][x] && (Character.isLowerCase(maze[y-1][x]) || maze[y-1][x] == 'E')){
		                    visited[y-1][x] = true;
		                    control_stack.push(new Node(x, y-1));
		                }
		                //check right
		                else if(x+1<char_count && !visited[y][x+1] && (Character.isLowerCase(maze[y][x+1]) || maze[y][x+1] == 'E')){
		                    visited[y][x+1] = true;
		                    control_stack.push(new Node(x+1, y));
		                }
		                //check down
		                else if(y+1<line_count && !visited[y+1][x] && (Character.isLowerCase(maze[y+1][x]) || maze[y+1][x] == 'E')){
		                    visited[y+1][x] = true;
		                    control_stack.push(new Node(x, y+1));
		                }
		                //check left
		                else if(x-1>0 && !visited[y][x-1] && (Character.isLowerCase(maze[y][x-1]) || maze[y][x - 1] == 'E')){
		                    visited[y][x-1] = true;
		                    control_stack.push(new Node(x - 1, y));
		                }
		                //don't have any move left 
		                else {
		                    control_stack.pop();
		                }
		            }
		            if(found >= 0){
		           
		            	
		                System.out.println(found + " treasures are found.");
		                
			            
		                System.out.println("Paths are:");
		              
		            	  
		                for(int i = 0; i < found; i++)
		                	
		                System.out.println((i+1)+")"+results[i]);
		                //	System.out.println((i+1)+")"+ans.get(i));
		            }
		            //
		            }
		        

		        
		        
		    }
		

		}


