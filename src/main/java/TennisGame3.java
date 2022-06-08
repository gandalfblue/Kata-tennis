
public class TennisGame3 implements TennisGame {

    private int p2;
    private int p1;
    private String p1N;
    private String p2N;
    private String s = "";

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {

        if (isLessPointFour()) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            s = p[p1];
            return board(p);
        }
        s = isDeuce(p1, p2, s);
        return s;
    }

    private String board(String[] p) {
        return (p1 == p2) ? s + "-All" : s + "-" + p[p2];
    }

    private boolean isLessPointFour() {
        return p1 < 4 && p2 < 4 && isNotEqualsPointsSix();
    }

    private boolean isNotEqualsPointsSix() {
        return !(p1 + p2 == 6);
    }

    private String isDeuce(int p1, int p2, String s) {
        s = getPlayerName(p1, p2);
        if (p1 == p2) {
            return s = "Deuce";
        }
        s = isAdvantageOrWin(p1, p2, s);
        return s;
    }

    private String getPlayerName(int p1, int p2) {
        s = p1 > p2 ? p1N : p2N;
        return s;
    }

    private String isAdvantageOrWin(int p1, int p2, String s) {

        if (isPointequalsOne(p1, p2)){
            s = "Advantage " + s;
            return s;
        }
        s = "Win for " + s;
        return s;
    }

    private boolean isPointequalsOne(int p1, int p2) {
        return (p1 - p2) * (p1 - p2) == 1;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1 += 1;
        else
            this.p2 += 1;
    }
}
