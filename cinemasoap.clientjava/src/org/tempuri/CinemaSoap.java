
package org.tempuri;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CinemaSoap", targetNamespace = "http://tempuri.org/", wsdlLocation = "http://localhost:7979/CinemaService.svc?wsdl")
public class CinemaSoap
    extends Service
{

    private final static URL CINEMASOAP_WSDL_LOCATION;
    private final static WebServiceException CINEMASOAP_EXCEPTION;
    private final static QName CINEMASOAP_QNAME = new QName("http://tempuri.org/", "CinemaSoap");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:7979/CinemaService.svc?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CINEMASOAP_WSDL_LOCATION = url;
        CINEMASOAP_EXCEPTION = e;
    }

    public CinemaSoap() {
        super(__getWsdlLocation(), CINEMASOAP_QNAME);
    }

    public CinemaSoap(WebServiceFeature... features) {
        super(__getWsdlLocation(), CINEMASOAP_QNAME, features);
    }

    public CinemaSoap(URL wsdlLocation) {
        super(wsdlLocation, CINEMASOAP_QNAME);
    }

    public CinemaSoap(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CINEMASOAP_QNAME, features);
    }

    public CinemaSoap(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CinemaSoap(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ICinemaService
     */
    @WebEndpoint(name = "WSHttpBinding_ICinemaService")
    public ICinemaService getWSHttpBindingICinemaService() {
        return super.getPort(new QName("http://tempuri.org/", "WSHttpBinding_ICinemaService"), ICinemaService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ICinemaService
     */
    @WebEndpoint(name = "WSHttpBinding_ICinemaService")
    public ICinemaService getWSHttpBindingICinemaService(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "WSHttpBinding_ICinemaService"), ICinemaService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CINEMASOAP_EXCEPTION!= null) {
            throw CINEMASOAP_EXCEPTION;
        }
        return CINEMASOAP_WSDL_LOCATION;
    }

}