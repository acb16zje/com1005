/*
 * Decompiled with CFR 0_118.
 *
 * Could not load the following classes:
 *  sheffield.EasyWriter
 */

import java.util.Random;
import sheffield.EasyWriter;

public class EpuzzGen {

    EasyWriter screen = new EasyWriter();
    int[][] tar = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
    Random gen;

    public EpuzzGen() {
        this.gen = new Random();
    }

    public EpuzzGen(int seed) {
        this.gen = new Random(seed);
    }

    public int[][] puzzGen(int diff) {
        int[][] puzz = new int[3][3];
        int n = 0;
        while (n <= 8) {
            int i = this.gen.nextInt(3);
            int j = this.gen.nextInt(3);
            while (puzz[i][j] != 0) {
                i = this.gen.nextInt(3);
                j = this.gen.nextInt(3);
            }
            puzz[i][j] = n++;
        }
        if (this.impossible(puzz, diff)) {
            puzz = this.puzzGen(diff);
        }
        return puzz;
    }

    private boolean impossible(int[][] puzzq, int diff) {
        int[] flatp = new int[8];
        int f = 0;
        for (int i = 0; i <= 2; ++i) {
            for (int j = 0; j <= 2; ++j) {
                if (puzzq[i][j] <= 0) {
                    continue;
                }
                flatp[f] = puzzq[i][j];
                ++f;
            }
        }
        int invcount = 0;
        for (int k = 0; k <= 6; ++k) {
            for (int l = k + 1; l <= 7; ++l) {
                if (flatp[l] >= flatp[k]) {
                    continue;
                }
                ++invcount;
            }
        }
        int mhat = this.manhattan(puzzq, this.tar);
        return invcount % 2 != 0 || mhat > diff;
    }

    private int manhattan(int[][] s, int[][] t) {
        int d = 0;
        int si = 0;
        int sj = 0;
        for (int n = 0; n <= 8; ++n) {
            int j;
            int i;
            for (i = 0; i <= 2; ++i) {
                for (j = 0; j <= 2; ++j) {
                    if (s[i][j] != n) {
                        continue;
                    }
                    si = i;
                    sj = j;
                }
            }
            for (i = 0; i <= 2; ++i) {
                for (j = 0; j <= 2; ++j) {
                    if (t[i][j] != n) {
                        continue;
                    }
                    d = d + Math.abs(i - si) + Math.abs(j - sj);
                }
            }
        }
        return d;
    }
}
