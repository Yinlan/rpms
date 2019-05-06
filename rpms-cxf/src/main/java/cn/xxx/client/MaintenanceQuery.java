
package cn.xxx.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>maintenanceQuery complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="maintenanceQuery"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://service.rpms.xxx.cn/}baseQuery"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="carnum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "maintenanceQuery", propOrder = {
    "carnum"
})
public class MaintenanceQuery
    extends BaseQuery
{

    protected String carnum;

    /**
     * 获取carnum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarnum() {
        return carnum;
    }

    /**
     * 设置carnum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarnum(String value) {
        this.carnum = value;
    }

}
