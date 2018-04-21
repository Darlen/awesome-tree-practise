package com.tree.jdbctemplate;


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
public class User{
	private static final long serialVersionUID = 1L;
	private Long id;
    private String nickname;
    private String email;
    private String pwd;
    private Date createTime;
    private Date lastLoginTime;
    private Long status;
    private Date modifyTime;

    public User() {
    }



    public User(String nickname, String email, String pwd) {
        this.nickname = nickname;
        this.email = email;
        this.pwd = pwd;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", createTime=" + createTime +
                ", lastLoginTime=" + lastLoginTime +
                ", status=" + status +
                ", modifyTime=" + modifyTime +
                '}';
    }
}