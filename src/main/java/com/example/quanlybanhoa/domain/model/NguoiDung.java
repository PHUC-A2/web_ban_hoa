package com.example.quanlybanhoa.domain.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.quanlybanhoa.domain.enums.VaiTro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Document(collection = "nguoidung") // tạo bảng csld
public class NguoiDung {

    @Id
    private String id;
    private String hoTen;
    private String email;
    private String matKhau;
    private String soDienThoai;
    private String diaChi;
    private VaiTro vaiTro = VaiTro.USER;

    @CreatedDate
    private LocalDateTime ngayTao;

}
