package com.amk.action;

import com.amk.utils.HttpClientUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/")
public class Pay {

    @RequestMapping(value = "/pay/{account}/{money}",method = RequestMethod.PUT)
    public String pay(@PathVariable("account")String account,@PathVariable("money")double money){

        //访问Pay服务

        return HttpClientUtil.getData("/pay/"+account+"/"+money);
    }

}
