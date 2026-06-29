package uef.edu.vn.controller;

import java.sql.Date;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uef.edu.vn.dto.OrderHistoryDTO;
import uef.edu.vn.model.Order;
import uef.edu.vn.model.OrderDetail;
import uef.edu.vn.service.InvoiceService;
import uef.edu.vn.service.OrderService;

@Controller
@RequestMapping("/admin/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String invoiceList(
            @RequestParam(required = false) String fromDate,
            @RequestParam(required = false) String toDate,
            Model model) {

        Date parsedFromDate
                = parseDate(fromDate);

        Date parsedToDate
                = parseDate(toDate);

        model.addAttribute(
                "orders",
                orderService.findOrderHistory(
                        parsedFromDate,
                        parsedToDate));

        model.addAttribute(
                "fromDate",
                fromDate);

        model.addAttribute(
                "toDate",
                toDate);

        return "admin/invoice/invoice-list";
    }

    @GetMapping("/detail/{id}")
    public String orderDetail(
            @PathVariable int id,
            Model model) {

        Order order
                = orderService.findById(id);

        List<OrderDetail> details
                = orderService.findDetails(id);

        model.addAttribute(
                "order",
                order);

        model.addAttribute(
                "details",
                details);

        model.addAttribute(
                "invoice",
                invoiceService.findByOrderId(id));

        return "admin/invoice/invoice-detail";
    }

    @GetMapping("/export-excel")
    public void exportOrderHistoryExcel(
            @RequestParam(required = false) String fromDate,
            @RequestParam(required = false) String toDate,
            HttpServletResponse response)
            throws Exception {

        Date parsedFromDate
                = parseDate(fromDate);

        Date parsedToDate
                = parseDate(toDate);

        List<OrderHistoryDTO> orders
                = orderService.findOrderHistory(
                        parsedFromDate,
                        parsedToDate);

        Workbook workbook
                = new XSSFWorkbook();

        Sheet sheet
                = workbook.createSheet("Lich Su Don Hang");

        Row header
                = sheet.createRow(0);

        header.createCell(0).setCellValue("Ma Don");
        header.createCell(1).setCellValue("Thoi Gian Tao");
        header.createCell(2).setCellValue("Nhan Vien");
        header.createCell(3).setCellValue("Ban");
        header.createCell(4).setCellValue("Khach Hang");
        header.createCell(5).setCellValue("Tong Tien");
        header.createCell(6).setCellValue("Phuong Thuc Thanh Toan");
        header.createCell(7).setCellValue("Thoi Gian Thanh Toan");
        header.createCell(8).setCellValue("Trang Thai");

        int rowNum = 1;

        for (OrderHistoryDTO order : orders) {

            Row row
                    = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(order.getOrderId());
            row.createCell(1).setCellValue(order.getOrderTime() == null ? "" : order.getOrderTime().toString());
            row.createCell(2).setCellValue(order.getEmployeeName() == null ? "" : order.getEmployeeName());
            row.createCell(3).setCellValue(order.getTableName() == null ? "" : order.getTableName());
            row.createCell(4).setCellValue(order.getCustomerName() == null ? "" : order.getCustomerName());
            row.createCell(5).setCellValue(order.getTotalAmount() == null ? 0 : order.getTotalAmount().doubleValue());
            row.createCell(6).setCellValue(order.getPaymentMethod() == null ? "" : order.getPaymentMethod());
            row.createCell(7).setCellValue(order.getPaymentTime() == null ? "" : order.getPaymentTime().toString());
            row.createCell(8).setCellValue(order.getStatus() == null ? "" : order.getStatus());
        }

        for (int i = 0; i <= 8; i++) {

            sheet.autoSizeColumn(i);
        }

        response.setContentType(
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        response.setHeader(
                "Content-Disposition",
                "attachment; filename=LichSuDonHang.xlsx");

        workbook.write(
                response.getOutputStream());

        workbook.close();
    }

    private Date parseDate(
            String value) {

        if (value == null
                || value.trim().isEmpty()) {

            return null;
        }

        return Date.valueOf(value);
    }

    @GetMapping("/delete/{id}")
    public String deleteInvoice(
            @PathVariable int id) {

        invoiceService.delete(id);

        return "redirect:/admin/invoices";
    }

}
