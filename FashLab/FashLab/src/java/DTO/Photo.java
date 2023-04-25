/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ACER
 */
public class Photo {

    int photoId;
    int userId;
    String link;

    public Photo() {
    }

    public Photo(int photoId, int userId, String link) {
        this.photoId = photoId;
        this.userId = userId;
        this.link = link;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Photo{" + "photoId=" + photoId + ", userId=" + userId + ", link=" + link + '}';
    }

}
