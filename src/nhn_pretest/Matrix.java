package nhn_pretest;

import java.util.ArrayList;
import java.util.Scanner;

public class Matrix {
    private static int cnt=1;
    private static int[] X = {-1,0,1,0}; // X축의 상하좌우 이동을 위한 배열
    private static int[] Y = {0,1,0,-1}; // Y축의 상하좌우 이동을 위한 배열 (x,y 짝만 맞추어주면 상하좌우든 하좌우상 이든 순서 상관x)

    private static void solution(int sizeOfMatrix, int[][] matrix) {
        // TODO: 이곳에 코드를 작성하세요.
        ArrayList list = new ArrayList();
        boolean[][] check = new boolean[matrix.length][matrix[0].length];  //방문여부 확인하는 배열
        Matrix mx = new Matrix();
        for(int i=0; i<matrix.length; i++) {
            //System.out.println("다음 찾기 시작");
            //(0,0) 부터 탐색 시작 후 1을 만나면 넓이 구하기 시작
            for(int j=0; j<matrix[i].length; j++) { //1을 만나면 dfs시작
                if(matrix[i][j] == 1) {
                    mx.dfs(i,j,check,matrix);
                    list.add(cnt);
                    cnt = 1;
                }
                // 아닌경우 continue
                else
                    continue;
            }
        }
        System.out.println("arr : "+ list);
    }
    public void dfs(int x, int y, boolean[][] ck,int[][] map) {

        System.out.println(x+","+y);
        ck[x][y] = true;
        map[x][y] = 0;

        for(int i=0; i<4; i++) {
            int nextX = x + X[i];
            int nextY = y + Y[i];
            //상,하,좌,우 이동 중 범위가 넘어서는 경우 continue
            if(nextX <0 || nextY<0 || nextX>=ck.length || nextY>=ck.length) {continue;}
            //방문한곳은 continue
            if(ck[nextX][nextY]){continue;}
            //0은 벽이라서 이동할 경로가 벽이면 continue
            if(map[nextX][nextY] == 0) {ck[nextX][nextY] = true; continue;}

            dfs(nextX,nextY,ck,map);
            cnt++;
        }
        //System.out.println("END");
        //System.out.println();

    }

    private static class InputData {
        int sizeOfMatrix;
        int[][] matrix;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
            for (int i = 0; i < inputData.sizeOfMatrix; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.sizeOfMatrix; j++) {
                    inputData.matrix[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();
        solution(inputData.sizeOfMatrix, inputData.matrix);
    }
}
/*
*
* 입력 1
*
6
0 1 1 0 0 0
0 1 1 0 1 1
0 0 0 0 1 1
0 0 0 0 1 1
1 1 0 0 1 0
1 1 1 0 0 0
*
* 입력 2
*
4
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0
* */