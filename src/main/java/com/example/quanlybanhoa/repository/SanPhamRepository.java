package com.example.quanlybanhoa.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.quanlybanhoa.domain.model.SanPham;

public interface SanPhamRepository extends MongoRepository<SanPham, String> {

    @Query("{ '$or': [ " +
            "{ 'tenHoa': { $regex: ?0, $options: 'i' } }, " +
            "{ 'moTa': { $regex: ?0, $options: 'i' } }, " +
            "{ 'loaiHoa': { $regex: ?0, $options: 'i' } } " +
            "] }")
    List<SanPham> timKiemSanPham(String keyword);
}
