package tn.amira.customerservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.amira.customerservice.config.GlobalConfig;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {

    @Autowired
    private GlobalConfig globalConfig;

    @GetMapping("/TestConfig")
    public Map<String,Integer> configTest(){
        return Map.of();
    }

    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }

}
