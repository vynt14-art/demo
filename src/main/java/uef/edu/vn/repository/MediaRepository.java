package uef.edu.vn.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import uef.edu.vn.model.Media;

@Repository
public class MediaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(
            Media media) {

        String sql
                = "INSERT INTO media "
                + "(file_name, file_path, file_type) "
                + "VALUES (?, ?, ?)";

        return jdbcTemplate.update(
                sql,
                media.getFileName(),
                media.getFilePath(),
                media.getFileType());
    }

    public int getLastMediaId() {

        String sql
                = "SELECT MAX(media_id) FROM media";

        Integer id
                = jdbcTemplate.queryForObject(
                        sql,
                        Integer.class);

        return id == null ? 0 : id;
    }

    public Integer saveImagePath(
            String imagePath,
            String fileType) {

        if (imagePath == null
                || imagePath.trim().isEmpty()) {

            return null;
        }

        Media media
                = new Media();

        String cleanPath
                = normalizeImagePath(
                        imagePath.trim(),
                        fileType);

        int slashIndex
                = Math.max(
                        cleanPath.lastIndexOf('/'),
                        cleanPath.lastIndexOf('\\'));

        media.setFileName(
                slashIndex >= 0
                ? cleanPath.substring(slashIndex + 1)
                : cleanPath);

        media.setFilePath(cleanPath);
        media.setFileType(fileType);

        save(media);

        return getLastMediaId();
    }

    private String normalizeImagePath(
            String imagePath,
            String fileType) {

        if (imagePath.startsWith("/resources/")) {

            return imagePath;
        }

        String normalizedPath
                = imagePath.replace("\\", "/");

        int resourcesIndex
                = normalizedPath.indexOf("resources/images/");

        if (resourcesIndex >= 0) {

            return "/" + normalizedPath.substring(resourcesIndex);
        }

        if (imagePath.startsWith("resources/")) {

            return "/" + imagePath;
        }

        if (imagePath.contains("/")
                || imagePath.contains("\\")) {

            return normalizedPath;
        }

        if ("MENU".equals(fileType)) {

            return "/resources/images/menu/" + imagePath;
        }

        if ("EMPLOYEE".equals(fileType)) {

            return "/resources/images/employees/" + imagePath;
        }

        if ("LOGO".equals(fileType)) {

            return "/resources/images/logo/" + imagePath;
        }

        return imagePath;
    }

    public List<Media> findByType(
            String fileType) {

        String sql
                = "SELECT * FROM media "
                + "WHERE file_type = ? "
                + "ORDER BY uploaded_at DESC";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> {

                    Media media
                            = new Media();

                    media.setMediaId(
                            rs.getInt("media_id"));
                    media.setFileName(
                            rs.getString("file_name"));
                    media.setFilePath(
                            rs.getString("file_path"));
                    media.setFileType(
                            rs.getString("file_type"));
                    media.setUploadedAt(
                            rs.getTimestamp("uploaded_at"));

                    return media;
                },
                fileType);
    }
}
