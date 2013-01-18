package implemented.certSigner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import SR.CertSignerPrx;
import SR.CertSignerPrxHelper;
import SR.DataTooLong;
import SR.IncorrectCSRFile;

public class SignMyCert extends Ice.Application {

	@Override
	public int run(String[] args) {
		CertSignerPrx prx = CertSignerPrxHelper.checkedCast(communicator().stringToProxy("certsigner2011:tcp -h 149.156.97.154 -p 2002"));
		System.out.println(System.getProperty("user.dir"));
		File file = new File("s.csr");

		long length = file.length();

		byte[] csrFile = new byte[(int) length];
		try {
			InputStream is = new FileInputStream(file);

			int offset = 0;
			int numRead = 0;
			while (offset < csrFile.length && (numRead = is.read(csrFile, offset, csrFile.length - offset)) >= 0)
				offset += numRead;

			if (offset < csrFile.length) {
			  is.close();
				throw new IOException("Could not completely read file " + file.getName());
			}

			is.close();

			byte[] signed = prx.signCSR("Konrad", "Gadek", csrFile);
			System.out.println("siema " + signed.length);
			File file1 = new File("s.crt");
			
			OutputStream os = new FileOutputStream(file1);
			offset = 0;
		
			os.write(signed);
		
			os.close();

			
		} catch (DataTooLong | IncorrectCSRFile e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		SignMyCert app = new SignMyCert();
		int status = app.main("Client", args);
		System.exit(status);
	}
}
