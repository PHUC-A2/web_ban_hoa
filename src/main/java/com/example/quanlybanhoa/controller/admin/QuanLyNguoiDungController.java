package com.example.quanlybanhoa.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.quanlybanhoa.domain.model.NguoiDung;
import com.example.quanlybanhoa.service.NguoiDungService;

@Controller
@RequestMapping("/admin")
public class QuanLyNguoiDungController {

    private final NguoiDungService nguoiDungService;

    public QuanLyNguoiDungController(NguoiDungService nguoiDungService) {
        this.nguoiDungService = nguoiDungService;
    }

    // tạo người dùng

    // file tạo người dùng
    @GetMapping("/nguoidung/them")
    public String themNguoiDung(Model model) {
        model.addAttribute("nguoidung", new NguoiDung());
        return "admin/them_nguoidung";
    }

    @PostMapping("/nguoidung/them")
    public String themNguoiDung(Model model, @ModelAttribute NguoiDung nguoiDung) {
        this.nguoiDungService.save(nguoiDung);
        return "redirect:/admin/nguoidung/tatca";
    }

    // lấy tất cả người dùng

    @GetMapping("/nguoidung/tatca")
    public String getTatCaNguoiDung(Model model) {
        List<NguoiDung> dsNguoiDung = this.nguoiDungService.getTatCaNguoiDung();
        model.addAttribute("nguoiDungs", dsNguoiDung);
        return "admin/danhsach_nguoidung";
    }

    // lấy người dùng bằng ID
    @GetMapping("/nguoidung/chitiet/{id}")
    public String getChiTietNguoiDung(Model model, @PathVariable String id) {
        NguoiDung nguoiDung = this.nguoiDungService.getNguoiDungById(id);
        model.addAttribute("nguoiDung", nguoiDung);
        return "admin/chitiet_nguoidung";
    }

    // sửa người dùng
    @GetMapping("/nguoidung/sua/{id}")
    public String suaNguoiDung(Model model, @PathVariable String id) {
        NguoiDung nguoiDung = this.nguoiDungService.getNguoiDungById(id);
        model.addAttribute("nguoiDung", nguoiDung);
        return "admin/sua_nguoidung";
    }

    // post
    @PostMapping("/nguoidung/sua/{id}")
    public String suaNguoiDung(Model model, @ModelAttribute NguoiDung nguoiDung, @PathVariable String id) {
        NguoiDung nguoiDungCu = this.nguoiDungService.getNguoiDungById(id);
        if (nguoiDungCu == null) {
            return "redirect:/admin/nguoidung?error=notfound";
        }
        if (nguoiDungCu != null) {
            nguoiDungCu.setHoTen(nguoiDung.getHoTen());
            nguoiDungCu.setEmail(nguoiDung.getEmail());
            nguoiDungCu.setMatKhau(nguoiDung.getMatKhau());
            nguoiDungCu.setSoDienThoai(nguoiDung.getSoDienThoai());
            nguoiDungCu.setDiaChi(nguoiDung.getDiaChi());
            nguoiDungCu.setVaiTro(nguoiDung.getVaiTro());
            this.nguoiDungService.suaNguoiDung(id, nguoiDungCu);
        }
        return "redirect:/admin/nguoidung/tatca";
    }

    @PostMapping("/nguoidung/xoa/{id}")
    public String xoaNguoiDung(Model model, @PathVariable String id) {
        this.nguoiDungService.xoaNguoiDung(id);
        return "redirect:/admin/nguoidung/tatca";
    }

    // tìm kiếm 
    @GetMapping("/nguoidung/timkiem")
    public String timKiemNguoiDung(Model model,@RequestParam("keyword") String keyword) {
        List<NguoiDung> dsNguoiDung = this.nguoiDungService.timKiemNguoiDung(keyword);
        model.addAttribute("nguoiDungs", dsNguoiDung);
        return "admin/danhsach_nguoidung";
    }

}
