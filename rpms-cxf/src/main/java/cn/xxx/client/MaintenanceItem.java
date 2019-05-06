
package cn.xxx.client;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>maintenanceItem complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="maintenanceItem"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="amt1" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="amt2" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="itemid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="mainid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="num" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="opid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="parts" type="{http://service.rpms.xxx.cn/}parts" minOccurs="0"/&gt;
 *         &lt;element name="pid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="totalamt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "maintenanceItem", propOrder = {
    "amt1",
    "amt2",
    "itemid",
    "mainid",
    "num",
    "opid",
    "parts",
    "pid",
    "totalamt"
})
public class MaintenanceItem {

    protected BigDecimal amt1;
    protected BigDecimal amt2;
    protected Long itemid;
    protected Long mainid;
    protected Integer num;
    protected Long opid;
    protected Parts parts;
    protected Long pid;
    protected BigDecimal totalamt;

    /**
     * 获取amt1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmt1() {
        return amt1;
    }

    /**
     * 设置amt1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmt1(BigDecimal value) {
        this.amt1 = value;
    }

    /**
     * 获取amt2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmt2() {
        return amt2;
    }

    /**
     * 设置amt2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmt2(BigDecimal value) {
        this.amt2 = value;
    }

    /**
     * 获取itemid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getItemid() {
        return itemid;
    }

    /**
     * 设置itemid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setItemid(Long value) {
        this.itemid = value;
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
     * 获取num属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置num属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNum(Integer value) {
        this.num = value;
    }

    /**
     * 获取opid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOpid() {
        return opid;
    }

    /**
     * 设置opid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOpid(Long value) {
        this.opid = value;
    }

    /**
     * 获取parts属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Parts }
     *     
     */
    public Parts getParts() {
        return parts;
    }

    /**
     * 设置parts属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Parts }
     *     
     */
    public void setParts(Parts value) {
        this.parts = value;
    }

    /**
     * 获取pid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置pid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPid(Long value) {
        this.pid = value;
    }

    /**
     * 获取totalamt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalamt() {
        return totalamt;
    }

    /**
     * 设置totalamt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalamt(BigDecimal value) {
        this.totalamt = value;
    }

    @Override
    public String toString() {
        return "MaintenanceItem{" +
                "amt1=" + amt1 +
                ", amt2=" + amt2 +
                ", itemid=" + itemid +
                ", mainid=" + mainid +
                ", num=" + num +
                ", opid=" + opid +
                ", parts=" + parts +
                ", pid=" + pid +
                ", totalamt=" + totalamt +
                '}';
    }
}
