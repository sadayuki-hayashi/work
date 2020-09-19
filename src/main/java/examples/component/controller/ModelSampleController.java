package examples.component.controller;

import examples.entity.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelSampleController {

    public ModelSampleController(){
        super();
    }

    @RequestMapping(value = "/model_sample.do", method = RequestMethod.GET)
    public ModelAndView handleRequest(){
        String viewName = "model_view";

        ProductModel productModel = new ProductModel();
        productModel.setName("pen");
        productModel.setPrice(100);

        return new ModelAndView(viewName, "product", productModel);
    }
}
