package com.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class App 
{
    public static String fullAccountDetails;
    public static String fullHTML;
    public static float cashValue;
    public static float stockValue;

    public static void main( String[] args )
    {
        fullHTML = "<!DOCTYPE html>\n<html>\n<body>\n";
        JSONArray jArray = Read.ReadJson();
        int i = 0;
        int iMax = jArray.size();
        //while(i<iMax){
            Sort1(jArray, i);
            i++;
        //};
        fullHTML += "</body>\n</html>";
    }

    public static void Sort1(JSONArray jArray, int loopNum){
        JSONObject stockAccount = (JSONObject) jArray.get(loopNum);
        String accountDetails = "Account #: " + String.valueOf(stockAccount.get("account_number")) + " Account Holder: " + String.valueOf(stockAccount.get("first_name")) + " " + String.valueOf(stockAccount.get("last_name")) + " SSN: " + String.valueOf(stockAccount.get("ssn")) + " Email: " + String.valueOf(stockAccount.get("email")) + " Phone #: " + String.valueOf(stockAccount.get("phone"));
        fullAccountDetails = "<h2>" + accountDetails + "</h2>\n\n\n";
        Sort2(stockAccount);
        System.out.println();
    }

    public static void Sort2(JSONObject stockAccount){
        String preBal = String.valueOf(stockAccount.get("beginning_balance"));
        String stockTradesRead = String.valueOf(stockAccount.get("stock_trades"));;
        
        JSONArray stockTrades = (JSONArray) Read.ReadJsonPiece(stockTradesRead);
        preBal = preBal.replaceAll("\\$", "");
        cashValue = Float.parseFloat(preBal);
        stockValue = 0;

        fullAccountDetails += "<h3>Stock&nbsp;|&nbsp;Type&nbsp;|&nbsp;Stock Count&nbsp;|&nbsp;Price Per Share</h3>\n\n";

        int loopMax = stockTrades.size();
        int loopNum2 = 0;
        while(loopNum2<loopMax){
            JSONObject stockDetailsObj = (JSONObject) stockTrades.get(loopNum2);
            Math(stockDetailsObj);
            loopNum2++;
        }

        fullAccountDetails += "\n<h3>Cash Balance: $" + String.valueOf(cashValue) + "&nbsp;&nbsp;&nbsp;Stock Value: $" + String.valueOf(stockValue) + "</h3>\n<br>\n<br>\n<br>";
        fullHTML += fullAccountDetails;
        System.out.println();
    }

    public static void Math(JSONObject stockDetailsObj){
        String stockSym = String.valueOf(stockDetailsObj.get("stock_symbol"));
        String tradeType = String.valueOf(stockDetailsObj.get("type"));
        String stockCountS = String.valueOf(stockDetailsObj.get("count_shares"));
        int stockCount = Integer.parseInt(stockCountS);
        String ppsB = String.valueOf(stockDetailsObj.get("price_per_share"));
        ppsB = ppsB.replaceAll("\\$", "");
        float pps = Float.parseFloat(ppsB);

        float sValueTotal = stockCount * pps;

        if(tradeType.equals("Buy")){
            cashValue = cashValue - sValueTotal;
            stockValue = stockValue + sValueTotal;
            System.out.println();
        }else if(tradeType.equals("Sell")){
            cashValue = cashValue + sValueTotal;
            stockValue = stockValue - sValueTotal;
            System.out.println();
        }else{
            System.out.println("What the hell did you do with your stocks?\nFuck you");
        }

        fullAccountDetails += "<b>" + stockSym + "&nbsp;&nbsp;|&nbsp;&nbsp;" + tradeType + "&nbsp;&nbsp;|&nbsp;&nbsp;" + stockCountS + "&nbsp;&nbsp;|&nbsp;&nbsp;$" + ppsB + "</b><br>\n";
    }
}
