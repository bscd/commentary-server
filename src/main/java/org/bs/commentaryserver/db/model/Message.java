package org.bs.commentaryserver.db.model;

public class Message
{
    private Integer messageId;

    private Integer author;

    private String content;

    private String type;

    private Integer id;

    public Integer getMessageId()
    {
        return messageId;
    }

    public void setMessageId(Integer messageId)
    {
        this.messageId = messageId;
    }

    public Integer getAuthor()
    {
        return author;
    }

    public void setAuthor(Integer author)
    {
        this.author = author;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content == null ? null : content.trim();
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type == null ? null : type.trim();
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }
}