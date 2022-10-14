package kea.dk;

public class Enemy {

    private final String enemyName;
    private int enemyHP;
    private final int enemyDMG;

    public Enemy(String enemyName, int enemyHP, int enemyDMG) {
        this.enemyName = enemyName;
        this.enemyHP = enemyHP;
        this.enemyDMG = enemyDMG;
    }

    public int getEnemyHP(){
        return enemyHP;
    }
    public void setEnemyHP(int yourDMG){
        enemyHP = enemyHP - yourDMG;
    }
    public int getEnemyDMG(){
        return enemyDMG;
    }

    @Override
    public String toString() {
        return enemyName;
    }
}
