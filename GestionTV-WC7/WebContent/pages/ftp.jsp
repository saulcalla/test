<%@page import="java.net.*"%>
<%@page import="java.io.*"%>

<%@page import="org.apache.commons.net.ftp.*"%>







<% 

try {
		
		
		//URL url = new URL("ftp://rcweb:rcweb0803@145.2.0.10/Informe.pdf");
		//URL url = new URL("ftp://tvirtual:Virtual@10.0.152.12/PDFVCTO20/06/00001050200706.pdf;type=i");
		//URLConnection con = url.openConnection();
		//BufferedInputStream in = new BufferedInputStream(con.getInputStream());
		String fileName = "archivos-pdf-new/PDFVCTO20/08/00001050200708.pdf";
						   		
		FTPClient f = new FTPClient();

		f.connect("10.0.152.12");
		f.login("tvirtual", "Virtual");
		System.out.println(f.printWorkingDirectory());
		System.out.println(fileName.substring(17, 29));
		System.out.println(fileName.substring(31));

		//f.sendCommand("cd archivos-pdf-new/PDFVCTO05/07");
		
		System.out.println(f.printWorkingDirectory());
				
		InputStream in = f.retrieveFileStream(fileName);
		int bit = in.available();
				
		
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "inline; filename=epu_electronico.pdf");
		response.setHeader("Expires", "1"); 
		response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0"); 
		response.setHeader("Pragma", "public");
		
		try {
			
			
			PrintWriter outw = response.getWriter();
			while ((bit) >= 0) {
				bit = in.read();
				if (bit != -1) {
					outw.write(bit);
				}
			}
			outw.close();			
			in.close();
			
		} catch (Exception ioe) {
			out.println("1" + ioe);
		}	
		
		finally {
		
			try {
				if (f.isConnected()) {
					f.disconnect();
				}
			}
			catch (Exception e) {
				out.println("2" + e);
			}
		}
		
		
	}
	
catch (Exception e) {
	out.println("3" + e);
}
%>
