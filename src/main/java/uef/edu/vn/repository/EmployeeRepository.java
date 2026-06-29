package uef.edu.vn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import uef.edu.vn.model.Employee;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Employee> rowMapper
            = new RowMapper<Employee>() {

        @Override
        public Employee mapRow(
                ResultSet rs,
                int rowNum)
                throws SQLException {

            Employee employee
                    = new Employee();

            employee.setEmployeeId(
                    rs.getInt("employee_id"));

            employee.setUserId(
                    rs.getInt("user_id"));

            employee.setMediaId(
                    rs.getObject(
                            "media_id",
                            Integer.class));

            employee.setFullName(
                    rs.getString("full_name"));

            employee.setPhone(
                    rs.getString("phone"));

            employee.setEmail(
                    rs.getString("email"));

            employee.setAddress(
                    rs.getString("address"));

            employee.setHireDate(
                    rs.getDate("hire_date"));

            employee.setSalary(
                    rs.getBigDecimal("salary"));

            try {
                employee.setRole(rs.getString("role"));
            } catch (SQLException ignored) {
                employee.setRole(null);
            }

            try {
                employee.setAccountStatus(rs.getBoolean("account_status"));
            } catch (SQLException ignored) {
                employee.setAccountStatus(true);
            }

            try {
                employee.setImagePath(rs.getString("image_path"));
            } catch (SQLException ignored) {
                employee.setImagePath(null);
            }

            return employee;
        }
    };

    // ==========================
    // FIND ALL
    // ==========================
    public List<Employee> findAll() {

        String sql
                = "SELECT e.*, u.role, u.status account_status, m.file_path image_path "
                + "FROM employees e "
                + "LEFT JOIN users u ON e.user_id = u.user_id "
                + "LEFT JOIN media m ON e.media_id = m.media_id "
                + "ORDER BY e.employee_id DESC";

        return jdbcTemplate.query(
                sql,
                rowMapper);
    }

    // ==========================
    // FIND BY ID
    // ==========================
    public Employee findById(
            int employeeId) {

        String sql
                = "SELECT e.*, u.role, u.status account_status, m.file_path image_path "
                + "FROM employees e "
                + "LEFT JOIN users u ON e.user_id = u.user_id "
                + "LEFT JOIN media m ON e.media_id = m.media_id "
                + "WHERE e.employee_id = ?";

        List<Employee> employees
                = jdbcTemplate.query(
                        sql,
                        rowMapper,
                        employeeId);

        return employees.isEmpty()
                ? null
                : employees.get(0);
    }

    public Employee findByUserId(
            int userId) {

        String sql
                = "SELECT e.*, u.role, u.status account_status, m.file_path image_path "
                + "FROM employees e "
                + "LEFT JOIN users u ON e.user_id = u.user_id "
                + "LEFT JOIN media m ON e.media_id = m.media_id "
                + "WHERE e.user_id = ?";

        List<Employee> employees
                = jdbcTemplate.query(
                        sql,
                        rowMapper,
                        userId);

        return employees.isEmpty()
                ? null
                : employees.get(0);
    }

    // ==========================
    // SAVE
    // ==========================
    public int save(
            Employee employee) {

        String sql
                = "INSERT INTO employees "
                + "(user_id, media_id, full_name, phone, email, address, hire_date, salary) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(
                sql,
                employee.getUserId(),
                employee.getMediaId(),
                employee.getFullName(),
                employee.getPhone(),
                employee.getEmail(),
                employee.getAddress(),
                employee.getHireDate(),
                employee.getSalary());
    }

    // ==========================
    // UPDATE
    // ==========================
    public int update(
            Employee employee) {

        String sql
                = "UPDATE employees "
                + "SET media_id = ?, "
                + "full_name = ?, "
                + "phone = ?, "
                + "email = ?, "
                + "address = ?, "
                + "hire_date = ?, "
                + "salary = ? "
                + "WHERE employee_id = ?";

        return jdbcTemplate.update(
                sql,
                employee.getMediaId(),
                employee.getFullName(),
                employee.getPhone(),
                employee.getEmail(),
                employee.getAddress(),
                employee.getHireDate(),
                employee.getSalary(),
                employee.getEmployeeId());
    }

    // ==========================
    // DELETE
    // ==========================
    public int delete(
            int employeeId) {

        String sql
                = "DELETE FROM employees "
                + "WHERE employee_id = ?";

        return jdbcTemplate.update(
                sql,
                employeeId);
    }

    // ==========================
    // COUNT EMPLOYEES
    // ==========================
    public int countEmployees() {

        String sql
                = "SELECT COUNT(*) "
                + "FROM employees";

        return jdbcTemplate.queryForObject(
                sql,
                Integer.class);
    }

    // ==========================
    // SEARCH BY NAME
    // ==========================
    public List<Employee> searchByName(
            String keyword) {

        String sql
                = "SELECT e.*, u.role, u.status account_status, m.file_path image_path "
                + "FROM employees e "
                + "LEFT JOIN users u ON e.user_id = u.user_id "
                + "LEFT JOIN media m ON e.media_id = m.media_id "
                + "WHERE e.full_name LIKE ? "
                + "ORDER BY e.full_name";

        return jdbcTemplate.query(
                sql,
                rowMapper,
                "%" + keyword + "%");
    }
}
