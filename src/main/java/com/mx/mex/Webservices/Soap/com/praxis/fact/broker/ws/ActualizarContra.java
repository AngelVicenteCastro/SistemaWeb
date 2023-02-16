
package com.mx.mex.Webservices.Soap.com.praxis.fact.broker.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actualizarContra complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actualizarContra">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="credenciales" type="{http://ws.broker.fact.praxis.com/}credenciales" minOccurs="0"/>
 *         &lt;element name="usuNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizarContra", propOrder = {
    "credenciales",
    "usuNombre",
    "pass"
})
public class ActualizarContra {

    protected Credenciales credenciales;
    protected String usuNombre;
    protected String pass;

    /**
     * Obtiene el valor de la propiedad credenciales.
     * 
     * @return
     *     possible object is
     *     {@link Credenciales }
     *     
     */
    public Credenciales getCredenciales() {
        return credenciales;
    }

    /**
     * Define el valor de la propiedad credenciales.
     * 
     * @param value
     *     allowed object is
     *     {@link Credenciales }
     *     
     */
    public void setCredenciales(Credenciales value) {
        this.credenciales = value;
    }

    /**
     * Obtiene el valor de la propiedad usuNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuNombre() {
        return usuNombre;
    }

    /**
     * Define el valor de la propiedad usuNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuNombre(String value) {
        this.usuNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad pass.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPass() {
        return pass;
    }

    /**
     * Define el valor de la propiedad pass.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPass(String value) {
        this.pass = value;
    }

}
