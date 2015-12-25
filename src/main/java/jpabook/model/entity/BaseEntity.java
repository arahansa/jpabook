package jpabook.model.entity;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by jarvis on 15. 12. 25..
 */

@MappedSuperclass
public class BaseEntity {

    private Date createdDate;      // 등록일
    private Date lastModifiedDate; // 수정일

    @Override
    public String toString() {
        return "BaseEntity{" +
                "createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
