package thread;

/**创建多线程方法一: 继承Thread,重写run方法
 * @author sunshine
 * @date 2018年9月29日 下午3:43:27
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
