

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static int[][] graph;
    static int[] dist;
    static boolean[] st;
    static int INF = 0x3f3f3f3f;
    static int n, m;
    static int start;
    static int end;
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().trim().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        graph = new int[n + 1][n + 1];
        dist = new int[n + 1];
        st = new boolean[n + 1];
        for(int i = 0; i <= n; ++i) {
            dist[i] = INF;
            for(int j = 0; j <= n; ++j) {
                graph[i][j] = INF;
            }
        }
        for (int i = 0; i < m; ++i) {
            String[] strl = scanner.nextLine().trim().split(" ");
            int x = Integer.parseInt(strl[0]);
            int y = Integer.parseInt(strl[1]);
            int z = Integer.parseInt(strl[2]);
            int temp = Math.min(graph[x][y], z);
            graph[x][y] = graph[y][x] = temp;
        }
        String[] strr = scanner.nextLine().trim().split(" ");
        start = Integer.parseInt(strr[0]);
        end = Integer.parseInt(strr[1]);
        String startTime = strr[2];
        StringBuffer s = new StringBuffer();
        s.append("2020-");
        String[] mm1 = startTime.split("\\.");
        String mm = mm1[0];
        if(mm.length() == 1) {
            s.append("0");
            s.append(mm);
        } else {
            s.append(mm);
        }
        s.append("-");
        String dd = startTime.split("\\.")[1].split("\\/")[0];
        if(dd.length() == 1) {
            s.append("0");
            s.append(dd);
        } else {
            s.append(dd);
        }
        s.append(" ");

        String hh = startTime.split("\\.")[1].split("\\/")[1];
        if(hh.length() == 1) {
            s.append("0");
            s.append(hh);
        } else {
            s.append(hh);
        }
        s.append(":");
        s.append("00:00");
        int cost = dis();
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = form.parse(s.toString());
        long ts = date.getTime() + cost * 60 * 60 * 1000;
        Date date1 = new Date(ts);
        String res = form.format(date1);

        StringBuffer strnew = new StringBuffer();
        String[] tt = res.split("-");
        if(tt[1].charAt(0) == '0') {
            strnew.append(tt[1].charAt(1));
        } else {
            strnew.append(tt[1]);
        }
        strnew.append(".");

        String[] tt1 = tt[2].split(" ");
        if(tt1[0].charAt(0) == '0') {
            strnew.append(tt1[0].charAt(1));
        } else {
            strnew.append(tt1[0]);
        }
        strnew.append("/");

        String[] tt2 = tt1[1].split(":");
        if(tt2[0].charAt(0) == '0') {
            strnew.append(tt2[0].charAt(1));
        } else {
            strnew.append(tt2[0]);
        }

        System.out.println(strnew.toString());
    }
    public static int dis() {
        dist[start] = 0;
        for(int i = 0; i < n; ++i) {
            int temp = -1;
            for(int j = 1; j <= n; ++j) {
                if(!st[j] && (-1 == temp || dist[temp] > dist[j])) {
                    temp = j;
                }
            }
            st[temp] = true;
            for (int j = 1; j <= n; ++j) {
                dist[j] = Math.min(dist[j], dist[temp] + graph[temp][j]);
            }
        }
        if(dist[end] == INF) return  -1;
        return dist[end];
    }
}
