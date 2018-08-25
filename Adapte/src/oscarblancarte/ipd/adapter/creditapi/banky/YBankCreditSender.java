package oscarblancarte.ipd.adapter.creditapi.banky;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://wwww.oscarblancarteblog.com
 */
public class YBankCreditSender {

    public void sendCreditForValidate(final YBankCreditApprove request, final YBankCreditSenderListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("yBank received your request in a moment you will have the answer, be patient please");
                YBankCreditApproveResult response = new YBankCreditApproveResult();
                if (request.getCredit() <= 1500) {
                    response.setApproved("Y");
                } else {
                    response.setApproved("N");
                }
                try {
                    Thread.sleep(1000 * 30);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                listener.notifyCreditResult(response);
            }
        }).start();
    }
}