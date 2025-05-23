package com.example.quanlybanhoa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.quanlybanhoa.domain.enums.VaiTro;
import com.example.quanlybanhoa.domain.model.NguoiDung;
import com.example.quanlybanhoa.domain.model.dto.RegisterDTO;
import com.example.quanlybanhoa.repository.NguoiDungRepository;

@Service
public class NguoiDungService {

    private final NguoiDungRepository nguoiDungRepository;

    public NguoiDungService(NguoiDungRepository nguoiDungRepository) {
        this.nguoiDungRepository = nguoiDungRepository;
    }

    // thêm mới người dùng
    public NguoiDung save(NguoiDung nguoiDung) {
        return this.nguoiDungRepository.save(nguoiDung);
    }

    // lấy tất cả người dùng
    public List<NguoiDung> getTatCaNguoiDung() {
        return this.nguoiDungRepository.findAll();
    }

    // lấy người dùng bằng ID
    public NguoiDung getNguoiDungById(String id) {
        return this.nguoiDungRepository.findById(id).orElse(null);
    }

    // sửa
    public NguoiDung suaNguoiDung(String id, NguoiDung nguoiDung) {
        NguoiDung nguoiDungCu = this.getNguoiDungById(id);

        if (nguoiDungCu.getId() != null) {
            this.nguoiDungRepository.save(nguoiDung);
        }

        return this.nguoiDungRepository.save(nguoiDung);
    }

    // xóa
    public void xoaNguoiDung(String id) {
        this.nguoiDungRepository.deleteById(id);
    }

    // tìm kiếm

    public List<NguoiDung> timKiemNguoiDung(String keyword) {
        return this.nguoiDungRepository.timKiemTheoTuKhoa(keyword);
    }

    // lấy người dùng email
    public NguoiDung getNguoiDungByEmail(String email) {
        return this.nguoiDungRepository.findByEmail(email);
    }

    public boolean isAdminExists() {
        return this.nguoiDungRepository.existsByVaiTro(VaiTro.ADMIN);
    }

    // xử lý đăng ký
    public NguoiDung registerDTOtoNguoiDung(RegisterDTO registerDTO) {
        NguoiDung nguoiDung = new NguoiDung();
        nguoiDung.setHoTen(registerDTO.getTenDangNhap());
        nguoiDung.setEmail(registerDTO.getEmail());
        nguoiDung.setMatKhau(registerDTO.getMatKhau());
        nguoiDung.setVaiTro(registerDTO.getVaiTro());
        return nguoiDung;
    }

}
