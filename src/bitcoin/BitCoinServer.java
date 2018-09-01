package bitcoin;

import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @ServerEndpoint ע����һ�����ε�ע�⣬���Ĺ�����Ҫ�ǽ�Ŀǰ���ඨ���һ��websocket��������,
 * ע���ֵ�������ڼ����û����ӵ��ն˷���URL��ַ,�ͻ��˿���ͨ�����URL�����ӵ�WebSocket��������
 * 	OnOpen ��ʾ����������ӹ�����ʱ�򱻵���
	OnClose ��ʾ����������ر������ʱ�򱻵���
	OnMessage ��ʾ���������Ϣ��ʱ�򱻵���
	OnError ��ʾ�д���������������Ͽ��˵ȵ�
	sendMessage ������������ط���Ϣ
 */
@ServerEndpoint("/ws/bitcoinServer")
public class BitCoinServer {

	private Session session;
	
	@OnOpen
	public void OnOpen(Session session) {
			this.session = session;
			ServerManager.add(this);
	}
	
	public void sendMessage(String message) throws IOException{
		this.session.getBasicRemote().sendText(message);
	}
	
	@OnClose
	public void onClose() {
		ServerManager.remove(this);
	}
	
	@OnMessage
	public void onMessage(String message,Session session) {
		System.out.println("���Կͻ��˵���Ϣ:"+message);
	}
	
	@OnError
	public void onError(Session session,Throwable error) {
		System.out.println("��������");
		error.printStackTrace();
	}
	
}