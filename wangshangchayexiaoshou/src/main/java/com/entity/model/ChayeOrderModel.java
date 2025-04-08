package com.entity.model;

import com.entity.ChayeOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 茶叶订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChayeOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String chayeOrderUuidNumber;


    /**
     * 收获地址
     */
    private Integer addressId;


    /**
     * 茶叶
     */
    private Integer chayeId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 购买数量
     */
    private Integer buyNumber;


    /**
     * 实付价格
     */
    private Double chayeOrderTruePrice;


    /**
     * 快递公司
     */
    private String chayeOrderCourierName;


    /**
     * 订单快递单号
     */
    private String chayeOrderCourierNumber;


    /**
     * 订单类型
     */
    private Integer chayeOrderTypes;


    /**
     * 支付类型
     */
    private Integer chayeOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单号
	 */
    public String getChayeOrderUuidNumber() {
        return chayeOrderUuidNumber;
    }


    /**
	 * 设置：订单号
	 */
    public void setChayeOrderUuidNumber(String chayeOrderUuidNumber) {
        this.chayeOrderUuidNumber = chayeOrderUuidNumber;
    }
    /**
	 * 获取：收获地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 设置：收获地址
	 */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 获取：茶叶
	 */
    public Integer getChayeId() {
        return chayeId;
    }


    /**
	 * 设置：茶叶
	 */
    public void setChayeId(Integer chayeId) {
        this.chayeId = chayeId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 设置：购买数量
	 */
    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getChayeOrderTruePrice() {
        return chayeOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setChayeOrderTruePrice(Double chayeOrderTruePrice) {
        this.chayeOrderTruePrice = chayeOrderTruePrice;
    }
    /**
	 * 获取：快递公司
	 */
    public String getChayeOrderCourierName() {
        return chayeOrderCourierName;
    }


    /**
	 * 设置：快递公司
	 */
    public void setChayeOrderCourierName(String chayeOrderCourierName) {
        this.chayeOrderCourierName = chayeOrderCourierName;
    }
    /**
	 * 获取：订单快递单号
	 */
    public String getChayeOrderCourierNumber() {
        return chayeOrderCourierNumber;
    }


    /**
	 * 设置：订单快递单号
	 */
    public void setChayeOrderCourierNumber(String chayeOrderCourierNumber) {
        this.chayeOrderCourierNumber = chayeOrderCourierNumber;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getChayeOrderTypes() {
        return chayeOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setChayeOrderTypes(Integer chayeOrderTypes) {
        this.chayeOrderTypes = chayeOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getChayeOrderPaymentTypes() {
        return chayeOrderPaymentTypes;
    }


    /**
	 * 设置：支付类型
	 */
    public void setChayeOrderPaymentTypes(Integer chayeOrderPaymentTypes) {
        this.chayeOrderPaymentTypes = chayeOrderPaymentTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
