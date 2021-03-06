package eu.europa.esig.dss.web.ws;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import eu.europa.esig.dss.token.RemoteSignatureTokenConnection;
import eu.europa.esig.dss.token.SoapSignatureTokenConnection;
import eu.europa.esig.dss.web.config.CXFConfig;

public class SoapServerSigningIT extends AbstractServerSigning {

	@Override
	RemoteSignatureTokenConnection getRemoteToken() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(SoapSignatureTokenConnection.class);

		Map<String, Object> props = new HashMap<String, Object>();
		props.put("mtom-enabled", Boolean.TRUE);
		factory.setProperties(props);

		factory.setAddress(getBaseCxf() + CXFConfig.SOAP_SERVER_SIGNING);
		return (SoapSignatureTokenConnection) factory.create();
	}

}
