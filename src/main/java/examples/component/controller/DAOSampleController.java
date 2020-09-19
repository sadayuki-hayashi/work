package examples.component.controller;

import examples.component.repository.DataAccessObjectSample;
import examples.entity.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DAOSampleController {
    private final DataAccessObjectSample dao;

    public DAOSampleController(DataAccessObjectSample dao) {
        super();
        this.dao = dao;
    }

    @RequestMapping(value="/dao_sample.do", method= RequestMethod.GET)
    public ModelAndView handleRequest(){
        ProductModel productModel = this.dao.getProduct();
        String name = "examples/dao_sample";
        return new ModelAndView(name, "product", productModel);
    }

    @RequestMapping(value="/product/entry.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String executeEntry(){
        try{
            this.dao.entryProduct();
            return "success !";
        }
        catch(Exception e){
            e.printStackTrace();
            return "failure !";
        }
    }

    @RequestMapping(value="/product/list.do", method=RequestMethod.GET)
    public ModelAndView showList(){
        List<ProductModel> list = this.dao.getProducts();
        String name = "examples/list_sample";
        return new ModelAndView(name, "products", list);
    }
}

