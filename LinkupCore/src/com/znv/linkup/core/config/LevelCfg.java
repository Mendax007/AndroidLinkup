package com.znv.linkup.core.config;

import java.io.Serializable;

import android.content.Context;

import com.znv.linkup.core.GameSettings;
import com.znv.linkup.core.card.align.GameAlign;

public class LevelCfg implements Serializable {

    private static final long serialVersionUID = 2145150870959932172L;

    public static GlobalCfg globalCfg = new GlobalCfg();

    public LevelCfg(String levelName) {
        this.levelName = levelName;
    }

    private String levelId;
    private String levelName;
    private String rankName;
    private int xSize;
    private int ySize;
    private int levelTime;
    private GameAlign levelAlign;
    private int maxScore;
    private boolean isActive;
    private int levelStar;
    private int[] starScores = null;
    private int emptyNum;
    private int obstacleNum;
    private int pieceWidth;
    private int pieceHeight;
    private int beginImageX;
    private int beginImageY;
    private int levelBackground;
    private String maptplStr;
    private Context context;

    public void initStarScores() {
        if (starScores == null) {
            starScores = new int[4];
            int cardCount = (xSize - 2) * (ySize - 2) - emptyNum - obstacleNum;
            starScores[0] = cardCount * GameSettings.CardScore;
            starScores[2] = cardCount / 2 * (GameSettings.CardScore + GameSettings.CornerScore) + levelTime * GameSettings.TimeScore / 2;
            starScores[1] = (starScores[0] + starScores[2]) / 2;
            starScores[3] = starScores[2] + levelTime * GameSettings.TimeScore / 2;
        }
    }

    public int getStar(int score) {
        initStarScores();

        if (score < starScores[0])
            return 1;
        else if (score < starScores[1])
            return 2;
        else if (score < starScores[2])
            return 3;
        else if (score < starScores[3])
            return 4;
        else if (score >= starScores[3])
            return 5;
        else
            return 0;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    // public String getRankId() {
    // return rankId;
    // }
    //
    // public void setRankId(String rankId) {
    // this.rankId = rankId;
    // }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public int getXSize() {
        return xSize;
    }

    public void setXSize(int xSize) {
        this.xSize = xSize;
    }

    public int getYSize() {
        return ySize;
    }

    public void setYSize(int ySize) {
        this.ySize = ySize;
    }

    // public int getLevelScore() {
    // return levelScore;
    // }
    //
    // public void setLevelScore(int levelScore) {
    // this.levelScore = levelScore;
    // }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    // public int getRewardScore() {
    // return rewardScore;
    // }
    //
    // public void setRewardScore(int rewardScore) {
    // this.rewardScore = rewardScore;
    // }

    public int getLevelTime() {
        return levelTime;
    }

    public void setLevelTime(int levelTime) {
        this.levelTime = levelTime;
    }

    public GameAlign getLevelAlign() {
        return levelAlign;
    }

    public void setLevelAlign(GameAlign levelAlign) {
        this.levelAlign = levelAlign;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getLevelStar() {
        return levelStar;
    }

    public void setLevelStar(int levelStar) {
        this.levelStar = levelStar;
    }

    public int[] getStarScores() {
        return starScores;
    }

    public void setStarScores(int[] starScores) {
        this.starScores = starScores;
    }

    public int getEmptyNum() {
        return emptyNum;
    }

    public void setEmptyNum(int emptyNum) {
        this.emptyNum = emptyNum;
    }

    public int getObstacleNum() {
        return obstacleNum;
    }

    public void setObstacleNum(int obstacleNum) {
        this.obstacleNum = obstacleNum;
    }

    public int getPieceWidth() {
        return pieceWidth;
    }

    public void setPieceWidth(int pieceWidth) {
        this.pieceWidth = pieceWidth;
    }

    public int getPieceHeight() {
        return pieceHeight;
    }

    public void setPieceHeight(int pieceHeight) {
        this.pieceHeight = pieceHeight;
    }

    public int getBeginImageX() {
        return beginImageX;
    }

    public void setBeginImageX(int beginImageX) {
        this.beginImageX = beginImageX;
    }

    public int getBeginImageY() {
        return beginImageY;
    }

    public void setBeginImageY(int beginImageY) {
        this.beginImageY = beginImageY;
    }

    public int getLevelBackground() {
        return levelBackground;
    }

    public void setLevelBackground(int levelBackground) {
        this.levelBackground = levelBackground;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getMaptplStr() {
        return maptplStr;
    }

    public void setMaptplStr(String maptplStr) {
        this.maptplStr = maptplStr;
    }
}
