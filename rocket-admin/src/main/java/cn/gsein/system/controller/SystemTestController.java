package cn.gsein.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author G.Seinfeld
 * @date 2018/12/24
 */
@RestController
@RequestMapping("/system/test")
public class SystemTestController {

    @RequestMapping("/node")
    public String testNode() {
        return "I'm here to receive requests from node!";
    }
}
