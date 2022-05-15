package com.IshanAdeepaRidma.BidCoinBackend;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorController1 implements ErrorController{
    private final static String PATH = "/error";

    @RequestMapping(PATH)
    @ResponseBody
    public showError getErrorPath() {
        return new showError();
    }

}

class showError {
    private String status = "Error - Please check if the url is correct and the request body is correct";

    public String getStatus(){
        return status;
    }
}