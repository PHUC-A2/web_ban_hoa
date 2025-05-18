package com.example.quanlybanhoa.controller;

import com.example.quanlybanhoa.domain.model.SanPham;
import com.example.quanlybanhoa.repository.SanPhamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TrangChuController {

    private final SanPhamRepository sanPhamRepo;

    public TrangChuController(SanPhamRepository sanPhamRepo) {
        this.sanPhamRepo = sanPhamRepo;
    }

    @GetMapping("/")
    public String trangChu(Model model) {
        List<SanPham> sanPhams = sanPhamRepo.findAll(); // Lấy tất cả sản phẩm
        model.addAttribute("sanPhams", sanPhams); // Gửi sang Thymeleaf
        return "trang_chu"; // nằm trong templates/
    }
}
