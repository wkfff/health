package com.vaizn.data.busi.dal.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_attachments")
public class SysAttachments {
    @Id
    @Column(name = "attachment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String attachmentId;

    @Column(name = "busi_id")
    private String busiId;

    @Column(name = "attachment_type")
    private Byte attachmentType;

    @Column(name = "old_file_name")
    private String oldFileName;

    @Column(name = "new_file_name")
    private String newFileName;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "file_size")
    private Integer fileSize;

    private String creator;

    @Column(name = "upload_date")
    private Date uploadDate;

    /**
     * @return attachment_id
     */
    public String getAttachmentId() {
        return attachmentId;
    }

    /**
     * @param attachmentId
     */
    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }

    /**
     * @return busi_id
     */
    public String getBusiId() {
        return busiId;
    }

    /**
     * @param busiId
     */
    public void setBusiId(String busiId) {
        this.busiId = busiId;
    }

    /**
     * @return attachment_type
     */
    public Byte getAttachmentType() {
        return attachmentType;
    }

    /**
     * @param attachmentType
     */
    public void setAttachmentType(Byte attachmentType) {
        this.attachmentType = attachmentType;
    }

    /**
     * @return old_file_name
     */
    public String getOldFileName() {
        return oldFileName;
    }

    /**
     * @param oldFileName
     */
    public void setOldFileName(String oldFileName) {
        this.oldFileName = oldFileName;
    }

    /**
     * @return new_file_name
     */
    public String getNewFileName() {
        return newFileName;
    }

    /**
     * @param newFileName
     */
    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    /**
     * @return file_path
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return file_size
     */
    public Integer getFileSize() {
        return fileSize;
    }

    /**
     * @param fileSize
     */
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * @return creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * @return upload_date
     */
    public Date getUploadDate() {
        return uploadDate;
    }

    /**
     * @param uploadDate
     */
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
}