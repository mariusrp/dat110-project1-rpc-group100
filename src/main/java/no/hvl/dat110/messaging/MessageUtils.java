package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8091;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {
		if (message == null) {
			throw new IllegalArgumentException("Message cannot be null");
		}

		byte[] data = message.getData();

		if (data == null) {
			throw new IllegalArgumentException("Data was null");
		}
		int length = data.length;

		if (length > SEGMENTSIZE - 1) {
			throw new IllegalArgumentException("Data length exeecds max");
		}

		byte[] segment = new byte[SEGMENTSIZE];
		segment[0] = (byte) length;

		for (int i = 0; i < length; i++) {
			segment[1 + i] = data[i];
		}

		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {
		if (segment == null) {
			throw new IllegalArgumentException("Segment was null");
		}

		int length = segment[0];
		byte[] data = new byte[length];

		for (int i = 0; i < length; i++) {
			data[i] = segment[i+1];
		}

		return new Message(data);
		
	}
	
}
