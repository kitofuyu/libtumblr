package com.kitofuyu.libtumblr.resources;

public class Answer extends Post {
    private String asking_name;
    private String asking_url;
    private String question;
    private String answer;
    
    /**
     * get the blog name of the user asking the question
     * @return
     */
    public String getAskingName() {
        return asking_name;
    }
    
    /**
     * set the blog name of the user asking the question
     * @param asking_name
     */
    public void setAskingName(String askingName) {
        this.asking_name = askingName;
    }
    
    /**
     * get the blog URL of the user asking the question
     * @return
     */
    public String getAskingUrl() {
        return asking_url;
    }
    
    /**
     * set the blog URL of the user asking the question
     * @param asking_url
     */
    public void setAskingUrl(String askingUrl) {
        this.asking_url = askingUrl;
    }
    
    /**
     * get the asked question 
     * @return
     */
    public String getQuestion() {
        return question;
    }
    
    /**
     * set the asked question 
     * @param question
     */
    public void setQuestion(String question) {
        this.question = question;
    }
    
    /**
     * get the answer to the question
     * @return
     */
    public String getAnswer() {
        return answer;
    }
    
    /**
     * set the answer to the question
     * @param answe
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
