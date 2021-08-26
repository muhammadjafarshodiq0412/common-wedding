package com.api.commonwedding.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public class BaseModel implements Serializable {
    private static final long serialVersionUID = -260807388675307862L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    protected Long id;

    @GenericGenerator(name = "uuid", strategy = "uuid4")
    @Column(length = 36, updatable = false, nullable = false)
    protected String uuid;

    @Column(nullable = false)
    protected boolean enabled;

    @Column(updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    protected Date DateCreated;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    protected Date DateModified;

    @PrePersist
    protected void onCreated() {
        this.uuid = UUID.randomUUID().toString();
        this.DateCreated = new Date();
        this.enabled = Boolean.TRUE;
    }

    @PreUpdate
    protected void onUpdated() {
        this.DateModified = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        DateCreated = dateCreated;
    }

    public Date getDateModified() {
        return DateModified;
    }

    public void setDateModified(Date dateModified) {
        DateModified = dateModified;
    }
}
