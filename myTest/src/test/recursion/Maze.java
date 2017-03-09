package test.recursion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Maze {
	int mazeSize;//路口个数
	InterSection[] intSec;//路口集合
	int exit;//出口
	Maze(String fileName){
		String line;
		try{
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			line = in.readLine();
			mazeSize = Integer.parseInt(line.trim());
			intSec = new InterSection[mazeSize+1];
			for(int i=1;i<=mazeSize;i++){
				line = in.readLine();
				StringTokenizer tokenizer = new StringTokenizer(line);
				InterSection curr = new InterSection();
				curr.left = Integer.parseInt(tokenizer.nextToken());
				curr.forword = Integer.parseInt(tokenizer.nextToken());
				curr.right = Integer.parseInt(tokenizer.nextToken());
				intSec[i] = curr;
			}
			exit = Integer.parseInt(in.readLine());
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public boolean travMaze(int intSecValue){
		if(intSecValue>0){
			if(intSecValue==exit){
				System.out.print(intSecValue+"<==");
				return true;
			}else if(travMaze(intSec[intSecValue].left)){
				System.out.print(intSecValue+"<==");
				return true;
			}else if(travMaze(intSec[intSecValue].forword)){
				System.out.print(intSecValue+"<==");
				return true;
			}else if(travMaze(intSec[intSecValue].right)){
				System.out.print(intSecValue+"<==");
				return true;
			}
		}
		return false;
	}
}
