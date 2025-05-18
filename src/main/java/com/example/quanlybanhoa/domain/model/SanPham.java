package com.example.quanlybanhoa.domain.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Document(collection = "sanpham") // tạo bảng csld
public class SanPham {
    @Id
    private String id;
    private String tenHoa;
    private String moTa;
    private double gia;
    private int soLuong;
    private String hinhAnh;
    private String loaiHoa;

    @CreatedDate
    private LocalDateTime ngayTao;

}
