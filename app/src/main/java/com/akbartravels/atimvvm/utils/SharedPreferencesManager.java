package com.akbartravels.atimvvm.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.akbartravels.atimvvm.R;


public class SharedPreferencesManager {
    public static String AUI = "AUI";
    public static String SID = "SID";
    public static String UTL="UTL";

    public static String Uname="Uname";
    public static String Pswd="Pswd";
    public static String EncryptedUname="EncryptedUname";

    public static String FileRefNo = "FileRefNo";
    public static String TransactionDetails = "TransactionDetails";
    public static String ResponseCode="ResponseCode";
    public static String ResponseCount="ResponseCount";
    public static String ResponseMessage ="ResponseMessage";
    public static String ResponseStatus="ResponseStatus";



    public static String WCAddress="WCAddress";
    public static String WCCountryId="WCCountryId";
    public static String WCCurrentBalance="WCCurrentBalance";
    public static String WCCustRefNo="WCCustRefNo";


    public static String WCDOB="WCDOB";
    public static String WCDateOfIssue="WCDateOfIssue";
    public static String WCEmail="WCEmail";
    public static String WCFileIdNumber="WCFileIdNumber";
    public static String WCFileRefNo="WCFileRefNo";

    public static String WCFileTypeId="WCFileTypeId";
    public static String WCGSTStateCode="WCGSTStateCode";
    public static String WCMobile="WCMobile";
    public static String WCName="WCName";
    public static String WCPANFileName="WCPANFileName";

    public static String WCPassportFileName="WCPassportFileName";
    public static String WCPassportNo="WCPassportNo";
    public static String WCPhone="WCPhone";
    public static String WCPlaceOfIssue="WCPlaceOfIssue";
    public static String WCRefEmployeeId="WCRefEmployeeId";
    public static String WCSwipingMachingeDetails="WCSwipingMachingeDetails";
    public static String WCTitle="WCTitle";

    public static String DC_FileRefNo="DC_FileRefNo";


    private static SharedPreferences sharedPreferences;

    private SharedPreferencesManager() {
    }

    public static void writeString(Context context, String key, String value) {
        getSharedPreferencesEditor(context).putString(key, value).commit();
    }

    public static void writeInt(Context context, String key, int value) {
        getSharedPreferencesEditor(context).putInt(key, value).commit();
    }

    public static void writeBoolean(Context context, String key, boolean value) {
        getSharedPreferencesEditor(context).putBoolean(key, value).commit();
    }

    public static void writeLong(Context context, String key, long value) {
        getSharedPreferencesEditor(context).putLong(key, value).commit();
    }

    public static void writeFloat(Context context, String key, float value) {
        getSharedPreferencesEditor(context).putFloat(key, value).commit();
    }

    public static String getSharedPreferenceString(Context context, String key) {
        return getPreferencesInstance(context).getString(key, "");
    }

    public static SharedPreferences getPreferencesInstance(Context context) {
        try {
            if (sharedPreferences == null) {
                sharedPreferences = context.getSharedPreferences(context.getString(R.string.str_preference_file), Context.MODE_PRIVATE);
            }
            return sharedPreferences;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sharedPreferences;
    }

    public static SharedPreferences.Editor getSharedPreferencesEditor(Context context) {
        return getPreferencesInstance(context).edit();
    }

    public static void clearSharedPreferences(Context context) {
        getSharedPreferencesEditor(context).clear().commit();
    }
}
