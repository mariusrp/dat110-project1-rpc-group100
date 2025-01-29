package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class DisplayStub extends RPCLocalStub {

	public DisplayStub(RPCClient rpcclient) {
		super(rpcclient);
	}
	
	public void write (String message) {

		// implement marshalling, call and unmarshalling for write RPC method

		byte[] encoded = RPCUtils.marshallString(message);
		this.rpcclient.call(encoded[0], RPCUtils.decapsulate(encoded));

	}
}
