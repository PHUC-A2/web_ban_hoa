package com.example.quanlybanhoa.controller.user;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.quanlybanhoa.domain.model.SanPham;
import com.example.quanlybanhoa.service.SanPhamService;

@Controller
@RequestMapping("/user/sanpham")
public class SanPhamController {

    private final SanPhamService sanPhamService;

    public SanPhamController(SanPhamService sanPhamService) {
        this.sanPhamService = sanPhamService;
    }

    // Danh sách sản phẩm
    @GetMapping("/tatca")
    public String danhSachSanPham(Model model) {
        List<SanPham> list = sanPhamService.getTatCaSanPham();
        model.addAttribute("sanPhams", list);
        return "user/danhsach_sanpham";
    }

    // Chi tiết sản phẩm
    @GetMapping("/chitiet/{id}")
    public String chiTietSanPham(@PathVariable String id, Model model) {
        SanPham sp = sanPhamService.getSanPhamById(id);
        model.addAttribute("sanPham", sp);
        return "user/chitiet_sanpham";
    }

    // Tìm kiếm sản phẩm
    @GetMapping("/timkiem")
    public String timKiemSanPham(@RequestParam("keyword") String keyword, Model model) {
        List<SanPham> list = sanPhamService.timKiem(keyword);
        model.addAttribute("sanPhams", list);
        model.addAttribute("keyword", keyword);
        return "user/danhsach_sanpham";
    }
}
