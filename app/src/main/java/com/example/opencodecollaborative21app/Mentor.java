package com.example.opencodecollaborative21app;

public class Mentor {
    private String name;
    private String gitId;
    private String facebookId;
    private String twitterId;

    public Mentor(String newName, String newGitId) {
        name = newName;
        gitId = newGitId;
    }

    public String getName() {
        return name;
    }
    public void setName(String newName) {
        this.name = newName;
    }

    public String getGitId() {
        return gitId;
    }
    public void setGitId(String newGitId) {
        this.gitId = newGitId;
    }

    public String getFacebookId() {
        return facebookId;
    }
    public void setFacebookId(String newFacebookId) {
        this.facebookId = newFacebookId;
    }

    public String getTwitterId() {
        return twitterId;
    }
    public void setTwitterId(String newTwitterId) {
        this.twitterId = newTwitterId;
    }
}
