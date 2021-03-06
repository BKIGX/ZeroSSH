/*
 * Copyright 2016 Robert Li.
 * Released under the MIT license
 * https://opensource.org/licenses/MIT
 */
package robertli.zero.action;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import org.json.JSONObject;
import robertli.zero.struts2.TextResultSupport;

/**
 *
 * @author Robert Li
 */
public class FileUploadDemoAction extends ActionSupport implements TextResultSupport {

    private File fe[];
    private String feContentType[];
    private String feFileName[];
    private String textResult;

    @Override
    public String execute() {

        if (fe != null) {
            System.out.println(fe[0].getAbsoluteFile());
            System.out.println(feContentType[0]);
            System.out.println(feFileName[0]);
        }
        return SUCCESS;
    }

    public String json() {
        execute();
        JSONObject json = new JSONObject();
        json.put("result", "success");
        textResult = json.toString();
        return TEXT;
    }

    public void setFe(File[] fe) {
        this.fe = fe;
    }

    public void setFeContentType(String[] feContentType) {
        this.feContentType = feContentType;
    }

    public void setFeFileName(String[] feFileName) {
        this.feFileName = feFileName;
    }

    @Override
    public String getTextResult() {
        return textResult;
    }

}
