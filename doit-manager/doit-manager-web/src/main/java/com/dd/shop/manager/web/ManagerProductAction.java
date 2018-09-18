package com.dd.shop.manager.web;

import com.dd.shop.common.core.JsonUtils;
import com.dd.shop.common.core.PropKit;
import com.dd.shop.common.core.StrKit;
import com.dd.shop.common.fdfs.FastDFSFile;
import com.dd.shop.common.fdfs.FastDFSUtils;
import com.dd.shop.common.pojo.dto.PageInfo;
import com.dd.shop.common.pojo.dto.ProductResult;
import com.dd.shop.manager.pojo.po.Product;
import com.dd.shop.manager.pojo.vo.ProductCustom;
import com.dd.shop.manager.pojo.vo.ProductQuery;
import com.dd.shop.manager.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ManagerProductAction {

    //初始化logger
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //依赖注入
    @Autowired
    public ProductService productService;

    //分页查询
    @ResponseBody
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public ProductResult<ProductCustom> listProductsSelectByPage(PageInfo page, ProductQuery query) {

        ProductResult<ProductCustom> result = null;
        try {
            result = productService.listProductsByPage(page, query);
        } catch (Exception e) {
            //通过logback将异常打印日志中,ConsoleAppender FileAppender
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    //数组,List
    //批量删除
    @ResponseBody
    @RequestMapping(value = "/item/batch", method = RequestMethod.POST)
    public int updateProductsByIds(@RequestParam("ids[]") List<Integer> ids) {

        int i = 0;
        try {

            i = productService.updateProductsByIds(ids);
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }

    //增
    @ResponseBody
    @RequestMapping(value = "/item/add", method = RequestMethod.POST)
    public String saveProducts(Product product) {

        int i = 0;
        try {

            i = productService.insertProducts(product);

            if (i == 1) {

                return "1";
            } else {

                return "0";
            }

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return "1";
    }

    //修改状态
    @ResponseBody
    @RequestMapping(value = "/item/status", method = RequestMethod.POST)
    public int updateProductsStatus(Product product) {

        int i = 0;
        try {

            i = productService.updateProductStatus(product);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return i;
    }

    //图片上传
    @ResponseBody
    @RequestMapping(value = "/uploadImage",method = RequestMethod.POST)
    public String uploadImage(@RequestParam MultipartFile file, HttpSession session) {

        Map<String, Object> map = new HashMap<String, Object>();
        String jsonString = "";
        try {
            //将文件上传到fdfs
            //初始化实体类
            FastDFSFile fastDFSFile = new FastDFSFile(file.getBytes(), file.getOriginalFilename(), file.getSize());
            //上传
            String filePath = FastDFSUtils.uploadFile(fastDFSFile);
            System.out.println(filePath+"-------------");
            //回显到富文本编辑器中
            String basePath = PropKit.use("fdfs_client.conf").get("fdfs_server");
            System.out.println(basePath+"=-=-=-=-=--=-=-=-=-");
            //判断filePath是否为空,不为空上传成功
            if (StrKit.notBlank(filePath)) {
                //不为空
                map.put("code", 0);
                map.put("msg", "success");
                Map<String, Object> dataMap = new HashMap<String, Object>();
                dataMap.put("src", basePath + "/" + filePath);
                map.put("data", dataMap);

                String images = basePath + "/" + filePath;
                session.removeAttribute("images");
                session.setAttribute("images",images);


            } else {
                map.put("code", 1);
                map.put("msg", "file");
                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("src", basePath + "/" + filePath);
                map.put("data", dataMap);

            }
            jsonString = JsonUtils.objectToJson(map);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);

        }

        return jsonString;
    }

    //修改

    @RequestMapping(value = "/pages/item/edit",method = RequestMethod.GET)
    public String find(Integer id,Model model) {

        System.out.println(id+"------------");

        Product product= null;
        try {
            product = productService.findProduct(id);
            model.addAttribute("product",product);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return "/pages/item/edit";
    }

    @ResponseBody
    @RequestMapping(value = "/item/update", method = RequestMethod.POST)
    public String modifyProduct(Product product) {

        System.out.println(product+"------------");
        System.out.println(product.getId()+"!!!!!!!!!!!!!!!!!");
        System.out.println(product.getTitle()+"qqqqqqq");
        System.out.println(product.getSubtitle()+"wwwwwwww");

        try {
           productService.modifyProduct(product);
        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return "1";
    }

    /*@ResponseBody
    @RequestMapping(value = "/item/indexlib/import",method = RequestMethod.POST)
    public void importIndex(){

        //1.采集数据(从数据库中)

        //2 遍历列表--> DocumentList
        //for(SearchItem item:list){
        // SolrInputDocument document =new SolrInputDocument();
        // document.addField("item_title",item.getTitle());
        // solrServer.add(document);
        // }


        //3 提交
        //solrServer.commit();


    }*/







}
