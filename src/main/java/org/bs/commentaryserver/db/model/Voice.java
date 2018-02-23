package org.bs.commentaryserver.db.model;

public class Voice
{
    private Integer voiceId;

    private String type;

    private Integer author;

    private String url;

    private Integer stars;

    public Integer getVoiceId()
    {
        return voiceId;
    }

    public void setVoiceId(Integer voiceId)
    {
        this.voiceId = voiceId;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type == null ? null : type.trim();
    }

    public Integer getAuthor()
    {
        return author;
    }

    public void setAuthor(Integer author)
    {
        this.author = author;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url == null ? null : url.trim();
    }

    public Integer getStars()
    {
        return stars;
    }

    public void setStars(Integer stars)
    {
        this.stars = stars;
    }
}