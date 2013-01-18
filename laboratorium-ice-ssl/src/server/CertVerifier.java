package server;


public class CertVerifier implements IceSSL.CertificateVerifier {

	@Override
	public boolean verify(IceSSL.NativeConnectionInfo info) {
		System.out.println("**** verify:" + info.nativeCerts[0].toString());
		
		return true;
	}
}
