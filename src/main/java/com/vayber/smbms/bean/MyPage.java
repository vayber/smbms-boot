package com.vayber.smbms.bean;

public class MyPage {
   private Integer currentPageNo;
   private Integer pageSize;

   public MyPage(Integer currentPageNo,Integer pageSize){

       this.pageSize = pageSize;
       this.currentPageNo = (currentPageNo - 1) * pageSize ;
   }
}
