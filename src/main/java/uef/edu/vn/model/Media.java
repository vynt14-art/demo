package uef.edu.vn.model;

import java.sql.Timestamp;

public class Media {

    private int mediaId;

    private String fileName;

    private String filePath;

    private String fileType;

    private Timestamp uploadedAt;

    public Media() {
    }

    public Media(int mediaId,
                 String fileName,
                 String filePath,
                 String fileType,
                 Timestamp uploadedAt) {

        this.mediaId = mediaId;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.uploadedAt = uploadedAt;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Timestamp getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(Timestamp uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}