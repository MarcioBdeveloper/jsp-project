
package client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tipoGerente.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoGerente"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="GerenteConta"/&gt;
 *     &lt;enumeration value="GerenteContaMaster"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "tipoGerente")
@XmlEnum
public enum TipoGerente {

    @XmlEnumValue("GerenteConta")
    GERENTE_CONTA("GerenteConta"),
    @XmlEnumValue("GerenteContaMaster")
    GERENTE_CONTA_MASTER("GerenteContaMaster");
    private final String value;

    TipoGerente(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoGerente fromValue(String v) {
        for (TipoGerente c: TipoGerente.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
