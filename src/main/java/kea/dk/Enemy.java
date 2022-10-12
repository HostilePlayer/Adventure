package kea.dk;

public class Enemy {

    private String enemyName;
    private int enemyHP;
    private int enemyDMG;

    public Enemy(String enemyName, int enemyHP, int enemyDMG) {
        this.enemyName = enemyName;
        this.enemyHP = enemyHP;
        this.enemyDMG = enemyDMG;
    }

    public String getEnemyName() {
        return enemyName;
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
