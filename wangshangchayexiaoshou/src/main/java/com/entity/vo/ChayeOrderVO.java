package com.entity.vo;

import com.entity.ChayeOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 茶叶订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chaye_order")
public class ChayeOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单号
     */

    @TableField(value = "chaye_order_uuid_number")
    private String chayeOrderUuidNumber;


    /**
     * 收获地址
     */

    @TableField(value = "address_id")
    private Integer addressId;


    /**
     * 茶叶
     */

    @TableField(value = "chaye_id")
    private Integer chayeId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 购买数量
     */

    @TableField(value = "buy_number")
    private Integer buyNumber;


    /**
     * 实付价格
     */

    @TableField(value = "chaye_order_true_price")
    private Double chayeOrderTruePrice;


    /**
     * 快递公司
     */

    @TableField(value = "chaye_order_courier_name")
    private String chayeOrderCourierName;


    /**
     * 订单快递单号
     */

    @TableField(value = "chaye_order_courier_number")
    private String chayeOrderCourierNumber;


    /**
     * 订单类型
     */

    @TableField(value = "chaye_order_types")
    private Integer chayeOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "chaye_order_payment_types")
    private Integer chayeOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号
	 */
    public String getChayeOrderUuidNumber() {
        return chayeOrderUuidNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setChayeOrderUuidNumber(String chayeOrderUuidNumber) {
        this.chayeOrderUuidNumber = chayeOrderUuidNumber;
    }
    /**
	 * 设置：收获地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 获取：收获地址
	 */

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 设置：茶叶
	 */
    public Integer getChayeId() {
        return chayeId;
    }


    /**
	 * 获取：茶叶
	 */

    public void setChayeId(Integer chayeId) {
        this.chayeId = chayeId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 获取：购买数量
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getChayeOrderTruePrice() {
        return chayeOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setChayeOrderTruePrice(Double chayeOrderTruePrice) {
        this.chayeOrderTruePrice = chayeOrderTruePrice;
    }
    /**
	 * 设置：快递公司
	 */
    public String getChayeOrderCourierName() {
        return chayeOrderCourierName;
    }


    /**
	 * 获取：快递公司
	 */

    public void setChayeOrderCourierName(String chayeOrderCourierName) {
        this.chayeOrderCourierName = chayeOrderCourierName;
    }
    /**
	 * 设置：订单快递单号
	 */
    public String getChayeOrderCourierNumber() {
        return chayeOrderCourierNumber;
    }


    /**
	 * 获取：订单快递单号
	 */

    public void setChayeOrderCourierNumber(String chayeOrderCourierNumber) {
        this.chayeOrderCourierNumber = chayeOrderCourierNumber;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getChayeOrderTypes() {
        return chayeOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setChayeOrderTypes(Integer chayeOrderTypes) {
        this.chayeOrderTypes = chayeOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getChayeOrderPaymentTypes() {
        return chayeOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setChayeOrderPaymentTypes(Integer chayeOrderPaymentTypes) {
        this.chayeOrderPaymentTypes = chayeOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
