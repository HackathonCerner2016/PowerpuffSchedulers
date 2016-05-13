package ro.cerner.envdashboard.businesslogic;

import java.security.cert.CertificateException;

import javax.net.ssl.X509TrustManager;

public class TrustAllCertificatesManager implements X509TrustManager {

	public java.security.cert.X509Certificate[] getAcceptedIssuers() {
		return null;
	}

	@Override
	public void checkClientTrusted(java.security.cert.X509Certificate[] arg0, String arg1) throws CertificateException {
	}

	@Override
	public void checkServerTrusted(java.security.cert.X509Certificate[] arg0, String arg1) throws CertificateException {

	}

}
