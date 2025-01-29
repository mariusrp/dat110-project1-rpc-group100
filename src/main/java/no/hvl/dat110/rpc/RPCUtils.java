package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;
import no.hvl.dat110.TODO;

public class RPCUtils {
	
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
		
		byte[] rpcmsg = new byte[payload.length+1];

		// Encapsulate the rpcid and payload in a byte array according to the RPC message syntax / format
		rpcmsg[0] = rpcid;
		for (int i = 0; i < payload.length; i++) {
			rpcmsg[i+1] = payload[i];
		}
		return rpcmsg;
	}
	
	public static byte[] decapsulate(byte[] rpcmsg) {
		
		byte[] payload = new byte[rpcmsg.length-1];

		for (int i = 0; i < rpcmsg.length-1; i++) {
			payload[i] = rpcmsg[i+1];
		}
		return payload;
	}

	// convert String to byte array
	public static byte[] marshallString(String str) {
		byte[] encoded = null;

		encoded = str.getBytes();

		return encoded;
	}

	// convert byte array to a String
	public static String unmarshallString(byte[] data) {
		if (data == null) {
			throw new IllegalArgumentException("Data was null");
		}
		String decoded = null;
		decoded = new String(data);
		return decoded;
	}
	
	public static byte[] marshallVoid() {
		return new byte[0];
	}
	
	public static void unmarshallVoid(byte[] data) {
		if (data == null) {
			throw new IllegalArgumentException("Data was null");
		}
		if (data.length != 0) {
			throw new IllegalArgumentException("Data was not empty");
		}
	}

	// convert boolean to a byte array representation
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];
				
		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}
		
		return encoded;
	}

	// convert byte array to a boolean representation
	public static boolean unmarshallBoolean(byte[] data) {
		return (data[0] > 0);
	}

	// integer to byte array representation
	public static byte[] marshallInteger(int x) {
		
		byte[] encoded = null;

		String stringX = String.valueOf(x);
		encoded = stringX.getBytes();

		return encoded;
	}
	
	// byte array representation to integer
	public static int unmarshallInteger(byte[] data) {
		if (data == null) {
			throw new IllegalArgumentException("Data was null");
		}
		int decoded = 0;

		String stringData = new String(data);
		decoded = Integer.parseInt(stringData);

		return decoded;
	}
}
