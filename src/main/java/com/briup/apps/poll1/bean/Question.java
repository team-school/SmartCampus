package com.briup.apps.poll1.bean;

public class Question {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_question.id
     *
     * @mbg.generated Tue Jun 26 10:41:33 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_question.name
     *
     * @mbg.generated Tue Jun 26 10:41:33 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_question.questionType
     *
     * @mbg.generated Tue Jun 26 10:41:33 CST 2018
     */
    private String questiontype;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_question.id
     *
     * @return the value of poll_question.id
     *
     * @mbg.generated Tue Jun 26 10:41:33 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_question.id
     *
     * @param id the value for poll_question.id
     *
     * @mbg.generated Tue Jun 26 10:41:33 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_question.name
     *
     * @return the value of poll_question.name
     *
     * @mbg.generated Tue Jun 26 10:41:33 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_question.name
     *
     * @param name the value for poll_question.name
     *
     * @mbg.generated Tue Jun 26 10:41:33 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_question.questionType
     *
     * @return the value of poll_question.questionType
     *
     * @mbg.generated Tue Jun 26 10:41:33 CST 2018
     */
    public String getQuestiontype() {
        return questiontype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_question.questionType
     *
     * @param questiontype the value for poll_question.questionType
     *
     * @mbg.generated Tue Jun 26 10:41:33 CST 2018
     */
    public void setQuestiontype(String questiontype) {
        this.questiontype = questiontype == null ? null : questiontype.trim();
    }
}