package com.cskaoyan.malldemo.controller;

import com.cskaoyan.malldemo.bean.*;
import com.cskaoyan.malldemo.service.CABService;
import com.cskaoyan.malldemo.service.GoodsService;
import com.cskaoyan.malldemo.vo.Vo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.List;
import java.util.jar.Attributes;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @Autowired
    CABService cABService;

    Vo vo = new Vo();

    // 显示数据
    @RequestMapping("list")
    public Vo list(int page, int limit, Goods goods){
        List<Goods> allGoods = goodsService.findAllGoods(page,limit,goods);
        int count = (int)goodsService.selectCount();
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",count);
        map.put("items",allGoods);
        vo.setData(map);
        String msg = "成功";
        vo.setErrmsg(msg);
        vo.setErrno(0);
        return vo;
    }

    // 删除一条数据
    @RequestMapping("delete")
    public HashMap<String, Object> delete(@RequestBody Goods goods){
        int i = goodsService.deleteGoods(goods);
        HashMap<String, Object> map = new HashMap<>();
        if(i!=0){
            map.put("errmsg","成功");
            map.put("errno",0);
        }
        return map;
    }

    @RequestMapping("catAndBrand")
    public Vo list() {
        List<Category> categorys = cABService.selectCategoryVLC();
        List<Brand> brandVL = cABService.selectBrandVL();
        List<Object> categoryList = new LinkedList<>();
        //封装每一个category为一个map
        if(categorys != null) {
            HashMap<String, Object> categoryMap = null;

            for(Category category : categorys) {
                categoryMap = new HashMap<>();
                categoryMap.put("value",category.getId());
                categoryMap.put("label",category.getName());
                LinkedList<Object> children = new LinkedList<>();
                HashMap<String, Object> childMap=null ;
                //封装每一个category的children为list
                for (Category child : category.getChildren()) {
                    //封装children为map
                    childMap = new HashMap<>();
                    childMap.put("value", child.getId());
                    childMap.put("label", child.getName());
                    children.add(childMap);
                }
                categoryMap.put("children",children);
                categoryList.add(categoryMap);
            }
        }
        HashMap<String, Object> data = new HashMap<>();
        data.put("categoryList",categoryList);
        data.put("brandList",brandVL);
        vo.setData(data);
        String msg = "成功";
        vo.setErrmsg(msg);
        vo.setErrno(0);
        return vo;
    }



    @RequestMapping("create")
//    public HashMap<String, Object> create(List<GoodsAttribute> attributes,Goods goods,List<GoodsProduct> products,List<GoodsSpecification> specifications) {
//    public HashMap<String, Object> create( @RequestBody GoodsAttribute attributes,@RequestBody Goods goods,@RequestBody GoodsProduct products ,@RequestBody GoodsSpecification specifications) {
    public HashMap<String, Object> create(@RequestBody Map<String,Object> jsonMap) throws InvocationTargetException, IllegalAccessException {



        Map goods = (Map) jsonMap.get("goods");
        Goods good = new Goods();
        BeanUtils.populate(good,goods);

        Integer insertGoods = goodsService.insertGoods(good);
        Integer goodsId = null;
        if(insertGoods != null) {
            goodsId = good.getId();
        }

        List<GoodsAttribute> attributes = (List<GoodsAttribute>) jsonMap.get("attributes");
        Map attributeMap = (Map) attributes.get(0);
        GoodsAttribute attribute = new GoodsAttribute();
        BeanUtils.populate(attribute,attributeMap);
        attribute.setGoodsId(goodsId);

        List<GoodsProduct> products = (List<GoodsProduct>) jsonMap.get("products");
        Map productMap = (Map) products.get(0);
        GoodsProduct product = new GoodsProduct();
        BeanUtils.populate(product,productMap);
        product.setGoodsId(goodsId);

        List<GoodsSpecification> specifications = (List<GoodsSpecification>) jsonMap.get("specifications");
        Map specificationMap = (Map) specifications.get(0);
        GoodsSpecification specification = new GoodsSpecification();
        BeanUtils.populate(specification,specificationMap);
        specification.setGoodsId(goodsId);

//        Map<String, Object> stringObjectMap = Json2Map.json2Map(jsonMap);
        int insertAll = goodsService.insertAll(attribute, product, specification);
        HashMap<String, Object> map = new HashMap<>();
        if(insertAll == 1){
            map.put("errmsg","成功");
            map.put("errno",0);
        }
//        BeanUtils.populate();
        return map;
    }

    @RequestMapping("detail")
    public Map detail(Integer id) {
        HashMap<String, Object> data = goodsService.selectDetail(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("data",data);
        if(data != null){
            map.put("errmsg","成功");
            map.put("errno",0);
        } else {
            map.put("errmsg","失败");
            map.put("errno",-1);
        }
        return map;
    }
}
