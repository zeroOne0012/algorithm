package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class IOManager {
    private static IOManager instance = new IOManager();
    private IOManager(){

    }
    public static IOManager getInstance(){
        return instance;
    }

    int[][] map = null;
    private int m = 0; //세로
    private int n = 0; //가로
    public int getWidth(){
        return n;
    }
    public int getHeight(){
        return m;
    }
    public int[][] readFile(String fileName){ //텍스트 파일 미로 읽기
        try {
            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\" + fileName +".txt"));
            String line = br.readLine();

            n = line.length();  //가로 길이
            while (line!= null) {     //세로 길이
                m++;
                line = br.readLine();
            }
            br.close();

            map = new int[m][n];
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\" + fileName +".txt"));

            int k = 0;
            while ((line = br.readLine()) != null) {  //map 저장
                for (int j = 0; j < n; j++) {
                    map[k][j] = Character.getNumericValue(line.charAt(j));
                }
                k++;
            }
            br.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }

        System.out.println("m = " + m + ", n = " + n);

        //for (int i = 0; i < m; i++) { //map 출력
          //  for (int j = 0; j < n; j++) {
            //    System.out.print(map[i][j] + " ");
            //}
            //System.out.println();
        //}
        return map;
    }

    public void generateRandomMaze(){  //랜덤 미로 생성
        Random random = new Random();
        int m = random.nextInt(30)+5; //세로
        int n = random.nextInt(30)+5; //가로
        try {
            FileWriter fw = new FileWriter("testMaze"+ "1" +".txt");
            int exit = random.nextInt(n-2)+1;
            for(int i = 0; i<m; i++){
                for(int j = 0; j<n; j++) {
                    if ((i==0 && j == 1)||(i==1&&j==1)||(i==m-1&&j==exit)||(i==m-2&&j==exit)) fw.write('0'); //입출구
                    else if (i == 0 || j == 0 || i == m - 1 || j == n - 1) fw.write('1'); //벽
                    else {
                        int k = random.nextInt(2);
                        if (k==0) fw.write('0');
                        else fw.write('1');
                    }
                }
                fw.write('\n');
            }
            fw.flush();
            fw.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void saveFile(){

    }
}
