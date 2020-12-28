package by.kazarezov.bean;

import org.apache.commons.fileupload.FileItem;

import java.io.Serializable;
import java.util.Objects;

public class Image implements Serializable {
    private int id;
    private FileItem picture;

    public Image() {
    }

    public Image(int id, FileItem picture) {
        this.id = id;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FileItem getPicture() {
        return picture;
    }

    public void setPicture(FileItem picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return id == image.id && Objects.equals(picture, image.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, picture);
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", picture=" + picture +
                '}';
    }
}
