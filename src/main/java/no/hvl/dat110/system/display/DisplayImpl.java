package no.hvl.dat110.system.display;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCRemoteImpl;
import no.hvl.dat110.rpc.RPCUtils;
import no.hvl.dat110.rpc.RPCServer;

public class DisplayImpl extends RPCRemoteImpl {

	public DisplayImpl(byte rpcid, RPCServer rpcserver) {
		super(rpcid,rpcserver);
	}

	public void write(String message) {
		System.out.println("DISPLAY:" + message);
	}

	public byte[] invoke(byte[] param) {
		// unmarshall string parameter
		String message = RPCUtils.unmarshallString(param);

		// call write method with the unmarshalled string
		write(message);

		// marshall void return value
		byte[] returnval = RPCUtils.marshallVoid();

		return returnval;
	}
}
