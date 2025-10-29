package org.lupoi.security25.user;/*
    @author Andrii
    @project security25
    @class AuditMetaData
    @version 1.0.0
    @since 29.10.2025 - 11.39
*/

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
public class AuditMetaData {

    @CreatedDate
    private LocalDateTime date;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime modifiedDate;
    @LastModifiedBy
    private String modifiedBy;
}
