package com.sapient.globalinsurancejee.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class SapientTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
       getJspContext().getOut().print("Publicis Sapient Digital Transformation");
    }
}
