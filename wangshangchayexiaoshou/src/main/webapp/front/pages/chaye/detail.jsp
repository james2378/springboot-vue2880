<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>

<!-- 首页 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>首页</title>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <link rel="stylesheet" href="../../xznstatic/css/bootstrap.min.css" />
    <!-- 样式 -->
    <link rel="stylesheet" href="../../css/style.css"/>
    <!-- 主题（主要颜色设置） -->
    <link rel="stylesheet" href="../../css/theme.css"/>
    <!-- 通用的css -->
    <link rel="stylesheet" href="../../css/common.css"/>
</head>
<style>
    /*.data-detail .title {
        font-size:35px;
        line-height:100%;
        font-weight:700;
        color:#4b4b46;
        margin-top:-4px;
        margin-bottom:24px;
        border:none;
    }
    .data-detail .detail-item {
        font-size:16px;
        line-height:50px;
        color:#4b4b46;
        background:#f3f3f9;
        border:1px solid rgba(75,75,70,.07);
        border-radius:7px;
        padding:0 35px;
        margin-bottom:15px;
        width: auto;
    }
    div .detail-item span:nth-child(1) {
        font-size:18px;
        font-weight:700;
        width:40%
    }*/</style>
<body>

    <div id="app">
        <div class="data-detail">
            <div class="data-detail-breadcrumb">
                <span class="layui-breadcrumb">
                    <a href="../home/home.jsp">首页</a>
                    <a><cite>{{detail.chayeName}}</cite></a>
                </span>

                <!-- 收藏 -->
                <a v-if='storeupFlag' onclick="addChayeCollection()" href="javascript:void(0)">
                    <i class="layui-icon" style="font-size: 20px;color: red;">&#xe67a;</i>取消收藏
                </a>
                <a v-if='!storeupFlag' onclick="addChayeCollection()" href="javascript:void(0)">
                    <i class="layui-icon" style="font-size: 20px;color: red;">&#xe67b;</i>点我收藏
                </a>

            </div>
            <div class="layui-row">
                <div class="layui-col-md5">
                    <div class="layui-carousel" id="swiper">
                        <div carousel-item id="swiper-item">
                            <div v-for="(item,index) in swiperList" v-bind:key="index">
                                <img class="swiper-item" :src="item.img">
                            </div>
                        </div>
                    </div>

                        <div class="tool-container">
                            <!-- 没有赞 没有踩 -->
                            <div v-if="zanFlag == 0 && caiFlag == 0" onclick="zanNumberClick()" style="display: flex;align-items: center;">
                                <i class="layui-icon" style="font-size: 20px;color: red;margin-right: 10px;">&#xe6af;</i>
                                赞一下({{detail.zanNumber}})
                            </div>
                            <div v-if="zanFlag == 0 && caiFlag == 0" onclick="caiNumberClick()" style="display: flex;align-items: center;">
                                <i class="layui-icon" style="font-size: 20px;color: red;margin-right: 10px;">&#xe69c;</i>
                                踩一下({{detail.caiNumber}})
                            </div>

                            <!-- 已赞 -->
                            <div v-if="zanFlag == 1" onclick="zanNumberClick()" style="display: flex;align-items: center;">
                                <i class="layui-icon" style="font-size: 20px;color: red;margin-right: 10px;">&#xe6af;</i>
                                已赞({{detail.zanNumber}})
                            </div>

                            <!-- 已踩 -->
                            <div v-if="caiFlag == 1" onclick="caiNumberClick()" style="display: flex;align-items: center;">
                                <i class="layui-icon" style="font-size: 20px;color: red;margin-right: 10px;">&#xe6af;</i>
                                已踩({{detail.caiNumber}})
                            </div>
                        </div>

                </div>
                <div class="layui-col-md7" style="padding-left: 20px;">
                        <h1 class="title">{{detail.chayeName}}</h1>

                        <div v-if="detail.chayeTypes" class="detail-item">
                            <span>茶叶类型：</span>
                            <span class="desc">
                                {{detail.chayeValue}}
                            </span>
                        </div>

                        <div v-if="detail.chayeKucunNumber" class="detail-item">
                            <span>茶叶库存：</span>
                            <span class="desc">
                                {{detail.chayeKucunNumber}}
                            </span>
                        </div>

                        <div v-if="detail.chayePrice" class="detail-item">
                            <span>购买获得积分：</span>
                            <span class="desc">
                                {{detail.chayePrice}}
                            </span>
                        </div>

                        <div v-if="detail.chayeOldMoney" class="detail-item">
                            <span>茶叶原价：</span>
                            <span class="desc">
                                        {{detail.chayeOldMoney}}
                            </span>
                        </div>

                        <div v-if="detail.chayeNewMoney" class="detail-item">
                            <span>现价/积分：</span>
                            <span class="desc">
                                        {{detail.chayeNewMoney}}
                            </span>
                        </div>

                        <div v-if="detail.chayeClicknum" class="detail-item">
                            <span>点击次数：</span>
                            <span class="desc">
                                {{detail.chayeClicknum}}
                            </span>
                        </div>

                        <div v-if="detail.zanNumber" class="detail-item">
                            <span>赞数量：</span>
                            <span class="desc">
                                {{detail.zanNumber}}
                            </span>
                        </div>

                        <div v-if="detail.caiNumber" class="detail-item">
                            <span>踩数量：</span>
                            <span class="desc">
                                {{detail.caiNumber}}
                            </span>
                        </div>

                    <div class="detail-item">

                        <!--<button onclick="addChayeqqqqqqqq()" type="button" class="layui-btn layui-btn-warm">
                                添加到购物车
                            </button>-->
                            <div class="num-picker">
                                <button type="button" onclick="reduceBuynumber()" class="layui-btn layui-btn-primary">
                                    -
                                </button>
                                <input type="text" id="buyNumber" name="buyNumber" class="layui-input" disabled="disabled" />
                                <button type="button" onclick="plusBuynumber()" class="layui-btn layui-btn-primary">
                                    +
                                </button>
                            </div>
                            <button onclick="addChayeCart()" type="button" class="layui-btn layui-btn-warm">
                                添加到购物车
                            </button>
                            <button onclick="addChayeOrder()" type="button" class="layui-btn btn-submit">
                                立即购买
                            </button>
                    </div>

                    <div class="detail-item" style="text-align: right;">
                    </div>
                </div>
            </div>

            <div class="layui-row">
                <div class="layui-tab layui-tab-card">

                    <ul class="layui-tab-title">
                            <li class="layui-this">详情</li>
                            <li>评价</li>
                    </ul>

                    <div class="layui-tab-content">
                            <div class="layui-tab-item layui-show">
                                <div v-html="myFilters(detail.chayeContent)"></div>
                            </div>

                            <div class="layui-tab-item">
                                <div class="message-container">
                                    <div class="message-list">
                                        <div class="message-item" v-for="(item,index) in chayeCommentbackDataList" v-bind:key="index">
                                            <div class="username-container">
                                                <img class="avator" :src="item.yonghuPhoto">
                                                <span class="username">
                                                    {{item.yonghuName}}
                                                </span>
                                            </div>
                                            <div class="content">
                                                    <span style="color: rgb(175, 135, 77)">
                                                        评价:<div v-html="item.chayeCommentbackText"></div>
                                                    </span>
                                            </div>
                                            <div class="content">
                                                    <span style="color: rgb(175, 135, 77)">
                                                        回复:<div v-html="item.replyText"></div>
                                                    </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="pager" id="chayeCommentbackPager"></div>
                                </div>
                            </div>


                    </div>
                </div>
            </div>
        </div>    </div>

