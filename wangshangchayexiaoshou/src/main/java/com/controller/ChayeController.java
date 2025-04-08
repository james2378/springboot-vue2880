
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 茶叶
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chaye")
public class ChayeController {
    private static final Logger logger = LoggerFactory.getLogger(ChayeController.class);

    @Autowired
    private ChayeService chayeService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("chayeDeleteStart",1);params.put("chayeDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = chayeService.queryPage(params);

        //字典表数据转换
        List<ChayeView> list =(List<ChayeView>)page.getList();
        for(ChayeView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChayeEntity chaye = chayeService.selectById(id);
        if(chaye !=null){
            //entity转view
            ChayeView view = new ChayeView();
            BeanUtils.copyProperties( chaye , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ChayeEntity chaye, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chaye:{}",this.getClass().getName(),chaye.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ChayeEntity> queryWrapper = new EntityWrapper<ChayeEntity>()
            .eq("chaye_name", chaye.getChayeName())
            .eq("chaye_types", chaye.getChayeTypes())
            .eq("chaye_kucun_number", chaye.getChayeKucunNumber())
            .eq("chaye_price", chaye.getChayePrice())
            .eq("chaye_clicknum", chaye.getChayeClicknum())
            .eq("zan_number", chaye.getZanNumber())
            .eq("cai_number", chaye.getCaiNumber())
            .eq("shangxia_types", chaye.getShangxiaTypes())
            .eq("chaye_delete", chaye.getChayeDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChayeEntity chayeEntity = chayeService.selectOne(queryWrapper);
        if(chayeEntity==null){
            chaye.setChayeClicknum(1);
            chaye.setShangxiaTypes(1);
            chaye.setChayeDelete(1);
            chaye.setCreateTime(new Date());
            chayeService.insert(chaye);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChayeEntity chaye, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chaye:{}",this.getClass().getName(),chaye.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ChayeEntity> queryWrapper = new EntityWrapper<ChayeEntity>()
            .notIn("id",chaye.getId())
            .andNew()
            .eq("chaye_name", chaye.getChayeName())
            .eq("chaye_types", chaye.getChayeTypes())
            .eq("chaye_kucun_number", chaye.getChayeKucunNumber())
            .eq("chaye_price", chaye.getChayePrice())
            .eq("chaye_clicknum", chaye.getChayeClicknum())
            .eq("zan_number", chaye.getZanNumber())
            .eq("cai_number", chaye.getCaiNumber())
            .eq("shangxia_types", chaye.getShangxiaTypes())
            .eq("chaye_delete", chaye.getChayeDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChayeEntity chayeEntity = chayeService.selectOne(queryWrapper);
        if("".equals(chaye.getChayePhoto()) || "null".equals(chaye.getChayePhoto())){
                chaye.setChayePhoto(null);
        }
        if(chayeEntity==null){
            chayeService.updateById(chaye);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<ChayeEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ChayeEntity chayeEntity = new ChayeEntity();
            chayeEntity.setId(id);
            chayeEntity.setChayeDelete(2);
            list.add(chayeEntity);
        }
        if(list != null && list.size() >0){
            chayeService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ChayeEntity> chayeList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ChayeEntity chayeEntity = new ChayeEntity();
//                            chayeEntity.setChayeName(data.get(0));                    //茶叶名称 要改的
//                            chayeEntity.setChayePhoto("");//照片
//                            chayeEntity.setChayeTypes(Integer.valueOf(data.get(0)));   //茶叶类型 要改的
//                            chayeEntity.setChayeKucunNumber(Integer.valueOf(data.get(0)));   //茶叶库存 要改的
//                            chayeEntity.setChayePrice(Integer.valueOf(data.get(0)));   //购买获得积分 要改的
//                            chayeEntity.setChayeOldMoney(data.get(0));                    //茶叶原价 要改的
//                            chayeEntity.setChayeNewMoney(data.get(0));                    //现价/积分 要改的
//                            chayeEntity.setChayeClicknum(Integer.valueOf(data.get(0)));   //点击次数 要改的
//                            chayeEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞数量 要改的
//                            chayeEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩数量 要改的
//                            chayeEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            chayeEntity.setChayeDelete(1);//逻辑删除字段
//                            chayeEntity.setChayeContent("");//照片
//                            chayeEntity.setCreateTime(date);//时间
                            chayeList.add(chayeEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        chayeService.insertBatch(chayeList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = chayeService.queryPage(params);

        //字典表数据转换
        List<ChayeView> list =(List<ChayeView>)page.getList();
        for(ChayeView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChayeEntity chaye = chayeService.selectById(id);
            if(chaye !=null){

                //点击数量加1
                chaye.setChayeClicknum(chaye.getChayeClicknum()+1);
                chayeService.updateById(chaye);

                //entity转view
                ChayeView view = new ChayeView();
                BeanUtils.copyProperties( chaye , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ChayeEntity chaye, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chaye:{}",this.getClass().getName(),chaye.toString());
        Wrapper<ChayeEntity> queryWrapper = new EntityWrapper<ChayeEntity>()
            .eq("chaye_name", chaye.getChayeName())
            .eq("chaye_types", chaye.getChayeTypes())
            .eq("chaye_kucun_number", chaye.getChayeKucunNumber())
            .eq("chaye_price", chaye.getChayePrice())
            .eq("chaye_clicknum", chaye.getChayeClicknum())
            .eq("zan_number", chaye.getZanNumber())
            .eq("cai_number", chaye.getCaiNumber())
            .eq("shangxia_types", chaye.getShangxiaTypes())
            .eq("chaye_delete", chaye.getChayeDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChayeEntity chayeEntity = chayeService.selectOne(queryWrapper);
        if(chayeEntity==null){
            chaye.setChayeDelete(1);
            chaye.setCreateTime(new Date());
        chayeService.insert(chaye);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
