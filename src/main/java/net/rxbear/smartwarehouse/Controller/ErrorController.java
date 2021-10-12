package net.rxbear.smartwarehouse.Controller;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class ErrorController {
    @Configuration
    public class ErrorConfigurar implements ErrorPageRegistrar {

        @Override
        public void registerErrorPages(ErrorPageRegistry registry) {
            ErrorPage[] errorPages = new ErrorPage[2];
            errorPages[0] = new ErrorPage(HttpStatus.NOT_FOUND, "/error404");
            errorPages[1] = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error500");

            registry.addErrorPages(errorPages);
        }
    }


    @GetMapping("/error404")
    public String Error404(Model model){
        model.addAttribute("errorcode","404");
//        System.out.println(model);
        return "error";
    }
    @GetMapping("/error500")
    public String Error500(Model model) {
        model.addAttribute("errorcode","500");
//        System.out.println(model);
        return "error";
    }
    @GetMapping("/test")

    public String test(Map<String,Object> map){

        map.put("hello","Hello World!");

        return "test";

    }
}
