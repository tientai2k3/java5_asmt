package com.example.asmt.exportExcel;

import com.example.asmt.entity.SanPham;
import com.example.asmt.service.ISanPhamService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExportExcelSanPham {
    @Autowired
    private ISanPhamService sanPhamService;

    public void generateExcel(HttpServletResponse response) throws Exception{
        List<SanPham> sanPhamList =sanPhamService.getAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Product");
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("Mã Sản Phẩm");
        row.createCell(2).setCellValue("Tên Sản Phẩm");
        row.createCell(3).setCellValue("Dòng Sản Phẩm");
        row.createCell(4).setCellValue("Thương hiệu");
        row.createCell(5).setCellValue("Màu Sắc");
        row.createCell(6).setCellValue("Size");
        row.createCell(7).setCellValue("Năm bảo hành");
        row.createCell(8).setCellValue("Mô tả");
        row.createCell(9).setCellValue("Số lượng tồn");
        row.createCell(10).setCellValue("Đơn giá");


        int dataRowIndex =1;
        for (SanPham x:sanPhamList) {
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(x.getId());
            dataRow.createCell(1).setCellValue(x.getMa());
            dataRow.createCell(2).setCellValue(x.getTen());
            dataRow.createCell(3).setCellValue(x.getLoaiSP().getTen());
            dataRow.createCell(4).setCellValue(x.getNsx().getTen());
            dataRow.createCell(5).setCellValue(x.getMauSac());
            dataRow.createCell(6).setCellValue(x.getSize());
            dataRow.createCell(7).setCellValue(x.getNamBH());
            dataRow.createCell(8).setCellValue(x.getMoTa());
            dataRow.createCell(9).setCellValue(x.getSoLuongTon());
            dataRow.createCell(10).setCellValue(String.valueOf(x.getDonGia()));

            dataRowIndex++;

        }

        ServletOutputStream ops = response.getOutputStream();
        workbook.write(ops);
        workbook.close();
        ops.close();
    }


}
