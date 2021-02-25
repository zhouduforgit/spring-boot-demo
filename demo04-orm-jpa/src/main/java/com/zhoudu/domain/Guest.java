package com.zhoudu.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Guest implements Serializable {
    @Id
    private int id;
    @Column
    private String name;
    @Column
    private String role;
}
