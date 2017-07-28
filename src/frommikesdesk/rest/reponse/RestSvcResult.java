/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package frommikesdesk.rest.reponse;

import com.google.gson.Gson;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michael Silveus <michaelsilveus@gmail.com>
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class RestSvcResult extends Object{

    public static final int RESTSVC_SUCCESS = 0;
    public static final int RESTSVC_ERR = 1;
    public static final String RESTSVC_SUCCESS_MSG = "SUCCESS";

    private int errorCode = -1;
    private StringBuilder message;

    public RestSvcResult(){
    }

    RestSvcResult(RestSvcResult cfgResultObj) {
        if(cfgResultObj == null)
            return;
        this.message = new StringBuilder();
        this.message.append(cfgResultObj.message.toString());
        this.errorCode = cfgResultObj.errorCode;
    }

    @XmlElement(name="message")
    public String getResultMsg(){
        return this.message == null ? "":this.message.toString();
    }

    @XmlElement(name="errorCode")
    public int getResultCode(){
        return this.errorCode;
    }

    public void setSuccessfulResult() {
        setSuccessfulResult("");
    }
    public void setSuccessfulResult(String message){
        if (message.isEmpty())
            addMessage(RESTSVC_SUCCESS_MSG);
        else
            addMessage(message);
        this.errorCode = RESTSVC_SUCCESS;
    }
    public void setFailedResult(String message){
        this.setFailedResult(message, RESTSVC_ERR);
    }
    public void setFailedResult(RestSvcException ex) {
        try {
            if(ex.getErrorCode() < 0)
                this.errorCode = RESTSVC_ERR;
            else
                this.errorCode = ex.getErrorCode();
            this.addMessage(ex.getMessage());
        } catch (Exception exc) {
            this.addMessage(exc.getMessage());
        }
    }
    public void setFailedResult(String message, int errCode){
        addMessage(message);
        this.errorCode = errCode;
    }

    public void addMessage(String message) {
        if(this.message == null)
            this.message = new StringBuilder();
        if (!this.message.toString().isEmpty())
            this.message.append(". ");
        this.message.append(message);
    }

    public boolean isSuccessfulResult(){
        return this.errorCode == RESTSVC_SUCCESS;
    }

    public String toJSON()
    {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
