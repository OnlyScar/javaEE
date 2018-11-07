package thread;

/** 实现runnable接口
 * @author sunshine
 * @date 2018年9月29日 下午3:44:43
 * 
 */
public class Battle implements Runnable {

	private Hero h1;
	private Hero h2;
	
	public Battle(Hero h1, Hero h2) {
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
