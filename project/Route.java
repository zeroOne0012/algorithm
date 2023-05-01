package project;

import java.util.ArrayList;
import java.util.Stack;

public class Route {
    private Stack<Integer> branch = new Stack<Integer>(); // 분기 스택 
    private ArrayList<Point> blueRoute = new ArrayList<Point>(); // 최적의 경로
    private ArrayList<Point> redRoute = new ArrayList<Point>(); // 막혀서 되돌아온 경로

    Route(){}

    public void add(Point point, boolean isBranch){ // 경로 추가
        blueRoute.add(point); 
        if(isBranch){ // 분기점이라면, 
            branch.push(blueRoute.size()-1); // 분기 스택에 추가
        }
    }

    public int getDistanceToBackWay(){ // 막힌 좌표로부터 마지막 분기점까지의 길이 반환
        return blueRoute.size() - branch.peek();
    }

    public void reroute(){ // 경로 재탐색 
        redRoute.addAll(blueRoute.subList(branch.pop() + 1, blueRoute.size()-1)); 
        // 막힌 좌표로부터 마지막 분기점까지의 경로를 모두 red로 옮기고 blue에서는 삭제
        // 마지막 분기점을 삭제
    }

}
