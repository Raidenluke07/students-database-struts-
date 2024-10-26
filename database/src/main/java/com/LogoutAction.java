package com;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
    @Override
    public String execute() {
        // Clear session or any user-specific data here if needed
        return SUCCESS;
    }
}
