package com.example.opencodecollaborative21app.classes;

public class Participant {
    private String name;
    private String gitId;
    private String facebookId;
    private String twitterId;
    private int reposContributed;
    private int mergedPrs;

    public Participant(String name, String gitId) {
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

    public int getReposContributed() {
        return reposContributed;
    }
    public void setReposContributed(int reposContributed) {
        this.reposContributed = reposContributed;
    }

    public int getMergedPrs() {
        return mergedPrs;
    }
    public void setMergedPrs(int mergedPrs) {
        this.mergedPrs = mergedPrs;
    }
}
