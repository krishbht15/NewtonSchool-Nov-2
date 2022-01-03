package com.company.backtracking;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
//        ArrayList<String> res = new ArrayList<>();
//        printFindPaths(arr, 0, 0, "", res);
//        System.out.println(res);
        printRatInAMaze(arr, 0, 0, "");
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
}
