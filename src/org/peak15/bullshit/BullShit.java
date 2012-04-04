package org.peak15.bullshit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

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
	public static Properties configuration;
	
	/**
	 * Main method.
	 * @param args No arguments are parsed.
	 */
	public static void main(String[] args) {
		// --------------------
		// Load Configuration
		//--------------------
		try {
			// This is where the file should be.
			File configRoot = new File(BullShit.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParentFile();
			File configFilePath = new File(configRoot, "bullshit.properties");
			
			configuration = new Properties();
			
			// does the file exist?
			if(configFilePath.exists()) {
				// load it
				configuration.load(new FileInputStream(configFilePath));
			}
			else {
				// create defaults
				configuration.setProperty("port", "1337");
				configuration.setProperty("name", "Super Awesome Server");
				
				PrintStream ps = new PrintStream(configFilePath);
				configuration.store(ps, "Default file created.");
				ps.close();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			System.exit(1);
		}
		
		// --------------------
		// Start String Server
		// --------------------
		server = new StringServer(new BSListener());
		server.start();
		try {
			server.bind(Integer.parseInt(configuration.getProperty("port")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
