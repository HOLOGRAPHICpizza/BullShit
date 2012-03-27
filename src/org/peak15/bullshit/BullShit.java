package org.peak15.bullshit;

import java.io.IOException;

import org.peak15.stringserver.StringServer;

/**
 * A telnet-based version of the card game bullshit.
 * Players can telnet into a BullShit server and play with everyone else connected to the server.
 * Uses the StringServer library. (https://github.com/HOLOGRAPHICpizza/StringServer)
 * Released under the New BSD License.
 * 
 * @author Michael Craft <mcraft@peak15.org>
 */
public class BullShit {
	public static StringServer server;
	
	/**
	 * Main method.
	 * @param args No arguments are parsed.
	 */
	public static void main(String[] args) {
		server = new StringServer(new BSListener());
		server.start();
		try {
			server.bind(1337);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
