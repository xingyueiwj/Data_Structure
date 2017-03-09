package test.recursion;

public class TestMaze {
	public static void main(String[] args) {
		String fileName = "D:\\myworkspace\\myTest\\src\\Maze1.dat";
		Maze m = new Maze(fileName);
		int start = 1;
		if(m.travMaze(start)){
			System.out.println();
			System.out.println("此迷宫的一条通路如上所示");
		}else{
			System.out.println("此迷宫无通路!");
		}
	}
}

//6路口个数
//020左右不通,向前通
