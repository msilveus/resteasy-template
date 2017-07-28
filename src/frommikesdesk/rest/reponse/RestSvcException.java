/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package frommikesdesk.rest.reponse;

/**
 *
 * @author Michael Silveus <michaelsilveus@gmail.com>
 */
public class RestSvcException extends Exception{

    protected int errorCode = -1;

    public RestSvcException(){
        super("");
    }
    public RestSvcException(String message, int errCode){
        super(message);
        this.errorCode=errCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
 



}
