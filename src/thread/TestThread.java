package thread;

/** java �������߳�
 * @author sunshine
 * @date 2018��9��29�� ����3:31:11
 * 
 */
public class TestThread {
	public static void main(String[] args) {
		Hero gareen = new Hero();
        gareen.name = "����";
        gareen.hp = 616;
        gareen.damage = 50;
 
        Hero teemo = new Hero();
        teemo.name = "��Ī";
        teemo.hp = 300;
        teemo.damage = 30;
         
        Hero bh = new Hero();
        bh.name = "�ͽ�����";
        bh.hp = 500;
        bh.damage = 65;
         
        Hero leesin = new Hero();
        leesin.name = "äɮ";
        leesin.hp = 455;
        leesin.damage = 80;
         
        /*//���׹�����Ī
        while(!teemo.isDead()){
            gareen.attackHero(teemo);
        }
 
        //�ͽ����˹���äɮ
        while(!leesin.isDead()){
            bh.attackHero(leesin);
        }*/
        
        /*KillThread thread1 = new KillThread(gareen, teemo);
        thread1.start();
        KillThread thread2 = new KillThread(bh, leesin);
        thread2.start();*/
        
        Battle battle1 = new Battle(gareen, teemo);
        new Thread(battle1).start();
        
        Battle battle2 = new Battle(bh, leesin);
        new Thread(battle2).start();
        
        
	}
}
