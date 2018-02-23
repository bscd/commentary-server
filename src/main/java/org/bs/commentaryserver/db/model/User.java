package org.bs.commentaryserver.db.model;

import java.util.Date;

public class User
{
    private Integer userId;

    private String wxNickname;

    private String wxAvatarurl;

    private String wxGender;

    private String nickname;

    private String avatarurl;

    private String gender;

    private String phone;

    private String desc;

    private Date lastLoginTime;

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public String getWxNickname()
    {
        return wxNickname;
    }

    public void setWxNickname(String wxNickname)
    {
        this.wxNickname = wxNickname == null ? null : wxNickname.trim();
    }

    public String getWxAvatarurl()
    {
        return wxAvatarurl;
    }

    public void setWxAvatarurl(String wxAvatarurl)
    {
        this.wxAvatarurl = wxAvatarurl == null ? null : wxAvatarurl.trim();
    }

    public String getWxGender()
    {
        return wxGender;
    }

    public void setWxGender(String wxGender)
    {
        this.wxGender = wxGender == null ? null : wxGender.trim();
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getAvatarurl()
    {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl)
    {
        this.avatarurl = avatarurl == null ? null : avatarurl.trim();
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc == null ? null : desc.trim();
    }

    public Date getLastLoginTime()
    {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime)
    {
        this.lastLoginTime = lastLoginTime;
    }
}