package project;

import java.util.Stack;

public class ExecuteManager { 
    private static ExecuteManager instance = new ExecuteManager(); // singleton 디자인 패턴 
    private ExecuteManager(){}
    public static ExecuteManager getInstance(){
        return instance;
    }

    View view;

    // 변수 선언 
    int[][] map;
    boolean[][] visited;
    int width;
    int height;
    Mouse mouse;
    Route route = new Route(); // 경로 저장하는 객체 생성

    Point curr = new Point(1, 2);

    Point[] offset = new Point[]{
        new Point(0,1),
        new Point(-1,0),
        new Point(0,-1),
        new Point(1,0)
    };

    Stack<Point> stack = new Stack<Point>();

    boolean isFail = false;

    public void run(String fileName){
        init(fileName);
        escape();
    }

    public void init(String fileName){
        map = IOManager.getInstance().readFile(fileName);

        width = IOManager.getInstance().getWidth();
        height = IOManager.getInstance().getHeight();
        mouse = new Mouse(width, height); 

        view = new View(width, height);
    }

    public void escape(){ // 탈출 시작 
        view.Show();
        DFS();
        printStatus();
    }

    private void DFS(){
        stack.push(curr);
        while(!isFinish() || !isFail || !stack.empty()){
            findRoute();
            wait(1.0f);
        }
    }

    private void findRoute(){
        int count = 0;
        for(int i = 0;i<4;++i){
            Point p = curr.add(offset[i]); // offset 
            if(map[p.y][p.x] == 0 && !visited[p.y][p.x] && !p.equal(new Point(1, 0))){
                stack.push(p);
                ++count;
            }
        }
        if(count == 0){ // 길이 막혀있을 경우
            moveBack();
        }else{
            curr = stack.pop(); // 방문할 좌표
            move(count > 1);
        }
    }

    private void move(boolean isBranch){ // 좌표 방문
        System.out.print("moveTo: ("+curr.x+","+curr.y+")");
        visited[curr.y][curr.x] = true;
        view.moveObjectView(curr.x, curr.y);
        if(mouse.move()) fail();
        else route.add(curr, isBranch);
    }

    private void moveBack(){ // 막힌 좌표로부터 되돌아감
        if(mouse.move(route.getDistanceToBackWay())) fail();
        route.reroute();
    }

    private boolean isFinish(){
        return (curr.equal(new Point(1,0))) && (curr.x == 0 || curr.x == width - 1 || curr.y == 0 || curr.y == height - 1);
    }

    private void fail(){
        isFail = true;
        System.out.println("Failed");
    }

    private void printStatus(){
        mouse.status();
    }
}
