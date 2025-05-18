package com.example.quanlybanhoa.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.quanlybanhoa.domain.model.SanPham;
import com.example.quanlybanhoa.service.SanPhamService;

@Controller
@RequestMapping("/admin/sanpham")
public class QuanLySanPhamController {

    private final SanPhamService sanPhamService;

    public QuanLySanPhamController(SanPhamService sanPhamService) {
        this.sanPhamService = sanPhamService;
    }

    // Danh sách sản phẩm
    @GetMapping("/tatca")
    public String danhSachSanPham(Model model) {
        List<SanPham> list = sanPhamService.getTatCaSanPham();
        model.addAttribute("sanPhams", list);
        return "admin/danhsach_sanpham";
    }

    // Chi tiết sản phẩm
    @GetMapping("/chitiet/{id}")
    public String chiTietSanPham(@PathVariable String id, Model model) {
        SanPham sp = sanPhamService.getSanPhamById(id);
        model.addAttribute("sanPham", sp);
        return "admin/chitiet_sanpham";
    }

    // Thêm sản phẩm
    @GetMapping("/them")
    public String themSanPhamForm(Model model) {
        model.addAttribute("sanPham", new SanPham());
        return "admin/them_sanpham";
    }

    @PostMapping("/them")
    public String themSanPhamSubmit(@ModelAttribute SanPham sanPham) {
        sanPhamService.save(sanPham);
        return "redirect:/admin/sanpham/tatca";
    }

    // Sửa sản phẩm
    @GetMapping("/sua/{id}")
    public String suaSanPhamForm(@PathVariable String id, Model model) {
        model.addAttribute("sanPham", sanPhamService.getSanPhamById(id));
        return "admin/sua_sanpham";
    }

    @PostMapping("/sua/{id}")
    public String suaSanPhamSubmit(@PathVariable String id, @ModelAttribute SanPham sanPham) {
        SanPham sp = sanPhamService.getSanPhamById(id);
        if (sp != null) {
            sp.setTenHoa(sanPham.getTenHoa());
            sp.setMoTa(sanPham.getMoTa());
            sp.setGia(sanPham.getGia());
            sp.setSoLuong(sanPham.getSoLuong());
            sp.setHinhAnh(sanPham.getHinhAnh());
            sp.setLoaiHoa(sanPham.getLoaiHoa());
            sanPhamService.save(sp);
        }
        return "redirect:/admin/sanpham/tatca";
    }

    // Xóa sản phẩm
    @PostMapping("/xoa/{id}")
    public String xoaSanPham(@PathVariable String id) {
        sanPhamService.xoaSanPham(id);
        return "redirect:/admin/sanpham/tatca";
    }

    // Tìm kiếm
    @GetMapping("/timkiem")
    public String timKiemSanPham(@RequestParam("keyword") String keyword, Model model) {
        List<SanPham> list = sanPhamService.timKiem(keyword);
        model.addAttribute("sanPhams", list);
        return "admin/danhsach_sanpham";
    }
}
