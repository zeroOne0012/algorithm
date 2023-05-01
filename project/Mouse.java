package project;

public class Mouse {
    private int hp; // energy
    private int initHP;
    private float mp = 3.0f;
    private boolean isItemUsed = false; // 일회용 아이템(벽뚫기)

    Mouse(int n, int m){
        initHP = hp = n * m * 2; // 초기 체력 설정 
    }

    public boolean move(){ // 한 칸 이동한 만큼 변수 조정
        --hp;
        mp += 0.1f;
        return hp < 1; // HP가 1보다 낮아지면 false를 출력하여 시스템 종료 
    }

    public boolean move(int amount){ // amount칸 이동한 만큼 변수 조정
        if(hp - amount < 1){
            hp = 0;
            mp += 0.1f * hp;
            return false;
        }else{
            hp -= amount;
            mp += 0.1f * amount;
            return true;
        }
    }

    public boolean isEnoughMPtoScan(){ // 스캔이 가능한지 판별
        return mp >= 3.0f;
    }

    public boolean isItemUsed(){ // 아이템 사용이 가능한지 판별
        return isItemUsed;
    }

    public void status(){
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("init HP: " + initHP);
        System.out.println("remain HP: " + hp);
        System.out.println("init MP: 3.0");
        System.out.println("remain MP: " + mp);
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    }
}
