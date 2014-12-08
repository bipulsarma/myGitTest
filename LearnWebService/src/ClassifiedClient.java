import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.StringWriter;
//test
public class ClassifiedClient {

	private static EndpointReference targetEPR = new  EndpointReference("http://localhost:8080/axis2/services/MyService");
	
	public static OMElement getEchoOMElement(){
		SOAPFactory fac = OMAbstractFactory.getSOAP12Factory();
		OMNamespace omNs = fac.createOMNamespace("http://daily-moon.com/cms","cms");
		OMElement method = fac.createOMElement("echo",omNs);
		OMElement value = fac.createOMElement("category",omNs);
		value.addChild(fac.createOMText(value,"classifieds"));
		method.addChild(value);
		value = fac.createOMElement("subcategory",omNs);
		value.addChild(fac.createOMText(value,"forSale"));
		method.addChild(value);
		
		return method;
	}
	
	public static void main (String[] args) {
	
		try {
			OMElement payload = ClassifiedClient.getEchoOMElement();
			System.out.print(payload.toString());
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}