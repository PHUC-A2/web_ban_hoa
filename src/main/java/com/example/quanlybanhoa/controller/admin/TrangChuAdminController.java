package com.example.quanlybanhoa.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrangChuAdminController {

    @GetMapping("/admin")
    public String trangChuAdmin() {
        return "admin/trang_chu_admin";
    }
}
