
package cn.xxx.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>maintenance complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="maintenance"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="carnum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="createtime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="custormer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="mainid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="maintenanceItems" type="{http://service.rpms.xxx.cn/}maintenanceItem" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="opt" type="{http://service.rpms.xxx.cn/}opt" minOccurs="0"/&gt;
 *         &lt;element name="optid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "maintenance", propOrder = {
    "address",
    "carnum",
    "createtime",
    "custormer",
    "mainid",
    "maintenanceItems",
    "opt",
    "optid",
    "status"
})
public class Maintenance {

    protected String address;
    protected String carnum;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createtime;
    protected String custormer;
    protected Long mainid;
    @XmlElement(nillable = true)
    protected List<MaintenanceItem> maintenanceItems;
    protected Opt opt;
    protected Long optid;
    protected Boolean status;

    /**
     * 获取address属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置address属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

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

    /**
     * 获取createtime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatetime() {
        return createtime;
    }

    /**
     * 设置createtime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatetime(XMLGregorianCalendar value) {
        this.createtime = value;
    }

    /**
     * 获取custormer属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustormer() {
        return custormer;
    }

    /**
     * 设置custormer属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustormer(String value) {
        this.custormer = value;
    }

    /**
     * 获取mainid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMainid() {
        return mainid;
    }

    /**
     * 设置mainid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMainid(Long value) {
        this.mainid = value;
    }

    /**
     * Gets the value of the maintenanceItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the maintenanceItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMaintenanceItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MaintenanceItem }
     * 
     * 
     */
    public List<MaintenanceItem> getMaintenanceItems() {
        if (maintenanceItems == null) {
            maintenanceItems = new ArrayList<MaintenanceItem>();
        }
        return this.maintenanceItems;
    }

    /**
     * 获取opt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Opt }
     *     
     */
    public Opt getOpt() {
        return opt;
    }

    /**
     * 设置opt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Opt }
     *     
     */
    public void setOpt(Opt value) {
        this.opt = value;
    }

    /**
     * 获取optid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOptid() {
        return optid;
    }

    /**
     * 设置optid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOptid(Long value) {
        this.optid = value;
    }

    /**
     * 获取status属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStatus() {
        return status;
    }

    /**
     * 设置status属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStatus(Boolean value) {
        this.status = value;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "address='" + address + '\'' +
                ", carnum='" + carnum + '\'' +
                ", createtime=" + createtime +
                ", custormer='" + custormer + '\'' +
                ", mainid=" + mainid +
                ", maintenanceItems=" + maintenanceItems +
                ", opt=" + opt +
                ", optid=" + optid +
                ", status=" + status +
                '}';
    }
}
