package jp.ac.uryukyu.ie.e215701;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class OriginalEnemy{
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public OriginalEnemy (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * Heroへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param hero 攻撃対象
     */
    public void attack(Hero hero){
        int damage = (int)(Math.random() * attack);
        if(this.dead == false){
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, hero.getName(), damage);
            hero.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }

    /**
     * 名前を取得するメソッド
     * @return 名前
     */
    public String getName(){
        return name;
    }

    /**
     * ヒットポイントを取得するメソッド
     * @return　ヒットポイント
     */
    public int getHitPoint(){
        return hitPoint;
    }

    /**
     * 攻撃力を取得するメソッド
     * @return　攻撃力
     */
    public int getAttack(){
        return attack;
    }

    /**
     * 生存状態を取得するメソッド
     * @return　生存状態
     */
    public boolean getDead(){
        return dead;
    }

    /**
     * 名前を設定するメソッド
     * @param name 名前
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * ヒットポイントを設定するメソッド
     * @param hitPoint ヒットポイント
     */
    public void setHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }

    /**
     * 攻撃力を設定するメソッド
     * @param attack 攻撃力
     */
    public void setAttack(int attack){
        this.attack = attack;
    }

    /**
     * 生存状態を設定するメソッド
     * @param dead 生存状態
     */
    public void setDead(boolean dead){
        this.dead = dead;
    }
}