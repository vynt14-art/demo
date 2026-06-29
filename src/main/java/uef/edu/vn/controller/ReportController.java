package uef.edu.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import uef.edu.vn.dto.RevenueReportDTO;
import uef.edu.vn.service.ReportService;

@Controller
@RequestMapping("/admin/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/revenue")
    public String revenueReport(
            Model model) {

        model.addAttribute(
                "reports",
                reportService.revenueReport());

        return "admin/report/revenue-report";
    }

    @GetMapping("/food")
    public String foodReport(
            Model model) {

        model.addAttribute(
                "reports",
                reportService.foodReport());

        return "admin/report/food-report";
    }

    @GetMapping("/employee")
    public String employeeReport(
            Model model) {

        model.addAttribute(
                "reports",
                reportService.employeeReport());

        return "admin/report/employee-report";
    }

    @GetMapping("/export-excel")
    public void exportRevenueExcel(
            HttpServletResponse response)
            throws Exception {

        List<RevenueReportDTO> reports
                = reportService.revenueReport();

        Workbook workbook
                = new XSSFWorkbook();

        Sheet sheet
                = workbook.createSheet(
                        "Bao Cao Doanh Thu");

        Row header
                = sheet.createRow(0);

        header.createCell(0)
                .setCellValue("Ngày");

        header.createCell(1)
                .setCellValue("Doanh Thu");

        int rowNum = 1;

        for (RevenueReportDTO report : reports) {

            Row row
                    = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(
                            report.getReportDate()
                                    .toString());

            row.createCell(1)
                    .setCellValue(
                            report.getRevenue()
                                    .doubleValue());
        }

        response.setContentType(
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        response.setHeader(
                "Content-Disposition",
                "attachment; filename=BaoCaoDoanhThu.xlsx");

        workbook.write(
                response.getOutputStream());

        workbook.close();

    }

}
