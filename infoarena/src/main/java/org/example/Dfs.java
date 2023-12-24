package org.example;

import java.io.*;
import java.util.*;

public class Dfs {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("dfs.in"));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            if (!graph.containsKey(from)) {
                graph.put(from, new ArrayList<>());
            }
            graph.get(from).add(to);
            if (!graph.containsKey(to)) {
                graph.put(to, new ArrayList<>());
            }
            graph.get(to).add(from);
        }
        boolean[] visited = new boolean[n+1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                res++;
                dfs(graph, visited, i);
            }
        }
        FileWriter fileWriter = new FileWriter("dfs.out");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.write("" + res);
        printWriter.close();
    }

    private static void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int curr) {
        visited[curr] = true;
        for (var next : graph.getOrDefault(curr, List.of())) {
            if (!visited[next]) {
                dfs(graph, visited, next);
            }
        }
    }
}
