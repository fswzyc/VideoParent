package com.xcy.video.pojo;


import com.xcy.video.utils.StringUtils;

public class Video {
    private int id;
    private String title;
    private String detail;
    private int time;
    private int spearkerId;
    private int courseId;
    private String videoUrl;
    private String imageUrl;
    private int playNum;

    private String showTime;

    public String getShowTime() {
        showTime = StringUtils.getTimeByInt(time);
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    private String speakerName;

    public Video() {
    }

    public Video(int id, String title, String detail, int time, int spearkerId, int courseId, String videoUrl, String imageUrl, int playNum, String speakerName) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.time = time;
        this.spearkerId = spearkerId;
        this.courseId = courseId;
        this.videoUrl = videoUrl;
        this.imageUrl = imageUrl;
        this.playNum = playNum;
        this.speakerName = speakerName;
    }

    public int getPlayNum() {
        return playNum;
    }

    public void setPlayNum(int playNum) {
        this.playNum = playNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getSpearkerId() {
        return spearkerId;
    }

    public void setSpearkerId(int spearkerId) {
        this.spearkerId = spearkerId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", time=" + time +
                ", spearkerId=" + spearkerId +
                ", courseId=" + courseId +
                ", videoUrl='" + videoUrl + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", playNum=" + playNum +
                ", speakerName='" + speakerName + '\'' +
                '}';
    }
}
