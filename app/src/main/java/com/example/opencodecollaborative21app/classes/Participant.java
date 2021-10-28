package com.example.opencodecollaborative21app.classes;

import java.util.ArrayList;

public class Participant {
    private String name;
    private String gitId;
    private String facebookId;
    private String twitterId;
    private int reposContributed;
    private int mergedPrs;
    private int score;
    ArrayList<Repo> repo = new ArrayList();

    public static class Repo {
        private String repo_name;
        private int pr_id;
        private int issue_id;
        private int points;

        public String getRepo_Name() {
            return repo_name;
        }

        public void setRepo_name(String repo_name) {
            this.repo_name = repo_name;
        }

        public int getPr_ID() {
            return pr_id;
        }

        public void setPr_ID(int pr_id) {
            this.pr_id = pr_id;
        }

        public int getIssue_ID() {
            return issue_id;
        }

        public void setIssue_ID(int issue_id) {
            this.issue_id = issue_id;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public Repo(String repo_name,int pr_id,int issue_id,int points) {
            this.repo_name=repo_name;
            this.pr_id=pr_id;
            this.issue_id=issue_id;
            this.points=points;
        }


    }

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

    public ArrayList<Repo> getRepo() {
        return repo;
    }

    public void setRepo(ArrayList<Repo> repo) {
        this.repo = repo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
