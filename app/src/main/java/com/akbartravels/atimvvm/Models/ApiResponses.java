package com.akbartravels.atimvvm.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResponses {

    @SerializedName("AUI")
    @Expose
    private String AUI;

    @SerializedName("SID")
    @Expose
    private String SID;

    @SerializedName("UTL")
    @Expose
    private String UTL;

    @SerializedName("FileRefNo")
    @Expose
    private String FileRefNo;

    @SerializedName("WCAddress")
    @Expose
    private String WCAddress;

    @SerializedName("WCCountryId")
    @Expose
    private String WCCountryId;

    @SerializedName("WCCurrentBalance")
    @Expose
    private String WCCurrentBalance;

    @SerializedName("WCCustRefNo")
    @Expose
    private String WCCustRefNo;

    @SerializedName("WCDOB")
    @Expose
    private String WCDOB;

    @SerializedName("WCDateOfIssue")
    @Expose
    private String WCDateOfIssue;

    @SerializedName("WCEmail")
    @Expose
    private String WCEmail;

    @SerializedName("WCFileIdNumber")
    @Expose
    private String WCFileIdNumber;

    @SerializedName("WCFileRefNo")
    @Expose
    private String WCFileRefNo;

    @SerializedName("WCFileTypeId")
    @Expose
    private String WCFileTypeId;

    @SerializedName("WCGSTStateCode")
    @Expose
    private String WCGSTStateCode;

    @SerializedName("WCMobile")
    @Expose
    private String WCMobile;

    @SerializedName("WCName")
    @Expose
    private String WCName;

    @SerializedName("WCPANFileName")
    @Expose
    private String WCPANFileName;

    @SerializedName("WCPassportFileName")
    @Expose
    private String WCPassportFileName;

    @SerializedName("WCPassportNo")
    @Expose
    private String WCPassportNo;

    @SerializedName("WCPhone")
    @Expose
    private String WCPhone;

    @SerializedName("WCPlaceOfIssue")
    @Expose
    private String WCPlaceOfIssue;

    @SerializedName("WCRefEmployeeId")
    @Expose
    private String WCRefEmployeeId;

    @SerializedName("WCSwipingMachingeDetails")
    @Expose
    private String WCSwipingMachingeDetails;

    @SerializedName("WCTitle")
    @Expose
    private String WCTitle;

    @SerializedName("TransactionDetails")
    @Expose
    private TransactionDetails transdetails;

    public class TransactionDetails{

        @SerializedName("ResponseCode")
        @Expose
        private String ResponseCode;

        @SerializedName("ResponseCount")
        @Expose
        private String ResponseCount;

        @SerializedName("ResponseMessage")
        @Expose
        private String ResponseMessage;

        @SerializedName("ResponseStatus")
        @Expose
        private String ResponseStatus;

        public String getResponseCode() {
            return ResponseCode;
        }

        public void setResponseCode(String responseCode) {
            ResponseCode = responseCode;
        }

        public String getResponseCount() {
            return ResponseCount;
        }

        public void setResponseCount(String responseCount) {
            ResponseCount = responseCount;
        }

        public String getResponseMessage() {
            return ResponseMessage;
        }

        public void setResponseMessage(String responseMessage) {
            ResponseMessage = responseMessage;
        }

        public String getResponseStatus() {
            return ResponseStatus;
        }

        public void setResponseStatus(String responseStatus) {
            ResponseStatus = responseStatus;
        }
    }


    public String getAUI() {
        return AUI;
    }

    public void setAUI(String AUI) {
        this.AUI = AUI;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getUTL() {
        return UTL;
    }

    public void setUTL(String UTL) {
        this.UTL = UTL;
    }

    public String getFileRefNo() {
        return FileRefNo;
    }

    public void setFileRefNo(String fileRefNo) {
        FileRefNo = fileRefNo;
    }

    public String getWCAddress() {
        return WCAddress;
    }

    public void setWCAddress(String WCAddress) {
        this.WCAddress = WCAddress;
    }

    public String getWCCountryId() {
        return WCCountryId;
    }

    public void setWCCountryId(String WCCountryId) {
        this.WCCountryId = WCCountryId;
    }

    public String getWCCurrentBalance() {
        return WCCurrentBalance;
    }

    public void setWCCurrentBalance(String WCCurrentBalance) {
        this.WCCurrentBalance = WCCurrentBalance;
    }

    public String getWCCustRefNo() {
        return WCCustRefNo;
    }

    public void setWCCustRefNo(String WCCustRefNo) {
        this.WCCustRefNo = WCCustRefNo;
    }

    public String getWCDOB() {
        return WCDOB;
    }

    public void setWCDOB(String WCDOB) {
        this.WCDOB = WCDOB;
    }

    public String getWCDateOfIssue() {
        return WCDateOfIssue;
    }

    public void setWCDateOfIssue(String WCDateOfIssue) {
        this.WCDateOfIssue = WCDateOfIssue;
    }

    public String getWCEmail() {
        return WCEmail;
    }

    public void setWCEmail(String WCEmail) {
        this.WCEmail = WCEmail;
    }

    public String getWCFileIdNumber() {
        return WCFileIdNumber;
    }

    public void setWCFileIdNumber(String WCFileIdNumber) {
        this.WCFileIdNumber = WCFileIdNumber;
    }

    public String getWCFileRefNo() {
        return WCFileRefNo;
    }

    public void setWCFileRefNo(String WCFileRefNo) {
        this.WCFileRefNo = WCFileRefNo;
    }

    public String getWCFileTypeId() {
        return WCFileTypeId;
    }

    public void setWCFileTypeId(String WCFileTypeId) {
        this.WCFileTypeId = WCFileTypeId;
    }

    public String getWCGSTStateCode() {
        return WCGSTStateCode;
    }

    public void setWCGSTStateCode(String WCGSTStateCode) {
        this.WCGSTStateCode = WCGSTStateCode;
    }

    public String getWCMobile() {
        return WCMobile;
    }

    public void setWCMobile(String WCMobile) {
        this.WCMobile = WCMobile;
    }

    public String getWCName() {
        return WCName;
    }

    public void setWCName(String WCName) {
        this.WCName = WCName;
    }

    public String getWCPANFileName() {
        return WCPANFileName;
    }

    public void setWCPANFileName(String WCPANFileName) {
        this.WCPANFileName = WCPANFileName;
    }

    public String getWCPassportFileName() {
        return WCPassportFileName;
    }

    public void setWCPassportFileName(String WCPassportFileName) {
        this.WCPassportFileName = WCPassportFileName;
    }

    public String getWCPassportNo() {
        return WCPassportNo;
    }

    public void setWCPassportNo(String WCPassportNo) {
        this.WCPassportNo = WCPassportNo;
    }

    public String getWCPhone() {
        return WCPhone;
    }

    public void setWCPhone(String WCPhone) {
        this.WCPhone = WCPhone;
    }

    public String getWCPlaceOfIssue() {
        return WCPlaceOfIssue;
    }

    public void setWCPlaceOfIssue(String WCPlaceOfIssue) {
        this.WCPlaceOfIssue = WCPlaceOfIssue;
    }

    public String getWCRefEmployeeId() {
        return WCRefEmployeeId;
    }

    public void setWCRefEmployeeId(String WCRefEmployeeId) {
        this.WCRefEmployeeId = WCRefEmployeeId;
    }

    public String getWCSwipingMachingeDetails() {
        return WCSwipingMachingeDetails;
    }

    public void setWCSwipingMachingeDetails(String WCSwipingMachingeDetails) {
        this.WCSwipingMachingeDetails = WCSwipingMachingeDetails;
    }

    public String getWCTitle() {
        return WCTitle;
    }

    public void setWCTitle(String WCTitle) {
        this.WCTitle = WCTitle;
    }

    public TransactionDetails getTransdetails() {
        return transdetails;
    }

    public void setTransdetails(TransactionDetails transdetails) {
        this.transdetails = transdetails;
    }
}
