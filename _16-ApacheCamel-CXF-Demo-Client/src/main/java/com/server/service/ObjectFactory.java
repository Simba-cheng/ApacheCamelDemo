
package com.server.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.server.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _QueryPeopleInfoResponse_QNAME = new QName("http://service.server.com/", "queryPeopleInfoResponse");
    private final static QName _QueryPeopleInfo_QNAME = new QName("http://service.server.com/", "queryPeopleInfo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.server.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link QueryPeopleInfoResponse }
     * 
     */
    public QueryPeopleInfoResponse createQueryPeopleInfoResponse() {
        return new QueryPeopleInfoResponse();
    }

    /**
     * Create an instance of {@link QueryPeopleInfo }
     * 
     */
    public QueryPeopleInfo createQueryPeopleInfo() {
        return new QueryPeopleInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryPeopleInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.server.com/", name = "queryPeopleInfoResponse")
    public JAXBElement<QueryPeopleInfoResponse> createQueryPeopleInfoResponse(QueryPeopleInfoResponse value) {
        return new JAXBElement<QueryPeopleInfoResponse>(_QueryPeopleInfoResponse_QNAME, QueryPeopleInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryPeopleInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.server.com/", name = "queryPeopleInfo")
    public JAXBElement<QueryPeopleInfo> createQueryPeopleInfo(QueryPeopleInfo value) {
        return new JAXBElement<QueryPeopleInfo>(_QueryPeopleInfo_QNAME, QueryPeopleInfo.class, null, value);
    }

}
