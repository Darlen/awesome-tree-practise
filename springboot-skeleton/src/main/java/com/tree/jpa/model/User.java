package com.tree.jpa.model;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Package: com.tree.model
 * Description: <类功能描述>. <br>
 * <p>
 *	<使用说明>
 * </p>
 * @Author tree
 * @Date  2018/4/9 23:11
 * @Version 1.0
 */
@Entity
//@Table
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
	private Long id;
    @Column
    private String nickname;
    @Column
    private String email;
    @Column
    private String pswd;
    @Column
    private Date createTime;
    @Column
    private Date lastLoginTime;
    @Column
    private Long status;

    public User() {
    }

    @Column
    private Date modifyTime;


    public User(String nickname, String email, String pswd) {
        this.nickname = nickname;
        this.email = email;
        this.pswd = pswd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}