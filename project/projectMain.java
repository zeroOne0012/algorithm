package project;

import java.util.Scanner;

public class projectMain{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
    
        String fileName = sc.nextLine(); // 파일 이름 입력
        ExecuteManager.getInstance().run(fileName); // 실행
        
    }
}