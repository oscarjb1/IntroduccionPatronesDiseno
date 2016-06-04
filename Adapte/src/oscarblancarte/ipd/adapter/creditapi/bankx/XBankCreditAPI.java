package oscarblancarte.ipd.adapter.creditapi.bankx;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://wwww.oscarblancarteblog.com
 */
public class XBankCreditAPI {
    
    public XBankCreditResponse sendCreditRequest(XBankCreditRequest request){
        XBankCreditResponse response =new XBankCreditResponse();
        if(request.getRequestAmount()<= 5000){
            response.setAproval(true);
        }else{
            response.setAproval(false);
        }
        return response;
    }
}