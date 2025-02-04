package no.hvl.dat110.system.sensor;

import no.hvl.dat110.rpc.RPCServer;
import no.hvl.dat110.system.controller.Common;

public class SensorDevice {

	// SensorDevice.java
	public static void main(String[] args) {
		System.out.println("Sensor server starting ...");
		RPCServer sensorserver = new RPCServer(Common.SENSORPORT);
		SensorImpl sensor = new SensorImpl((byte)Common.READ_RPCID,sensorserver);
		sensorserver.register((byte)Common.READ_RPCID, sensor);
		sensorserver.run();
		sensorserver.stop();
		System.out.println("Sensor server stopping ...");
	}
}
