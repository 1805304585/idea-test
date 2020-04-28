package com.lianglongwei.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author LLW
 * @Date 2020/3/30.
 * @Description user实体类
 **/
@Table(name = "tb_user")
@Data
public class User implements Serializable {
    @Id
    @NotBlank(message = "{required}")
    private Integer userid;
    @NotBlank(message = "{required}")
    private String username;
    @NotBlank(message = "{required}")
    private Integer deptid;

    private String email;

    private String phonenum;

    private Integer status;

}