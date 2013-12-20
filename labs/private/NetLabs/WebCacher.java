import java.io.*;
import java.net.*;

class WebCacher {
	public static void main(String [] args) throws Exception {
		String line, siteURL="http://blank.org", fileName;
		PrintStream ps = new PrintStream(new FileOutputStream("default.txt") ); //Create output to file	
		
		if (args.length < 1) {							// Improper number of arguments
			System.err.println("Usage: WebCacher <URL> <file> ...");
			System.exit(2);
		}
		else if (args.length == 1) {
			siteURL = args[0];
			System.err.println("All data will be shown in System.out");
		}
		else if(args.length ==2) {
			siteURL = args[0];
			fileName = args[1];
			ps = new PrintStream(new FileOutputStream(fileName) ); 
			System.err.println("Data will be coppied to the file <"+fileName+">");
		}

		String pattern = args[0];
		boolean foundAny = false;
		
		System.out.println("\n==============================\n");
		URL site = new URL(siteURL);
		URLConnection uc = site.openConnection();
		
		BufferedReader ur = new BufferedReader(new InputStreamReader( uc.getInputStream() ) );
		
		System.out.println("Connected to : "+site.getHost());
		System.out.println("Current Directory : "+site.getPath());	
		
		line = ur.readLine();
		while (line != null) {
			if (args.length ==2)
				ps.println(line);
			else
				System.out.println(line);
			line = ur.readLine();
		}
	}
}