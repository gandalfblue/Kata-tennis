import java.util.HashMap;
import java.util.Map;

public class TennisGame1 implements TennisGame {
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private String score = "";

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {

        int tempScore=0;
        if (m_score1==m_score2)
        {
            score = getDescriptionPointForAllPlayers();
            return score;
        }
        score = verifygreaterForPoint(m_score1, m_score2, score);
        return score;
    }

    private String verifygreaterForPoint( int m_score1, int m_score2, String score){
        if (m_score1>=4 || m_score2>=4){
            int minusResult = m_score1-m_score2;
            score = getWinnerPlayer(minusResult, score);
            return score;
        }
        score = getScoreGlobal(score);
        return score;
    }

    private String getWinnerPlayer(int minusResult, String score){

        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";

        return score;
    }

    private String getDescriptionPointForAllPlayers() {
        String score;
        switch (m_score1)
        {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    private String getScoreGlobal(String score) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = m_score1;
            else { score +="-"; tempScore = m_score2;}
            score = getPointsDescription(score, tempScore);
        }
        return score;
    }

    private String getPointsDescription (String score, int tempScore) {
        switch(tempScore)
        {
            case 0:
                score +="Love";
                break;
            case 1:
                score +="Fifteen";
                break;
            case 2:
                score +="Thirty";
                break;
            case 3:
                score +="Forty";
                break;
        }
        return score;
    }
}
