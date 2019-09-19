package com.vainglory.domain.vo;

import com.vainglory.domain.User;

import java.util.List;

public class QueryVo {
    private User user;
    private List<Integer> ids;

    public QueryVo(User user, List<Integer> ids) {
        this.user = user;
        this.ids = ids;
    }

    public QueryVo() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "user=" + user +
                ", ids=" + ids +
                '}';
    }
}
