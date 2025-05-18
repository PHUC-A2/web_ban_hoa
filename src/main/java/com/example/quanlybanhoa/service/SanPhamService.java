package com.example.quanlybanhoa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.quanlybanhoa.domain.model.SanPham;
import com.example.quanlybanhoa.repository.SanPhamRepository;

@Service
public class SanPhamService {
    private final SanPhamRepository sanPhamRepo;

    public SanPhamService(SanPhamRepository sanPhamRepo) {
        this.sanPhamRepo = sanPhamRepo;
    }

    public List<SanPham> getTatCaSanPham() {
        return sanPhamRepo.findAll();
    }

    public SanPham getSanPhamById(String id) {
        return sanPhamRepo.findById(id).orElse(null);
    }

    public void save(SanPham sp) {
        sanPhamRepo.save(sp);
    }

    public void xoaSanPham(String id) {
        sanPhamRepo.deleteById(id);
    }

    public List<SanPham> timKiem(String keyword) {
        return sanPhamRepo.timKiemSanPham(keyword);
    }
}