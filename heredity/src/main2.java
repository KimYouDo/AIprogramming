import java.util.*;

public class main2 {

    public static void main(String[] args) {
        int[][] a1 = {{7, 5}, {7, 2}};
        int[][] a2 = {{5, 4}, {10, 3}};
        int i, j;
        int mse = 0;
        double pslr = 0;
        for ( i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                mse += (a1[i][j] - a2[i][j]) * (a1[i][j] - a2[i][j]);
            }
        }

        mse = mse / 4;
        pslr = 10 * Math.log10(255 * 255 / mse);
        System.out.println("aaa");
        System.out.println(pslr);

        int s=0;
        int[][] Y = {{255, 0}, {0, 255}};
        int[][] X = {{7, 5}, {4, 2}};
        int[][] Z = new int[2][2];
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
            s = Y[i][j];
       if (s >= 128)
           Y[i][j] = 255;
       if (s < 128)
           Y[i][j] = 0;
            }
}
// watermark를 Lena에 삽입함
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                s = X[i][j];
                s = s & 0xFE;
                s = s + (char)(Y[i][j] / 255);
                Z[i][j] = s;
            }
        }
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                System.out.print(Z[i][j]+" ");
            }
            System.out.println();
        }
    for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
            s = Z[i][j];
            s = (s & 0x01) * 255;
            Y[i][j] = s;
            }
            }

        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                System.out.print(Y[i][j]+" ");
            }
            System.out.println();
        }


        int[][] M = {{3, 4}, {7, 2}};
        int[][] Q = new int[2][2];
        int m,n;
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                Q[i][j]=0;
                for (m = 0; m < 2; m++) {
                    for (n = 0; n < 2; n++) {
                        Q[i][j]+=M[m][n]*Math.cos((2*m+1)*3.14/16.0)*Math.cos((2*n+1)*3.14/16.0);
                    }
                }
            }
        }

        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                System.out.print(Q[i][j] + " ");
            }
            System.out.println();
        }

    }
}
