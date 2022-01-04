package com.company.backtracking;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Main {

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
//        ArrayList<String> res = new ArrayList<>();
//        printFindPaths(arr, 0, 0, "", res);
//        System.out.println(res);
//        printRatInAMaze(arr, 0, 0, "");
        boolean[][] chess = new boolean[4][4];
        ans = new ArrayList<>();
        nQueens(chess, 0, 0, new ArrayList<>());
        System.out.println("ans = " + ans);
    }

    //    https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/
    public static void printFindPaths(int[][] m, int r, int c, String psf, ArrayList<String> res) {
        if (r == m.length - 1 && c == m[0].length - 1) {
            res.add(psf);
            return;
        }
        m[r][c] = 0;
        if (r - 1 >= 0 && m[r - 1][c] == 1) {
            printFindPaths(m, r - 1, c, psf + "U", res);
        }
        if (r + 1 < m.length && m[r + 1][c] == 1) {
            printFindPaths(m, r + 1, c, psf + "D", res);
        }
        if (c - 1 >= 0 && m[r][c - 1] == 1) {
            printFindPaths(m, r, c - 1, psf + "L", res);
        }
        if (c + 1 < m[0].length && m[r][c + 1] == 1) {
            printFindPaths(m, r, c + 1, psf + "R", res);
        }
        m[r][c] = 1;
    }

    public static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static char[] dirChar = {'U', 'R', 'D', 'L'};

    public static void printRatInAMaze(int[][] m, int r, int c, String psf) {
        if (r == m.length - 1 && c == m[0].length - 1) {
            System.out.println(psf);
            return;
        }
        m[r][c] = 0;
        for (int i = 0; i < dir.length; i++) {
            int dr = dir[i][0];
            int dc = dir[i][1];
            int nr = dr + r;
            int nc = dc + c;
            if (nr >= 0 && nr < m.length && nc >= 0
                    && nc < m[0].length && m[nr][nc] == 1) {
                printRatInAMaze(m, nr, nc, psf + dirChar[i]);
            }
        }
        m[r][c] = 1;
    }

    //    https://practice.geeksforgeeks.org/problems/n-queen-problem0315/
    static ArrayList<ArrayList<Integer>> ans;

    public static void nQueens(boolean[][] chess, int r,
                               int c, ArrayList<Integer> qpsf) {
        if (r == chess.length) {
            ArrayList<Integer> res = new ArrayList<>(qpsf);
            ans.add(res);
            return;
        }
        boolean canBePlaced = canQueenBePlaced(chess, r, c);
        if (canBePlaced) {
            chess[r][c] = true;
            qpsf.add(c + 1);
            nQueens(chess, r + 1, 0, qpsf);
            chess[r][c] = false;
            qpsf.remove(qpsf.size() - 1);
        }
        if (c + 1 < chess.length) {
            nQueens(chess, r, c + 1, qpsf);
        }
    }

    static int[][] queenDirections = {{-1, -1}, {-1, 0}, {-1, 1}};

    public static boolean canQueenBePlaced(boolean[][] chess, int r, int c) {
        for (int i = 0; i < queenDirections.length; i++) {
            int dr = queenDirections[i][0];
            int dc = queenDirections[i][1];
            int nr = r;
            int nc = c;
            while (nr + dr >= 0 && nc + dc >= 0 && nc + dc < chess.length) {
                nr += dr;
                nc += dc;
                if (chess[nr][nc]) return false;
            }
        }
        return true;
    }

}
