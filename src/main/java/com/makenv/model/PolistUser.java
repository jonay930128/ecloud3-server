package com.makenv.model;

import javax.persistence.*;

@Table(name = "POLIST_USER")
public class PolistUser {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select POLIST_USER_SEQ.nextval from dual")
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "SOLE")
    private String sole;

    @Column(name = "STATE")
    private String state;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "V2")
    private String v2;

    @Column(name = "V3")
    private String v3;

    @Column(name = "REGION")
    private String region;

    /**
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return USER_NAME
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return SOLE
     */
    public String getSole() {
        return sole;
    }

    /**
     * @param sole
     */
    public void setSole(String sole) {
        this.sole = sole;
    }

    /**
     * @return STATE
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return TYPE
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return V2
     */
    public String getV2() {
        return v2;
    }

    /**
     * @param v2
     */
    public void setV2(String v2) {
        this.v2 = v2;
    }

    /**
     * @return V3
     */
    public String getV3() {
        return v3;
    }

    /**
     * @param v3
     */
    public void setV3(String v3) {
        this.v3 = v3;
    }

    /**
     * @return REGION
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }
}