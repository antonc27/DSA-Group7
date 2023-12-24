package org.example;

import java.io.*;
import java.util.*;

public class Padure {
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Reader r = new Reader("padure.in");
        int N = r.nextInt();
        int M = r.nextInt();
        int pl = r.nextInt()-1;
        int pc = r.nextInt()-1;
        int cl = r.nextInt()-1;
        int cc = r.nextInt()-1;
        int[][] forest = new int[N][M];
        int[][] cost = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                forest[i][j] = r.nextInt();
            }
            Arrays.fill(cost[i], -1);
        }
        cost[pl][pc] = 0;
        Deque<Cell> deq = new ArrayDeque<>();
        deq.add(new Cell(pl, pc));
        while (!deq.isEmpty()) {
            var curr = deq.pollFirst();
            // System.out.println(curr + " -> " + cost[curr.row][curr.col]);
            if (curr.row == cl && curr.col == cc) {
                // System.out.println(cost[cl][cc]);
                FileWriter fileWriter = new FileWriter("padure.out");
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.write("" + cost[cl][cc]);
                printWriter.close();
                return;
            }
            for (var next : curr.neighbours(forest, cost)) {
                if (curr.isSame(forest, next)) {
                    cost[next.row][next.col] = cost[curr.row][curr.col];
                    deq.addFirst(next);
                } else {
                    cost[next.row][next.col] = cost[curr.row][curr.col] + 1;
                    deq.addLast(next);
                }
            }
        }
    }

    private static class Cell {
        int row, col;
        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "(" + row + "," + col + ")";
        }

        boolean isSame(int[][] forest, Cell other) {
            return forest[row][col] == forest[other.row][other.col];
        }

        List<Cell> neighbours(int[][] forest, int[][] cost) {
            int n = cost.length;
            int m = cost[0].length;
            List<Cell> res = new ArrayList<>();
            for (int i = -1; i <= 1; i++) {
                int r = row + i;
                if (!(0 <= r && r < n))
                    continue;
                for (int j = -1; j <= 1; j++) {
                    if (Math.abs(i) == Math.abs(j))
                        continue;
                    int c = col + j;
                    if (!(0 <= c && c < m))
                        continue;
                    var next = new Cell(r, c);
                    if (cost[r][c] != -1 && cost[row][col] + (isSame(forest, next) ? 0 : 1) >= cost[r][c])
                        continue;
                    res.add(next);
                }
            }
            return res;
        }
    }
}
