package uef.edu.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uef.edu.vn.dto.EmployeeReportDTO;
import uef.edu.vn.dto.FoodReportDTO;
import uef.edu.vn.dto.RevenueReportDTO;
import uef.edu.vn.repository.ReportRepository;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public List<RevenueReportDTO> revenueReport() {

        return reportRepository.revenueReport();
    }

    public List<FoodReportDTO> foodReport() {

        return reportRepository.foodReport();
    }

    public List<EmployeeReportDTO> employeeReport() {

        return reportRepository.employeeReport();
    }

}
