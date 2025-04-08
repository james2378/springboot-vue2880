package com.entity.view;

import com.entity.ChayeCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 茶叶收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chaye_collection")
public class ChayeCollectionView extends ChayeCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String chayeCollectionValue;



		//级联表 chaye
			/**
			* 茶叶名称
			*/
			private String chayeName;
			/**
			* 茶叶照片
			*/
			private String chayePhoto;
			/**
			* 茶叶类型
			*/
			private Integer chayeTypes;
				/**
				* 茶叶类型的值
				*/
				private String chayeValue;
			/**
			* 茶叶库存
			*/
			private Integer chayeKucunNumber;
			/**
			* 购买获得积分
			*/
			private Integer chayePrice;
			/**
			* 茶叶原价
			*/
			private Double chayeOldMoney;
			/**
			* 现价/积分
			*/
			private Double chayeNewMoney;
			/**
			* 点击次数
			*/
			private Integer chayeClicknum;
			/**
			* 赞数量
			*/
			private Integer zanNumber;
			/**
			* 踩数量
			*/
			private Integer caiNumber;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer chayeDelete;
			/**
			* 茶叶介绍
			*/
			private String chayeContent;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 余额
			*/
			private Double newMoney;
			/**
			* 总积分
			*/
			private Double yonghuSumJifen;
			/**
			* 现积分
			*/
			private Double yonghuNewJifen;
			/**
			* 会员等级
			*/
			private Integer huiyuandengjiTypes;
				/**
				* 会员等级的值
				*/
				private String huiyuandengjiValue;

	public ChayeCollectionView() {

	}

	public ChayeCollectionView(ChayeCollectionEntity chayeCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, chayeCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getChayeCollectionValue() {
				return chayeCollectionValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setChayeCollectionValue(String chayeCollectionValue) {
				this.chayeCollectionValue = chayeCollectionValue;
			}










				//级联表的get和set chaye
					/**
					* 获取： 茶叶名称
					*/
					public String getChayeName() {
						return chayeName;
					}
					/**
					* 设置： 茶叶名称
					*/
					public void setChayeName(String chayeName) {
						this.chayeName = chayeName;
					}
					/**
					* 获取： 茶叶照片
					*/
					public String getChayePhoto() {
						return chayePhoto;
					}
					/**
					* 设置： 茶叶照片
					*/
					public void setChayePhoto(String chayePhoto) {
						this.chayePhoto = chayePhoto;
					}
					/**
					* 获取： 茶叶类型
					*/
					public Integer getChayeTypes() {
						return chayeTypes;
					}
					/**
					* 设置： 茶叶类型
					*/
					public void setChayeTypes(Integer chayeTypes) {
						this.chayeTypes = chayeTypes;
					}


						/**
						* 获取： 茶叶类型的值
						*/
						public String getChayeValue() {
							return chayeValue;
						}
						/**
						* 设置： 茶叶类型的值
						*/
						public void setChayeValue(String chayeValue) {
							this.chayeValue = chayeValue;
						}
					/**
					* 获取： 茶叶库存
					*/
					public Integer getChayeKucunNumber() {
						return chayeKucunNumber;
					}
					/**
					* 设置： 茶叶库存
					*/
					public void setChayeKucunNumber(Integer chayeKucunNumber) {
						this.chayeKucunNumber = chayeKucunNumber;
					}
					/**
					* 获取： 购买获得积分
					*/
					public Integer getChayePrice() {
						return chayePrice;
					}
					/**
					* 设置： 购买获得积分
					*/
					public void setChayePrice(Integer chayePrice) {
						this.chayePrice = chayePrice;
					}
					/**
					* 获取： 茶叶原价
					*/
					public Double getChayeOldMoney() {
						return chayeOldMoney;
					}
					/**
					* 设置： 茶叶原价
					*/
					public void setChayeOldMoney(Double chayeOldMoney) {
						this.chayeOldMoney = chayeOldMoney;
					}
					/**
					* 获取： 现价/积分
					*/
					public Double getChayeNewMoney() {
						return chayeNewMoney;
					}
					/**
					* 设置： 现价/积分
					*/
					public void setChayeNewMoney(Double chayeNewMoney) {
						this.chayeNewMoney = chayeNewMoney;
					}
					/**
					* 获取： 点击次数
					*/
					public Integer getChayeClicknum() {
						return chayeClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setChayeClicknum(Integer chayeClicknum) {
						this.chayeClicknum = chayeClicknum;
					}
					/**
					* 获取： 赞数量
					*/
					public Integer getZanNumber() {
						return zanNumber;
					}
					/**
					* 设置： 赞数量
					*/
					public void setZanNumber(Integer zanNumber) {
						this.zanNumber = zanNumber;
					}
					/**
					* 获取： 踩数量
					*/
					public Integer getCaiNumber() {
						return caiNumber;
					}
					/**
					* 设置： 踩数量
					*/
					public void setCaiNumber(Integer caiNumber) {
						this.caiNumber = caiNumber;
					}
					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getChayeDelete() {
						return chayeDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setChayeDelete(Integer chayeDelete) {
						this.chayeDelete = chayeDelete;
					}
					/**
					* 获取： 茶叶介绍
					*/
					public String getChayeContent() {
						return chayeContent;
					}
					/**
					* 设置： 茶叶介绍
					*/
					public void setChayeContent(String chayeContent) {
						this.chayeContent = chayeContent;
					}
















				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}
					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}
					/**
					* 获取： 总积分
					*/
					public Double getYonghuSumJifen() {
						return yonghuSumJifen;
					}
					/**
					* 设置： 总积分
					*/
					public void setYonghuSumJifen(Double yonghuSumJifen) {
						this.yonghuSumJifen = yonghuSumJifen;
					}
					/**
					* 获取： 现积分
					*/
					public Double getYonghuNewJifen() {
						return yonghuNewJifen;
					}
					/**
					* 设置： 现积分
					*/
					public void setYonghuNewJifen(Double yonghuNewJifen) {
						this.yonghuNewJifen = yonghuNewJifen;
					}
					/**
					* 获取： 会员等级
					*/
					public Integer getHuiyuandengjiTypes() {
						return huiyuandengjiTypes;
					}
					/**
					* 设置： 会员等级
					*/
					public void setHuiyuandengjiTypes(Integer huiyuandengjiTypes) {
						this.huiyuandengjiTypes = huiyuandengjiTypes;
					}


						/**
						* 获取： 会员等级的值
						*/
						public String getHuiyuandengjiValue() {
							return huiyuandengjiValue;
						}
						/**
						* 设置： 会员等级的值
						*/
						public void setHuiyuandengjiValue(String huiyuandengjiValue) {
							this.huiyuandengjiValue = huiyuandengjiValue;
						}



}
