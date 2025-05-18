package com.example.quanlybanhoa.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrangChuUserController {
    @GetMapping("/user")
    public String trangChu() {
        return "user/trang_chu_user";
    }

}
