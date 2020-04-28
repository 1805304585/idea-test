package com.lianglongwei.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author LLW
 * @Date 2020/3/30.
 * @Description 封装的userVo
 **/
@Data
public class UserVo implements Serializable {
    @NotBlank(message = "{required}")
    private Integer userid;
    @NotBlank(message = "{required}")
    private String username;
    @NotBlank(message = "{required}")
    private Integer deptid;

    private String email;

    private String phonenum;

    private Integer status;
    @NotBlank(message = "{required}")
    private String dname;

    private String remark;
}
