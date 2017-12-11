package A2Z;
import java.util.Date;

import static A2Z.system.voucherCards;


public class VoucherCardController {
    private VoucherCard voucherCard;

    public boolean AddVoucherToDB(double vouchValue, Date exDate, String vouchID){
        boolean flag = true;

        for (int i = 0; i < voucherCards.size(); i++){
            if(voucherCards.get(i).getValue() == vouchValue && voucherCards.get(i).getExpiryDate().equals(exDate) && voucherCards.get(i).getVoucherID().equals(vouchID)){
                flag=false;
                break;
            }
        }

        if(flag == true){
            VoucherCard myVoucher = new VoucherCard();
            myVoucher.setValue(vouchValue);
            myVoucher.setExpiryDate(exDate);
            myVoucher.setVoucherID(vouchID);
            voucherCards.add(myVoucher);
        }

        return flag;
    }

    public boolean RemoveVoucherFromDB(double vouchValue, Date exDate, String vouchID){
        boolean flag = false;

        for (int i = 0; i < voucherCards.size(); i++){
            if(voucherCards.get(i).getValue() == vouchValue && voucherCards.get(i).getExpiryDate().equals(exDate) && voucherCards.get(i).getVoucherID().equals(vouchID)){
                voucherCards.remove(i);
                flag=true;
                break;
            }
        }

        return flag;
    }

    public boolean UpdateVoucherDB(double vouchValue, Date exDate, String vouchID){
        boolean flag1;
        boolean flag2;
        boolean flag = true;

        flag1 = RemoveVoucherFromDB( vouchValue,  exDate, vouchID);
        flag2 = AddVoucherToDB(vouchValue,  exDate,  vouchID);

        if(flag1 == false || flag2 == false){
            flag = false;
        }

        return flag;
    }

}