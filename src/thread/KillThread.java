package thread;

/**�������̷߳���һ: �̳�Thread,��дrun����
 * @author sunshine
 * @date 2018��9��29�� ����3:43:27
 * 
 */
public class KillThread extends Thread{
	private Hero h1;
	private Hero h2;
	
	public KillThread(Hero h1, Hero h2){
		this.h1 = h1;
		this.h2 = h2;
	}
	
	@Override
	public void run() {
		while(!h2.isDead()){
			h1.attackHero(h2);
		}
	}
}