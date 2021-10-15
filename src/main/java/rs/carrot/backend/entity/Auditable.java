package rs.carrot.backend.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import rs.carrot.backend.entity.domain.RecordStatus;

import javax.persistence.EntityListeners;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.ORDINAL;
import static rs.carrot.backend.entity.domain.RecordStatus.ACTIVE;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Auditable implements Serializable {

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
    @LastModifiedBy
    private String lastModifiedBy;
    @Enumerated(ORDINAL)
    private RecordStatus recordStatus = ACTIVE;

}