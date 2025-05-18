package com.example.quanlybanhoa.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.quanlybanhoa.domain.enums.VaiTro;
import com.example.quanlybanhoa.domain.model.NguoiDung;

public interface NguoiDungRepository extends MongoRepository<NguoiDung, String> {
    @Query("{ '$or': [ " +
            "  { 'hoTen': { $regex: ?0, $options: 'i' } }, " +
            "  { 'soDienThoai': { $regex: ?0, $options: 'i' } }, " +
            "  { 'diaChi': { $regex: ?0, $options: 'i' } } " +
            "] }")
    List<NguoiDung> timKiemTheoTuKhoa(String keyword);

    NguoiDung findByEmail(String email);

    boolean existsByVaiTro(VaiTro vaiTro);
}