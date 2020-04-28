package com.lianglongwei.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author LLW
 * @Description Dept实体类
 * @Date 2020/3/30
 **/
@Table(name = "tb_dept")
@Data
public class Dept implements Serializable {
    @Id
    @NotBlank(message = "{required}")
    private Integer deptid;
    @NotBlank(message = "{required}")
    private String dname;

    private String remark;

}