<script type="text/javascript" src="../../xznstatic/js/jquery.min.js"></script>
<script src="../../xznstatic/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../../layui/layui.js"></script>
<script src="../../js/vue.js"></script>
<!-- 组件配置信息 -->
<script src="../../js/config.js"></script>
<!-- 扩展插件配置信息 -->
<script src="../../modules/config.js"></script>
<!-- 工具方法 -->
<script src="../../js/utils.js"></script>

<script>
    Vue.prototype.myFilters= function (msg) {
        if(msg != null){
            return msg.replace(/\n/g, "<br>");
        }else{
            return "";
        }
    };
    var vue = new Vue({
        el: '#app',
        data: {
            // 轮播图
            swiperList: [],
            // 数据详情
            detail: {
                id: 0
            },
            // 商品标题
            title: '',

            storeupFlag: 0,//收藏 [0为收藏 1已收藏]
            zanFlag: 0,//赞 [0 未赞 1 已赞]
            caiFlag: 0,//踩 [0 未踩 1 已踩]
            //系统推荐
            chayeRecommendList: [],
            dataList: [],
            // 加入购物车数量
            buyNumber: 1,
            // 当前详情页表
            detailTable: 'chaye',
            // 评价列表
            chayeCommentbackDataList: [],
        },
        //  清除定时器
        destroyed: function () {
            // 不知道具体作用
            // window.clearInterval(this.inter);
        },
        methods: {
            jump(url) {
                jump(url)
            }
        }
    });

    layui.use(['layer', 'form', 'element', 'carousel', 'http', 'jquery', 'laypage'], function () {
        var layer = layui.layer;
        var element = layui.element;
        var form = layui.form;
        var carousel = layui.carousel;
        var http = layui.http;
        var jquery = layui.jquery;
        var laypage = layui.laypage;

        var limit = 10;

        // 设置数量
        jquery('#buyNumber').val(vue.buyNumber);

        // 数据ID
        var id = http.getParam('id');
        vue.detail.id = id;
        // 当前详情
        http.request(`${vue.detailTable}/detail/` + id, 'get', {}, function (res) {
            // 详情信息
            vue.detail = res.data;
            vue.title = vue.detail.chayeName;
           // 轮播图片
            vue.swiperList = vue.detail.chayePhoto ? vue.detail.chayePhoto.split(",") : [];
            var swiperItemHtml = '';
            for (let item of vue.swiperList) {
                swiperItemHtml +=
                        '<div>' +
                        '<img class="swiper-item" src="' + item + '" style="margin-top: 50px;" >' +
                        '</div>';
            }
            jquery('#swiper-item').html(swiperItemHtml);
            // 轮播图
            carousel.render({
                elem: '#swiper',
                width: swiper.width, height: swiper.height,
                arrow: swiper.arrow,
                anim: swiper.anim,
                interval: swiper.interval,
                indicator: swiper.indicator
            });
        });

        // 系统推荐
        http.request(`chaye/list`, 'get', {
            page: 1,
            limit: 5,
            chayeTypes: vue.detail.chayeTypes,
            chayeDelete: 1,







                shangxiaTypes: vue.detail.shangxiaTypes,

        }, function (res) {
            vue.chayeRecommendList = res.data.list;
        });



        // 获取评价
        http.request(`${vue.detailTable}Commentback/list`, 'get', {
            page: 1,
            limit: limit,
            chayeId: vue.detail.id
        }, function (res) {
            vue.chayeCommentbackDataList = res.data.list;
            // 分页
            laypage.render({
                elem: 'chayeCommentbackPager',
                count: res.data.total,
                limit: limit,
                jump: function (obj, first) {
                    //首次不执行
                    if (!first) {
                        http.request(`${vue.detailTable}Commentback/list`, 'get', {
                            page: obj.curr,
                            limit: obj.limit,
                            chayeId: vue.detail.id
                        }, function (res) {
                            vue.chayeCommentbackDataList = res.data.list
                        })
                    }
                }
            });
        });
        if (localStorage.getItem('userid')) {
            http.request('chayeCollection/list', 'get', {
                page: 1,
                limit: 1,
                chayeId: vue.detail.id,
                yonghuId: localStorage.getItem('userid'),
            }, function (res) {
                if(res.data.total >0){
                    res.data.list.forEach(element => {
                        if (element.chayeCollectionTypes == 1) {
                            vue.storeupFlag = 1;
                        }
                        if (element.chayeCollectionTypes == 2) {
                            vue.zanFlag = 1;
                        }
                        if (element.chayeCollectionTypes == 3) {
                            vue.caiFlag = 1;
                        }
                    });

                }
            });
        }

    });



    // 收藏
    function addChayeCollection(){
        layui.http.request('chayeCollection/list', 'get', {
            page: 1,
            limit: 1,
            chayeId: vue.detail.id,
            chayeCollectionTypes: 1,
            yonghuId: localStorage.getItem('userid'),
        }, (res) => {
            if (res.data.list.length == 1) {
                layui.http.requestJson('chayeCollection/delete', 'post', [res.data.list[0].id], function (res) {
                    layui.layer.msg('取消成功', {
                        time: 1000,
                        icon: 5
                    }, function () {
                        window.location.reload();
                    });
                });
                return false;
            }
            layui.http.requestJson('chayeCollection/add', 'post', {
                yonghuId: localStorage.getItem('userid'),
                chayeId: vue.detail.id,
                chayeCollectionTypes: 1,
            }, function (res) {
                layui.layer.msg('收藏成功', {
                    time: 1000,
                    icon: 6
                }, function () {
                    window.location.reload();
                });
            });
        });
    }

    // 添加数量
    function plusBuynumber() {
        vue.buyNumber++;
        layui.jquery('#buyNumber').val(vue.buyNumber);
    }
    // 减少数量
    function reduceBuynumber() {
        if(vue.buyNumber>1){
            vue.buyNumber--;
        }
        layui.jquery('#buyNumber').val(vue.buyNumber);
    }

    // 添加到购物车
    function addChayeCart(){
        if (vue.detail.chayeKucunNumber > 0 && vue.detail.chayeKucunNumber < vue.buyNumber) {
            layer.msg(`库存不足`, {
                time: 2000,
                icon: 5
            });
            return false;
        }
        // 查询是否已经添加到购物车
        layui.http.request('cart/list', 'get', {
            yonghuId: localStorage.getItem('userid'),
            chayeId: vue.detail.id
        }, (res) => {
            if(res.data.list.length > 0){
                layer.msg("该茶叶已经添加到购物车", {
                    time: 2000,
                    icon: 5
                });
                return false
            }
            layui.http.requestJson(`cart/add`, 'post', {
                yonghuId : localStorage.getItem('userid'),
                chayeId : vue.detail.id,
                buyNumber: vue.buyNumber,
            }, function (res) {
                if(res.code==0){
                    layer.msg('添加到购物车成功', {
                        time: 2000,
                        icon: 6
                    });
                }else{
                    layer.msg(res.msg, {
                        time: 2000,
                        icon: 2
                    });
                }
            });
        })
    }

    // 立即购买
    function addChayeOrder(){
        if (vue.detail.chayeKucunNumber > 0 && vue.detail.chayeKucunNumber < vue.buyNumber) {
            layer.msg(`茶叶库存不足`, {
                time: 2000,
                icon: 5
            });
            return false;
        }
        // 保存到storage中，在确认下单页面中获取要购买的物品
        localStorage.setItem('chayes', JSON.stringify([{
            chayeId: vue.detail.id,
            chayeName: vue.detail.chayeName,
            chayePhoto: vue.detail.chayePhoto,
            chayeTypes: vue.detail.chayeTypes,
            chayeKucunNumber: vue.detail.chayeKucunNumber,
            chayePrice: vue.detail.chayePrice,
            chayeOldMoney: vue.detail.chayeOldMoney,
            chayeNewMoney: vue.detail.chayeNewMoney,
            chayeClicknum: vue.detail.chayeClicknum,
            zanNumber: vue.detail.zanNumber,
            caiNumber: vue.detail.caiNumber,
            shangxiaTypes: vue.detail.shangxiaTypes,
            chayeDelete: vue.detail.chayeDelete,
            chayeContent: vue.detail.chayeContent,
            createTime: vue.detail.createTime,
            buyNumber: vue.buyNumber,
            yonghuId: localStorage.getItem('userid'),
        }]));
        // 跳转到确认下单页面
        jump('../chayeOrder/confirm.jsp');
    }


    // 赞
    function zanNumberClick(){
        layui.http.request('chayeCollection/list', 'get', {
            page: 1,
            limit: 1,
                chayeId: vue.detail.id,
                chayeCollectionTypes: 2,
                yonghuId: localStorage.getItem('userid'),
        }, (res) => {
            if (res.data.total == 1) {
                layui.http.requestJson('chayeCollection/delete', 'post', [res.data.list[0].id], function (res) {
                    vue.detail.zanNumber = vue.detail.zanNumber - 1;
                    layui.http.requestJson(`chaye/update`, 'POST',vue.detail, (res1) => {
                        if(res1.code==0){
                            layui.layer.msg('取消点赞成功', {
                                time: 1000,
                                icon: 6
                            }, function () {
                                vue.zanFlag =0;
                            });
                        }else{
                            layui.layer.msg('取消点赞失败', {
                                time: 1000,
                                icon: 5
                            }, function () {
                                return false;
                            });
                        }
                    });
                });
            }else{
                layui.http.requestJson('chayeCollection/add', 'post', {
                        yonghuId: localStorage.getItem('userid'),
                        chayeId: vue.detail.id,
                        chayeCollectionTypes: 2,
                }, function (res) {
                    vue.detail.zanNumber = vue.detail.zanNumber + 1;
                    layui.http.requestJson(`chaye/update`, 'POST', vue.detail, (res1) => {
                        if(res1.code==0){
                            layui.layer.msg('点赞成功', {
                                time: 1000,
                                icon: 6
                            }, function () {
                                vue.zanFlag =1;
                            });
                        }else{
                            layui.layer.msg('点赞失败', {
                                time: 1000,
                                icon: 5
                            }, function () {
                                return false;
                            });
                        }
                    });
                });
            }
        });
    }

    // 踩
    function caiNumberClick(){
        layui.http.request('chayeCollection/list', 'get', {
            page: 1,
            limit: 1,
                chayeId: vue.detail.id,
                chayeCollectionTypes: 3,
                yonghuId: localStorage.getItem('userid'),
        }, (res) => {
            if (res.data.total == 1) {
                layui.http.requestJson('chayeCollection/delete', 'post', [res.data.list[0].id], function (res) {
                    vue.detail.caiNumber = vue.detail.caiNumber - 1;
                    layui.http.requestJson(`chaye/update`, 'POST',vue.detail, (res1) => {
                        if(res1.code==0){
                            layui.layer.msg('取消点踩成功', {
                                time: 1000,
                                icon: 6
                            }, function () {
                                vue.caiFlag =0;
                            });
                        }else{
                            layui.layer.msg('取消点踩失败', {
                                time: 1000,
                                icon: 5
                            }, function () {
                                return false;
                            });
                        }
                    });
                });
            }else{
                layui.http.requestJson('chayeCollection/add', 'post', {
                        yonghuId: localStorage.getItem('userid'),
                        chayeId: vue.detail.id,
                        chayeCollectionTypes: 3,
                }, function (res) {
                    vue.detail.caiNumber = vue.detail.caiNumber + 1;
                    layui.http.requestJson(`chaye/update`, 'POST',vue.detail, (res1) => {
                        if(res1.code==0){
                            layui.layer.msg('点踩成功', {
                                time: 1000,
                                icon: 6
                            }, function () {
                                vue.caiFlag =1;
                            });
                        }else{
                            layui.layer.msg('点踩失败', {
                                time: 1000,
                                icon: 5
                            }, function () {
                                return false;
                            });
                        }
                    });
                });
            }
        });
    }


</script>
</body>
</html>
