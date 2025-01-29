package no.hvl.dat110.rpc;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

public class RPCClient {

	// underlying messaging client used for RPC communication
	private MessagingClient msgclient;

	// underlying messaging connection used for RPC communication
	private MessageConnection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void connect() {
		connection = msgclient.connect();
	}
	
	public void disconnect() {
		connection.close();
	}
	
	public byte[] call(byte rpcid, byte[] param) {
		
		byte[] returnval = null;
		
		byte[] rpcmsg = RPCUtils.encapsulate(rpcid, param);
		Message message = new Message(rpcmsg);

		connection.send(message);
		Message returnMessage = connection.receive();

		returnval = RPCUtils.decapsulate(returnMessage.getData());

		return returnval;
		
	}

}
