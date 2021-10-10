package com.example.opencodecollaborative21app.classes;

public class Mentor {
    private String name;
    private String gitId;
    private String facebookId;
    private String twitterId;

    public Mentor(String name, String gitId) {
        this.name = name;
        this.gitId = gitId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGitId() {
        return gitId;
    }
    public void setGitId(String gitId) {
        this.gitId = gitId;
    }

    public String getFacebookId() {
        return facebookId;
    }
    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getTwitterId() {
        return twitterId;
    }
    public void setTwitterId(String twitterId) {
        this.twitterId = twitterId;
    }
}
