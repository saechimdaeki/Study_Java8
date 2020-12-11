package com.example.demo.streamApi;

import com.example.demo.optional.Progress;

import java.util.Optional;

public class OnlineClass {

    private Integer id;

    private String title;

    private boolean closed;

    private Progress progress;  //필드에 Optional 쓰지말기!!

//    public Progress getProgress() {
////        if(this.progress==null){
////            throw new IllegalStateException();
////        }
//        return progress;
//    }

    public Optional<Progress> getProcess(){
        return Optional.ofNullable(progress);
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
